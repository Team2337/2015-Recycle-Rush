package org.usfirst.frc2337.RobotProject.commands;
// RobotBuilder Version: 1.5


import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 *
 */
public class  Auton_CanBurglarRetract extends Command {
	
    public Auton_CanBurglarRetract() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.canBurglar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.canBurglar.autonRetractBurglar();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.canBurglar.isRevLimitSwitch() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
