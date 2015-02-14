package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.CONTAINERARM_JoystickRun;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ContainerArmMotor extends Subsystem {
    SpeedController containerArm = RobotMap.containerArm;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    boolean joystickStatus = true;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CONTAINERARM_JoystickRun());
    }
    public void joystickModeOn() {
    	this.joystickStatus = true;
    	
    }
    public void joystickModeOff() {
    	this.joystickStatus = false;
    	
    }
    public boolean joystickModeStatus() {
    	return this.joystickStatus;
    }
}

