// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.drivetrain.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain drivetrain = new Drivetrain();

  private final XboxController drivercontroller = new XboxController(0);
    // final JoystickButton l2 = new JoystickButton(0, 9);
    // final JoystickButton r2 = new JoystickButton(m_joystick, 10);
    // final JoystickButton l1 = new JoystickButton(m_joystick, 11);
    // final JoystickButton r1 = new JoystickButton(m_joystick, 12);
  private final ExampleCommand m_autoCommand = new ExampleCommand(new ExampleSubsystem());

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    drivetrain.setDefaultCommand(new RunCommand()) -> {
          speed = 2*drivetrain.getLeftY();
          turnspeed = drivetrain.getLeftX();

          if (speed > 0.1 || turnspeed > 0.1) {
            drivetrain.drive(speed, turnspeed);

          }
    }

    //drivetrain.setDefaultCommand(new RunCommand(() -> {
    //  drivetrain.drive(drivercontroller.getAButton() ? 2: 0, drivercontroller.getXButton() ? 2 : 0);
    // }, drivetrain));
      // final JoystickButton l2 = new JoystickButton(m_joystick, 9);
      // l2.whenPressed(new DriveForward(drivetrain));
      // l1.whenPressed(new DriveBackward(drivetrain));
      // r1.whileheld(new TurnSomeAngle(drivetrain));
      

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    
    m_autoCommand = ParallelRaceGroup(new drivetrain.drive(1.0,0), new Thread.sleep(5000))
    
    return m_autoCommand;
  }
}
