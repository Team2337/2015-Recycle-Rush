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

    //Buttons for Driver Gamepad
    public JoystickButton joystickDriverButtonA;		//1
    public JoystickButton joystickDriverButtonB;		//2
    public JoystickButton joystickDriverButtonX;		//3
    public JoystickButton joystickDriverButtonY;		//4
    public JoystickButton joystickDriverBumperLeft;		//5
    public JoystickButton joystickDriverBumperRight;	//6
    public JoystickButton joystickDriverButtonBack;		//7
    public JoystickButton joystickDriverButtonStart;	//8
    public JoystickButton joystickDriverHatLeft;		//9
    public JoystickButton joystickDriverHatRight;		//10
    public Joystick joystickDriver;
    
    //Buttons for Operator Control Panel
    public JoystickButton operatorControlsRightToggleDown;		//9
    public JoystickButton operatorControlsRightToggleUp;		//8
    public JoystickButton operatorControlsBase3;		//7
    public JoystickButton operatorControlsLift0;
    public JoystickButton operatorControlsLift1;		//14
    public JoystickButton operatorControlsLift2;		//13
    public JoystickButton operatorControlsLift3;		//12
    public JoystickButton operatorControlsLift4;		//11
    public JoystickButton operatorControlsLift5;		//10
    public JoystickButton operatorControlsRockerCmdA;	//5
    public JoystickButton operatorControlsRockerCmdB;	//6
    public JoystickButton operatorControlsLeftToggle;	//16
    public JoystickButton operatorControlsBlueButton;	//3
    public JoystickButton operatorControlsYellowButton;	//4
    public JoystickButton operatorControlsTopWhiteButton;
    
    public JoystickButton operatorControlsTest1;	
    public JoystickButton operatorControlsTest2;	
    
    public Joystick operatorControls;
    
    //Buttons for Operator Joystick, i.e. intake/kicker
    public JoystickButton liftJoystickTrigger;	//Button1 
    public JoystickButton LiftJoystickButton2;	//kickerKick;
    public JoystickButton LiftJoystickButton3;	//intakePush;
    public JoystickButton LiftJoystickButton4;	//intakeLeft;
    public JoystickButton LiftJoystickButton5;	//intakeRight;
    
    public JoystickButton LiftJoystickButton7;
    public JoystickButton LiftJoystickButton8; 
    public JoystickButton LiftJoystickButton9;
    public JoystickButton LiftJoystickButton10;
    public JoystickButton liftJoystickButton11;	//intakeDeploy;
    public Joystick liftJoystick; 



    public OI() {


    	//Speed for the motors for any given button or command
   	    double speed = 1;
        double p = 1; //Positive
        double n = -1; //Negative
        
        //PULL speeds 
        double rightPull = speed * p; 
        double leftPull = speed * n;
        
        double rightSlowPull = (speed * p)/2;
        double leftSlowPull = (speed * n)/2;
        
        //PUSH speeds 
        double rightSlowPush = (speed * n)/3;
        double leftSlowPush = (speed * p)/3;
        		
        	//Used to move Totes to the side
        double rightPush = (speed * n);
        double leftPush = (speed * p);
        
        
    	
    	//Joystick Driver     - USED MOSTLY FOR TESTING
        joystickDriver = new Joystick(0);
        
       
       joystickDriverButtonA = new JoystickButton(joystickDriver, 1);
       joystickDriverButtonB = new JoystickButton(joystickDriver, 2);
       
       //joystickDriverButtonA.whenPressed(new MultiPurposeGrabber_Open());
       //joystickDriverButtonB.whenPressed(new MultiPurposeGrabber_Close());
       joystickDriverButtonA.whileHeld(new CANBURGLAR_Retract());
       joystickDriverButtonB.whileHeld(new CANBURGLAR_Deploy());
        

      //  joystickDriverButtonX = new JoystickButton(joystickDriver, 3);
      //  joystickDriverButtonX.whenPressed(new MetaTrolleyBrake_On());
       // joystickDriverButtonY = new JoystickButton(joystickDriver, 4);
       // joystickDriverButtonY.whenPressed(new MetaTrolleyGrabber_Closed());
        /*
        joystickDriverBumperLeft = new JoystickButton(joystickDriver, 5);
        joystickDriverBumperLeft.whileHeld(new CONTAINERARM_PidSet(1.52));
        joystickDriverBumperRight = new JoystickButton(joystickDriver, 6);
        joystickDriverBumperRight.whileHeld(new CONTAINERARM_PidSet(3.3));
        joystickDriverButtonBack = new JoystickButton(joystickDriver, 7);
        joystickDriverButtonBack.whileHeld(new CONTAINERARM_PidSet(3.6));
        */

        
        
        //Joystick Control, (Operator Right hand)
        liftJoystick = new Joystick(1); 
        
        //Lift Joystick trigger
        liftJoystickTrigger = new JoystickButton(liftJoystick, 1);
        liftJoystickTrigger.whileHeld(new INTAKE_ActivateMotors(leftPull,rightPull));
        
        //Lift Joystick on Hat bottom button
        LiftJoystickButton2 = new JoystickButton(liftJoystick, 2);
        LiftJoystickButton2.whenPressed(new KICKER_KickOut());
        
        //Lift Joystick on Hat center button
        LiftJoystickButton3 = new JoystickButton(liftJoystick, 3);				
        LiftJoystickButton3.whileHeld(new INTAKE_CloseArms());
        
        //Lift Joystick on Hat left button
        LiftJoystickButton4 = new JoystickButton(liftJoystick, 4);
        LiftJoystickButton4.whileHeld(new INTAKE_ActivateMotors(leftSlowPush,rightSlowPush));
        //Lift Joystick on Hat right button
        LiftJoystickButton5 = new JoystickButton(liftJoystick, 5);
        LiftJoystickButton5.whileHeld(new INTAKE_ActivateMotors(leftSlowPush,rightSlowPush));
        
        LiftJoystickButton7 = new JoystickButton(liftJoystick, 7);
        LiftJoystickButton7.whileHeld (new INTAKE_ActivateMotors(leftSlowPull,rightSlowPull));
        
        LiftJoystickButton8 = new JoystickButton(liftJoystick, 8);
        LiftJoystickButton8.whileHeld(new INTAKE_ActivateMotors(leftPush,leftPush));
        
        //Lift Joystick Move Tote Left or Right
        LiftJoystickButton9 = new JoystickButton(liftJoystick, 9);
        LiftJoystickButton9.whileHeld(new INTAKE_ActivateMotors(rightPush,rightPush));
        
        LiftJoystickButton10 = new JoystickButton(liftJoystick, 10);
        LiftJoystickButton10.whileHeld (new INTAKE_ActivateMotors(leftSlowPull,rightSlowPull));
        
        //Lift Joystick base rear right
        liftJoystickButton11 = new JoystickButton(liftJoystick, 11);
        //liftJoystickButton11.whileHeld(new INTAKE_ActivateMotors(leftSlowPull,rightSlowPull));
        liftJoystickButton11.whenPressed(new BUTTON_Score());

        

        
        //ButtonPanel for Lift (Operator Left Hand)
        operatorControls = new Joystick(2);         
        
        //ContainerArm Components
        // Buttons 3 and 4

        //Operator Controls Blue button # 10
        operatorControlsBlueButton = new JoystickButton(operatorControls, 4);
        //operatorControlsBlueButton.whenPressed(new LIFT_PidSetBlueButton()); 
        operatorControlsBlueButton.whenPressed(new MetaTrolleyBrake_On());
        
        //Operator Controls yellow button # 4
        operatorControlsYellowButton = new JoystickButton(operatorControls, 10);
        //operatorControlsYellowButton.whileHeld(new INTAKE_OutAndPull(leftPull,rightPull));        
        operatorControlsYellowButton.whenPressed(new MetaTrolleyBrake_Off());
        
        
        // **************************  Leave 5 an 6 alone, these are both being called by the rocker switch.  ****************
        //Operator Station Rocker Switch
        // Operator Controls Rocker Switch # 5
        operatorControlsRockerCmdA = new JoystickButton(operatorControls, 5);
        operatorControlsRockerCmdA.whenPressed(new INTAKE_ExtendArms_ArmsOut());
        operatorControlsRockerCmdA.whenReleased(new INTAKE_ExtendArms_ArmsIn());     
       
        // Operator Controls Rocker from UHID # 6
        operatorControlsRockerCmdB = new JoystickButton(operatorControls, 6);
        operatorControlsRockerCmdB.whenPressed(new INTAKE_OpenArms_ArmsOut());
        operatorControlsRockerCmdB.whenReleased(new INTAKE_OpenArms_ArmsIn());
        
        //********************************************************************************************************************
        
        
        operatorControlsRightToggleUp = new JoystickButton(operatorControls, 8);
       // operatorControlsRightToggleUp.whenPressed(new LIFT_StopPID());
      //  operatorControlsRightToggleUp.whenReleased(new LIFT_StartPID());
        
        operatorControlsRightToggleUp.whileHeld(new Telop_CanBurglarImmediate());
    
        
      // operatorControlsRightToggleDown = new JoystickButton(operatorControls, 9);
      //  operatorControlsRightToggleDown.whileHeld(new LIFT_StartPID());
        
        //  Operator Station Buttons 10 - 15  White, Green, and 4 Black buttons.
        
        //Operator controls top Black Button # 3
        operatorControlsLift5 = new JoystickButton(operatorControls, 3);
        //operatorControlsLift5.whileHeld(new LIFT_PidSet(5,1));
        operatorControlsLift5.whileHeld(new KICKER_KickIn());
        
        //Operator controls yellow SCORE button
        operatorControlsLift4 = new JoystickButton(operatorControls, 11);
        operatorControlsLift4.whenPressed(new BUTTON_ScoreWithoutLower());
        
        operatorControlsTopWhiteButton = new JoystickButton(operatorControls, 18);
        operatorControlsTopWhiteButton.whenPressed(new BUTTON_Score());
        
        //##############################################################################################################
        SmartDashboard.putData("Score", new BUTTON_Score());
        
        operatorControlsTest1 = new JoystickButton(operatorControls, 1);
        operatorControlsTest1.whenPressed(new LIFT_PidSetMinusRelative(-0.8));
        SmartDashboard.putData("Arms Out", new INTAKE_OpenArms_ArmsOut());
        
        //SmartDashboard.putData("TheBigF with Turn", new Auton_Summary_TheBigFinishWithTurn());  
        //SmartDashboard.putData("Turn", new AutonTurnDegreesCcwNeg(83));  //?????????????????????????????
        //############################################################################################################## 

        
        //Operator controls second from bottom Black Button # 12
        operatorControlsLift3 = new JoystickButton(operatorControls, 12);
        operatorControlsLift3.whenPressed(new MetaTrolleyGrabber_Open());
        
        //Operator controls bottom Black Button # 13
        operatorControlsLift2 = new JoystickButton(operatorControls, 13);
        operatorControlsLift2.whenPressed(new MetaTrolleyGrabber_Closed());
        
        //Operator Controls Green button # 14
        operatorControlsLift1 = new JoystickButton(operatorControls, 14);
        operatorControlsLift1.whenPressed(new BUTTON_LiftUp_KickOut_LiftUp());
        
        //Operator Controls white button # 15
        operatorControlsLift0 = new JoystickButton(operatorControls, 15);
        operatorControlsLift0.whileHeld(new BUTTON_KickIn_LiftDown());
        
        //Field Centric # 16
        operatorControlsLeftToggle = new JoystickButton(operatorControls, 16);
        
        operatorControlsLeftToggle.whileHeld(new AutonWait(.1));
        //operatorControlsKickToggle.whileHeld(new LIFT_StopPID());
        
        /*  In case we bring back the container arm.
        
        //Operator Station Rocker switch
        
        //Rocker switch Pos 2
        operatorControlsBase1 = new JoystickButton(operatorControls, 9);
       // operatorControlsBase1.whenPressed(new LIFT_PidSet(0,0));
        //Rocker switch Pos OFF
        operatorControlsBase2 = new JoystickButton(operatorControls, 8);
       // operatorControlsBase2.whenPressed(new LIFT_PidSet(1,0));
        //Rocker switch Pos 1
        operatorControlsBase3 = new JoystickButton(operatorControls, 7);
        operatorControlsBase3.whileHeld(new CONTAINERARM_DisablePID());
        
        */

    }
    
    //For Driver Gamepad 
    public Joystick getjoystickDriver() {
        return joystickDriver;
    }
    //For OperatorControl Panel 
    public Joystick getOperatorControls() {
        return operatorControls; 
    }
    //For LiftJoystick Joystick 
    public Joystick getLiftJoystick() {
        return liftJoystick; 
    }

}

