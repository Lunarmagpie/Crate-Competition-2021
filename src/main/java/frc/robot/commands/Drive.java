// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//PACKAGES
package frc.robot.commands;
//IMPORTS
import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase 
{
  /** Creates a new Drive. */
  private Drivetrain driveTrain;
  private DoubleSupplier leftSpeed, rightSpeed;

  public Drive(Drivetrain d, DoubleSupplier rightSpeed, DoubleSupplier leftSpeed) 
  {
    //requirements 
    addRequirements(d);

    //class to passed
    this.driveTrain = d;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    driveTrain.tankDrive(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return false;
  }
}
