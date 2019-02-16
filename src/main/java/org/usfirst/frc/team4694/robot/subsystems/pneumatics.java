// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package org.usfirst.frc.team4694.robot.subsystems;

// import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.Compressor;
// import org.usfirst.frc.team4694.robot.RobotMap;
// import org.usfirst.frc.team4694.robot.commands.FillAirTanks;

// /**
//  * Add your docs here.
//  */
// public class pneumatics extends Subsystem {
//   // Put methods for controlling this subsystem
//   // here. Call these from Commands.
//   public Compressor compressor = new Compressor(RobotMap.compressor); //Defines the compressor

//   @Override
//   public void initDefaultCommand() {
//     // Set the default command for a subsystem here.
//     // setDefaultCommand(new MySpecialCommand());
//     setDefaultCommand(new FillAirTanks());
//   }
//   public void FillAirTanks() {
//     if (compressor.getPressureSwitchValue() == false) { //If the compressor switch value is false
//       compressor.start(); //Start the compressor
//     }
//     else {
//       compressor.stop(); //Stop the compressor
//     }
//     SmartDashboard.putBoolean("Compressor Status", compressor.getPressureSwitchValue());//Outputs the status for the compressor to Dashboard
//   }
//   public void TurnoffCompressor() {
//     compressor.stop(); //Stop the compressor
//   }
// }
