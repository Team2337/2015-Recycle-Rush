package org.usfirst.frc2337.RobotProject.commands;
// RobotBuilder Version: 1.5
//


import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject.Robot;

/**
 *
 */
public class  MultiPurposeGrabber_Close extends Command {

    public MultiPurposeGrabber_Close() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.multiPurposeGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   	Robot.multiPurposeGrabber.off();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
