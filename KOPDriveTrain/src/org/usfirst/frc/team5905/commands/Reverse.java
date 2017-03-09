package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.*;

import edu.wpi.first.wpilibj.command.Command;

public class Reverse extends Command {

    public Reverse() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
		Robot.driveTrain.toggleReverse();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
