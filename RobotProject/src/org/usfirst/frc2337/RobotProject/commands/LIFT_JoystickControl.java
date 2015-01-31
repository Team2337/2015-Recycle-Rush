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
    	Robot.lift.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double liftJoystickY = Robot.oi.liftJoystick.getRawAxis(1);
    	
    	//Check the joystick for a dead band, if in do...
    	if ((liftJoystickY > -.1 ) && (liftJoystickY < .1)) { //Dead band
    		
    		liftJoystickY = 0;  //Set Motor to 0 if in dead band
    		//If setPointSet, is not set (so false), run this ONCE and
    		//enable the Lift PID and set the PID to where the lift is
    		if (!setPointSet) {
    			if (Robot.lift.getPIDStatus()) {
    				Robot.lift.enable(); //Enable Lift Pid
    				Robot.lift.setSetpoint(Robot.lift.getPosition()); //Set the Lift
    				//Make setPointSet true so this statment true so it won't loop
    			}
    			setPointSet = true; 
    			
    		}
    		
    	}
    	
    	//If the Joystick is out of the dead band, do..
    	else {
    		if (Robot.lift.getPIDStatus()) {
    			Robot.lift.disable(); //Disable the Lift PID, just in cases
        		//Make the motor be controlled by the joystick but at 15%
        		RobotMap.liftMotor.set(0.15 * liftJoystickY); 

    		}
    		else {	
    			Robot.lift.disable(); //Disable the Lift PID
    			//Make the motor be controlled by the joystick but at 15%
    			RobotMap.liftMotor.set(0.15 * liftJoystickY); 
    			//Make the setPointSet to false, so if in dead band, the PID can reset
    			setPointSet = false;
    		}
    		
    	}
    	
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.lift.AtLowerLimit() || Robot.lift.AtUpperLimit());
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.liftMotor.set(0);
    	Robot.lift.enable();
		Robot.lift.setSetpoint(Robot.lift.getPosition());
		SmartDashboard.putNumber("Elevator", Robot.lift.getPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
