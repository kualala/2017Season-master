package org.usfirst.frc.team5905.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5905.robot.Robot;
import org.usfirst.frc.team5905.robot.RobotMap;
import org.usfirst.frc.team5905.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

public class DriveTrain extends Subsystem {
	private enum DriveTrainMode {
		MANUAL, DRIVE_STRAIGHT, ROTATE, DRIVE_BACKWARDS
	}
	private final RobotDrive myDrive = RobotMap.drive;
	DriveTrainMode mode; 
	private boolean isReversed = false;

    public void initDefaultCommand() {
    	setDefaultCommand(new MoveWithJoysticks());
    }
    
    public void prepareManual(){
    	mode = DriveTrainMode.MANUAL;
    }
    
    public void moveWithJoysticks(){
    	double leftPower = -1 * RobotMap.STRAIGHT * RobotMap.DRIVE_SPEED * Robot.oi.gamepad.getRawAxis(RobotMap.LEFT_GAMEPAD_JOYSTICK_Y);
    	//leftPower = 0;
		double rightPower = -1 * RobotMap.STRAIGHT * RobotMap.DRIVE_SPEED * Robot.oi.gamepad.getRawAxis(RobotMap.RIGHT_GAMEPAD_JOYSTICK_Y);
		//rightPower = 0;
		myDrive.tankDrive(leftPower - 0.1,  rightPower);
    }
    
    public void toggleReverse(){
    		//RobotMap.STRAIGHT *= -1;
		    isReversed = !isReversed;
			RobotMap.FRONT_LEFT_SPEED_CONTROLLER.setInverted(isReversed);
			RobotMap.FRONT_RIGHT_SPEED_CONTROLLER.setInverted(isReversed);
			RobotMap.BACK_LEFT_SPEED_CONTROLLER.setInverted(isReversed);
			RobotMap.BACK_RIGHT_SPEED_CONTROLLER.setInverted(isReversed);
			int x = RobotMap.LEFT_GAMEPAD_JOYSTICK_Y;
			RobotMap.LEFT_GAMEPAD_JOYSTICK_Y = RobotMap.RIGHT_GAMEPAD_JOYSTICK_Y;
			RobotMap.RIGHT_GAMEPAD_JOYSTICK_Y = x;
    	
    }
    public void toggleSpeed() {
    	if(RobotMap.DRIVE_POWER) {
    		RobotMap.drive.setMaxOutput(0.25);
    	}
    	else
    		RobotMap.drive.setMaxOutput(0.5);
    	RobotMap.DRIVE_POWER = !RobotMap.DRIVE_POWER;
    }
    
    public void AutoRightSpin(){
    	double leftPower = RobotMap.DRIVE_SPEED; //switch values to negative depending on spin direction
    	double rightPower = -1 * RobotMap.DRIVE_SPEED;
    	myDrive.tankDrive(leftPower, rightPower);
    }
    
    public void AutoLeftSpin(){
    	double leftPower = -1 * RobotMap.DRIVE_SPEED; //switch values to negative depending on spin direction
    	double rightPower = RobotMap.DRIVE_SPEED;
    	myDrive.tankDrive(leftPower, rightPower);
    }
    
    public void AutoDriveStraight(double leftIncrease, double rightIncrease){
    	double leftPower = RobotMap.DRIVE_SPEED + leftIncrease;
    	double rightPower = RobotMap.DRIVE_SPEED + rightIncrease;
    	myDrive.tankDrive(leftPower, rightPower);
    }
    public void AutoBrake(double direction) {
    	myDrive.tankDrive(direction * .25, direction * .25);
    }
}
