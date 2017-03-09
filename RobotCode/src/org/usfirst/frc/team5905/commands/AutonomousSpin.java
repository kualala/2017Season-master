package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc.team5905.robot.RobotMap;
public class AutonomousSpin extends Command {
	private final ADXRS450_Gyro gyro = RobotMap.driveTrainGyro;
    double timer = 0;
    int theta = 100;
    double maxtime = 0;
    
    boolean exit = false;
    
    double leftDistance;
    double rightDistance;
    int leftCount;
    int rightCount;
    
    double desiredTheta = 1.0;
    double startAngle;
    double endAngle;

    public AutonomousSpin() {
     requires(Robot.driveTrain);
    }
    
    public void setDesiredTheta(double desiredTheta){
    	this.desiredTheta = desiredTheta;
    }

    protected void initialize() {
    //maxtime = .01 * theta/RobotMap.TURN_SPEED;
     //timer = 0;
    	setTimeout(2);
    //	RobotMap.LEFT_DRIVE_ENCODER.reset();
    //    RobotMap.RIGHT_DRIVE_ENCODER.reset();
    //    RobotMap.LEFT_DRIVE_ENCODER.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
    //    RobotMap.RIGHT_DRIVE_ENCODER.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
    	startAngle = gyro.getAngle();
    	if (RobotMap.TURN_DIRECTION){
    		endAngle = startAngle + desiredTheta;
    	} else {
    		endAngle = startAngle - desiredTheta;
    	}
    }

    protected void execute() {
    	double currentAngle = gyro.getAngle(); //feel like this should be below first if branch
    	System.out.println("Gyro Angle: " + currentAngle);
    	if(RobotMap.TURN_DIRECTION) {
            Robot.driveTrain.AutoRightSpin();
    	}
    	else {
    		Robot.driveTrain.AutoLeftSpin();
    	}
        
        //leftDistance = RobotMap.LEFT_DRIVE_ENCODER.getDistance();
        //rightDistance = RobotMap.RIGHT_DRIVE_ENCODER.getDistance();
        
        //if(RobotMap.LEFT_DRIVE_ENCODER.get() > 30)
        //	exit = true;
        
        //if(RobotMap.TURN_DIRECTION && ((leftDistance) > RobotMap.TURN_AMOUNT)) {
        //	exit = true;
        //}
        //else if(!RobotMap.TURN_DIRECTION && (rightDistance) > RobotMap.TURN_AMOUNT) {
        //	exit = true;
        //}
    	
    	if (RobotMap.TURN_DIRECTION){
    		if (currentAngle <= endAngle){
    			exit = true;
    		}
    	} else {
    		if (currentAngle >= endAngle){
    			exit = true;
    		}
    	}
    	
    	
        timer+=.02;
        /*if (timer >= maxtime)
            exit = true;*/
    }

    protected boolean isFinished() {
        return exit;
    	//return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
