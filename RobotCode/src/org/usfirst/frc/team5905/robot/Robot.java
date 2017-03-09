package org.usfirst.frc.team5905.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import org.usfirst.frc.team5905.commands.*;
import org.usfirst.frc.team5905.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class Robot extends IterativeRobot {
    
    Command autonomousCommand;
    public static OI oi;
    public static DriveTrain driveTrain;
    public static LowGoal lowGoal;
    public static Climber climber;


    
    public void robotInit() {
    	//RobotMap.SMART_DASHBOARD.putString("Start", "true");
        RobotMap.init();
        lowGoal = new LowGoal();
        driveTrain = new DriveTrain();
        climber = new Climber();
        autonomousCommand = new AutonomousCommands();
        oi = new OI();

    }
    
    public void disabledInit(){
        
    }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        //TODO: Remove this if it doesn't work
        
    }
    
    public void autonomousInit() {
        if (autonomousCommand != null){
        	autonomousCommand.start();
        }
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}