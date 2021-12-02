// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//PACKAGES
package frc.robot.subsystems;

//IMPORTS
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase 
{
  //Motors
  public Spark front_L;
  public Spark back_L;
  public Spark front_R;
  public Spark back_R;

  SpeedControllerGroup left;
  SpeedControllerGroup right;
  //Differential Drive to group the front motors together
  private DifferentialDrive drive;
  
  /** Creates a new Drivetrain. */
  public Drivetrain() 
  {
    front_L = new Spark(Constants.FRONTl);
    front_R = new Spark(Constants.FRONTR);
    back_L = new Spark(Constants.BACKL);
    back_R = new Spark(Constants.BACKR);

    left = new SpeedControllerGroup(front_L, back_L);
    right = new SpeedControllerGroup(front_R, back_R);

    drive = new DifferentialDrive(left, right);
    //Not safe here buck-o
    drive.setSafetyEnabled(false);

    //inverted here and when the values are recieved
    //front_R.setInverted(true);
    //back_R.setInverted(true);
  }

  //Tankdrive
  public void tankDrive(double leftSpeed, double rightSpeed)
  {
    System.out.println("Left" + leftSpeed + " Right:" + rightSpeed);
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
