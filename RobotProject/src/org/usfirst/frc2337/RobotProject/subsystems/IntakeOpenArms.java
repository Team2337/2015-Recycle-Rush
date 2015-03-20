package org.usfirst.frc2337.RobotProject.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

/**
 *
 */
public class IntakeOpenArms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Solenoid openArmsSolenoid = RobotMap.intakeOpenSolenoid;

    /** Defines whether the intake arms are deployed in the open position or not */
    public boolean openArmPosition = true;
   

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new INTAKE_OpenArms_DoNothing());
    }

    /**
     * Deploys the intake arms
     */
    public void openArmsOut() {
    	openArmPosition = true;
    	openArmsSolenoid.set(true);
    }
    /**
     * Retracts the intake arms
     */
    public void openArmsIn() {
    	openArmPosition = false;
    	openArmsSolenoid.set(false);
    }
    /**
     * Returns the poisition of the intake arms
     * 
     * @return true or false
     */
    public boolean getArmPosition() {
    	return openArmPosition;
    }
    
}

