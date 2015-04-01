package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 *
 */
public class  LED_TurnOn extends Command {


    public LED_TurnOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.chassis);
    	requires(Robot.led);   	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.led.led(true);
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
    }
}
