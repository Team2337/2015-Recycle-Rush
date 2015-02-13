package org.usfirst.frc2337.RobotProject.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

/**
 *
 */
public class IntakePneumatics extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Solenoid rightSolenoid = RobotMap.intakeRightSolenoid;
    Solenoid leftSolenoid = RobotMap.intakeLeftSolenoid;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new INTAKEPNEUMATICS_ArmsIn());
    }
    public void armsOut() {
    	rightSolenoid.set(true);
    	leftSolenoid.set(true);
    }
    public void armsIn() {
    	rightSolenoid.set(false);
    	leftSolenoid.set(false);
    }
}

