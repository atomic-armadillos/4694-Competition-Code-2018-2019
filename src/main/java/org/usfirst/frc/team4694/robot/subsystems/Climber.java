/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot.subsystems;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team4694.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Spark m_climberMotorRight = new Spark(RobotMap.climberMotorLeft); //Defines the right climber motor controller
  public Spark m_climberMotorLeft = new Spark(RobotMap.climberMotorRight); //Defines the left climber motor controller
  public DoubleSolenoid m_climberSolenoid = new DoubleSolenoid(1, 4); //Defines the climber solenoid

  @Override
  public void initDefaultCommand() {
    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void raiseClimber() {
    m_climberMotorRight.set(-0.5); //Sets the right climber motor in reverse at half power
    m_climberMotorLeft.set(0.5); //Sets the left climber motor at half power
  }

  public void stopClimber() {
    m_climberMotorLeft.set(0); //Sets the left climber motor at zero power
    m_climberMotorRight.set(0); //Sets the right climber motor at zero power
  }
  
  public void lowerClimber() {
    m_climberMotorRight.set(0.5); //Sets the right climber motor at half power
    m_climberMotorLeft.set(-0.5); //Sets the left climber motor in reverse at half power
  }

  public void climbClaw(DoubleSolenoid Sol) {
    if (Sol.get() == Value.kForward) {
        Sol.set(Value.kReverse);
        
      }
      else if (Sol.get() == Value.kReverse) {
        Sol.set(Value.kForward);
      }
  }
}
