package org.usfirst.frc2337.RobotProject.commands;
// RobotBuilder Version: 1.5


import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 *
 */
public class  CANBURGLAR_Deploy extends Command {
	
    public CANBURGLAR_Deploy() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
        requires(Robot.canBurglar);
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.canburglarright.set(1);
    	RobotMap.canburglarleft.set(1);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.canburglarleft.set(0);
    	RobotMap.canburglarright.set(0);   
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
    		this.end();
    }
}
