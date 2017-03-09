package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.robot.Robot;
import org.usfirst.frc.team5905.robot.RobotMap;
import org.usfirst.frc.team5905.robot.OI;
import org.usfirst.frc.team5905.commands.AutonomousSpin;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommands extends CommandGroup {

    public AutonomousCommands() {
        RobotMap.LEFT_DRIVE_ENCODER.reset();
    	//Start Test
    	RobotMap.STRAIGHT_DISTANCE = 0.1;
    	addSequential(drive());
    	addSequential(brake());
    	RobotMap.TURN_DIRECTION = true;
    	RobotMap.TURN_AMOUNT = 0.3;
    	//addSequential(spin());
    	//End Test
    	
    	/*Start: Left Side, Left Gear Drop
    	RobotMap.STRAIGHT_DISTANCE = 192;
    	addSequential(drive());
    	RobotMap.TURN_DIRECTION = true;
    	RobotMap.TURN_AMOUNT = 135 degrees;
    	End: Left Side, Left Gear Drop */
    	
    	/*Start: Middle Side, Middle Gear Drop
    	RobotMap.StraightDistance = 72;
    	addSequential(drive());     
    	End: Middle Side, Middle Gear Drop */
    	
    	//Start: Right Side, Right Gear Drop
    	
    	//End: Right Side, Right Gear Drop
    	
    	
    }
    private AutonomousSpin spin() {
    	return new AutonomousSpin();
    }
    
    private AutonomousDrive drive(){
    	return new AutonomousDrive();
    }
    
    private AutonomousBrake brake() {
    	return new AutonomousBrake();
    }
   }
    
   