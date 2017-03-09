package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;



import org.usfirst.frc.team5905.robot.RobotMap;
public class AutonomousBrake extends Command {
	int count = 0;
    public AutonomousBrake() {
     requires(Robot.driveTrain);
    }

    protected void initialize() {

    }

    protected void execute() {
    	count++;
    	double x = RobotMap.LEFT_DRIVE_ENCODER.getDistance();
    	Timer.delay(0.01);
    	double y = RobotMap.LEFT_DRIVE_ENCODER.getDistance();
    	if(y - x > 0) {
    		Robot.driveTrain.AutoBrake(-1);
    	}
    	else
    		Robot.driveTrain.AutoBrake(1);
   
    }

    protected boolean isFinished() {
    	return count == 2;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}