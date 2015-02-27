// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 * Strafe at a specified speed for a specified time. May or may not be in a straight line.
 * 
 * @param strafeFactor The fraction of max speed to strafe, ranging from -1.0 (left) to 1.0 (right).
 * @param seconds The time, in seconds, to Strafe for.
 */
public class  AutonStrafeAtSpeedForTimeGyro extends Command {
	private double strafeFactor;
	private double seconds;
	private double gyroValue;
	private double kP = .03;  

	
    public AutonStrafeAtSpeedForTimeGyro(double strafeFactor, double seconds) {
    	this.strafeFactor = strafeFactor;
    	this.seconds = seconds;    	
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(seconds);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gyroValue = RobotMap.imu.getYaw();
    	
    	gyroValue = gyroValue * -kP;
    	
    	if (gyroValue > 0.5) {
    		gyroValue = .5;
    	}
    	if (gyroValue < -0.5) {
    		gyroValue = -0.5;
    	}

    	Robot.chassis.driveMecanum(0, strafeFactor, gyroValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.chassis.stopMotors();
    }
}