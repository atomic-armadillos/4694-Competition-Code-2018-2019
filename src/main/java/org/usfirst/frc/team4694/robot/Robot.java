/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot;

//import org.usfirst.frc.team4694.robot.subsystems.ExtendableClaw;
import org.usfirst.frc.team4694.robot.subsystems.DriveBase;
import org.usfirst.frc.team4694.robot.subsystems.pneumatics;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.wpilibj.command.*;

//import org.usfirst.frc.team4694.robot.commands.armDeploy;
import org.usfirst.frc.team4694.robot.subsystems.Climber;
import org.usfirst.frc.team4694.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static OI m_oi; //Defines the OI file
	
	public static pneumatics Pneumatics = new pneumatics(); //Subsystem that controls the compressor
	//public static ExtendableClaw m_extendableclaw = new ExtendableClaw(); //Subsystem that controls the extendable claw
	public static Climber m_climber = new Climber(); //Subsystem that controls the climber
	public static DriveBase m_drivetrain = new DriveBase(); //Subsystem that controls the drivetrain
	//Command ArmSolenoid;
	public static Shooter m_shooter = new Shooter();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() { //Void statement that runs once when the robot turns on
		m_oi = new OI(); //Assigns the OI file a name that can be referenced elsewhere in the code
		CameraServer.getInstance().startAutomaticCapture();
		//ArmSolenoid = new armDeploy();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() { //Void statement that runs once when the robot is disabled

	}

	@Override
	public void disabledPeriodic() { //Void statement that runs continuously when the robot is disabled
		Scheduler.getInstance().run(); 
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() { //Void statement that runs once when the robot is in autonomous mode

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		 //ArmSolenoid.start();
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() { //Void statement that runs continuously during autonomous mode
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() { //Void statement that runs once during teleop mode
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		//ArmSolenoid.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() { //Void statement that runs continuously during teleop mode
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() { //Void statement that runs continuously during test mode
	}
}
