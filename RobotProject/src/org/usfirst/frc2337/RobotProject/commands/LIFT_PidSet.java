

package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject.Robot;

/**
 *
 */
public class  LIFT_PidSet extends Command {

    int pos; //What Pos (for Array)
    int type; //The type of Command (0 = Base Buttons) (1 = Tote Buttons)
    
    public LIFT_PidSet(int pos, int type) {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.lift);
    	
    	//Make the variables for this command usable through out it
    	this.pos = pos; 
    	this.type = type;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       //RobotMap.masterliftMotor.setVoltageRampRate(30);

    	//Type == 0 (So, thats the 'Base' buttons/positions
    	if (type == 0) {
        	
        	Robot.lift.setBase(pos); //Run command in Lift Subsytem

    	}
    	//Type == 1 (So, thats the 'Tote' buttons/positions
    	if (type == 1) {
    			Robot.lift.setTote(pos); //Run command in Lift Subsytem
    	}

    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return (Robot.lift.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.lift.enable();
    	Robot.lift.setSetpoint(Robot.lift.getPosition());
    	
       // RobotMap.masterliftMotor.setVoltageRampRate(0);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
