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
public class Auton_Summary_Initial_Block extends CommandGroup {
    
    public  Auton_Summary_Initial_Block() {
    //	addParallel(new KICKER_KickIn());								//deploy kicker IN Just in case
    	addSequential(new AutonEncoderStrafeIn(0.5, -5));
    	//*****************MASK LACK OF STAFE ENCODER
    //	addSequential(new AutonStrafeAtSpeedForTimeGyro(-0.5, 0.3));	//strafe out to clear handle of can when driving forward
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos1));   	//lift tote to position 1
    	
    	//AVOID CONTAINER
    	addSequential(new AutonDriveAtSpeedForTimeGyro(-0.3, 0.11));	//drive back to clear can lid when lifting
    	
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos7));		//lift tote to position to clear can

    	addSequential(new AutonEncoderStrafeOut(0.5, 10));				// changed at kettering for container arm
    	//*****************MASK LACK OF STAFE ENCODER
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(0.5, 0.3));		//strafe in to set down tote 1 on tote 2
    	//addSequential(new AutonWait(1));								// STILL NEED??????

    	//DRIVE TO TOTE 2   	
    	//addSequential(new AutonDriveForEncoderGyroIterative(290));			//ramp speed up and drive past container
    	addSequential(new AutonDriveForTimeGyroIterative(.85));			//ramp speed up and drive past container

    	addParallel(new Auton_ChassisPidSetWithToteSensor(600));		//drive to 2nd tote, reset setpoint when sensor sees tote
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos2));		//lower tote to pos 2 in parallel while driving to next tote

	
    }
}
