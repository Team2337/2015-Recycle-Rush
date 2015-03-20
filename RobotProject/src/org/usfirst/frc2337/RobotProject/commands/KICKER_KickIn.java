package org.usfirst.frc2337.RobotProject.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject.Robot;

/**
 * The KICKER_KickOut Class retracts the lift kicker
 */
public class KICKER_KickIn extends Command {

    public KICKER_KickIn() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.kicker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		//Robot.kicker.autoOff = true;
    		Robot.kicker.solenoid.set(DoubleSolenoid.Value.kForward);
    		Robot.kicker.stateOut = true;
    		Robot.led.kickerLED(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
