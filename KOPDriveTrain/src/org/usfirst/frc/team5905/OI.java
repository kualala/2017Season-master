package org.usfirst.frc.team5905;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc.team5905.commands.*;

public class OI {
	
	public Joystick gamepad = new Joystick(0);
	public JoystickButton reverseButton = new JoystickButton(gamepad, 0);
	public int intakeButton = 2; 
    public int elevatorButton = 3; 	
	public OI(){
		reverseButton.whenPressed(new Reverse());
	}
}

