package org.usfirst.frc.team5905.commands;

import org.usfirst.frc.team5905.*;

import edu.wpi.first.wpilibj.command.Command;

public class MoveWithJoysticks extends Command {

    public MoveWithJoysticks() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.prepareManual();
    }

    protected void execute() {
    	Robot.driveTrain.moveWithJoysticks();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
