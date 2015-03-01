package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ContainerArmLift extends PIDSubsystem {

    SpeedController motor = RobotMap.containerArmMotor;
    AnalogPotentiometer potentiometer = RobotMap.armPotentiometer;
    
    //Lift PID variables
    /** Defines the tolerance for the rear arm*/
    double armSetPointTolerance = 0.05;
    /** Defines the maximum speed for the rear arm for the up direction */
    public double armMaxSpeedUp = 1.0;
    /** Defines the maximum speed for the rear arm for the down direction */
    public double armMaxSpeedDown = -1.0;
    /** Defines the top limit for the rear arm */
    public double armTopLimit = 3.88;
    /** Defines the bottom limit for the rear arm */
    public double armBottomLimit = 1.215;  //1.44;
	
    /** define the positions for the rear arm */
    double pos0,pos1,pos2,pos3,pos4,pos5,pos6,pos7;

    public ContainerArmLift() {
        super("ContainerArmLift", 2.0, 0.0, 0.0);
        setAbsoluteTolerance(armSetPointTolerance);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("ContainerArmLift", "PIDSubsystem Controller", getPIDController());   
        
        getPIDController().setOutputRange(armMaxSpeedDown, armMaxSpeedUp);   //For the Container Arm PID
        getPIDController().setInputRange(armBottomLimit, armTopLimit);
          	
        pos0 = 1.52; 						// container arm bottom position
        pos1 = 3.3;							// container arm level position
        pos2 = 3.6;							// container arm top position

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CONTAINERARM_JoystickThrottle());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return potentiometer.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        motor.pidWrite(-output);

    }
    /**
     *  Set the maximum and minimum soeeds for the arm
     */

    public void setSpeed() {
        getPIDController().setOutputRange(armMaxSpeedDown, armMaxSpeedUp);   //For the Arm PID
    }
}
