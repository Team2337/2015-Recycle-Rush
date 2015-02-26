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

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
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
    
    //Buttons for Lift Positions
    public JoystickButton operatorControlsBase1;
    public JoystickButton operatorControlsBase2;
    public JoystickButton operatorControlsBase3;
    public JoystickButton operatorControlsLift0;
    public JoystickButton operatorControlsLift1;
    public JoystickButton operatorControlsLift2;
    public JoystickButton operatorControlsLift3;
    public JoystickButton operatorControlsLift4;
    public JoystickButton operatorControlsLift5;
    public JoystickButton operatorControlsAutoTote;
    public JoystickButton operatorControlsLiftToggle;
    public JoystickButton operatorControlsKickToggle;
    public JoystickButton operatorControlsJoystickMode;
    public JoystickButton operatorControlsExtension;
    public Joystick operatorControls;
    
    //Buttons for intake/kicker
    public JoystickButton intakePull;
    public JoystickButton intakePush;
    public JoystickButton intakeRight;
    public JoystickButton intakeLeft;
    public JoystickButton intakeDeploy;
    public JoystickButton kickerKick;
    public Joystick liftJoystick; //Lift Control (Precise Motor Action)

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    	//Speed for the motors for any given button or command
   	    double speed = 1.0;
        double p = 1; //Positive
        double n = -1; //Negative
        
        //Pull commands. 
        double rightPull = speed * p; 
        double leftPull = speed * n;
        
        //Push commands. 
        double rightPush = speed * n;
        double leftPush = speed * p;
        		
        //Declare variables
        
        double rightRotateRight,leftRotateRight, leftRotateLeft,rightRotateLeft;
        
        //Rotating commands
        rightRotateRight = leftRotateRight = speed *p;
        leftRotateLeft = rightRotateLeft = speed * n;  	
    	
    	//Joystick Driver
        joystickDriver = new Joystick(0);
        
        /*
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
        joystickDriverButtonA = new JoystickButton(joystickDriver, 1);				//resets encoder
        joystickDriverButtonA.whileHeld(new ResetEncoder());
        */
        
        //Joystick Control, for Lift (Precise) (Operator Right hand)
        liftJoystick = new Joystick(1); 
        
        intakeDeploy = new JoystickButton(liftJoystick, 11);
        intakeDeploy.whileHeld(new INTAKEPNEUMATICS_ArmsOut());
        intakeLeft = new JoystickButton(liftJoystick, 4);
        intakeLeft.whileHeld(new INTAKE_ActivateMotors(leftRotateLeft,rightRotateLeft));
        intakeRight = new JoystickButton(liftJoystick, 5);
        intakeRight.whileHeld(new INTAKE_ActivateMotors(leftRotateRight,rightRotateRight));
        intakePush = new JoystickButton(liftJoystick, 3);
        intakePush.whileHeld(new INTAKE_ActivateMotors(leftPush,rightPush));
        intakePull = new JoystickButton(liftJoystick, 1);
        intakePull.whileHeld(new INTAKE_OutAndPull(leftPull,rightPull));
        operatorControlsKickToggle = new JoystickButton(liftJoystick, 8);
        operatorControlsKickToggle.whenPressed(new KICKER_StopKick());
        kickerKick = new JoystickButton(liftJoystick, 2);
        kickerKick.whenPressed(new KICKER_KickIn());
        
        
        //ButtonPanel for Lift (Operator Left Hand)
        operatorControls = new Joystick(2);         
        //Buttons for Base Position
        operatorControlsBase1 = new JoystickButton(operatorControls, 9);
        operatorControlsBase1.whenPressed(new LIFT_PidSet(0,0));
        operatorControlsBase2 = new JoystickButton(operatorControls, 8);
        operatorControlsBase2.whenPressed(new LIFT_PidSet(1,0));
        operatorControlsBase3 = new JoystickButton(operatorControls, 7);
        operatorControlsBase3.whenPressed(new LIFT_PidSet(2,0));
        //Buttons for Tote Position (Pos0 - Pos5)
        operatorControlsLift0 = new JoystickButton(operatorControls, 15);
        //operatorControlsLift0.whileHeld(new LIFT_PidSet(0,1));
        operatorControlsLift0.whileHeld(new LIFT_PidSetWhiteButton());
        
        operatorControlsLift1 = new JoystickButton(operatorControls, 14);
        //operatorControlsLift1.whileHeld(new LIFT_PidSet(1,1));
        operatorControlsLift1.whileHeld(new LIFT_PidSetGreenButton());
        operatorControlsLift2 = new JoystickButton(operatorControls, 13);
        //operatorControlsLift2.whileHeld(new LIFT_PidSet(2,1));
        operatorControlsLift2.whenPressed(new LIFT_PidSet1stBlackButton());
        
        operatorControlsLift3 = new JoystickButton(operatorControls, 12);
        operatorControlsLift3.whileHeld(new LIFT_PidSet(3,1));
        operatorControlsLift4 = new JoystickButton(operatorControls, 11);
        operatorControlsLift4.whileHeld(new LIFT_PidSet(4,1));
        operatorControlsLift5 = new JoystickButton(operatorControls, 10);
        operatorControlsLift5.whileHeld(new LIFT_PidSet(5,1));        
        
        //AutoToteLift Detector Components
        operatorControlsAutoTote = new JoystickButton(operatorControls, 5);
        operatorControlsAutoTote.whileHeld(new LIFT_AutoToteLift(1));
        
        //LiftToggle (On or Off) Components
        operatorControlsLiftToggle = new JoystickButton(operatorControls, 6);
        operatorControlsLiftToggle.whenPressed(new LIFT_StopPID());
        operatorControlsLiftToggle.whenReleased(new LIFT_StartPID());
        
        
        //ContainerArm Components
        operatorControlsJoystickMode = new JoystickButton(operatorControls, 3);
        operatorControlsExtension = new JoystickButton(operatorControls, 4);
        operatorControlsJoystickMode.whenPressed(new CONTAINERARM_JoystickMode(false));
        operatorControlsJoystickMode.whenReleased(new CONTAINERARM_JoystickMode(true));
        operatorControlsExtension.whenPressed(new CONTAINERARM_ExtensionOut());
        operatorControlsExtension.whenReleased(new CONTAINERARM_ExtensionIn());
	    
        // SMARTDASH BOARD STUFF
        
        SmartDashboard.putData("Auton Strafe out (-1.0,3.0)", new AutonStrafeAtSpeedForTime(-1.0,1.0));
        SmartDashboard.putData("Auton Backup (-1.0,2.0)", new AutonDriveAtSpeedForTime(-0.3,1.0));
        SmartDashboard.putData("Auton Strafe in (1.0,3.0)", new AutonStrafeAtSpeedForTime(0.3,1.0));
        SmartDashboard.putData("Auton Drive Gyro (0.3,3.0)", new AutonDriveAtSpeedForTimeGyro(0.5,6.0));
        SmartDashboard.putData("Auton Strafe Gyro in (0.3,3.0)", new AutonStrafeAtSpeedForTimeGyro(0.7,6.0));
               
        SmartDashboard.putData("PID Drive with Tote Sensor", new Auton_ChassisPidSetWithToteSensor(171.250));
        SmartDashboard.putData("PID with Gyro and Totoe Sensor in ", new Auton_ChassisPidSetWithToteSensor(165));
        
        SmartDashboard.putData("AutonRandomTest", new AutonRandomTest());
        SmartDashboard.putData("Auton_3ToteF_AfterKetteringWithToteB", new Auton_3ToteF_AfterKetteringWithToteB());
        SmartDashboard.putData("Auton_3ToteJ (was _AfterKetteringWithToteC)", new Auton_3ToteJ());

        SmartDashboard.putData("AutonDriveForTimeGyroIterative.5", new AutonDriveForTimeGyroIterative(.5));
        SmartDashboard.putData("AutonDriveForTimeGyroIterative1", new AutonDriveForTimeGyroIterative(1));
        
        SmartDashboard.putData("StopMotors", new StopMotors());
        
        SmartDashboard.putData("PNEUMATIC_ArmsIn", new INTAKEPNEUMATICS_ArmsIn());
        SmartDashboard.putData("PNUEMATIC_ArmsOut", new INTAKEPNEUMATICS_ArmsOut());
        SmartDashboard.putData("INTAKE_ActivateMotors", new INTAKE_ActivateMotors(.5,.5));
        
        SmartDashboard.putData("Pos0", new LIFT_PidSet(0,1));
        SmartDashboard.putData("Pos1", new LIFT_PidSet(1,1));
        SmartDashboard.putData("Pos2", new LIFT_PidSet(2,1));
        SmartDashboard.putData("Pos3", new LIFT_PidSet(3,1));
        SmartDashboard.putData("Pos4", new LIFT_PidSet(4,1));
        SmartDashboard.putData("Pos5", new LIFT_PidSet(5,1));
        
        SmartDashboard.putData("Base0", new LIFT_PidSet(0,0));
        SmartDashboard.putData("Base1", new LIFT_PidSet(1,0));
        SmartDashboard.putData("Base2", new LIFT_PidSet(2,0));
        
        
        //Preferences
        SmartDashboard.putNumber("teleopMaxSpeedUp", Robot.lift.teleopMaxSpeedUp);
        SmartDashboard.putNumber("teleopMaxSpeedDown", Robot.lift.teleopMaxSpeedDown);
        SmartDashboard.putNumber("autonPIDSet1", Robot.chassis.autonPIDSet1);
        SmartDashboard.putNumber("autonPIDSet2", Robot.chassis.autonPIDSet2);
        



        


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getjoystickDriver() {
        return joystickDriver;
    }
    //For OperatorControl Joystick (allows for it to run)
    public Joystick getOperatorControls() {
        return operatorControls; 
    }
    //For LiftJoystick Joystick (allows for it to run)
    public Joystick getLiftJoystick() {
        return liftJoystick; 
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

