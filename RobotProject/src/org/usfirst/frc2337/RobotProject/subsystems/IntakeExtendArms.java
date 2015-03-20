package org.usfirst.frc2337.RobotProject.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

/**
 *
 */
public class IntakeExtendArms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Solenoid rightSolenoid = RobotMap.intakeRightSolenoid;
    Solenoid leftSolenoid = RobotMap.intakeLeftSolenoid;
    /** Defines whether the intake arms are deployed or not */
    public boolean armPosition = true;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new INTAKE_ExtendArms_DoNothing());
    }

    /**
     * Deploys the intake arms
     */
    public void armsOut() {
    	armPosition = true;
    	leftSolenoid.set(true);
    }
    /**
     * Retracts the intake arms
     */
    public void armsIn() {
    	armPosition = false;
    	leftSolenoid.set(false);
    }
    /**
     * Returns the poisition of the intake arms
     * @return true or false
     */
    public boolean getArmPosition() {
    	return armPosition;
    }
    public void setArmPosition(boolean armPosition) {
    	this.armPosition = armPosition;
    }
    
}

