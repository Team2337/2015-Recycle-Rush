

package org.usfirst.frc2337.RobotProject;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject.commands.*;
import org.usfirst.frc2337.RobotProject.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonCommand;
    SendableChooser autonChooser;

    public static OI oi;
    public static ChassisPID chassis;
    public static Lift lift;
    public static IntakeMotors intakeMotors;
    public static Pneumatics pneumatics;
    public static IntakeExtendArms intakeExtendArms;
    public static Kicker kicker;
    public static LED led;
    public static IntakeOpenArms intakeOpenArms;
    
    public static MetaTrolleyBrake metaTrolleyBrake;		//====================================================
    public static MetaTrolleyGrabber metaTrolleyGrabber;
    public static MultiPurposeContainerGrabber multiPurposeGrabber;
    public static CanBurglarMotors canBurglar;
    public static boolean TelopCanGrab;



    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();

        chassis = new ChassisPID();
        lift = new Lift();
        intakeMotors = new IntakeMotors();
        pneumatics = new Pneumatics();
        intakeExtendArms = new IntakeExtendArms();
        kicker = new Kicker();
        led = new LED();
        intakeOpenArms = new IntakeOpenArms();
        
        metaTrolleyBrake = new MetaTrolleyBrake();			//============================================
        metaTrolleyGrabber = new MetaTrolleyGrabber();
        multiPurposeGrabber = new MultiPurposeContainerGrabber();
        canBurglar = new CanBurglarMotors();
        
        

        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();
        TelopCanGrab = false;
        
      //AUTON CHOOSER
        //Instantiate the command used for the autonomous period
        //SmartDashboard Auton Selector
        autonChooser = new SendableChooser();
        autonChooser.addObject("Drive To Auton Zone with PID", new Auton_DriveToAutonZone());
        autonChooser.addObject("Move 1 Container to Auton Zone", new Auton_OneContainer());
        autonChooser.addObject("Move 2 Containers to Auton Zone", new Auton_TwoContainer());
        autonChooser.addObject("Move 1 Tote to Auton Zone", new Auton_1Tote());
        autonChooser.addObject("Set variable to grab can at beginning of Telop", new Auton_TelopCanGrab());
        
        
        autonChooser.addObject("Grab Container First", new Auton_Nested_A_WithContainer());
        autonChooser.addObject("3 TOTE DO NOT Grab Container First", new Auton_Nested_A_without_container());
        
        
        
        autonChooser.addDefault("Grab Container from Step NOW", new Auton_CanBurglarImmediate());
        autonChooser.addObject("Grab Container from Step without driving", new Auton_CanBurglarDelayed());
        //autonChooser.addObject("OLD Grab Container from Step", new Auton_StepContainer());
         //autonChooser.addObject("COMP - Move 3 Totes J Kettering BLUE", new Auton_3ToteJ_COMP_Kettering_BLUE());
         //autonChooser.addObject("COMP - Move 3 Totes J AFTER Kettering TEST", new Auton_3ToteJ_After_Kettering());
         //autonChooser.addObject("Move 3 Summary with arms", new Auton_Nested_A());
       // autonChooser.addObject("Grab Container First Post Troy", new Auton_SummaryPostTroy());
      

       // autonChooser.addObject("TEST - Move 3 Summary with arms", new Auton_Nested_A_TEST());
        
       
        autonChooser.addObject("Do Nothing", new AutonWait(15));
        
    }
    
    /**
     * This function is called periodically while the robot is on, regardless of current mode.
     * The most obvious use for this is continuously updating SmartDashboard outputs.
     */
    public void robotPeriodic() {
    	LiveWindow.run();
    	
    	
        //Autonomous Chooser
        SmartDashboard.putData(		"Auton Chooser", 		autonChooser);	
    	//SmartDashboard.putData		("Scheduled Commands", 			Scheduler.getInstance());
    	
    	//Chassis
         SmartDashboard.putData(chassis);
        SmartDashboard.putNumber	("Chassis PID Setpoint", 			Robot.chassis.getSetpoint());
    	SmartDashboard.putNumber	("Chassis PID Position", 			Robot.chassis.getPosition());
    	SmartDashboard.putNumber	("Chassis Auton Encoder Position",	Robot.chassis.readAutonEncoder());
    	SmartDashboard.putNumber	("Chassis Strafe Encoder Position",	Robot.chassis.readStrafeEncoder());
    	SmartDashboard.putBoolean	("Chassis Tote Sensor", 			Robot.chassis.isToteSensor());
    	
    	//Intake
    	 //SmartDashboard.putData(intakeExtendArms);	
    	 //SmartDashboard.putData(intakeOpenArms);	
    	 //SmartDashboard.putData(intakeMotors);
    	SmartDashboard.putBoolean	("Intake Extended", 			Robot.intakeExtendArms.getArmPosition());
    	SmartDashboard.putBoolean	("Intake Open", 				Robot.intakeOpenArms.getArmPosition());
    	
    	//Lift
   	 	 //SmartDashboard.putData(lift);
    	 //SmartDashboard.putData(metaTrolleyBrake);
    	 //SmartDashboard.putData(metaTrolleyGrabber);
    	 //SmartDashboard.putData(led);
    	SmartDashboard.putBoolean	("Practice Bot Positions",		Robot.lift.isCompetitionBot());
    	//SmartDashboard.putNumber	("Lift Variable: Base", 		Robot.lift.base);
    	//SmartDashboard.putNumber	("Lift Variable: Tote", 		Robot.lift.tote);
    	//SmartDashboard.putNumber	("Lift Variable: Array", 		Robot.lift.setarray[Robot.lift.base][Robot.lift.tote]);
        SmartDashboard.putNumber	("Lift Current Position",		Robot.lift.getSetpoint());
        SmartDashboard.putNumber	("Lift New Position",			Robot.lift.getPosition());
        
        //Kicker
   	 	 //SmartDashboard.putData(kicker);
        SmartDashboard.putBoolean	("Kicker Position", 			Robot.kicker.getPosition());
        SmartDashboard.putBoolean("Kicker variable",                  Robot.kicker.stateOut);
        //SmartDashboard.putBoolean	("Kicker AutoKick",				Robot.kicker.isAutoKick());
        
        //Container Arm
        //SmartDashboard.putBoolean	("Container Arm Extended", 		Robot.conExtension.getSolenoidPosition());
        //SmartDashboard.putNumber	("Container Arm Lift Position", Robot.containerArmLift.getPosition());
        //SmartDashboard.putNumber	("Container Arm Set Point", 	Robot.containerArmLift.getSetpoint());

        //GYRO - IMU
        SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.imu.isConnected());
        SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.imu.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.imu.getYaw());
        SmartDashboard.putNumber(   "IMU_Pitch",              RobotMap.imu.getPitch());
        
        //SmartDashboard.putNumber("PDP chassisfrontLeft 0 ", RobotMap.pdp.getCurrent(0));
        //SmartDashboard.putNumber("PDP chassisbackLeft 1", RobotMap.pdp.getCurrent(1));
        //SmartDashboard.putNumber("PDP chassisfrontRight 2", RobotMap.pdp.getCurrent(2));
        //SmartDashboard.putNumber("PDP chassisbackRight 3",RobotMap. pdp.getCurrent(3));
        
        
        //SmartDashboard.putData("Container Hugger Up", new MultiPurposeGrabber_Open());
        
        //Sticky faults
      //  SmartDashboard.putBoolean("StickyFault?", RobotMap.containerSolenoid1.getPCMSolenoidVoltageStickyFault());
      //  SmartDashboard.putData("Clear Sticky Faults", new ClearStickyFaults());

        SmartDashboard.putNumber("Drive Speed", Robot.oi.joystickDriver.getRawAxis(1));
        SmartDashboard.putNumber("Strafe Speed", Robot.oi.joystickDriver.getRawAxis(3) - Robot.oi.joystickDriver.getRawAxis(2));
        SmartDashboard.putNumber("Rotate Speed", Robot.oi.joystickDriver.getRawAxis(4));
        
        SmartDashboard.putBoolean("Left fwd limit switch", RobotMap.canburglarleft.isFwdLimitSwitchClosed());
        SmartDashboard.putBoolean("Left rev limit switch", RobotMap.canburglarleft.isRevLimitSwitchClosed());
        SmartDashboard.putBoolean("right fwd limit switch", RobotMap.canburglarright.isFwdLimitSwitchClosed());
        SmartDashboard.putBoolean("right rev limit switch", RobotMap.canburglarright.isRevLimitSwitchClosed());
        
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	RobotMap.imu.zeroYaw();
    	Robot.chassis.initEncoder();
    	autonCommand = (Command) autonChooser.getSelected();
    	//autonCommand = new Auton_3ToteJ_COMP_Kettering_BLUE();
        if (autonCommand != null) autonCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonCommand != null) autonCommand.cancel();
        
    	RobotMap.imu.zeroYaw();
    	Robot.chassis.disable();
    	Robot.lift.setTeleopLiftSpeed();
    	Robot.multiPurposeGrabber.off();
    	
    	if (TelopCanGrab) {
    		new Auton_CanBurglarImmediate();
    	
    	}

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    	RobotMap.imu.zeroYaw();        
        robotPeriodic();
        
    }
}
