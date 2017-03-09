package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.*;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5905.RobotMap;
public class AutonomousSpin extends Command {

    double timer = 0;
    int theta = 150;
    double maxtime = 0;
    boolean exit = false;

    public AutonomousSpin() {
     requires(Robot.driveTrain);
    }

    protected void initialize() {
     maxtime = .01 * theta/RobotMap.TURN_SPEED;
     timer = 0;

    }

    protected void execute() {

        Robot.driveTrain.spin();
        timer+=.02;
        if (timer >= maxtime)
            exit = true;
    }

    protected boolean isFinished() {
        return exit;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

