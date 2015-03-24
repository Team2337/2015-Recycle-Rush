package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


public class IntakeMotors extends Subsystem {

    SpeedController intakeLeftArmMotor = RobotMap.intakeLeftArmMotor;
    SpeedController intakeRightArmMotor = RobotMap.intakeRightArmMotor;


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new INTAKE_DoNothing());
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
    
    public void setIntakeMotorsLeft() {		// not sure if direction is right on these two
	intakeLeftArmMotor.set(1);
	intakeRightArmMotor.set(1);
    }
    
    public void setIntakeMotorsRight() {
	intakeLeftArmMotor.set(-1);
	intakeRightArmMotor.set(-1);
    }
    
}

