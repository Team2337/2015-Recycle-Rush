package org.usfirst.frc2337.RobotProject.commands;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.*;

/**
 *
 */
public class PNEUMATICS_CompressorStart extends Command {
	
	Compressor compressor = RobotMap.pneumaticsCompressor;

    public PNEUMATICS_CompressorStart() {
        // Use requires() here to declare subsystem dependencies
    	requires (Robot.pneumatics);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	compressor.start();
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
