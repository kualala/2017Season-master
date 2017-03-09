package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
public class ToggleIntake extends Command{
	public ToggleIntake (){
		
	}
	 protected void initialize() {
	    	Robot.driveTrain.toggleReverse();
	    }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
