/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot.subsystems;

import org.usfirst.frc.team4694.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4694.robot.commands.ElevatorSetpoint;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * Add your docs here.
 */
public class ExtendableClaw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Spark m_elevatorMotor = new Spark(RobotMap.extendablecableMotor); //Defines the elevator motor controller
  public Spark m_elevatortiltMotor = new Spark(RobotMap.pivotarmMotor); //Defines the pivot motor controller
  public Solenoid m_ClawSolenoid = new Solenoid(RobotMap.ClawSolenoid); //Defines the claw solenoid
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ElevatorSetpoint());
  }

  public void ExtendableClaw() {
    m_elevatorMotor.setSafetyEnabled(true); //Turns on the safety for the elevator motor controller
    m_elevatorMotor.setExpiration(0.1); //Sets the expiration for the elevator motor controller to 0.1 seconds
    m_elevatortiltMotor.setSafetyEnabled(true); //Turns on the safety for the pivot motor controller
    m_elevatortiltMotor.setExpiration(0.1); //Sets the expiration for the pivot motor controller to 0.1 seconds
  }
  
  public void Move(XboxController Joy) {
     if (Joy.getRawAxis(3) > 0.005) { //If the third axis on the joystick is pressed
        m_elevatorMotor.set(Joy.getRawAxis(3)); //Set the elevator motor controller power to the third axis on the joystick
     }
     else {
       if (Joy.getRawAxis(2) > 0.005) { //If the second axis on the joystick is pressed
          m_elevatorMotor.set((Joy.getRawAxis(2))*-1); //Set the elevator motor controller power in reverse to the second axis on the joystick
       }
       else {
          m_elevatorMotor.set(0); //Set the elevator motor controller power to zero
       }
     }
     m_elevatortiltMotor.set(Joy.getRawAxis(5)); //Set the Pivot motor controller power to the fifth axis on the joystick
  }

  public void toggle(Solenoid Sol) {
    if (Sol.get() == true) {
      Sol.set(false);
    }
    else if (Sol.get() == false) {
      Sol.set(true);
    }
  }
}
