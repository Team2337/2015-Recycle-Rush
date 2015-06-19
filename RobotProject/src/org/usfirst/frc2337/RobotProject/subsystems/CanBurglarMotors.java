package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


public class CanBurglarMotors extends Subsystem {

	CANTalon armLeft = RobotMap.canburglarleft;
	CANTalon armRight = RobotMap.canburglarright;
	double autonRetract 	=  1.0;
	double autonDeploy 		= -1.0;
	double teleopRetract 	=  0.1;
	double teleopDeploy 	= -0.1;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new INTAKE_DoNothing());
    	
    	setDefaultCommand(new DoNothing());
    }

    public void autonDeployBurglar() {
    	armLeft.set	(autonDeploy);
    	armRight.set(autonDeploy);
    }
    
    public void autonRetractBurglar() {
    	armLeft.set (autonRetract);
    	armRight.set(autonRetract);
    }
    
    public void deployBurglar() {
    	armLeft.set	(teleopDeploy);
    	armRight.set(teleopDeploy);
    }
    
    public void retractBurglar() {
    	armLeft.set	(teleopRetract);
    	armRight.set(teleopRetract);
    }
    
    public void controlBurglar(double speedFactor) {
    	armLeft.set	(speedFactor);
    	armRight.set(speedFactor);
    }
    
    public boolean isFwdLimitSwitch() {
    	return (armLeft.isFwdLimitSwitchClosed() || armRight.isFwdLimitSwitchClosed());
    }
    
    public boolean isRevLimitSwitch() {
    	return (armLeft.isRevLimitSwitchClosed() || armRight.isRevLimitSwitchClosed());
    }
}

