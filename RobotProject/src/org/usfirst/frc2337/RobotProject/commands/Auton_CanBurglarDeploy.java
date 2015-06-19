package org.usfirst.frc2337.RobotProject.commands;
// RobotBuilder Version: 1.5


import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;

/**
 *
 */
public class  Auton_CanBurglarDeploy extends Command {
	
	double timeout;
	boolean maintainHold = false;
	
    public Auton_CanBurglarDeploy() {
        requires(Robot.canBurglar);
        timeout = .3;
        maintainHold = false;
    }
    
    public Auton_CanBurglarDeploy(double timeout) {
    	requires(Robot.canBurglar);
    	this.timeout = timeout;
    	maintainHold = true;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.canBurglar.autonDeployBurglar();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (maintainHold = true) {
    		return isTimedOut();
    	} else {
    		return Robot.canBurglar.isFwdLimitSwitch() || isTimedOut();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
