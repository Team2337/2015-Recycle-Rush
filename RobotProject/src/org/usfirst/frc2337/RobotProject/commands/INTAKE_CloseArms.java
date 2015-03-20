package org.usfirst.frc2337.RobotProject.commands;
// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.




import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 *
 */
public class  INTAKE_CloseArms extends Command {
	//double left; //Left Motor
	//double right; //Right Motor
	
    public INTAKE_CloseArms() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.intakeOpen);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        //this.left = left; //Make Variables usable in this comand
        //this.right = right;
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {

    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Set the Speed of the arms
    	
    	//Robot.intake.setLeftArmSpeed(left);
    	//Robot.intake.setRightArmSpeed(right);
    	Robot.intakeOpen.openArmsIn();


    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//RobotMap.intakeLeftArmMotor.set(0);
    	//RobotMap.intakeRightArmMotor.set(0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    	
    }
}