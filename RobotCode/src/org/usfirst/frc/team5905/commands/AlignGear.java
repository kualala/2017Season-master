package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.Robot;
import org.usfirst.frc.team5905.robot.RobotMap;
import org.usfirst.frc.team5905.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class AlignGear extends Command {
	boolean exit = true;
    public AlignGear() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	//Robot.lowGoal.stopSpin();
    }

    protected void execute() {
    	if(Robot.oi.gamepad.getRawButton(4)) {
	    	while(exit) {
	    		if(RobotMap.AREA_DIFFERENCE > 50) {
	    			RobotMap.TURN_AMOUNT = 10;
	    		}
	    		else if(RobotMap.AREA_DIFFERENCE > 20) {
	    			RobotMap.TURN_AMOUNT = 5;
	    		}
	    		else if(RobotMap.AREA_DIFFERENCE < 50) {
	    			RobotMap.TURN_AMOUNT = -10;
	    		}
	    		else if(RobotMap.AREA_DIFFERENCE < 20) {
	    			RobotMap.TURN_AMOUNT = -5;
	    		}
	    	}
    	}
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.lowGoal.stopSpin();
    }

    protected void interrupted() {
    }
}