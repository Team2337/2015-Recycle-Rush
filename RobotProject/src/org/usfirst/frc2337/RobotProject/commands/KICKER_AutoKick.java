package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.Robot;

/**
 *
 */
public class KICKER_AutoKick extends Command {
	
	int i = 1;

    public KICKER_AutoKick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kicker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (RobotMap.kickerFingerSensor.get()) {
    		Robot.kicker.kickIn();
    	}
    	if (!RobotMap.kickerFingerSensor.get()) {
    		Robot.kicker.kickOut();
    	}
    	SmartDashboard.putNumber("test", i);
    	i++;
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