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
public class Auton_CanBurglarWiggleWiggleWiggle extends CommandGroup {
	
    public  Auton_CanBurglarWiggleWiggleWiggle() {
    	
    	addSequential(new Auton_CANBURGLAR_Deploy(1.0));
     	addSequential(new AutonDriveAtSpeedForTimeGyro(0.4, 0.1));
    	addSequential(new AutonDriveAtSpeedForTimeGyro(-0.4, 0.2));
    	addSequential(new AutonDriveAtSpeedForTimeGyro(0.4, 0.1));
    	addSequential(new AutonWait(0.4));
    	//addSequential(new AutonStrafeAtSpeedForTime(1, 3));
    	//addSequential(new AutonEncoderStrafeIn(1, 200));
    	
    }
}
