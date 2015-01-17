package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class chassis extends Subsystem {
	//Declare variables and subsystem's contents
    SpeedController frontLeft = RobotMap.chassisfrontLeft;
    SpeedController backLeft = RobotMap.chassisbackLeft;
    SpeedController frontRight = RobotMap.chassisfrontRight;
    SpeedController backRight = RobotMap.chassisbackRight;
    RobotDrive robotDrive = new RobotDrive(backLeft, frontLeft, backRight, frontRight);
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

