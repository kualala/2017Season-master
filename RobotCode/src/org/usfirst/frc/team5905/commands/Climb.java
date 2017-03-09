package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.Robot;
import org.usfirst.frc.team5905.robot.RobotMap;
import org.usfirst.frc.team5905.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {
	//boolean check = false;
    public Climb() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    	Robot.climber.stopClimb();
    }

    protected void execute() {
    	if (Robot.oi.gamepad.getRawButton(Robot.oi.climbButtonRef)) {
    		Robot.climber.Climb();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.stopClimb();
    }

    protected void interrupted() {
    }
}