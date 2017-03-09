package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.Robot;
import org.usfirst.frc.team5905.robot.RobotMap;
import org.usfirst.frc.team5905.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class DrivePowerChange extends Command {
	//boolean check = false;
    public DrivePowerChange() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
       	Robot.driveTrain.toggleSpeed();
    }

    protected void execute() {
 
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}