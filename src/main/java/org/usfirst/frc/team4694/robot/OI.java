/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc.team4694.robot.commands.ToggleClaw;
import org.usfirst.frc.team4694.robot.commands.ClimbClaw;
// import org.usfirst.frc.team4694.robot.commands.RaiseClimber;
// import org.usfirst.frc.team4694.robot.commands.lowerClimber;
// import org.usfirst.frc.team4694.robot.commands.StopClimber;

//import org.usfirst.frc.team4694.robot.commands.lowerClimber;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI { //Contains mappings for the joystick and all joystick buttons
	public static XboxController m_joystick = new XboxController(0); //Defines the Xbox Controller
	Button X = new JoystickButton(m_joystick, 3); //Sets button X to button 3 on the joystick
	Button A = new JoystickButton(m_joystick, 1); //Sets button A to button 1 on the joystick
	Button B = new JoystickButton(m_joystick, 2); //Sets button B to button 2 on the joystick
	Button LB = new JoystickButton(m_joystick, 5); //Sets button LB to button 5 on the joystick
	Button RB = new JoystickButton(m_joystick, 6); //Sets button RB to button 6 on the joystick

	public OI() { //Defines buttons and the commands they are assigned to
		 X.whenPressed(new ToggleClaw()); //When button X is pressed, run command ToggleClaw
		 B.whenPressed(new ClimbClaw()); //When button B is pressed, run command ClimbClaw
		// LB.whenPressed(new RaiseClimber()); //When button LB is pressed, run command RaiseClimber
		// RB.whenPressed(new lowerClimber()); //When button RB is pressed, run command lowerClimber
		// LB.whenReleased(new StopClimber()); //When button LB is released, run command Stop Climber
		// RB.whenReleased(new StopClimber()); //When button RB is released, run command Stop Climber
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public XboxController getJoystick() { //Void statement that returns the joystick set up here with it's properties
		return m_joystick; //Returns the Xbox Controller set up here
	}
}
