package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;



import org.usfirst.frc.team5905.robot.RobotMap;
public class AutonomousDrive extends Command {
	private final ADXRS450_Gyro gyro = RobotMap.driveTrainGyro;
    double timer = 0;
    int theta = 100;
    double maxtime = 0;
    
    boolean exit = false;
    
    double leftDistance;
    double rightDistance;
    int leftCount;
    int rightCount;
    double leftIncrease = 0;
    double rightIncrease = 0;

    public AutonomousDrive() {
     requires(Robot.driveTrain);
    }

    protected void initialize() {
     //maxtime = .01 * theta/RobotMap.DRIVE_SPEED;
     //timer = 0;
     RobotMap.LEFT_DRIVE_ENCODER.reset();
     RobotMap.LEFT_DRIVE_ENCODER.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
    }
    //104 pulses: 0.3000 - 86.5
    //157 pulses: 0.45 - 122
    //136 in 200 pulses
    //0.8 inches per pulse
    protected void execute() {

        Robot.driveTrain.AutoDriveStraight(leftIncrease, rightIncrease);
        System.out.println("Gyro Angle: " + gyro.getAngle());
        
        leftCount = RobotMap.LEFT_DRIVE_ENCODER.get();       
        System.out.println("LeftCount: " + leftCount);
        
        leftDistance = RobotMap.LEFT_DRIVE_ENCODER.getDistance();
        System.out.println("Left Distance: " + leftDistance);
        
        if(leftCount > 200) {
        	exit = true;
        }
        
    }

    protected boolean isFinished() {
    	return exit;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}