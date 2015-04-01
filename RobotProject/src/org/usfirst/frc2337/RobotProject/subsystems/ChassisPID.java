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
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class ChassisPID extends PIDSubsystem {
    SpeedController frontLeft = RobotMap.chassisfrontLeft;
    SpeedController backLeft = RobotMap.chassisbackLeft;
    SpeedController frontRight = RobotMap.chassisfrontRight;
    SpeedController backRight = RobotMap.chassisbackRight;
    RobotDrive robotDrive = RobotMap.chassisrobotDrive;  
    DigitalInput toteSensor = RobotMap.chassistoteSensor;
    Encoder autonEncoder = RobotMap.autonEncoder;
    Encoder strafeEncoder = RobotMap.strafeEncoder;
    
    //These 3 values are being used on both Strafe and Drive Encoders.
    /** Defines the minimum rate for the strafe and drive encoders. Accepts double entries */
    double minRate = 10;
    /** Defines the distance per pulse for the strafe and drive encoders. Accepts double entries */    
    double distancePerPulse = 2;
    /** Defines the number of samples to average for the strafe and drive encoders. Accepts int */
    int encoderSamplesToAverage = 5;
    
    /** Defines the sign for the drive encoder. Accepts boolean */
    boolean encoderReverseDirection = false;
    /** Defines the sign for the strafe encoder. Accepts boolean */
    boolean StrafeEncoderReverseDirection = true;
    
    /** Defines the value for the gyro. Accepts double */
	private double gyroValue;
	/** Defines the value used to scale the gyro value. Accepts double */
	private double kP = .08;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public ChassisPID() {
        super("ChassisPID", .019, 0.0, 0.040);
        setAbsoluteTolerance(2);
        getPIDController().setContinuous(false);
        
        LiveWindow.addActuator("ChassisPID", "PIDSubsystem Controller", getPIDController());
        getPIDController().setOutputRange(-0.5, 0.5);  
    }

    public void initDefaultCommand() {
	
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystickMecanum());
    }
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        return autonEncoder.get();

    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
  	gyroValue = RobotMap.imu.getYaw();
    	
    	gyroValue = gyroValue * -kP;
    	
    	if (gyroValue > 0.5) {
    		gyroValue = .5;
    	}
    	if (gyroValue < -0.5) {
    		gyroValue = -0.5;
    	}
        this.driveMecanum(-output, 0, gyroValue);
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
    
    public void driveMecanumFC(double moveValue, double strafeValue, double rotateValue, double gyro) {
    	robotDrive.mecanumDrive_Cartesian(strafeValue, moveValue, rotateValue, gyro);
    }
    
    /**
     * Return whether the tote sensor has been triggered.
     * 
     * @return the current state of the tote sensor, inverted to read properly
     */
    public boolean isToteSensor() {
    	return !toteSensor.get();
    }
    
    /**
     * Initializes and resets the drive and strafe encoder.
     */
    
    public void initEncoder() {
    	//autonEncoder.setMinRate(minRate);
    	//autonEncoder.setDistancePerPulse(distancePerPulse);;
    	autonEncoder.setReverseDirection(encoderReverseDirection);
    	//autonEncoder.setSamplesToAverage(encoderSamplesToAverage);
     	autonEncoder.reset();
    
     	//strafeEncoder.setMinRate(minRate);
    	//strafeEncoder.setDistancePerPulse(distancePerPulse);
    	strafeEncoder.setReverseDirection(StrafeEncoderReverseDirection);
    	//strafeEncoder.setSamplesToAverage(encoderSamplesToAverage);
     	strafeEncoder.reset();
    }
    /**
     * Resets the drive encoder distance to 0;
     */
    public void resetAutonEncoder() {
    	autonEncoder.reset();
    }
    /**
     * Resets the Strafe encoder distance to 0;
     */
    public void resetStrafeEncoder() {
    	strafeEncoder.reset();
    }
    /**
     * Returns the distance value of the Y axis encoder. This is for forward and reverse
     * @return
     * Returns the value in double format
     */
    public double readAutonEncoder() {
    	return autonEncoder.getDistance();
    }
    
    
    /**
     * Returns the distance value of the strafing encoder.
     * @return
     * Returns the value in double format
     */
    public double readStrafeEncoder() {
    	return strafeEncoder.getDistance();
    }
}

