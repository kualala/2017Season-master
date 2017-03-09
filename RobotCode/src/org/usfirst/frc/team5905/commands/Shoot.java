package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.Robot;
import org.usfirst.frc.team5905.robot.RobotMap;
import org.usfirst.frc.team5905.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
    public Shoot() {
    	requires(Robot.lowGoal);
    }

    protected void initialize() {
    	Robot.lowGoal.stopSpin();
    }

    protected void execute() {
    	if (Robot.oi.gamepad.getRawAxis(Robot.oi.shootButtonRef) > 0.1) {
    		//RobotMap.SHOOT_SPEED = Robot.oi.gamepad.getRawAxis(3);
    		Robot.lowGoal.shootSpin();
    	}
    	else if(Robot.oi.gamepad.getRawAxis(Robot.oi.intakeButtonRef) > 0.1) {
    		//RobotMap.INTAKE_SPEED = Robot.oi.gamepad.getRawAxis(2);
    		Robot.lowGoal.intakeSpin();
    	}
    	else {
    		Robot.lowGoal.stopSpin();
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