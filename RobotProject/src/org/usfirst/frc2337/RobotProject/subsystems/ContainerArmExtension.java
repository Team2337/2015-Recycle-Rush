package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.CONTAINERARM_ExtensionIn;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerArmExtension extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Compressor compressor = RobotMap.pnuematicsCompressor;
	Solenoid Solenoid1  =  RobotMap.containerSolenoid1;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CONTAINERARM_ExtensionIn());
    }
    public void extOut() {
    	Solenoid1.set(true);
    }
    public void extIn() {
    	Solenoid1.set(false);
    }
}

