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
public class BUTTON_ScoreWithoutLower extends CommandGroup {
    
    public  BUTTON_ScoreWithoutLower() {

	
    	
    	addSequential(new MetaTrolleyGrabber_Open());	
    	addSequential(new MetaTrolleyBrake_On());
    	//addSequential(new AutonWait(.2));
    	//addSequential(new LIFT_PidSetMinusRelative(-0.8));
    	//addSequential(new INTAKE_OpenArms_ArmsIn());   
    	//addSequential(new INTAKE_ExtendArms_ArmsIn());

	
    }
    
}
