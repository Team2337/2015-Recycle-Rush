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
 *
 */
public class  LIFT_JoystickControl extends Command {

	public boolean setPointSet = false;
	
	
    public LIFT_JoystickControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.chassis);
    	requires(Robot.lift);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPointSet = false; 
    	Robot.lift.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double liftJoystickY = Robot.oi.liftJoystick.getRawAxis(1);
    	liftJoystickY = -liftJoystickY;
    	
    	//Check the joystick for a dead band, if in do...
    	if ((liftJoystickY > -.1 ) && (liftJoystickY < .1)) { //Dead band
    		
    		liftJoystickY = 0;  //Set Motor to 0 if in dead band
    		//If setPointSet, is not set (so false), run this ONCE and
    		//enable the Lift PID and set the PID to where the lift is
    		if (!setPointSet) {
    			Robot.lift.enable(); //Enable Lift Pid
    			Robot.lift.setSetpoint(Robot.lift.getPosition()); //Set the Lift
    			//Make setPointSet true so this statement true so it won't loop
    			setPointSet = true; 
    		}
    		
    	}
    	
    	//If the Joystick is out of the dead band, do..
    	else {
    		Robot.lift.disable(); //Disable the Lift PID
    		//Make the motor be controlled by the joystick but at a multiplied speed
    		if  ((liftJoystickY < 0) && (Robot.lift.getPosition() > 7.9)) {
    			RobotMap.masterliftMotor.set(0);
    		} else if (liftJoystickY < 0) {
    			RobotMap.masterliftMotor.set(1.00 * liftJoystickY); //Positive

    		} else if ((Robot.lift.getPosition() > 1.249) && (liftJoystickY > 0)) {
    			RobotMap.masterliftMotor.set(1.00 * liftJoystickY);	//Negative

    		} else  {
    			RobotMap.masterliftMotor.set(0);
    		}
    		//Make the setPointSet to false, so if in dead band, the PID can reset
    		setPointSet = false;
    		
    	}
  
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.masterliftMotor.set(0);
    	Robot.lift.enable();
		Robot.lift.setSetpoint(Robot.lift.getPosition());

		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
