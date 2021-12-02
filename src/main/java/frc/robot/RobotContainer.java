// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//PACKAGES
package frc.robot;
//IMPORTS
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{  
  //Subsystems
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake(); 

  //Commands
  private final Joystick left = new Joystick(0);
  private final Joystick right = new Joystick(1);
  private JoystickButton feed;
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();
    drivetrain.setDefaultCommand(
      new RunCommand(
        //make sure it's inverted dumbass
        ()-> drivetrain.tankDrive(left.getRawAxis(1), right.getRawAxis(1)), drivetrain)
    ); 
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   * 
   */
  
  private void configureButtonBindings() 
  {
    //Buttons
    feed = new JoystickButton(right, 1);
    feed.whileHeld(new StartEndCommand(() -> intake.feed(1), ()-> intake.feed(0), intake));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
