package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.KICKER_AutoKick;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Kicker extends Subsystem {
    
	DigitalInput fingerSensor = RobotMap.kickerFingerSensor;
	DoubleSolenoid solenoid = RobotMap.kickerSolenoid;
	public boolean stateOut = false;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());\
    	setDefaultCommand(new KICKER_AutoKick());
    }
    
    public void kickOut() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    	stateOut = true;
    }
    public void kickIn() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    	stateOut = false;
    }
    
}

