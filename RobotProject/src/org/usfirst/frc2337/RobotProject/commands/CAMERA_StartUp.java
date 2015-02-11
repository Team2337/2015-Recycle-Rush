package org.usfirst.frc2337.RobotProject.commands;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.subsystems.Camera;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class CAMERA_StartUp extends Command {

    public CAMERA_StartUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.Camera);

    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	//RobotMap.usbCamera1.startAutomaticCapture("cam0");
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
