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
 *
 */
public class Auton_3ToteF_AfterKetteringWithToteC extends CommandGroup {
	
    public  Auton_3ToteF_AfterKetteringWithToteC() {
        // Add Commands here:
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
    	//Auton_LIFT_PidSet(Robot.lift.autonPos)

    	setTimeout(10.5);
    	
    	addSequential(new GyroReset());
    	addSequential(new ResetEncoder());
    	addSequential(new KICKER_StopKick());
    	
    	
    	//LIFT TOTE 1
    	addParallel(new KICKER_KickOut());									//deploy kicker
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));   	//lift tote to position 1
    	
    	//AVOID CONTAINER
    	addSequential(new AutonDriveAtSpeedForTimeGyro(-0.3, 0.15));		//drive back to clear can lid when lifting
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos7));		//lift tote to position 6 to clear can
    	addSequential(new AutonStrafeAtSpeedForTimeGyro(-0.5, 0.3));	//strafe out to clear handle of can when driving forward
    	addSequential(new AutonWait(1));

    	//DRIVE TO TOTE 2[]\
    	
    	addSequential(new AutonDriveForTimeGyroIterative(.75));					//drive past container

    	addParallel(new Auton_ChassisPidSetWithToteSensor(600));
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos2));		//lower tote to pos 2 in parallel while driving to next tote
    	//addSequential(new Auton_ChassisPidSet(144));					//drive to 2nd tote // from 510 at kettering  //527 at Kettering.
    	
    	//addSequential(new AutonWait(10));
    	
    	//SET DOWN TOTE 1 ON TOTE 2
    	addSequential(new AutonStrafeAtSpeedForTimeGyro(0.5, 0.3));		//strafe in to set down tote 1 on tote 2
    	addParallel(new KICKER_KickOut());									//release kicker
    	//addSequential(new AutonWait(.2));
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos4));		//set down tote and get ready to pick up 2nd tote
       	addSequential(new AutonStrafeAtSpeedForTimeGyro(0.4, 0.5));		//nest totes  Changed to .4 .5 Kettering comp.
	
    	
    	//AVOID CONTAINER 2: PART 1
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos5));		//grab 2 tote stack

    	addSequential(new ChassisDisable());
    	addSequential(new AutonDriveAtSpeedForTimeGyro(-0.3, 0.3));		//drive back to clear can lid when lifting
    	
    	//PICK UP 2 TOTE STACK
    	addParallel(new KICKER_KickIn());									//deploy kicker
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos6));		//pick up 2 tote stack
    	
    	//RESET ENCODER
    	addSequential(new ResetEncoder());
    	
    	//AVOID CONTAINER 2: PART 2
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos7));		//lift tote stack to position 6 to clear can
    	//Changed to .6 from .5 at kettering.
    	addSequential(new AutonStrafeAtSpeedForTimeGyro(-0.65, 0.6));	//strafe out to clear handle of can when driving forward
    	addSequential(new AutonWait(0.5));
    	
    	//DRIVE TO TOTE 3
    	//Changed to 200 from 100
    	//Changed to 300 from 200
    	addSequential(new AutonDriveForTimeGyroIterative(.85));					//Drive past container
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));		//lower tote to pos 3 in parallel while driving to next tote
    	//Changed to 500 from 600
    	
    	//Changed to 400 from 500
    	//Changed to 570 from 600
    	//Changed to 545 from 560  //  this was at Kettering
    	//changed to 525 from 545
    	addSequential(new Auton_ChassisPidSetWithToteSensor(600));					//Drive to next tote
    	addSequential(new ChassisDisable());
    	

    	//SET DOWN TOTE & STRAFE TO AUTON ZONE
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));		//lower tote to pos 7
    	addSequential(new AutonStrafeAtSpeedForTimeGyro(0.8, 1.5));		//strafe in to set down tote 1 on tote 2
    	addParallel(new KICKER_KickIn());									//retract kicker				
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));		//lower intake to pos 0
    	//addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos3));
    	addSequential(new AutonStrafeAtSpeedForTimeGyro(0.8, 1.8));		//strafe into the auton zone
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));		//lower lift to release tote
    	//addSequential(new AutonWait(0.2));
    	addSequential(new AutonStrafeAtSpeedForTimeGyro(-0.8, 0.15));	//strafe away from totes
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos12));	//lower left to ground to prepare for teleop

    	
    	
    }
    
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	protected void end() {
		Robot.lift.setSetpoint(1.8);
		Robot.kicker.kickOut();

		RobotMap.chassisbackLeft.set(0.8);
		RobotMap.chassisbackRight.set(0.8);
		RobotMap.chassisfrontLeft.set(-0.8);
		RobotMap.chassisfrontRight.set(-0.8);
		Timer.delay(.5);
	}
}
