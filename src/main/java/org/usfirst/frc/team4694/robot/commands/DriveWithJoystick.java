/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4694.robot.Robot;
//yo this code is running constantly, unless another command interupts it
public class DriveWithJoystick extends Command {
  public DriveWithJoystick() { //Used to set dependencies 
    requires(Robot.m_drivetrain); //Sets the dependencies for the command
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_drivetrain.tankDrive(Robot.m_oi.getJoystick()); //Runs void statement in drivetrain subsystem that controls the robot with joystick from OI file
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
