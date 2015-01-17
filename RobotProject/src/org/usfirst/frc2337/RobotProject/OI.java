package org.usfirst.frc2337.RobotProject;

import org.usfirst.frc2337.RobotProject.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


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

    public Joystick driverStation;
    
    public Joystick operatorJoystick;
    public JoystickButton operatorButtonA;
    public JoystickButton operatorButtonB;
    public JoystickButton operatorButtonX;
    public JoystickButton operatorButtonY;
    public JoystickButton operatorButtonBumperLeft;
    public JoystickButton operatorButtonBumperRight;
    public JoystickButton operatorButtonBack;
    public JoystickButton operatorButtonStart;
    public JoystickButton operatorButtonHatLeft;
    public JoystickButton operatorButtonHatRight;
    
    public Joystick driverJoystick;
    public JoystickButton driverButtonA;
    public JoystickButton driverButtonB;
    public JoystickButton driverButtonX;
    public JoystickButton driverButtonY;
    public JoystickButton driverButtonBumperLeft;
    public JoystickButton driverButtonBumperRight;
    public JoystickButton driverButtonBack;
    public JoystickButton driverButtonStart;
    public JoystickButton driverButtonHatLeft;
    public JoystickButton driverButtonHatRight;
    
    
    public OI() {
        driverJoystick = new Joystick(2);
        driverButtonHatRight = new JoystickButton(driverJoystick, 9);
        driverButtonHatRight.whileHeld(new DoNothing());
        driverButtonHatLeft = new JoystickButton(driverJoystick, 8);
        driverButtonHatLeft.whileHeld(new DoNothing());
        driverButtonStart = new JoystickButton(driverJoystick, 7);
        driverButtonStart.whileHeld(new DoNothing());
        driverButtonBack = new JoystickButton(driverJoystick, 6);
        driverButtonBack.whileHeld(new DoNothing());
        driverButtonBumperRight = new JoystickButton(driverJoystick, 5);
        driverButtonBumperRight.whileHeld(new DoNothing());
        driverButtonBumperLeft = new JoystickButton(driverJoystick, 4);
        driverButtonBumperLeft.whileHeld(new DoNothing());
        driverButtonY = new JoystickButton(driverJoystick, 3);
        driverButtonY.whileHeld(new DoNothing());
        driverButtonX = new JoystickButton(driverJoystick, 2);
        driverButtonX.whileHeld(new DoNothing());
        driverButtonB = new JoystickButton(driverJoystick, 1);
        driverButtonB.whileHeld(new DoNothing());
        driverButtonA = new JoystickButton(driverJoystick, 0);
        driverButtonA.whileHeld(new DoNothing());
        
        operatorJoystick = new Joystick(1);
        operatorButtonHatRight = new JoystickButton(operatorJoystick, 9);
        operatorButtonHatRight.whileHeld(new DoNothing());
        operatorButtonHatLeft = new JoystickButton(operatorJoystick, 8);
        operatorButtonHatLeft.whileHeld(new DoNothing());
        operatorButtonStart = new JoystickButton(operatorJoystick, 7);
        operatorButtonStart.whileHeld(new DoNothing());
        operatorButtonBack = new JoystickButton(operatorJoystick, 6);
        operatorButtonBack.whileHeld(new DoNothing());
        operatorButtonBumperRight = new JoystickButton(operatorJoystick, 5);
        operatorButtonBumperRight.whileHeld(new DoNothing());
        operatorButtonBumperLeft = new JoystickButton(operatorJoystick, 4);
        operatorButtonBumperLeft.whileHeld(new DoNothing());
        operatorButtonY = new JoystickButton(operatorJoystick, 3);
        operatorButtonY.whileHeld(new DoNothing());
        operatorButtonX = new JoystickButton(operatorJoystick, 2);
        operatorButtonX.whileHeld(new DoNothing());
        operatorButtonB = new JoystickButton(operatorJoystick, 1);
        operatorButtonB.whileHeld(new DoNothing());
        operatorButtonA = new JoystickButton(operatorJoystick, 0);
        operatorButtonA.whileHeld(new DoNothing());
        
        driverStation = new Joystick(0);
        

        // SmartDashboard Buttons

    }
    
    public Joystick getdriverStation() {
        return driverStation;
    }

    public Joystick getoperatorJoystick() {
        return operatorJoystick;
    }

    public Joystick getdriverJoystick() {
        return driverJoystick;
    }
}

