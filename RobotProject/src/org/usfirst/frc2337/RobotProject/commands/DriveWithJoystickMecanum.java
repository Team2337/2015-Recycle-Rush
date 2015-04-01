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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;

/**
 * Drive with a mecanum-style drive. The joystick is setup as a
 * "cheesy" control scheme, with the triggers used for strafing.
 * The left stick, up and down, is used for driving; the right
 * stick, left and right, is used for rotation; and the triggers
 * are used for strafing.
 */
public class  DriveWithJoystickMecanum extends Command {

	private Joystick joystickDriver = Robot.oi.joystickDriver;
	private double threshold = 0.1;
	
    public DriveWithJoystickMecanum() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.chassis);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double moveValue = joystickDriver.getRawAxis(1);
    	double strafeValue = joystickDriver.getRawAxis(3) - joystickDriver.getRawAxis(2);
    	double rotateValue = joystickDriver.getRawAxis(4);
    	
    	//Set the values to 0 if the input is below threshold
    	if (Math.abs(moveValue) < threshold) {
    		moveValue = 0;
    	}
    	if (Math.abs(strafeValue) < threshold) {
    		strafeValue = 0;
    	}
    	if (Math.abs(rotateValue) < threshold) {
    		rotateValue = 0;
    	}
    	
    	// square the inputs (while preserving the sign) to increase fine control while permitting full power
    	if (moveValue >= 0.0) {
            moveValue = (moveValue * moveValue);
        } else {
            moveValue = -(moveValue * moveValue);
        }
    	if (strafeValue >= 0.0) {
            strafeValue = (strafeValue * strafeValue);
        } else {
            strafeValue = -(strafeValue * strafeValue);
        }
        if (rotateValue >= 0.0) {
            rotateValue = (rotateValue * rotateValue);
        } else {
            rotateValue = -(rotateValue * rotateValue);
        }
      // if (Robot.oi.operatorControlsKickToggle.get())  {
       // 	Robot.chassis.driveMecanum(moveValue, strafeValue, rotateValue, RobotMap.igyro);
      //  } else  {
        Robot.chassis.driveMecanum(moveValue, strafeValue, rotateValue);
     //   }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
