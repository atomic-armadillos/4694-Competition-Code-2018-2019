/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap { //Defines all ports for motor controllers, sensors, etc.
	// Note: PWM ports range from 0-9
	public static int frontrightMotor = 0; //Sets the front right motor controller to pwm port 0
	public static int rearrightMotor = 1; //Sets the rear right motor controller to pwm port 1
	public static int frontleftMotor = 2; //Sets the front left motor controller to pwm port 2
	public static int rearleftMotor = 3; //Sets the rear left motor controller to pwm port 3
	public static int extendablecableMotor = 4; //Sets the extendable cable motor controller to pwm port 4
	public static int pivotarmMotor = 5; //Sets the pivot arm motor controller to pwm port 5
	public static int climberMotorLeft = 6; // Sets the left climber motor controller to pwm 6
	public static int climberMotorRight = 7; //Sets the right climber motor controller to pwm 7
	public static int compressor = 0; //Sets the compressor to CAN port 0
	public static int ClawSolenoid = 0; //Sets the Claw Solenoid to port 0
	public static int ClimbSolenoid = 1; //Sets the Climb Solenoid to port 1
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
