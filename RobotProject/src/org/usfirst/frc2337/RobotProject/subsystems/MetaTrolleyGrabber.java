package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class MetaTrolleyGrabber extends Subsystem {
    
	//public DigitalInput fingerSensor = RobotMap.kickerFingerSensor;
	public DoubleSolenoid solenoid = RobotMap.metaTrolleyBrakeSolenoid;


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());\
    	setDefaultCommand(new MetaTrolleyGrabber_DoNothing());
    }
    /**
     * Sets the MetaTrolley grabber closed.
     */
    public void closed() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    /**
     * Sets the MetaTrolley grabber open.
     */
    public void open() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    }
   
}

