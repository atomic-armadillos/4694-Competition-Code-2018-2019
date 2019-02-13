/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4694.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 * Add your docs here.
 */
//toggles the claw from closed to open, and vise versa
public class ClawToggle extends Trigger {
  private Joystick Joy;
  private int Button;

  public ClawToggle(Joystick joy, int button) {
    
  }
  @Override
  public boolean get() {
    return false;
  }
}
