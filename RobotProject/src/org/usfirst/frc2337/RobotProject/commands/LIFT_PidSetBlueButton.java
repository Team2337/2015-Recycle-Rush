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
public class LIFT_PidSetBlueButton extends CommandGroup {
    
    public  LIFT_PidSetBlueButton() {
        // Add Commands here:
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());

    	//addSequential(new KICKER_KickOut());		// Extend Kicker
    	addSequential(new LIFT_PidSetWithSpeed(6,1,.5,-.5)); 	//lift tote to position 6 to pick up container

	
    }
}
