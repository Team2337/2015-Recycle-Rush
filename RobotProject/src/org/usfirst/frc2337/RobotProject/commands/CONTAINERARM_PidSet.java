

package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject.Robot;

/**
 *
 */
public class  CONTAINERARM_PidSet extends Command {

		double pos;

    
    public CONTAINERARM_PidSet(double pos) {
        // Use requires() here to declare subsystem dependencies
    	
    	requires(Robot.containerArmLift);
    	
    	this.pos = pos;
    	
  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        	
        	Robot.containerArmLift.setSetpoint(pos);

	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    	// return (Robot.containerArmLift.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
