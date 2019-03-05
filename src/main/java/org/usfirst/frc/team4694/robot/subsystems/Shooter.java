/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot.subsystems;

import org.usfirst.frc.team4694.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import org.usfirst.frc.team4694.robot.commands.Idle;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Spark m_shooterMotorAngle =  new Spark(RobotMap.shooterMotorAngle); // creates spark motor controller for the angle moter on the shooter
  public Spark m_shooterMotorWheel = new Spark(RobotMap.shooterMotorWheel); // creates spark motor controller for the power wheels on the shooter 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Idle()); // ensures no action when nothing is pressed.
  }

  public void Shooter() {
    //dew the dew - mountain dew the dew - mountain dew the dew - mountain dew the 
    m_shooterMotorAngle.setSafetyEnabled(true); // Enables safety for the angle motor
    m_shooterMotorAngle.setExpiration(0.1); // Motor will stop after 0.1 seconds of disconnect
    m_shooterMotorWheel.setSafetyEnabled(true); // Enables safety for the power motor
    m_shooterMotorWheel.setExpiration(0.1); // Motor will stop after 0.1 seconds of disconnect
  }

  public void SetAngle(XboxController Joy) {
    if (Joy.getRawAxis(3) > 0.005) { //If the third axis on the joystick is pressed
              m_shooterMotorAngle.set(Joy.getRawAxis(3)); //Set the elevator motor controller power to the third axis on the joystick
           }
           else {
             if (Joy.getRawAxis(2) > 0.005) { //If the second axis on the joystick is pressed
                m_shooterMotorAngle.set((Joy.getRawAxis(2))*-1); //Set the elevator motor controller power in reverse to the second axis on the joystick
             }
             else {
                m_shooterMotorAngle.set(0); //Set the elevator motor controller power to zero
             }
           }
  }

  public void Idle() {
    m_shooterMotorWheel.set(0); // stops the Power Wheels from moving
    m_shooterMotorAngle.set(0); // stops the Angle Moter from moving 
  }

  public void ShootForward() {
    //SHÜTE GAM
    m_shooterMotorWheel.set(0.75); // Ejects cargo at 75% power
  }

  public void Intake() {
    m_shooterMotorWheel.set(-0.75); // Grabs cargo at 75% power
  }
}
