package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class MetaTrolleyBrake extends Subsystem {
    
	//public DigitalInput fingerSensor = RobotMap.kickerFingerSensor;
	public DoubleSolenoid solenoidB = RobotMap.metaTrolleyBrakeSolenoid;


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());\
    	setDefaultCommand(new MetaTrolleyBrake_DoNothing());
    }
    /**
     * Sets the MetaTrolley brake on.
     */
    public void on() {
    	solenoidB.set(DoubleSolenoid.Value.kReverse);
    }
    /**
     * Sets the MetaTrolley brake off.
     */
    public void off() {
    	solenoidB.set(DoubleSolenoid.Value.kForward);
    }

}

