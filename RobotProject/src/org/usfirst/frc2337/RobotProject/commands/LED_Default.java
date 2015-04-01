package org.usfirst.frc2337.RobotProject.commands;


import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 *
 */
public class  LED_Default extends Command {
	
	int i;

    public LED_Default() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.chassis);
    	requires(Robot.led);   	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	i = 0;
    	//RobotMap.led.set(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	if (i>100) {
  
    		RobotMap.led.set(false);
    	}
    	else {
    		i++;
    	}
    	*/
    	if (Robot.lift.getPosition() > .87) {
    		RobotMap.led.set(false);
    	} else {
    		RobotMap.led.set(true);
    	}
    	
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
