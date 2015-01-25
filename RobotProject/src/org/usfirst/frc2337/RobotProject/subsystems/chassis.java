// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class chassis extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController frontLeft = RobotMap.chassisfrontLeft;
    SpeedController backLeft = RobotMap.chassisbackLeft;
    SpeedController frontRight = RobotMap.chassisfrontRight;
    SpeedController backRight = RobotMap.chassisbackRight;
    RobotDrive robotDrive = RobotMap.chassisrobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        //setDefaultCommand(new DriveWithJoystickMecanum());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Stops all motors and sets their output to 0
     */
    public void stopMotors() {
    	robotDrive.stopMotor();
    }
    
    /**
     * Controls the motors with an arcade-style control system.
     * 
     * @param moveValue The fraction of full speed to drive, ranging from -1.0 (full back) to 1.0 (full forward).
     * @param rotateValue The fraction of full speed to rotate, ranging from -1.0 (left) to 1.0 (right).
     */
    public void driveArcade(double moveValue, double rotateValue) {
    	robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    /**
     * Controls the motors with a tank-style control system.
     * 
     * @param leftValue The fraction of full speed to drive the left motors, ranging from -1.0 (full back) to 1.0 (full forward).
     * @param rightValue The fraction of full speed to drive the right motors, ranging from -1.0 (full back) to 1.0 (full forward).
     */
    public void driveTank(double leftValue, double rightValue) {
    	robotDrive.tankDrive(leftValue, rightValue);
    }
    
    /**
     * Controls the motors with a mecanum drive setup.
     * 
     * @param moveValue The fraction of full speed to drive, ranging from -1.0 (full back) to 1.0 (full forward).
     * @param strafeValue The fraction of full speed to strafe, ranging from -1.0 (full back) to 1.0 (full forward).
     * @param rotateValue The fraction of full speed to rotate, ranging from -1.0 (full back) to 1.0 (full forward).
     */
    public void driveMecanum(double moveValue, double strafeValue, double rotateValue) {
    	robotDrive.mecanumDrive_Cartesian(strafeValue, moveValue, rotateValue, 0);
    }
    
    /**
     * Change the default command for the chassis.
     * 
     * @param defaultCommand The default command to use.
     */
    //public void setDefaultCommand(Command defaultCommand) {
    //		super.setDefaultCommand(defaultCommand);

    //}
}

