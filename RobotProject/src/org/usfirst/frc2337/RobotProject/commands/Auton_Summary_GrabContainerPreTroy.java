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
public class Auton_Summary_GrabContainerPreTroy extends CommandGroup {
    
    public  Auton_Summary_GrabContainerPreTroy() {

    	addSequential(new MetaTrolleyGrabber_Closed());					//Grab the can
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos14));	//Raise the can
    	//addParallel(new MetaTrolleyBrake_On());
    	addSequential(new Auton_ChassisPidSet(-135));					//Drive to 1st tote
    	
    	//addParallel(new INTAKE_OpenArms_ArmsOut());					//Enable the arm intake
    	//addParallel(new INTAKE_ExtendArms_ArmsOut());
    	//addParallel(new Auton_ActivateMotors(-1,1));
    	
    	//addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos4));		//Lower lift to pick up 1st tote
    	addSequential(new AutonEncoderStrafeIn(0.5, -45));				//Strafe in to tote

    	addParallel(new INTAKE_OpenArms_ArmsOut());						//Enable the arm intake
    	addParallel(new INTAKE_ExtendArms_ArmsOut());
    	addParallel(new Auton_ActivateMotors(-1,1));
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos4));		//Lower lift to pick up 1st tote
    	
    	addSequential(new AutonWait(0.3));
    	
    	addParallel(new MetaTrolleyBrake_Off());
    	addParallel(new KICKER_KickOut());
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));   	//Lift tote to position 1
    	
    	addSequential(new Auton_ActivateMotors(0,0));					//Disable the arm intake
    	addParallel(new INTAKE_OpenArms_ArmsIn());
    	addSequential(new INTAKE_ExtendArms_ArmsIn());
    }
}
