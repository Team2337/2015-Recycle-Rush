package org.usfirst.frc2337.RobotProject.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc2337.RobotProject.commands.*;
import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class LED extends Subsystem {
	
	Solenoid kickerLED = RobotMap.ledKicker;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new LED_Auto());
    	setDefaultCommand(new LED_DoNothing());
    }
    
    /**
     * Sets the state of the kicker LED
     * @param on  Set to true if the LED is on
     * Accepts boolean
     */
    public void kickerLED(boolean on) {
    	kickerLED.set(on);
    }
    
}

