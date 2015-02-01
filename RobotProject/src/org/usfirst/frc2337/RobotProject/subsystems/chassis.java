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

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
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
    DigitalInput toteSensor = RobotMap.chassistoteSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public IMUAdvanced gyro = RobotMap.chassisgyro;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveWithJoystickMecanum());

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
    	robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
    	robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    /**
     * Controls the motors with a tank-style control system.
     * 
     * @param leftValue The fraction of full speed to drive the left motors, ranging from -1.0 (full back) to 1.0 (full forward).
     * @param rightValue The fraction of full speed to drive the right motors, ranging from -1.0 (full back) to 1.0 (full forward).
     */
    public void driveTank(double leftValue, double rightValue) {
    	robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
        
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
    	robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
    	robotDrive.mecanumDrive_Cartesian(strafeValue, -moveValue, rotateValue, 0);	//Invert moveValue because the mecanumDrive inverts it for the joystick
    }
    
    /**
     * Return whether the tote sensor has been triggered.
     * 
     * @return the current state of the tote sensor
     */
    public boolean isToteSensor() {
    	return !toteSensor.get();
    }
    
    /**
     * Return whether the gyro is currently calibrating.
     * 
     * @return the current state of the gyro's calibration
     */
    public boolean gyroIsCalibrating() {
    	return gyro.isCalibrating();
    }
    
    /**
     * Reset the gyro to zero
     */
    public void gyroReset() {
    	gyro.zeroYaw();
    }
    
    /**
     * Return the current yaw of the gyro.
     * @return the current yaw of the gyro
     */
    public double gyroReadAngle() {
    	return gyro.getYaw();
    }
}

