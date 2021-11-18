// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//PACKAGES
package frc.robot.subsystems;

//IMPORTS
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANError;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase 
{
  //Motors
  public final CANSparkMax front_L = new CANSparkMax(0, MotorType.kBrushless);
  public final CANSparkMax back_L = new CANSparkMax(1, MotorType.kBrushless);
  public final CANSparkMax front_R = new CANSparkMax(2, MotorType.kBrushless);
  public final CANSparkMax back_R = new CANSparkMax(3, MotorType.kBrushless);

  //Differential Drive to group the front motors together
  private final DifferentialDrive drive = new DifferentialDrive(front_L, front_R);
  
  /** Creates a new Drivetrain. */
  public Drivetrain() 
  {
    //Not safe here buck-o
    drive.setSafetyEnabled(false);
    //this is to make sure the motors are all good in the hood
    back_L.restoreFactoryDefaults();
    back_R.restoreFactoryDefaults();
    front_R.restoreFactoryDefaults();
    front_L.restoreFactoryDefaults();

    //Throws an error 
    if(back_L.follow(front_L) != CANError.kOk)
      throw new RuntimeException("FRONTL FOLLOW BACKL FAILED");
    if(back_R.follow(front_R) != CANError.kOk)
      throw new RuntimeException("FRONTR FOLLOW BACKR FAILED");
      //changes

  }

  //Tankdrive method
  public void tankDrive(double leftSpeed, double rightSpeed)
  {
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }
}
