package org.usfirst.frc.team5905.subsystems;
import org.usfirst.frc.team5905.commands.Shoot;
import org.usfirst.frc.team5905.robot.RobotMap;
import org.usfirst.frc.team5905.commands.*;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
public class Climber extends Subsystem {
	    public void initDefaultCommand() {
	    	 setDefaultCommand(new Climb());
	    	}
	    public void Climb() {
			RobotMap.CLIMB_CONTROLLER.set(RobotMap.CLIMB_SPEED);
		}
	   
		public void stopClimb() {
			RobotMap.CLIMB_CONTROLLER.stopMotor();
		}
	}
