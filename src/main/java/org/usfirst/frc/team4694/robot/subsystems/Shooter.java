/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot.subsystems;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Spark m_shooterMotorLeft = new Spark(6);
  public Spark m_shooterMotorRight = new Spark(7);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void outtake() {
    m_shooterMotorLeft.set(0.25);
    m_shooterMotorRight.set(-0.25);
  }

  public void intake() {
    m_shooterMotorLeft.set(-0.25);
    m_shooterMotorRight.set(0.25);
  }
}
