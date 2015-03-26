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
public class Auton_Summary_TheBigFinish extends CommandGroup {
    
    public  Auton_Summary_TheBigFinish() {
    	
    	
    	addParallel(new INTAKE_OpenArms_ArmsOut());
    	addSequential(new INTAKE_ExtendArms_ArmsOut());
    	addSequential(new Auton_ActivateMotors(-1,1));
    	


       	addSequential(new AutonEncoderStrafeIn(1.0, -300)); 		//.8
    	addSequential(new Auton_ActivateMotors(0,0));
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));		//		STILL NEED ????
    	addSequential(new AutonEncoderStrafeIn(0.8, -750));
    	//addSequential(new AutonStrafeAtSpeedForTimeGyro(0.8, 2.4));		//strafe into the auton zone
    	
      	//addSequential(new Auton_ActivateMotors(-1,1));
    	//addSequential(new AutonTurnDegreesCcwNeg(-80));
    	//addSequential(new Auton_ActivateMotors(0,0));
    	
    	//addSequential(new AutonWait(0.2));							// Removed during testing.
    	//========addParallel(new KICKER_KickIn());	//======================================================================
    	//addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));		//lower lift to release tote
    	


    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos12));	//lower lift to ground to prepare for teleop
    	
    	
    	addParallel(new INTAKE_OpenArms_ArmsIn());
    	addSequential(new INTAKE_ExtendArms_ArmsIn());
    	addSequential(new Auton_ActivateMotors(0,0));
    	
    	//addSequential(new AutonEncoderStrafeOut(0.8, -749));			//goes back a couple feet for some reason
		
    }
}
