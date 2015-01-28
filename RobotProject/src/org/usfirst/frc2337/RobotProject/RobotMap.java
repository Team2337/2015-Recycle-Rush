// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject;
    

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Vector;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController liftMotor;
    public static AnalogPotentiometer liftPotentiometer;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //Limit Switches for Tote Lift Mechanism
    public static DigitalInput liftUpperLimitSwitch;
    public static DigitalInput liftLowerLimitSwitch;
    //PowerDistroPanel for reading Volts and Amps.
    public static PowerDistributionPanel pdp;
    //In-take Motors for Arms
    public static SpeedController intakeLeftArmMotor;
    public static SpeedController intakeRightArmMotor;
    
    public static DigitalInput liftAutoTote;
    
    
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS   

        liftMotor = new Talon(4);
        LiveWindow.addActuator("Lift", "Motor", (Talon) liftMotor);
        
        liftPotentiometer = new AnalogPotentiometer(2, 10.0, 0.0);
        LiveWindow.addSensor("Lift", "Potentiometer", liftPotentiometer);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        //Init In-Take Motors
        liftUpperLimitSwitch = new DigitalInput(0);
        liftLowerLimitSwitch = new DigitalInput(1);
        LiveWindow.addActuator("Lift", "LimitUpper", liftUpperLimitSwitch);
        LiveWindow.addActuator("Lift", "LimitLower", liftLowerLimitSwitch);
        
        liftAutoTote = new DigitalInput(2);
        LiveWindow.addActuator("Lift", "AutoTote", liftAutoTote);
        
        
        pdp = new PowerDistributionPanel();
        LiveWindow.addSensor("Lift", "PDP1", pdp);
    }
}
