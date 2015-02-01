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

/**
 * Turn the robot a specified number of degrees at a specified speed.
 * 
 * @param degrees the number of degrees to turn, ranging from -180.0 (left) to 180.0 (right).
 * @param speedFactor how fast to turn the robot, ranging from 0.1 (10% speed) to 1.0 (100% speed).
 */
public class  AutonDriveTurnDegrees extends Command {
	
	double degrees;
	double speedFactor;
	double angleThreshold = 3;
	
	public AutonDriveTurnDegrees(double degrees, double speedFactor) {
		this.degrees = degrees;
		this.speedFactor = speedFactor;
		
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.gyroReset();	//Zero the Gyro
    	
    	/*
    	//Roll over the degrees input if it's over +- 180 degrees
    	if (Math.abs(degrees) > 180) {
    		if (degrees < 0) {
    			degrees = 180 + (degrees % 180);
    		} else {
    			degrees = -180 + (degrees % 180);
    		}
    	}
    	*/
    	
    	//Modify speedFactor if needed so the robot actually turns
    	if (speedFactor < 0.1) {
    		speedFactor = 0.1;
    	}
    	if (speedFactor > 1.0) {
    		speedFactor = 1.0;
    	}
    	
    	//Invert speedFactor if needed so the robot turns the right direction
    	if (degrees < 0) {
    		speedFactor = -speedFactor;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.chassis.driveArcade(0, speedFactor);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(degrees - Robot.chassis.gyroReadAngle()) <= angleThreshold;
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
