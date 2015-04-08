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
public class Auton_SummaryPostTroy extends CommandGroup {
    
    public  Auton_SummaryPostTroy() {

    	addSequential(new MetaTrolleyGrabber_Closed());					//Grab the can
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos14));	//Raise the can
    	//addParallel(new MetaTrolleyBrake_On());
    	addSequential(new Auton_ChassisPidSet(-135));					//Drive to 1st tote
    	
    	//addParallel(new INTAKE_OpenArms_ArmsOut());					//Enable the arm intake
    	//addParallel(new INTAKE_ExtendArms_ArmsOut());
    	//addParallel(new Auton_ActivateMotors(-1,1));
    	
    	//addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos4));		//Lower lift to pick up 1st tote
    	addSequential(new AutonEncoderStrafeIn(0.5, -35));				//Strafe in to tote

    	addParallel(new INTAKE_OpenArms_ArmsOut());						//Enable the arm intake
    	addParallel(new INTAKE_ExtendArms_ArmsOut());
    	addParallel(new Auton_ActivateMotors(-1,1));
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos4));		//Lower lift to pick up 1st tote
    	
    	addSequential(new AutonWait(0.3));
    	
    	//addParallel(new MetaTrolleyBrake_Off());
    	addParallel(new KICKER_KickOut());
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));   	//Lift tote to position 1
    	
    	addSequential(new Auton_ActivateMotors(0,0));					//Disable the arm intake
    	addParallel(new INTAKE_OpenArms_ArmsIn());
    	addSequential(new INTAKE_ExtendArms_ArmsIn());
    	
    	/// Initial Block
    	
      	addParallel(new KICKER_KickOut());
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));   	//lift tote to position 1
    	
    	//AVOID CONTAINER
    	//addSequential(new AutonDriveAtSpeedForTimeGyro(-0.3, 0.11));	//drive back to clear can lid when lifting
    	
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos2));		//lift tote to position to clear can
    	addSequential(new AutonEncoderStrafeOut(0.8, 10));				// changed at kettering for container arm  0.5
    	//*****************MASK LACK OF STAFE ENCODER
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(0.5, 0.3));		//strafe in to set down tote 1 on tote 2
    	//addSequential(new AutonWait(1));								// STILL NEED??????

    	//DRIVE TO TOTE 2   	
    	//addSequential(new AutonDriveForEncoderGyroIterative(290));			//ramp speed up and drive past container
    	addSequential(new AutonDriveForTimeGyroIterative(.85));			//ramp speed up and drive past container

    	addParallel(new Auton_ChassisPidSetWithToteSensor(600));		//drive to 2nd tote, reset setpoint when sensor sees tote
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos2));		//lower tote to pos 2 in parallel while driving to next tote
    	
    	
    	
    	//Grab Tote 2
    	
    	//SET DOWN TOTE 1 ON TOTE 2
    	addSequential(new AutonEncoderStrafeIn(0.8, -15));
    	
    	addParallel(new INTAKE_OpenArms_ArmsOut());
    	addSequential(new INTAKE_ExtendArms_ArmsOut());
    	addSequential(new Auton_ActivateMotors(-1,1));

    	//addParallel(new KICKER_KickIn());								//kicker already in?????????
    	//addSequential(new MetaTrolleyBrake_On());
    	addSequential(new AutonWait(0.7));
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos4));		//set down tote and get ready to pick up 2nd tote
    	addSequential(new KICKER_KickIn());								//kicker already in?????????
    	addSequential(new AutonEncoderStrafeIn(0.8, -35));				//Changed 3/22 from -30    //Changed at kettering from -20

     	addSequential(new AutonWait(0.7));
      	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos5));		//grab 2 tote stack
      	//addSequential(new MetaTrolleyBrake_Off());
    	
    	addParallel(new Auton_ActivateMotors(0,0));					//Moved from line 46
    	addSequential(new INTAKE_OpenArms_ArmsIn());
    	addSequential(new INTAKE_ExtendArms_ArmsIn());
    	
    	addSequential(new ChassisDisable());
    	//addSequential(new AutonDriveAtSpeedForTimeGyro(-0.3, 0.3));		//drive back to clear can lid when lifting
    	
    	
    	//Move To Tote 3
    	
    	addSequential(new KICKER_KickOut());								//deploy kicker
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
    	//addSequential(new AutonDriveForTimeGyroIterative(1.20));			//Ramp up speed and drive past container

    	//addSequential(new Auton_ChassisPidSetWithToteSensor(560));		//Drive to next tote with sensor
    	
    	addSequential(new AutonDriveForEncoderGyroIterativeWithToteSensor(560));
    	
    	//SET DOWN TOTE & STRAFE TO AUTON ZONE
    	addSequential(new AutonEncoderStrafeIn(0.8, -20));
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(0.8, 1.5));		//strafe in to set down tote 1 on tote 2
    	addSequential(new ChassisDisable());
    	addSequential(new AutonEncoderStrafeIn(0.8, -125));
    	
    	
    	//Finish
    	
    	addParallel(new INTAKE_OpenArms_ArmsOut());
    	addSequential(new INTAKE_ExtendArms_ArmsOut());
    	addSequential(new Auton_ActivateMotors(-1,1));
    	


       	addSequential(new AutonEncoderStrafeIn(1.0, -450)); 		//.8
    	addSequential(new Auton_ActivateMotors(0,0));
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos15));     //   commented out..................
    	
    	addSequential(new MetaTrolleyBrake_On());
    	//addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));		//		STILL NEED ????
    	addSequential(new AutonEncoderStrafeIn(0.8, -750));
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(0.8, 2.4));		//strafe into the auton zone
    	
      	//addSequential(new Auton_ActivateMotors(-1,1));
    	//addSequential(new AutonTurnDegreesCcwNeg(-80));
    	//addSequential(new Auton_ActivateMotors(0,0));
    	
    	//addSequential(new AutonWait(0.2));							// Removed during testing.
    	addSequential(new KICKER_KickIn());								// commented out.......................
    	//addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));		//lower lift to release tote
    	


    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos12));	//lower lift to ground to prepare for teleop
    																	//COMMENTED OUT..........
    	
    	
    	addParallel(new INTAKE_OpenArms_ArmsIn());
    	addSequential(new INTAKE_ExtendArms_ArmsIn());
    	addSequential(new Auton_ActivateMotors(0,0));
    	
    	//addSequential(new AutonEncoderStrafeOut(0.8, -749));			//goes back a couple feet for some reason
		
    	
    	
    	
    }
}
