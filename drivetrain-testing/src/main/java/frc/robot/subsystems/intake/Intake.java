package frc.robot.subsystems.intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

public class Intake extends SubsystemBase {

    private final static int kPort = 0;
    private final static double kP = 0;
    private final static double kI = 0;
    private final static double kD = 0;
    private final static double kFF = 0;

    private CANSparkMax intakeMotor;
    private RelativeEncoder intakeEncoder;
    private SparkMaxPIDController intakeController;

    public Intake(){
        this.intakeMotor = new CANSparkMax(Intake.kPort, CANSparkMax.MotorType.kBrushless);
        this.intakeEncoder = this.intakeMotor.getEncoder();
        
        this.intakeController = this.intakeMotor.getPIDController();
        this.intakeController.setP(Intake.kP); this.intakeController.setI(Intake.kI); this.intakeController.setD(Intake.kD); this.intakeController.setFF(Intake.kFF);

    }

    public void setPower (double power) {
        this.intakeMotor.set(power);
    }

    public double getPosition(){
        return this.intakeEncoder.getPosition();
    }

    public void stop(){
        this.intakeMotor.set(0);
    }
}