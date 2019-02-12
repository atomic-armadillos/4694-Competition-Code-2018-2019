/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Spark;
import org.usfirst.frc.team4694.robot.RobotMap;
import org.usfirst.frc.team4694.robot.commands.DriveWithJoystick;
/**
 * Add your docs here.
 */
public class DriveBase extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  	public double magnitudeInX;
  	public double magnitudeInY;
  
  	public double magnitudeRtX;
	public double magnitudeRtY;

	double minimumXThreshold = .25;
	double minimumYThreshold = .25;
	  
  	public Spark m_leftMotorFront = new Spark(RobotMap.frontleftMotor); //Defines the Spark motor controller for the front left motor
	public Spark m_leftMotorRear = new Spark(RobotMap.rearleftMotor); //Defines the Spark motor controller for the rear left motor
	public SpeedControllerGroup m_left = new SpeedControllerGroup(m_leftMotorFront, m_leftMotorRear); //Puts the previous 2 controllers into a controller group
	public Spark m_rightMotorFront = new Spark(RobotMap.frontrightMotor); //Defines the Spark motor controller for the front right motor
	public Spark m_rightMotorRear = new Spark(RobotMap.rearrightMotor); //Defines the Spark motor controller for the rear right motor
	public SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightMotorFront, m_rightMotorRear); //Puts the previous 2 controllers into a controller group
	public Spark m_testmotor = new Spark(4);
	private DifferentialDrive m_robotdrive = new DifferentialDrive(m_left, m_right); //Sets up the drive system with the previous 2 controller groups
	
  @Override //Makes this void statement take priority over others
  public void initDefaultCommand() { //This void statement sets the default command for the subsystem. Runs automatically
    setDefaultCommand(new DriveWithJoystick()); //Subsystem defaults to the driving with joystick command
  }
  
  public void DriveBase() { //(NOTE: FIX STATEMENT SO IT DOES NOT CONFLICT WITH A CONSTRUCTOR NAME) Code that automaticlally runs within the subsystem, can be used to initialize values and functions
		addChild("Front Left Motor", (Spark) m_leftMotorFront); //Adds Front Left Motor to the LiveWindow
		addChild("Front Right Motor", (Spark) m_rightMotorFront); //Adds Front Right Motor to the LiveWindow
		addChild("Rear Left Motor", (Spark) m_leftMotorRear); //Adds Rear Left Motor to the LiveWindow
		addChild("Rear Right Motor", (Spark) m_rightMotorRear); //Adds Rear Right Motor to the LiveWindow

		m_testmotor.setSafetyEnabled(true);
		m_testmotor.setExpiration(0.1);

		m_robotdrive.setSafetyEnabled(true); //Turns on the safety for all of the motors
		m_robotdrive.setExpiration(0.1); //Sets the timeout value for the motors in seconds
		m_robotdrive.setMaxOutput(1.0); //Defaults the scaling factor for the drive methods
	}
    
  public void tankDrive(XboxController Joy) { //Void statement that allows a user to drive the robot with the joystick

	
	magnitudeInY = Joy.getRawAxis(1);
	magnitudeInX = Joy.getRawAxis(0);


	if(Math.abs(magnitudeInY) <= minimumYThreshold) {
		magnitudeInY = 0;
	}

	if(Math.abs(magnitudeInX) <= minimumYThreshold) {
		magnitudeInX = 0;
	}
		m_robotdrive.arcadeDrive(magnitudeInY * -1, magnitudeInX); //Sets the amount of power of each motor to the value of each Y-Axis on the Xbox Controller
		//m_testmotor.set(Joy.getRawAxis(1) * 0.5);
		}

		
  
  public void stop() { //Void Statement that stops the robot from moving
    	m_robotdrive.arcadeDrive(0, 0); //Sets the amount of each motor to zero
    }
}

/*
public void finalBattle() {
	if battle(hero_v_hero) == true {
		play(dueloftheFates.mp3)
		system.out.printlog("Its over "+aggresorName+", I have the high ground!")
	}
	else {
		play(genericBattleMusic.mp3)
	}
}
*/