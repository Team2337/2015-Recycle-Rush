package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.KICKER_DoNothing;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class Kicker extends Subsystem {
    
	//public DigitalInput fingerSensor = RobotMap.kickerFingerSensor;
	public DoubleSolenoid solenoid = RobotMap.kickerSolenoid;
	/** Defines the position of the kicker */
	public boolean stateOut = false;
	public boolean autoOff = false;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());\
    	//setDefaultCommand(new KICKER_DoNothing());
    }
    /**
     * Sets the kicker to the out position.
     */
    public void kickOut() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    	stateOut = true;
    	Robot.led.kickerLED(true);
    }
    /**
     * Sets the kicker to the in position.
     */
    public void kickIn() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    	stateOut = false;
    	Robot.led.kickerLED(false);
    }
    /**
     * Returns the position of the kicker
     * @return true or false.
     */
    public boolean getPosition() {
    	return stateOut;
    }

}

