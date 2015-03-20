package org.usfirst.frc2337.RobotProject.subsystems;
// RobotBuilder Version: 1.5

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Pneumatics extends Subsystem {

    Compressor compressor = RobotMap.pneumaticsCompressor;
 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
        setDefaultCommand(new Pneumatics_DoNothing());
    }
}

