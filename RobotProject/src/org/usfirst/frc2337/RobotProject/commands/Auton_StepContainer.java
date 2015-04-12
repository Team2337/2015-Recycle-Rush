// RobotBuilder Version: 1.5
//

package org.usfirst.frc2337.RobotProject.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton_StepContainer extends CommandGroup {
    
    public  Auton_StepContainer() {
        // Add Commands here:


       	addParallel(new Auton_ChassisPidSet(15)); 	
    	addSequential(new MultiPurposeGrabber_Open()); 
    	addSequential(new AutonWait(1.0));
    	addSequential(new Auton_ChassisPidSet(-300));

	
    }
}
