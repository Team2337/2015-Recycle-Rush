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

import org.usfirst.frc2337.RobotProject.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton joystickDriverButtonA;
    public JoystickButton joystickDriverButtonB;
    public JoystickButton joystickDriverButtonX;
    public JoystickButton joystickDriverButtonY;
    public JoystickButton joystickDriverBumperLeft;
    public JoystickButton joystickDriverBumperRight;
    public JoystickButton joystickDriverButtonBack;
    public JoystickButton joystickDriverButtonStart;
    public JoystickButton joystickDriverHatLeft;
    public JoystickButton joystickDriverHatRight;
    public Joystick joystickDriver;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystickDriver = new Joystick(0);
        
        joystickDriverHatRight = new JoystickButton(joystickDriver, 10);
        joystickDriverHatRight.whileHeld(new DoNothing());
        joystickDriverHatLeft = new JoystickButton(joystickDriver, 9);
        joystickDriverHatLeft.whileHeld(new DoNothing());
        joystickDriverButtonStart = new JoystickButton(joystickDriver, 8);
        joystickDriverButtonStart.whileHeld(new DoNothing());
        joystickDriverButtonBack = new JoystickButton(joystickDriver, 7);
        joystickDriverButtonBack.whileHeld(new DoNothing());
        joystickDriverBumperRight = new JoystickButton(joystickDriver, 6);
        joystickDriverBumperRight.whileHeld(new DoNothing());
        joystickDriverBumperLeft = new JoystickButton(joystickDriver, 5);
        joystickDriverBumperLeft.whileHeld(new DoNothing());
        joystickDriverButtonY = new JoystickButton(joystickDriver, 4);
        joystickDriverButtonY.whileHeld(new DoNothing());
        joystickDriverButtonX = new JoystickButton(joystickDriver, 3);
        joystickDriverButtonX.whileHeld(new DoNothing());
        joystickDriverButtonB = new JoystickButton(joystickDriver, 2);
        joystickDriverButtonB.whileHeld(new DoNothing());
        joystickDriverButtonA = new JoystickButton(joystickDriver, 1);
        joystickDriverButtonA.whileHeld(new DoNothing());

	    
        // SmartDashboard Buttons
        SmartDashboard.putData("DriveStopMotors", new DriveStopMotors());

        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        SmartDashboard.putData("AutonDriveUntilBlocked", new AutonDriveUntilBlocked());

        SmartDashboard.putData("AutonDriveUntilUnblocked", new AutonDriveUntilUnblocked());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getjoystickDriver() {
        return joystickDriver;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

