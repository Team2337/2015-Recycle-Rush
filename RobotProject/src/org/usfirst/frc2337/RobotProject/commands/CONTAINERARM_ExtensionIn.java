package org.usfirst.frc2337.RobotProject.commands;

import org.usfirst.frc2337.RobotProject.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CONTAINERARM_ExtensionIn extends Command {

    public CONTAINERARM_ExtensionIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.conExtension);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.conExtension.extIn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
