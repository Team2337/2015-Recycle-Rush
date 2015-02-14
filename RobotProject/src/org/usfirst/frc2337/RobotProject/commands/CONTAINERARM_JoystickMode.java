package org.usfirst.frc2337.RobotProject.commands;

import org.usfirst.frc2337.RobotProject.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CONTAINERARM_JoystickMode extends Command {
	public boolean mode;
    public CONTAINERARM_JoystickMode(boolean mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.mode = mode;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println(mode);
    	if (mode) {
    		Robot.lift.joystickStatus = true;
    	}
    	else {
    		Robot.lift.joystickStatus = false;
    	}
    	
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
    	this.end();
    }
}
