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
public class Auton_Summary_GrabTote2 extends CommandGroup {
    
    public  Auton_Summary_GrabTote2() {

    	

    	
    	
       	//SET DOWN TOTE 1 ON TOTE 2
    	addSequential(new AutonEncoderStrafeIn(0.8, -15));
    	
    	addParallel(new INTAKE_OpenArms_ArmsOut());
    	addSequential(new INTAKE_ExtendArms_ArmsOut());
    	addSequential(new Auton_ActivateMotors(-1,1));

    	//addParallel(new KICKER_KickIn());								//kicker already in?????????
    	//addSequential(new MetaTrolleyBrake_On());
    	addSequential(new AutonWait(0.7));
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos4));		//set down tote and get ready to pick up 2nd tote
    	addSequential(new KICKER_KickIn());								//kicker already in?????????
    	addSequential(new AutonEncoderStrafeIn(0.8, -35));				//Changed 3/22 from -30    //Changed at kettering from -20

     	addSequential(new AutonWait(0.5));
      	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos5));		//grab 2 tote stack
      	//addSequential(new MetaTrolleyBrake_Off());
    	
    	addParallel(new Auton_ActivateMotors(0,0));					//Moved from line 46
    	addSequential(new INTAKE_OpenArms_ArmsIn());
    	addSequential(new INTAKE_ExtendArms_ArmsIn());
    	
    	addSequential(new ChassisDisable());
    	addSequential(new AutonDriveAtSpeedForTimeGyro(-0.3, 0.3));		//drive back to clear can lid when lifting
    	


  

    	
    }
}
