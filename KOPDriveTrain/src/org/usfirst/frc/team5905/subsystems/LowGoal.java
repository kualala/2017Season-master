package org.usfirst.frc.team5905.subsystems;

import org.usfirst.frc.team5905.RobotMap;
import org.usfirst.frc.team5905.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LowGoal extends Subsystem {

    public void initDefaultCommand() {
        setDefaultCommand(new Shoot());
    }
        
    public void intakeSpin() {
		RobotMap.INTAKE_CONTROLLER.set(RobotMap.INTAKE_SPEED);
		RobotMap.SHOOTER_CONTROLLER.set(RobotMap.SHOOT_SPEED);
	}
    
    public void shooterSpin() {
		RobotMap.INTAKE_CONTROLLER.set(RobotMap.INTAKE_SPEED);
		RobotMap.SHOOTER_CONTROLLER.set(-1*RobotMap.SHOOT_SPEED);
	}
	
	public void stopSpin() {
		RobotMap.INTAKE_CONTROLLER.stopMotor();
		RobotMap.SHOOTER_CONTROLLER.stopMotor();
	}
}

