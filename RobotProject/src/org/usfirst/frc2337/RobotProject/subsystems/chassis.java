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
    SpeedController frontLeft = RobotMap.chassisFrontLeft;
    SpeedController backLeft = RobotMap.chassisBackLeft;
    SpeedController frontRight = RobotMap.chassisFrontRight;
    SpeedController backRight = RobotMap.chassisBackRight;
    RobotDrive robotDrive = new RobotDrive(backLeft, frontLeft, backRight, frontRight);
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    /**
     * Set the default command that will be run whenever no commands for this subsystem are queued.
     */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

