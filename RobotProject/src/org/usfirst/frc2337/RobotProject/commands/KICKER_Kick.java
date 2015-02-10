package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.Robot;

/**
 *
 */
public class KICKER_Kick extends Command {

    public KICKER_Kick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kicker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.kicker.stateOut) {
    		Robot.kicker.kickIn();
    	}
    	else{
    		Robot.kicker.kickOut();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
    }
}
