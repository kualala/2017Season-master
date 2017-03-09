package org.usfirst.frc.team5905.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team5905.commands.*;

public class OI {
	
	public Joystick gamepad;
	public JoystickButton reverseButton;
	public JoystickButton speedToggleButton;
	public JoystickButton intakeToggleButton;
	public final int reverseButtonRef = RobotMap.A_BUTTON; //buttons 
	public final int climbButtonRef = RobotMap.B_BUTTON; //buttons 
	public final int intakeButtonRef = RobotMap.L_TRIGGER; //axes 
	public final int shootButtonRef = RobotMap.R_TRIGGER; //axes 
	public final int speedToggleButtonRef = RobotMap.R_BUTTON;
	public final int intakeToggleButtonRef = RobotMap.X_BUTTON;
	
	public OI(){
		gamepad = new Joystick(0);
		reverseButton = new JoystickButton(gamepad, reverseButtonRef);
		reverseButton.whenPressed(new Reverse());
		speedToggleButton = new JoystickButton(gamepad, speedToggleButtonRef);
		speedToggleButton.whenPressed(new DrivePowerChange());
		//intakeToggleButton.whenPressed(new )
	
	}
	
}