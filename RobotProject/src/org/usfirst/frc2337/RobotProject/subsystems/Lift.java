// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject.subsystems;

import org.usfirst.frc2337.RobotProject.Robot;
import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Lift extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    CANTalon motor = RobotMap.masterliftMotor;
    AnalogPotentiometer potentiometer = RobotMap.liftPotentiometer;
    
    public DigitalInput liftAutoTote = RobotMap.liftAutoTote;
    public DigitalInput practiceBot = RobotMap.practiceBot;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    //Lift PID variables
    double setPointTolerance = 0.05;
    double maxSpeedUp = 0.75;
    double maxSpeedDown = -0.5;
    double liftTopLimit = 7.0;
    double liftBottomLimit = 0.85;
	
    //Make an array for the positions
    public double[][] setarray = new double[3][8];
       
    public int tote = 0; 			//Store the tote array number
    public int base = 0; 			//Store the base array number
    public int pos; 				//The Pos.
    public int type; 				//The Type
    
    boolean PIDStatus = false;
    
    //boolean practiceBot = true;          // now set by jumper on roborio
    
    double pos0,pos1,pos2,pos3,pos4,pos5,pos6,pos7,bottom,mid,top;
    
    //Joystick mode for switching back motor and lift
    public boolean joystickStatus = true;
    
    public void setPracticeSetPoints() { 		// method to for set points on practice bot, called per practiceBot boolean/jumper
    	pos0 = 0.85; 	//Position 0
    	pos1 = 1.8;		//1
    	pos2 = 2.6;		//2
    	pos3 = 4.0;		//3
    	pos4 = 5.0;		//4
    	pos5 = 7.0;		//5
    	pos6 = 4.8;		// Auton: just above container
    	pos7 = 2.6;		// Auton: second tote
    
    	bottom = 0;		//Bottom
    	mid = 0.2;		//Middle
    	top = 0.8;		//Top
    }
    
    public void setCompetitionSetPoints() {		// competition bot set points, called per practiceBot boolean/jumper (i.e. NO jumper)
    	pos0 = 0.85; 	//Position 0
    	pos1 = 1.8;		//1
    	pos2 = 2.6;		//2
    	pos3 = 4.0;		//3
    	pos4 = 5.0;		//4
    	pos5 = 7.0;		//5
    	pos6 = 4.8;		// Auton: just above container
    	pos7 = 2.6;		// Auton: second tote
    
    	bottom = 0;		//Bottom
    	mid = 0.2;		//Middle
    	top = 0.8;		//Top
    }
    
    // Initialize your subsystem here
    public Lift() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("Lift", 2.0, 0.0, 0.0);
        setAbsoluteTolerance(setPointTolerance);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Lift", "PIDSubsystem Controller", getPIDController());   
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        
        getPIDController().setOutputRange(maxSpeedDown, maxSpeedUp);   //For the lift PID
        getPIDController().setInputRange(liftBottomLimit, liftTopLimit);
        
        if (practiceBot.get()) { 						//call method to set set-points based on DIO jumper        	
        	setPracticeSetPoints();
    	} else {
    		setCompetitionSetPoints();
    	}
        	
        
        //Bottoms Positions
        setarray[0][0] = bottom + pos0;
        setarray[0][1] = bottom + pos1;
        setarray[0][2] = bottom + pos2;
        setarray[0][3] = bottom + pos3;
        setarray[0][4] = bottom + pos4;
        setarray[0][5] = bottom + pos5;
        setarray[0][6] = bottom + pos6;
        //setarray[0][7] = bottom + pos7;        
        //Middle Positions     
        setarray[1][0] = mid + pos0;
        setarray[1][1] = mid + pos1;
        setarray[1][2] = mid + pos2;
        setarray[1][3] = mid + pos3;
        setarray[1][4] = mid + pos4;
        setarray[1][5] = mid + pos5;				
        setarray[1][6] = mid + pos6;			
        //setarray[1][7] = mid + pos7;
        //Top Positions
        setarray[2][0] = top + pos0;
        setarray[2][1] = top + pos1;
        setarray[2][2] = top + pos2;
        setarray[2][3] = top + pos3;
        setarray[2][4] = top + pos4;
        setarray[2][5] = top + pos5; 				//may need to adjust
        setarray[2][6] = top + pos6; 				//may need to adjust
        //setarray[2][7] = top + pos7;
        

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new LIFT_JoystickControl());

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return potentiometer.get();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        motor.pidWrite(-output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
    
    //Grab the baseIn position, save the variable then set it global.
    public void setBase(int baseIn){
    	this.base= baseIn;
    	setSetpoint(setarray[this.base][this.tote]);
    }
   //Grab the toteIn position, save the variable then set it global.
    public void setTote(int toteIn){
    	this.tote = toteIn;
    	setSetpoint(setarray[this.base][this.tote]);	
    }
    //StopPID, toggle option for stopping it. 
    public void stopPID(){
    	this.PIDStatus = true;
    }
    public void startPID() {
    	this.PIDStatus = false;
    }
    //Return the PID when needed to another command.
    public boolean getPIDStatus(){
    	return this.PIDStatus;
    }
    //
    public boolean LiftAutoTote() {
    	return liftAutoTote.get();
    }
    public boolean joystickModeStatus() {
    	return this.joystickStatus;
    }
    public boolean isPracticeBot() {
    	return practiceBot.get();
    }
}
