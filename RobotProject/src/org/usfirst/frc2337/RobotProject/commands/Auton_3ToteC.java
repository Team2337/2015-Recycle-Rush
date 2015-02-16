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
public class Auton_3ToteC extends CommandGroup {
	
    public  Auton_3ToteC() {
        // Add Commands here:
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
    	//Auton_LIFT_PidSet(Robot.lift.autonPos)

    	addSequential(new ResetEncoder());
    	addSequential(new KICKER_StopKick());
    	
    	
    	//LIFT TOTE 1
    	addParallel(new KICKER_Kick());								//deploy kicker
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos1));   					//lift tote to position 1
    	
    	//AVOID CONTAINER
    	addSequential(new AutonDriveAtSpeedForTime(-0.3, 0.5));		//drive back to clear can lid when lifting
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos2));							//lift tote to position 6 to clear can
    	addSequential(new AutonStrafeAtSpeedForTime(-0.5, 0.3));	//strafe out to clear handle of can when driving forward
    	addSequential(new AutonWait(1));

    	//DRIVE TO TOTE 2
    	addSequential(new Auton_ChassisPidSet(80));					//drive past container
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));							//lower tote to pos 2 in parallel while driving to next tote
    	addSequential(new Auton_ChassisPidSet(500));				//drive to 2nd tote
    	
    	//SET DOWN TOTE 1 ON TOTE 2
    	addSequential(new AutonStrafeAtSpeedForTime(0.5, 0.2));		//strafe in to set down tote 1 on tote 2
    	addParallel(new KICKER_Kick());								//release kicker
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos4));						//set down tote and get ready to pick up 2nd tote
       	addSequential(new AutonStrafeAtSpeedForTime(0.3, 0.5));		//nest totes
    	
    	//made strafe above a parallel command, moved strafe after lift drop
    	
    	
    	
    	//AVOID CONTAINER 2: PART 1
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos5));						//grab 2 tote stack
    	addSequential(new AutonDriveAtSpeedForTime(-0.3, 0.5));		//drive back to clear can lid when lifting
    	
    	//PICK UP 2 TOTE STACK
    	addParallel(new KICKER_Kick());								//deploy kicker
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos6));						//pick up 2 tote stack
    	
    	//RESET ENCODER
    	addSequential(new ResetEncoder());
    	
    	//AVOID CONTAINER 2: PART 2
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos7));							//lift tote stack to position 6 to clear can
    	addSequential(new AutonStrafeAtSpeedForTime(-0.5, 0.7));	//strafe out to clear handle of can when driving forward
    	addSequential(new AutonWait(0.5));
    	
    	//DRIVE TO TOTE 3
    	//Changed to 200 from 100
    	//Changed to 300 from 200
    	addSequential(new Auton_ChassisPidSet(300));				//Drive past container
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));							//lower tote to pos 3 in parallel while driving to next tote
    	// Changed to 500 from 600
    	//Changed to 400 from 500
    	addSequential(new Auton_ChassisPidSet(600));				//Drive to next tote
    	
    	
    	
    	
    	
    	//SET DOWN TOTE & STRAFE TO AUTON ZONE
    	addParallel(new Auton_LIFT_PidSet(Robot.lift.autonPos3));							//lower tote to pos 7
    	addSequential(new AutonStrafeAtSpeedForTime(0.5, 1.5));		//strafe in to set down tote 1 on tote 2
    	addParallel(new KICKER_Kick());								//retract kicker				
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos3));						//lower intake to pos 0
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos3));
    	addSequential(new AutonStrafeAtSpeedForTime(0.8, 2.0));		//strafe into the auton zone
    	addSequential(new Auton_LIFT_PidSet(Robot.lift.autonPos12));
    	addSequential(new AutonWait(0.2));
    	addSequential(new AutonStrafeAtSpeedForTime(-0.8, 0.5));	//strafe away from totes
    	

    	
    	
    	
    	
    	
    	/*addSequential(new AutonWait(1));
    	
    	//addSequential(new AutonDriveAtSpeedForTime(-0.3,0.5));	//drive back to clear can lid when lifting
    	addSequential(new Auton_ChassisPidSet(-15));
    	addSequential(new AutonWait(1));
    	
    	addSequential(new LIFT_PidSet(5, 1));						//lift tote to position 5 to clear can
    	addParallel(new AutonStrafeAtSpeedForTime(-0.3, 0.5));		//strafe out to clear handle of can when driving forward
    	addSequential(new AutonWait(1));

    	//addSequential(new AutonDriveUntilBlocked());				//drive until blocked (can)
    	//addSequential(new AutonDriveUntilUnblocked());			//drive until unblocked (past can)
    	//addSequential(new AutonDriveUntilBlocked());				//drive to next tote
    	addSequential(new Auton_ChassisPidSet(531));
    	addParallel(new LIFT_PidSet(7, 1));							//lower tote to pos 2 in parallel while driving to next tote
    	addSequential(new AutonWait(1));
    	
    	addSequential(new AutonStrafeAtSpeedForTime(0.3,0.5));		//strafe in to set down tote 1 on tote 2
    	addSequential(new AutonWait(1));
    	
    	addSequential(new LIFT_PidSet(0,1));						//lower lift to set down tote and get ready to pick up 2nd tote
    	addSequential(new AutonWait(1));
    	
    	addSequential(new LIFT_PidSet(1,1)); */

    	
    }
}
