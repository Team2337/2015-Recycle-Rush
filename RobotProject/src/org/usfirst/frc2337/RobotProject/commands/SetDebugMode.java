package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject.Robot;

/**
 * Set the state of the Debug Mode to on (true) or off (false).
 * 
 * @param state the state to set debug mode to. Can be true (on) or false (off).
 */
public class SetDebugMode extends Command {

	private boolean state;
	
    public SetDebugMode(boolean state) {
        this.state = state;
    }

    //Called just before this Command runs the first time
    protected void initialize() {
    	if (!state) Robot.print("Changed the state of Debug Mode to " + state);
    }

    //Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.setDebugMode(state);
    }

    //Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    //Called once after isFinished returns true
    protected void end() {
    	//Do nothing
    }

	protected void interrupted() {
		//Do nothing		
	}
}
