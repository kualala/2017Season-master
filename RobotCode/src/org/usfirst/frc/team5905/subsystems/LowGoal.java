package org.usfirst.frc.team5905.subsystems;
import org.usfirst.frc.team5905.commands.Shoot;
import org.usfirst.frc.team5905.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class LowGoal extends Subsystem {
	    public void initDefaultCommand() {
	    	 setDefaultCommand(new Shoot());
	    	}
	    public void intakeSpin() {
			RobotMap.INTAKE_CONTROLLER.set(RobotMap.SHOOT_SPEED);
			RobotMap.SHOOTER_CONTROLLER.set(RobotMap.INTAKE_SPEED);
		}
	    
	    public void shootSpin() {
	    	RobotMap.INTAKE_CONTROLLER.set(RobotMap.SHOOT_SPEED);
			RobotMap.SHOOTER_CONTROLLER.set(RobotMap.SHOOT_SPEED * -1);
	    }
	   
		public void stopSpin() {
			RobotMap.INTAKE_CONTROLLER.stopMotor();
			RobotMap.SHOOTER_CONTROLLER.stopMotor();
		}
	}
