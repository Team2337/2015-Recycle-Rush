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
public class Auton_Nested_A extends CommandGroup {
	
    public  Auton_Nested_A() {
    	
    	setTimeout(14.3);											// set Auton timer here
    	
    	addSequential(new ResetGyro());
    	addSequential(new ResetEncoder());
    	addSequential(new ResetStrafeEncoder());

    	addSequential(new Auton_Summary_Initial_Block());
    	//addParallel(new Auton_Summary_ArmsIntake());
    	addSequential(new Auton_Summary_GrabTote2());
    	//addSequential(new Auton_Summary_ArmsStop());
    	addSequential(new Auton_Summary_MoveToTote3AndPush());
    	//addParallel(new Auton_Summary_ArmsIntake());
    	addSequential(new Auton_Summary_TheBigFinish());
    	//addSequential(new Auton_Summary_ArmsStop());
    	
    	
    	
    }
    
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
		Timer.delay(.1);
		//Robot.lift.setSetpoint(1.8);				//trying to back away from stacked totes to score auton points
		//Robot.kicker.kickIn();

		for (int i = 0; i < 15; i++) {
			RobotMap.chassisbackLeft.set(0.5);
			RobotMap.chassisbackRight.set(0.5);
			RobotMap.chassisfrontLeft.set(-0.5);
			RobotMap.chassisfrontRight.set(-0.5);
			Timer.delay(.02);
		}
	}    
 
}
