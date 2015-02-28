package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Intake extends Subsystem {

    SpeedController intakeLeftArmMotor = RobotMap.intakeLeftArmMotor;
    SpeedController intakeRightArmMotor = RobotMap.intakeRightArmMotor;


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new INTAKE_DoNothing());
    }
    
/**
 * Sets the motor speed of the left intake arm
 * @param speed
 * Accepts double
 */

	public void setLeftArmSpeed(double speed) {
    	intakeLeftArmMotor.set(speed);
    }
/**
* Sets the motor speed of the right intake arm
* @param speed
* Accepts double
*/	
    public void setRightArmSpeed(double speed) {
    	intakeRightArmMotor.set(speed);
    }
    
/**
 * Sets the intake motor speed to 0;
 */
    public void setIntakeMotorsStop() {
	intakeLeftArmMotor.set(0);
	intakeRightArmMotor.set(0);
    }

    
}

