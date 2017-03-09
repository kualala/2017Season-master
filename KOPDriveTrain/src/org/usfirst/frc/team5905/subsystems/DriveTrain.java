package org.usfirst.frc.team5905.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5905.Robot;
import org.usfirst.frc.team5905.RobotMap;
import org.usfirst.frc.team5905.commands.*;
import edu.wpi.first.wpilibj.*;

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
    	double leftPower = RobotMap.DRIVE_SPEED * Robot.oi.gamepad.getRawAxis(RobotMap.LEFT_GAMEPAD_JOYSTICK_Y);
		double rightPower = RobotMap.DRIVE_SPEED * Robot.oi.gamepad.getRawAxis(RobotMap.RIGHT_GAMEPAD_JOYSTICK_Y);
		myDrive.tankDrive(leftPower,  rightPower);
    }
    
    public void toggleReverse(){
    	isReversed = !isReversed;
    	RobotMap.FRONT_LEFT_SPEED_CONTROLLER.setInverted(isReversed);
    	RobotMap.FRONT_RIGHT_SPEED_CONTROLLER.setInverted(isReversed);
    	RobotMap.BACK_LEFT_SPEED_CONTROLLER.setInverted(isReversed);
    	RobotMap.BACK_RIGHT_SPEED_CONTROLLER.setInverted(isReversed);
    }

   public void spin(){
    	double leftPower = -1 * RobotMap.DRIVE_SPEED; //switch values to negative depending on spin direction
    	double rightPower = RobotMap.DRIVE_SPEED;
    	myDrive.tankDrive(leftPower, rightPower);
    }
    
    public void AutoDriveStright(){
    	double leftPower = RobotMap.DRIVE_SPEED;
    	double rightPower = RobotMap.DRIVE_SPEED;
    	myDrive.tankDrive(leftPower, rightPower);
    }
}
