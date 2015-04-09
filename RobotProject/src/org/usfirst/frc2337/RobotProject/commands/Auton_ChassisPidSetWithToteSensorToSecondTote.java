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
import edu.wpi.first.wpilibj.Timer;
/**
 *
 */
public class  Auton_ChassisPidSetWithToteSensorToSecondTote extends Command {

   double pidset; 
   double totePosition = 152;
   boolean toteSensed = false;
   
    public Auton_ChassisPidSetWithToteSensorToSecondTote(double pidset) {
    	this.pidset = pidset;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.chassis);
    	requires(Robot.chassis); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		Robot.chassis.enable();
    		Robot.chassis.setSetpoint(pidset);    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double pidget = Robot.chassis.getPosition();
    	
    	if (Robot.chassis.isToteSensor() && !toteSensed) {		//tote sensor active AND hasn't previously triggered AND not sensing something else
    		Robot.chassis.disable();
    		Robot.chassis.setSetpoint(pidget + totePosition);
    		Robot.chassis.enable();
    		toteSensed = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// return (Robot.chassis.onTarget() || Robot.chassis.isToteSensor());
    	//return (Robot.chassis.onTarget());
    		return ((Robot.chassis.onTarget() || (Robot.chassis.getPosition() > Robot.chassis.getSetpoint())) && (Robot.chassis.getPosition() > 420));
    }
    
    // Called once after isFinished returns true
    protected void end() {
    	//Robot.chassis.stopMotors();
    	//Robot.chassis.resetEncoder();
    	//Robot.chassis.disable();
    	//    	Robot.chassis.setSetpoint(Robot.chassis.getPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
