

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
    public static ContainerArmLift containerArmLift;
    public static ContainerArmExtension conExtension;
    public static LED led;
    public static IntakeOpenArms intakeOpenArms;
    
    public static MetaTrolleyBrake metaTrolleyBrake;		//====================================================
    public static MetaTrolleyGrabber metaTrolleyGrabber;



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
        containerArmLift = new ContainerArmLift();
        conExtension = new ContainerArmExtension();
        led = new LED();
        intakeOpenArms = new IntakeOpenArms();
        
        metaTrolleyBrake = new MetaTrolleyBrake();			//============================================
        metaTrolleyGrabber = new MetaTrolleyGrabber();

        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        
      //AUTON CHOOSER
        //Instantiate the command used for the autonomous period
        //SmartDashboard Auton Selector
        autonChooser = new SendableChooser();
        autonChooser.addObject("Drive To Auton Zone with PID", new Auton_DriveToAutonZone());
        autonChooser.addObject("Move 1 Container to Auton Zone", new Auton_OneContainer());
        autonChooser.addObject("Move 1 Tote to Auton Zone", new Auton_1Tote());
      //  autonChooser.addObject("COMP - Move 3 Totes J Kettering BLUE", new Auton_3ToteJ_COMP_Kettering_BLUE());
        autonChooser.addObject("COMP - Move 3 Totes J AFTER Kettering TEST", new Auton_3ToteJ_After_Kettering());
        autonChooser.addDefault("TEST - Move 3 Summary with arms", new Auton_Nested_A());
        autonChooser.addObject("TEST - Move 3 Summary with arms", new Auton_Nested_A_WithContainer());
        
       
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
        SmartDashboard.putNumber	("Chassis PID Setpoint", 			Robot.chassis.getSetpoint());
    	SmartDashboard.putNumber	("Chassis PID Position", 			Robot.chassis.getPosition());
    	SmartDashboard.putNumber	("Chassis Auton Encoder Position",	Robot.chassis.readAutonEncoder());
    	SmartDashboard.putNumber	("Chassis Strafe Encoder Position",	Robot.chassis.readStrafeEncoder());
    	SmartDashboard.putBoolean	("Chassis Tote Sensor", 			Robot.chassis.isToteSensor());
    	
    	//Intake
    	SmartDashboard.putBoolean	("Intake Extended", 			Robot.intakeExtendArms.getArmPosition());
    	SmartDashboard.putBoolean	("Intake Open", 				Robot.intakeOpenArms.getArmPosition());
    	
    	//Lift
    	SmartDashboard.putBoolean	("Practice Bot Positions",		Robot.lift.isCompetitionBot());
    	//SmartDashboard.putNumber	("Lift Variable: Base", 		Robot.lift.base);
    	//SmartDashboard.putNumber	("Lift Variable: Tote", 		Robot.lift.tote);
    	//SmartDashboard.putNumber	("Lift Variable: Array", 		Robot.lift.setarray[Robot.lift.base][Robot.lift.tote]);
        SmartDashboard.putNumber	("Lift Current Position",		Robot.lift.getSetpoint());
        SmartDashboard.putNumber	("Lift New Position",			Robot.lift.getPosition());
        
        //Kicker
        SmartDashboard.putBoolean	("Kicker Position", 			Robot.kicker.getPosition());
        //SmartDashboard.putBoolean	("Kicker AutoKick",				Robot.kicker.isAutoKick());
        
        //Container Arm
        //SmartDashboard.putBoolean	("Container Arm Extended", 		Robot.conExtension.getSolenoidPosition());
        //SmartDashboard.putNumber	("Container Arm Lift Position", Robot.containerArmLift.getPosition());
        //SmartDashboard.putNumber	("Container Arm Set Point", 	Robot.containerArmLift.getSetpoint());

        //GYRO - IMU
        SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.imu.isConnected());
        SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.imu.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.imu.getYaw());

        
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
    	Robot.containerArmLift.enable();

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
