// RobotBuilder Version: 1.5

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
    public JoystickButton operatorControlsLeftToggle;
    public JoystickButton operatorControlsRightToggle;
    public JoystickButton operatorControlsKickToggle;
    public JoystickButton operatorControlsBlueButton;
    public JoystickButton operatorControlsYellowButton;
    public Joystick operatorControls;
    
    //Buttons for intake/kicker
    public JoystickButton liftJoystickTrigger;
    public JoystickButton intakePush;
    public JoystickButton intakeRight;
    public JoystickButton intakeLeft;
    public JoystickButton intakeDeploy;
    public JoystickButton kickerKick;
    public JoystickButton LiftJoystick9;
    public Joystick liftJoystick; //Lift Control (Precise Motor Action)



    public OI() {


    	//Speed for the motors for any given button or command
   	    double speed = 1;
        double p = 1; //Positive
        double n = -1; //Negative
        
        //Pull commands. 
        double rightPull = speed * p; 
        double leftPull = speed * n;
        
        //Push commands. 
        double rightPush = (speed * n)/3;
        double leftPush = (speed * p)/3;
        		
        //Declare variables
        
        double rightRotateRight, leftRotateRight, leftRotateLeft,rightRotateLeft;
        
        //Rotating commands
        rightRotateRight = leftRotateRight = speed *p;
        leftRotateLeft = rightRotateLeft = speed * n;  	
    	
    	//Joystick Driver
        joystickDriver = new Joystick(0);
        
        /* //Driver Joystick 
        joystickDriverButtonA = new JoystickButton(joystickDriver, 1);
        joystickDriverButtonA.whileHeld(new CONTAINERARM_PidSet(1.52));
        joystickDriverButtonB = new JoystickButton(joystickDriver, 2);
        joystickDriverButtonB.whileHeld(new CONTAINERARM_PidSet(3.3));
        joystickDriverButtonY = new JoystickButton(joystickDriver, 4);
        joystickDriverButtonY.whileHeld(new CONTAINERARM_PidSet(3.6));
        */

        //Joystick Control, for Lift (Precise) (Operator Right hand)
        liftJoystick = new Joystick(1); 
        
        //Lift Joystick base rear right
        intakeDeploy = new JoystickButton(liftJoystick, 11);
        intakeDeploy.whileHeld(new INTAKEPNEUMATICS_ArmsOut());
        //Lift Joystick on Hat left button
        intakeLeft = new JoystickButton(liftJoystick, 4);
        intakeLeft.whileHeld(new INTAKE_ActivateMotors(leftPush,rightPush));
        //Lift Joystick on Hat right button
        intakeRight = new JoystickButton(liftJoystick, 5);
        intakeRight.whileHeld(new INTAKE_ActivateMotors(leftPush,rightPush));
        //Lift Joystick on Hat center button
        intakePush = new JoystickButton(liftJoystick, 3);
       // intakePush.whileHeld(new INTAKE_ActivateMotors(leftPull,rightPull));
        intakePush.whileHeld(new INTAKE_CloseArmsAndPull(leftPull,rightPull));
        //intakePush.whileHeld(new INTAKE_CloseArmsAndIntake());
        
        
        
        //Lift Joystick trigger
        liftJoystickTrigger = new JoystickButton(liftJoystick, 1);
        //intakePull.whileHeld(new INTAKE_ActivateMotors(leftPull,rightPull));
       // liftJoystickTrigger.whileHeld(new INTAKE_CloseArmsAndPull(leftPull,rightPull));
        liftJoystickTrigger.whileHeld(new INTAKE_ActivateMotors(leftPull,rightPull));
        
        //Lift Joystick container arm button
        LiftJoystick9 = new JoystickButton(liftJoystick, 9);
        LiftJoystick9.whileHeld (new CONTAINERARM_PidSet(1.455));
        
        
        //Lift Joystick base front right
        operatorControlsKickToggle = new JoystickButton(liftJoystick, 8);
        operatorControlsKickToggle.whenPressed(new KICKER_StopKick());
        //Lift Joystick on Hat bottom button
        kickerKick = new JoystickButton(liftJoystick, 2);
        kickerKick.whenPressed(new KICKER_KickOut());
        
        
        //ButtonPanel for Lift (Operator Left Hand)
        operatorControls = new Joystick(2);         
        
        //Operator Station Rocker switch
        
        //Rocker switch Pos 2
        operatorControlsBase1 = new JoystickButton(operatorControls, 9);
       // operatorControlsBase1.whenPressed(new LIFT_PidSet(0,0));
        //Rocker switch Pos OFF
        operatorControlsBase2 = new JoystickButton(operatorControls, 8);
       // operatorControlsBase2.whenPressed(new LIFT_PidSet(1,0));
        //Rocker switch Pos 1
        operatorControlsBase3 = new JoystickButton(operatorControls, 7);
       // operatorControlsBase3.whenPressed(new LIFT_PidSet(2,0));

        
        
        //  Operator Station Buttons 10 - 15  White, Green, and 4 Black buttons.
        
        //Operator Controls white button # 15
        operatorControlsLift0 = new JoystickButton(operatorControls, 15);
        operatorControlsLift0.whileHeld(new LIFT_PidSetWhiteButton());
        
        //Operator Controls Green button # 14
        operatorControlsLift1 = new JoystickButton(operatorControls, 14);
        operatorControlsLift1.whenPressed(new LIFT_PidSet1stBlackButton());
        //Operator controls bottom Black Button # 13
        operatorControlsLift2 = new JoystickButton(operatorControls, 13);
        operatorControlsLift2.whenPressed(new LIFT_PidSetGreenButton());
        //Operator controls second from bottom Black Button # 12
        operatorControlsLift3 = new JoystickButton(operatorControls, 12);
        operatorControlsLift3.whileHeld(new LIFT_PidSet(3,1));
        //Operator controls second from top Black Button # 11
        operatorControlsLift4 = new JoystickButton(operatorControls, 11);
        operatorControlsLift4.whileHeld(new LIFT_PidSet(4,1));
        //Operator controls top Black Button # 10
        operatorControlsLift5 = new JoystickButton(operatorControls, 10);
        operatorControlsLift5.whileHeld(new LIFT_PidSet(5,1));        
        
        
        //ContainerArm Components
        // Buttons 3 and 4

        //Operator Controls Blue button # 3
        operatorControlsBlueButton = new JoystickButton(operatorControls, 3);
        operatorControlsBlueButton.whenPressed(new LIFT_PidSetBlueButton()); 
        
        //Operator Controls yellow button # 4
        operatorControlsYellowButton = new JoystickButton(operatorControls, 4);
        operatorControlsYellowButton.whileHeld(new INTAKE_OutAndPull(leftPull,rightPull));        
        
        //Operator Station Toggles
        // Left Toggle Operator Controls # 5
        operatorControlsLeftToggle = new JoystickButton(operatorControls, 5);
        operatorControlsLeftToggle.whileHeld(new INTAKEPNEUMATICS_ArmsOut());
        operatorControlsLeftToggle.whenReleased(new INTAKEPNEUMATICS_ArmsIn());
       
        //LiftToggle (On or Off) Components
        // Right Toggle Operator Controls # 6
        
        operatorControlsRightToggle = new JoystickButton(operatorControls, 6);
       // operatorControlsRightToggle.whenPressed(new LIFT_StopPID());
        //operatorControlsRightToggle.whenReleased(new LIFT_StartPID());
        operatorControlsRightToggle.whileHeld(new INTAKE_OpenArms_ArmsOut());
        operatorControlsRightToggle.whenReleased(new INTAKE_OpenArms_ArmsIn());
        
      
        

        
        
        
        
	    
        // SMARTDASH BOARD STUFF
        
        //SmartDashboard.putData("Auton Strafe out (-1.0,1.0)", new AutonStrafeAtSpeedForTime(-1.0,1.0));
        //SmartDashboard.putData("Auton Backup (-0.3,1.0)", new AutonDriveAtSpeedForTime(-0.3,1.0));
        //SmartDashboard.putData("Auton Strafe in (0.3,1.0)", new AutonStrafeAtSpeedForTime(0.3,1.0));
        //SmartDashboard.putData("Auton Drive Gyro (0.5,6.0)", new AutonDriveAtSpeedForTimeGyro(0.5,6.0));
        //SmartDashboard.putData("Auton Strafe Gyro in (0.7,6.0)", new AutonStrafeAtSpeedForTimeGyro(0.7,6.0));
               
        //SmartDashboard.putData("PID Drive with Tote Sensor (171.250)", new Auton_ChassisPidSetWithToteSensor(171.250));
        //SmartDashboard.putData("PID with Gyro and Totoe Sensor in (165)", new Auton_ChassisPidSetWithToteSensor(165));
        
        //SmartDashboard.putData("AutonRandomTest", new AutonRandomTest());
        //SmartDashboard.putData("Auton_3ToteJ (was _AfterKetteringWithToteC)", new Auton_3ToteJ());

        //SmartDashboard.putData("AutonDriveForTimeGyroIterative(.5)", new AutonDriveForTimeGyroIterative(.5));
        //SmartDashboard.putData("AutonDriveForTimeGyroIterative(1)", new AutonDriveForTimeGyroIterative(1));
        //SmartDashboard.putData("AutonStrafewithEncoder(0.5,90)", new AutonEncoderStrafeIn(.5, 900));
        
        //SmartDashboard.putData("StopMotors", new StopMotors());
        
        SmartDashboard.putData("PNEUMATIC_ArmsIn", new INTAKEPNEUMATICS_ArmsIn());
        SmartDashboard.putData("PNUEMATIC_ArmsOut", new INTAKEPNEUMATICS_ArmsOut());
        SmartDashboard.putData("INTAKE_ActivateMotors (.5,.5)", new INTAKE_ActivateMotors(.5,.5));
        
        SmartDashboard.putData("Pos0", new LIFT_PidSet(0,1));
        SmartDashboard.putData("Pos1", new LIFT_PidSet(1,1));
        SmartDashboard.putData("Pos2", new LIFT_PidSet(2,1));
        SmartDashboard.putData("Pos3", new LIFT_PidSet(3,1));
        SmartDashboard.putData("Pos4", new LIFT_PidSet(4,1));
        SmartDashboard.putData("Pos5", new LIFT_PidSet(5,1));
        
        //SmartDashboard.putData("Base0", new LIFT_PidSet(0,0));
        //SmartDashboard.putData("Base1", new LIFT_PidSet(1,0));
        //SmartDashboard.putData("Base2", new LIFT_PidSet(2,0));
        
        
        //Preferences
        //SmartDashboard.putNumber("teleopMaxSpeedUp", Robot.lift.teleopMaxSpeedUp);
        //SmartDashboard.putNumber("teleopMaxSpeedDown", Robot.lift.teleopMaxSpeedDown);
        
       // SmartDashboard.putBoolean("openArmPositionOI", Robot.intakeOpen.openArmPosition);
        //SmartDashboard.putBoolean("outArmPositionOI", Robot.intakePneumatics.armPosition);
        




    }
    

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


}

