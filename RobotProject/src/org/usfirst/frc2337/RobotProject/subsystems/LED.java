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
	Solenoid PIDLED =  RobotMap.ledPID;
	Solenoid bumperLED = RobotMap.ledBumper;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LED_Auto());
    }
    
    public void kickerLED(boolean kicker, boolean finger, boolean flasher) {
    	if (!Robot.kicker.autoOff) {
    		kickerLED.set(finger);
    	}
    	else if (flasher) {
    		kickerLED.set(kicker);
    	}
    	else {
    		kickerLED.set(false);
    	}
    }
    public void PIDLED(boolean on) {
    	PIDLED.set(on);
    }
    public void bumperLED(boolean on) {
    	bumperLED.set(on);
    }
}

