// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package org.usfirst.frc.team4694.robot.subsystems;

// import org.usfirst.frc.team4694.robot.RobotMap;
// import edu.wpi.first.wpilibj.Spark;
// import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import org.usfirst.frc.team4694.robot.commands.ElevatorSetpoint;
// import edu.wpi.first.wpilibj.Solenoid;
// import edu.wpi.first.wpilibj.Encoder;

// /**
//  * Add your docs here.
//  */
// public class ExtendableClaw extends Subsystem {
//   // Put methods for controlling this subsystem
//   // here. Call these from Commands.
//   public Spark m_elevatorMotor = new Spark(RobotMap.extendablecableMotor); //Defines the elevator motor controller
//   public Spark m_elevatortiltMotor = new Spark(RobotMap.pivotarmMotor); //Defines the pivot motor controller
//   public Solenoid m_ClawSolenoid = new Solenoid(RobotMap.ClawSolenoid); //Defines the claw solenoid
//   public Encoder m_elevatorEncoder = new Encoder(RobotMap.elevatorEncoderA, RobotMap.elevatorEncoderB);//Defines the elevator encoder
//   public Solenoid m_armSolenoid = new Solenoid(RobotMap.armSolenoid);

//   @Override
//   public void initDefaultCommand() {
//     // Set the default command for a subsystem here.
//     // setDefaultCommand(new MySpecialCommand());
//     setDefaultCommand(new ElevatorSetpoint());
//   }

//   public void ExtendableClaw() {
//     m_elevatorMotor.setSafetyEnabled(true); //Turns on the safety for the elevator motor controller
//     m_elevatorMotor.setExpiration(0.1); //Sets the expiration for the elevator motor controller to 0.1 seconds
//     m_elevatortiltMotor.setSafetyEnabled(true); //Turns on the safety for the pivot motor controller
//     m_elevatortiltMotor.setExpiration(0.1); //Sets the expiration for the pivot motor controller to 0.1 seconds
//   }
  
//   public void Move(XboxController Joy) {
//      if (Joy.getRawAxis(3) > 0.005) { //If the third axis on the joystick is pressed
//         m_elevatorMotor.set(Joy.getRawAxis(3)); //Set the elevator motor controller power to the third axis on the joystick
//      }
//      else {
//        if (Joy.getRawAxis(2) > 0.005) { //If the second axis on the joystick is pressed
//           m_elevatorMotor.set((Joy.getRawAxis(2))*-1); //Set the elevator motor controller power in reverse to the second axis on the joystick
//        }
//        else {
//           m_elevatorMotor.set(0); //Set the elevator motor controller power to zero
//        }
//      }
//      m_elevatortiltMotor.set(Joy.getRawAxis(5)); //Set the Pivot motor controller power to the fifth axis on the joystick
//   }

//   public void AutoMove(XboxController Joy) {//Hopefully auto moves claw
//     int positionClaw = 0;
    

//     if(Joy.getPOV() == 90) {//press right on D-pad, move to 3rd level
//       positionClaw =  3;
//     }
//     if(Joy.getPOV() == 0) {//press up on D-pad, move to 2nd level
//       positionClaw = 2;
//     }
//     if(Joy.getPOV() == 270) {//press left on D-pad, move to 1st level
//       positionClaw = 1;
//     }
//     if(Joy.getPOV() == 180) {//press bottom on D-pad, activate manual control
//       positionClaw = 0;
//     }
//     if(positionClaw == 3) {//sets the position for 3rd level
      
//       if( m_elevatorEncoder.getRaw() < 2000) {//shows if motor is below 2000 revolutions
//         m_elevatorMotor.set(1);//revolve the motor in the counterclockwise direction
//       }
//       if( m_elevatorEncoder.getRaw() > 1950) {//shows if motor is above 1950 revolutions
//         m_elevatorMotor.set(-1);//revolve the motor in the clockwise direction
//       }
//     }
//     if(positionClaw == 2) {//sets the position for 2nd level
//       if( m_elevatorEncoder.getRaw() < 1200) {//shows if motor is below 1200 revolutions
//         m_elevatorMotor.set(1);//revolve the motor in the counterclockwise direction
//       }
//       if( m_elevatorEncoder.getRaw() > 1100) {//shows if motor is above 1100 revolutions
//         m_elevatorMotor.set(-1);//revolve the motor in the clockwise direction
//       }
//     }
//     if(positionClaw == 1) {//sets the position of 1st level
//       if( m_elevatorEncoder.getRaw() < 100) {//shows if motor is below 1oo revolutions
//         m_elevatorMotor.set(1);//revolve the motor in the counterclockwise directiom
//       }
//       if( m_elevatorEncoder.getRaw() > 0) {//shows if motor is above 0 revolutions
//         m_elevatorMotor.set(-1);//revolve the motor in the clockwise direction
//       }
//     }

//     System.out.println(positionClaw);//prints value of claw's position to consle
//   }

//   public void armSolenoid(Solenoid Arm) {
//     Arm.set(true); // Extends the arm forward
//   }
//   public void toggle(Solenoid Sol) { //toggle solenoid valve
//     if (Sol.get() == true) {//if solenoid is true
//       Sol.set(false);//solenoid is set false
//     }
//     else if (Sol.get() == false) {//if solenoid is false
//       Sol.set(true);//solenoid is set true
//     }
//     SmartDashboard.putBoolean("ArmDeploy Status", Sol.get());//puts the status of the solenoid on the arm.
//   }
// }
