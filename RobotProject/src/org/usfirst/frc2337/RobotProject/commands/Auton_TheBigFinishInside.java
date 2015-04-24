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
import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *  With Strafe Encoder, Acceleration Profile, Tuned PID on drive encoder, and Gyro(IMU).
 */
public class Auton_TheBigFinishInside extends CommandGroup {
	
    public  Auton_TheBigFinishInside() {
    	
    	addSequential(new ResetEncoder());
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos15));
    	addSequential(new MetaTrolleyBrake_On());
    	
    	addSequential(new Auton_ChassisPidSetWithToteSensor(-300));	
    	
    	
    	
    }
    
}
