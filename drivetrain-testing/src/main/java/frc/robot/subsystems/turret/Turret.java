package frc.robot.subsystems.turret;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

public class Turret extends SubsystemBase {

    private CANSparkMax angleMotor;
    private CANSparkMax speedMotor;
    private RelativeEncoder angleEncoder;
    private SparkMaxPIDController speedController;

    public Turret(){
        this.angleMotor = new CANSparkMax(Turret.kPort1, CANSparkMax.MotorType.kBrushless);
        this.speedMotor = new CANSparkMax(Turret.kPort2, CANSParkMax.MotorType.kBrushless);

        this.angleEncoder = this.angleMotor.getEncoder();
        this.speedController = this.speedMotor.getPIDController();
        this.speedController.setP(Constants.Turret.kPSpeed); this.speedController.setI(Constants.Turret.kISpeed); this.speedController.setD(Constants.Turret.kDSpeed); this.speedController.setFF(Constants.Turret.kFFSpeed);

    }

    public void setAngle(double angle) {
        while (this.angleEncoder.getPosition() < angle) {
            this.angleMotor.set(0.1);
        }
        
    }

    public void shootBall(double shotPower) {
        this.speedMotor.set(shotPower);
    }

    public void stop(){
        this.speedMotor.set(0);
    }

}