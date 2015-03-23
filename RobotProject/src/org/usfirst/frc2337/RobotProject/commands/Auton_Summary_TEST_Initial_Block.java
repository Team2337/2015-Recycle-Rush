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

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton_Summary_TEST_Initial_Block extends CommandGroup {
    
    public  Auton_Summary_TEST_Initial_Block() {

    	
    	
    	
    	addSequential (new MetaTrolleyGrabber_Closed());
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos3));   	//lift Container above first Tote


    	//addSequential(new AutonEncoderStrafeOut(0.5, 5));				//Should not need because arms will grab away from tote allowing us to move backwards without needing to strafe
    	addSequential(new Auton_ChassisPidSet(-171));
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos12));
    	
    	
    	
    	addSequential(new AutonEncoderStrafeIn(0.5, -5));				//Strafe in to engage and pick up tote 1

    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos1));   	//lift tote to position 1
    	addParallel(new KICKER_KickOut());								//deploy kicker so we have something to rest container on.
    	
 
    	addSequential(new AutonEncoderStrafeOut(0.5, 10));				// Strafe out to get behind second tote.

    	//addSequential(new AutonWait(.25));							// STILL NEED??????  Check this

    	//DRIVE TO TOTE 2   	
    	addSequential(new AutonDriveForEncoderGyroIterative(290));	//ramp speed up and drive past container
    	//addSequential(new AutonDriveForTimeGyroIterative(.85));			//ramp speed up and drive past container

    	addParallel(new Auton_ChassisPidSetWithToteSensor(600));		//drive to 2nd tote, reset setpoint when sensor sees tote
    	//addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos2));		//lower tote to pos 2 in parallel while driving to next tote

	
    }
}
