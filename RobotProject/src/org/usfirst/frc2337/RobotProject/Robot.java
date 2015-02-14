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
	    
	    //Command variableCommand;       				//chooser to attempt to pick between practice and competition PID values
	    //SendableChooser variableChooser;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static chassis chassis;
    public static Lift lift;
    public static Intake intake;
    public static Pneumatics pneumatics;
    public static Camera Camera;
    public static Kicker kicker;
    public static LED led;
    public static IntakePneumatics intakePneumatics;
    public static ContainerArmMotor conArm;
    public static ContainerArmExtension conExtension;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassis = new chassis();
        lift = new Lift();
        intake = new Intake();
        pneumatics = new Pneumatics();
        Camera = new Camera();
        kicker = new Kicker();
        led = new LED();
        intakePneumatics = new IntakePneumatics();
        conArm = new ContainerArmMotor();
        conExtension = new ContainerArmExtension();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        
        //autonCommand = new Auton_3Tote();
        
        //SmartDashboard Auton Selector
        autonChooser = new SendableChooser();
        autonChooser.addObject("Move Straight to Auton Zone", new AutonDriveAtSpeedForTime(0.5,3.0)); //speed, time
        autonChooser.addObject("Move 1 Tote to Auton Zone", new Auton_1Tote());
        //autonChooser.addObject("Move 2 Totes to Auton Zone", new Auton2Tote());
        autonChooser.addDefault("Move 3 Totes to Auton Zone", new Auton_3Tote());
        //autonChooser.addObject("Move 1 Container to Auton Zone", new Auton1Container());
        //autonChooser.addObject("Move 2 Containers to Auton Zone", new Auton2Container());
        //autonChooser.addObject("Move 3 Containers to Auton Zone", new Auton3Container());
        autonChooser.addObject("Do Nothing", new DoNothing());
        SmartDashboard.putData("Auton Chooser", autonChooser);
        
        //Variable Selector
        //variableChooser = new SendableChooser();
        //variableChooser.addDefault("Comp values - ignore this - chooser not completed...", new DoNothing());
        //variableChooser.addObject("Practice values", new DoNothing());
        //SmartDashboard.putData("Variable Chooser", variableChooser);

 
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	autonCommand = (Command) autonChooser.getSelected();
        if (autonCommand != null) autonCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonCommand != null) autonCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
