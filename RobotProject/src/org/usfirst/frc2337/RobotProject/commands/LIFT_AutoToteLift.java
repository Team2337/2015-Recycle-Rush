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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject.Robot;

/**
 *
 */
public class  LIFT_AutoToteLift extends Command {
	
	public boolean autoToteSet = false;
	public int value;
	
    public LIFT_AutoToteLift(int value) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.chassis);
    	requires(Robot.lift);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	this.value = value;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Checks if LiftAutoTote is pressed
    	if (Robot.lift.LiftAutoTote()){
    		//Check if the variable is FALSE, this is so the PIDSetPoint won't be always set when button
    		//is pressed
    		if (!autoToteSet) {
    			//Set the variable to true now
    			autoToteSet = true;
    			//Run the tote command to pos. 1
    			Robot.lift.setTote(value); 
    		}
    	}
        SmartDashboard.getBoolean("ToteSwitch", Robot.lift.LiftAutoTote());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//When button is released. Set PID to where it stopped
    	Robot.lift.setSetpoint(Robot.lift.getPosition());
    	//Now set the variable back to false so the process can be used again
    	autoToteSet = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
