package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.Drivetrain;

public class TurnSomeAngle extends CommandBase {
    Drivetrain drivetrain;

    public TurnSomeAngle(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void execute() {
        drivetrain.drive(0,turnspeed);
    
}
}