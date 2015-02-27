package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 *
 */
public class LED_Auto extends Command {
	
	boolean flasher = false;
	int flashInt = 0;

    public LED_Auto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.led);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	flashInt++;
    	if (flashInt >= 15) {
    		flasher = !flasher;
    		flashInt = 0;
    	}
    	//Robot.led.kickerLED(Robot.kicker.stateOut, Robot.kicker.fingerSensor.get(), flasher);
    	//Robot.led.bumperLED(Robot.lift.liftAutoTote.get());
    	//Robot.led.PIDLED(Robot.lift.onTarget());
    	Robot.led.PIDLED(Robot.kicker.stateOut);
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
