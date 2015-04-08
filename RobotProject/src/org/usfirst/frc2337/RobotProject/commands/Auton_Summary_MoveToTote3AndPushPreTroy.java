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
public class Auton_Summary_MoveToTote3AndPushPreTroy extends CommandGroup {
    
    public  Auton_Summary_MoveToTote3AndPushPreTroy() {

    	
    	//PICK UP 2 TOTE STACK
    	addParallel(new KICKER_KickOut());								//deploy kicker
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos6));		//pick up 2 tote stack
    	
     	//RESET ENCODER
    	addSequential(new ResetEncoder());
    	
    	//AVOID CONTAINER 2: PART 2
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos9));		//lift tote stack to position 6 to clear can
    	//Changed to .6 from .5 at kettering.
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(-0.65, 0.6));	//strafe out to clear handle of can when driving forward
    	addSequential(new AutonEncoderStrafeOut(0.8, 10));				// changed at kettering for container arm  .65
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(-0.5, 0.4));	//strafe out to clear handle of can when driving forward
    	
    	//addParallel(new MetaTrolleyBrake_On());
    	//addSequential(new AutonWait(0.5));								//STILL NEED ?????
    	
    	//DRIVE TO TOTE 3
    	//addSequential(new AutonDriveForEncoderGyroIterative(290));			//Ramp up speed and drive past container
    	addSequential(new AutonDriveForTimeGyroIterative(1.05));			//Ramp up speed and drive past container

    	addSequential(new Auton_ChassisPidSetWithToteSensor(560));		//Drive to next tote with sensor

    	//SET DOWN TOTE & STRAFE TO AUTON ZONE
    	addSequential(new AutonEncoderStrafeIn(0.8, -20));
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(0.8, 1.5));		//strafe in to set down tote 1 on tote 2
    	addSequential(new ChassisDisable());
    	addSequential(new AutonEncoderStrafeIn(0.8, -125));
    }
}
