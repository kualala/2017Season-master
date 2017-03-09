
package org.usfirst.frc.team5905;

import edu.wpi.first.wpilibj.IterativeRobot;

import java.net.ServerSocket;

import org.usfirst.frc.team5905.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    
    Command autonomousCommand;
    public static OI oi;
    public static DriveTrain driveTrain;
    public static LowGoal lowGoal;
    public static ServerSocket sSocket;
    
    
    public static final int SERVER_PORT = 5905;
    
    public void robotInit() {
        RobotMap.init();
        driveTrain = new DriveTrain();
        lowGoal = new LowGoal();
        oi = new OI();
    }
    
    public void disabledInit(){
        
    }
    
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void autonomousInit() {
    	try {
    		sSocket = new ServerSocket(SERVER_PORT);
    	} catch (Exception e){
    		SmartDashboard.putString("Autonomous Init Exception", e.getMessage());
    	}
        if (autonomousCommand != null) autonomousCommand.start();
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
