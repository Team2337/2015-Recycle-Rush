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
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton_3Tote extends CommandGroup {
    
    public  Auton_3Tote() {
        // Add Commands here:
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());


    	addSequential(new LIFT_PidSet(1,1));   						//lift tote to position 1 to pick up tote
    	addSequential(new AutonWait(1));
    	addSequential(new AutonDriveAtSpeedForTime(-0.3,0.5));		//drive back to clear can lid when lifting
    	addSequential(new AutonWait(1));
    	addParallel(new AutonStrafeAtSpeedForTime(-0.3,0.5));		//strafe out to clear handle of can when driving forward
    	addSequential(new AutonWait(1));
    	addSequential(new LIFT_PidSet(5,1));						//lift tote to position 5 to clear can
    	addSequential(new AutonWait(1));

    	//   works up to here so far...
    	
    	addSequential(new AutonDriveUntilBlocked());		//drive until blocked (can)
    	addSequential(new AutonWait(1));
    	addSequential(new AutonDriveUntilUnblocked());				//drive until unblocked (past can)
    	addSequential(new AutonWait(1));
    	addParallel(new LIFT_PidSet(1,2));				//lower tote to pos 2 in parallel while driving to next tote
    	addSequential(new AutonWait(1));
    	addSequential(new AutonDriveUntilBlocked());				//drive until blocked  (next tote)
    	addSequential(new AutonWait(1));
    	addSequential(new AutonStrafeAtSpeedForTime(0.3,0.5));		//strafe in to set down tote 1 on tote 2
    	addSequential(new AutonWait(1));
    	addSequential(new LIFT_PidSet(1,0));						//lower lift to set down tote and get ready to pick up 2nd tote
    	addSequential(new AutonWait(1));
    														//repeat process to go ot 3rd tote
    	addSequential(new LIFT_PidSet(1,1)); 

    }
}
