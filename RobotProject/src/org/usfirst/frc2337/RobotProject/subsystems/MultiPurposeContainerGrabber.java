package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class MultiPurposeContainerGrabber extends Subsystem {
    

	//public Solenoid solenoidC = RobotMap.containerSolenoid1;


    public void initDefaultCommand() {

    	//setDefaultCommand(new DoNothing());
    }
    /**
     * Sets the MetaTrolley brake on.
     */
    public void on() {
  //  	solenoidC.set(true);
    }
    /**
     * Sets the MetaTrolley brake off.
     */
    public void off() {
    //	solenoidC.set(false);
    }
    public void getState() {
   // 	solenoidC.get();
    
    }

}

