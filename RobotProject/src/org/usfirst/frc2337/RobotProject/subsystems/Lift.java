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
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Lift extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //SpeedController motor = RobotMap.liftMotor;
	CANTalon masterLift = RobotMap.masterLiftMotor;
	CANTalon slaveLift1 = RobotMap.slaveLiftMotor1;
	CANTalon slaveLift2 = RobotMap.slaveLiftMotor2;
	CANTalon slaveLift3 = RobotMap.slaveLiftMotor3;
	
    AnalogPotentiometer potentiometer = RobotMap.liftPotentiometer;
    DigitalInput liftUpperLimit = RobotMap.liftUpperLimitSwitch;
    DigitalInput liftLowerLimit= RobotMap.liftLowerLimitSwitch;
    
    DigitalInput liftAutoTote = RobotMap.liftAutoTote;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
    //Make an array for the positions
    double[][] setarray = new double[3][6];
    
	double pos0 = 1.9; //Position 0
    double pos1 = 2.1;//1
    double pos2 = 2.3;//2
    double pos3 = 2.5;//3
    double pos4 = 2.7;//4
    double pos5 = 2.9;//5
    
    double bottom=0;//Bottom
    double mid=.2;//Middle
    double top=.4;//Top
    
    int tote = 0; //Store the tote array number
    int base = 0; //Stor the base array number
    int pos; //The Pos.
    int type; //The Type
    
    boolean PIDStatus = false;
    // Initialize your subsystem here
    
    public Lift() {    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("Lift", 5.0, 0.0, 0.0);
        setAbsoluteTolerance(0.005);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Lift", "PIDSubsystem Controller", getPIDController());   
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        
        getPIDController().setOutputRange(-.15, .15); //For the PID
        
    	masterLift.changeControlMode(ControlMode.PercentVbus);
    	masterLift.setVoltageRampRate(10);
    	slaveLift1.changeControlMode(ControlMode.Follower);
    	slaveLift2.changeControlMode(ControlMode.Follower);
    	slaveLift3.changeControlMode(ControlMode.Follower);
    	
    	slaveLift1.set(masterLift.getDeviceID());
    	slaveLift2.set(masterLift.getDeviceID());
    	slaveLift3.set(masterLift.getDeviceID());
    	
        
        //Bottoms Positions
        setarray[0][0] = bottom + pos0;
        setarray[0][1] = bottom + pos1;
        setarray[0][2] = bottom + pos2;
        setarray[0][3] = bottom + pos3;
        setarray[0][4] = bottom + pos4;
        setarray[0][5] = bottom + pos5;
        //Middle Positions     
        setarray[1][0] = mid + pos0;
        setarray[1][1] = mid + pos1;
        setarray[1][2] = mid + pos2;
        setarray[1][3] = mid + pos3;
        setarray[1][4] = mid + pos4;
        setarray[1][5] = mid + pos5;
        //Top Positions
        setarray[2][0] = top + pos0;
        setarray[2][1] = top + pos1;
        setarray[2][2] = top + pos2;
        setarray[2][3] = top + pos3;
        setarray[2][4] = top + pos4;
        setarray[2][5] = top + pos5; 
        

        
       

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
    	
    	//Smart Dashboard
    	SmartDashboard.putInt("Variable: Base", base);
    	SmartDashboard.putInt("Variable: Tote", tote);
    	SmartDashboard.putInt("Variable: Type", type);
    	SmartDashboard.putDouble("Variable: Array", setarray[base][tote]);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        //motor.pidWrite(output);
    	masterLift.pidWrite(output);

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
    //For the limit switches
    public boolean AtUpperLimit(){
    	return liftUpperLimit.get();
    }
    public boolean AtLowerLimit() {
    	return liftLowerLimit.get();
    }
    public boolean LiftAutoTote() {
    	return liftAutoTote.get();
    }
}
