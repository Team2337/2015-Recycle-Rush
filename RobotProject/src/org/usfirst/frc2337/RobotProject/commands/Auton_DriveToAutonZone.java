// RobotBuilder Version: 1.5
//


package org.usfirst.frc2337.RobotProject.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auton_DriveToAutonZone extends CommandGroup {
    
    public  Auton_DriveToAutonZone() {

    	addSequential(new Auton_ChassisPidSet(275));
    	//addSequential(new AutonTurnDegreesCwPos(90));
    	//addSequential(new AutonEncoderStrafeOut(0.5, 5));
	
    }
}
