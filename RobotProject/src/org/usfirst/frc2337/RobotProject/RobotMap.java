// RobotBuilder Version: 1.5

package org.usfirst.frc2337.RobotProject;
    

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import java.util.Vector;

import com.kauailabs.nav6.frc.IMUAdvanced;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	////////////////////////
	// Chassis Components //
	////////////////////////
	public static SpeedController chassisfrontLeft;
    public static SpeedController chassisbackLeft;
    public static SpeedController chassisfrontRight;
    public static SpeedController chassisbackRight;
    public static RobotDrive chassisrobotDrive;
    
    public static Encoder autonEncoder;
    public static Encoder strafeEncoder;
    
    //Tote sensor for Auton
    public static DigitalInput chassistoteSensor;
    
	////////////////
	// Gyro - IMU //
	////////////////
    public static Gyro chassisGyro;
    public static SerialPort serial_port;
    //public static IMU imu;  // Alternatively, use IMUAdvanced for advanced features
    public static IMUAdvanced imu;
    
    ///////////////////
    // Above Chassis //
    //////////////////
    
    //Lift
    public static CANTalon masterliftMotor;
    public static CANTalon slaveliftMotor1;
    public static CANTalon slaveliftMotor2;
    public static CANTalon slaveliftMotor3;
    public static AnalogPotentiometer liftPotentiometer;
    
    //Kicker > Finger Sensor
    //public static DigitalInput kickerFingerSensor;
    
    //Kicker > Actuator
    public static DoubleSolenoid kickerSolenoid;
    
    //Intake Solenoids, Motors, & Compressor
    //public static SpeedController intakeintakeLeftArmMotor;
    //public static SpeedController intakeintakeRightArmMotor;
    public static Solenoid intakeRightSolenoid;
    public static Solenoid intakeLeftSolenoid;
    public static Solenoid intakeOpenSolenoid;
    public static Compressor pneumaticsCompressor;
    //Intake Motors for Arms
    public static SpeedController intakeLeftArmMotor;
    public static SpeedController intakeRightArmMotor;
    
    public static DigitalInput liftAutoTote;

    //ContainerArm and Extension (Solenoid)
    public static CANTalon containerArmMotor;  
    public static AnalogPotentiometer armPotentiometer;
    public static Solenoid containerSolenoid1;
    
    //////////
    // LEDS //
    //////////
    //LED to show whether the kicker is out or in.
    public static Solenoid ledKicker;
    //LED to show once the PID is in its proper position.
    public static Solenoid ledPID;
    //LED to show whether the light sensor on the fingers is returning true or false.
    public static Solenoid ledFingers;
    //LED to show whether our bumper limit switch is returning true or false, and thus if we are touching a crate or not.
    public static Solenoid ledBumper;

    
    ///////////////////////
    //  Set Point Jumper //
    ///////////////////////
    //Switch for determining comp/practice bot for set points
    public static DigitalInput competitionBot;
    
    /////////
    // PDP //
    /////////
    //PowerDistroPanel for reading Volts and Amps.
    public static PowerDistributionPanel pdp;
     
    ////////////
    // Camera //
    ////////////
    public static CameraServer usbCamera1;
      

    
    public static void init() {
    	
    	
        chassisfrontLeft = new VictorSP(0);												//was 0 before strafe problem testing  
        LiveWindow.addActuator("chassis", "frontLeft", (VictorSP) chassisfrontLeft);
        chassisfrontRight = new VictorSP(2);
        LiveWindow.addActuator("chassis", "frontRight", (VictorSP) chassisfrontRight);
        chassisbackLeft = new VictorSP(1);
        LiveWindow.addActuator("chassis", "backLeft", (VictorSP) chassisbackLeft);
        chassisbackRight = new VictorSP(3);
        LiveWindow.addActuator("chassis", "backRight", (VictorSP) chassisbackRight);
        
        chassisrobotDrive = new RobotDrive(chassisfrontLeft, chassisbackLeft, chassisfrontRight, chassisbackRight);
        
        chassisrobotDrive.setSafetyEnabled(true);
        chassisrobotDrive.setExpiration(0.1);
        chassisrobotDrive.setSensitivity(0.5);
        chassisrobotDrive.setMaxOutput(1.0);
        chassisrobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        chassisrobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        chassisrobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        chassisrobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        
    	//Auton Encoder
    	autonEncoder = new Encoder(5, 6, false, EncodingType.k4X);
    	autonEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kDistance);
    	LiveWindow.addSensor("ChassisPID", "Auton Encoder", autonEncoder);
        
        //Strafe Encoder
    	strafeEncoder = new Encoder(3, 4, false, EncodingType.k4X);
    	strafeEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kDistance);
    	LiveWindow.addSensor("ChassisPID", "Strafe Encoder", strafeEncoder);
        
        //Lift Motors
        masterliftMotor = new CANTalon(4);
        //LiveWindow.addActuator("Lift", "Motor", (CANTalon) masterliftMotor);   //LiveWindow doesn't play nice with CANTalons 
        masterliftMotor.changeControlMode(ControlMode.PercentVbus);
        
        slaveliftMotor1 = new CANTalon(5);
        slaveliftMotor1.changeControlMode(ControlMode.Follower);
        slaveliftMotor1.reverseOutput(true);
        slaveliftMotor1.set(masterliftMotor.getDeviceID());
        
        slaveliftMotor2 = new CANTalon(6);
        slaveliftMotor2.changeControlMode(ControlMode.Follower);
        slaveliftMotor2.reverseOutput(false);
        slaveliftMotor2.set(masterliftMotor.getDeviceID());
        
        slaveliftMotor3 = new CANTalon(7);
        slaveliftMotor3.changeControlMode(ControlMode.Follower);
        slaveliftMotor3.reverseOutput(true);
        slaveliftMotor3.set(masterliftMotor.getDeviceID());
        
        masterliftMotor.enableBrakeMode(true);
        slaveliftMotor1.enableBrakeMode(true);
        slaveliftMotor2.enableBrakeMode(true);
        slaveliftMotor3.enableBrakeMode(true);

        
        //Lift Potentiometer
        liftPotentiometer = new AnalogPotentiometer(2, 10.0, 0.068);
        LiveWindow.addSensor("Lift", "Potentiometer", liftPotentiometer);
        
    	//Container items
        containerArmMotor = new CANTalon(10);
        containerArmMotor.changeControlMode(ControlMode.PercentVbus);
        containerArmMotor.enableBrakeMode(false);
        containerArmMotor.reverseOutput(false);
        
        armPotentiometer = new AnalogPotentiometer(0, 10.0, 0.068);			//settings ok????
        LiveWindow.addSensor("ContainerArmLift", "Container Arm Potentiometer", liftPotentiometer);
    	containerSolenoid1 = new Solenoid(0,3);
    	LiveWindow.addActuator("ContainerArmLift", "Conyainer Arm Extender", containerSolenoid1);
        
        
        //Kicker Solenoid
        kickerSolenoid = new DoubleSolenoid(0,7,6);
        LiveWindow.addActuator("Kicker", "kickerSolenoid", kickerSolenoid);
        
        //Kicker Finger Sensor
        //kickerFingerSensor = new DigitalInput(4);
       // LiveWindow.addActuator("Kicker", "FingerSensor", kickerFingerSensor);
        

        //Intake Solenoids
        //intakeRightSolenoid = new Solenoid(0, 4);									//  re-enable??????????????
        //LiveWindow.addActuator("Pnuematics", "RightSolenoid", intakeRightSolenoid);
        intakeLeftSolenoid = new Solenoid(0, 5);
        LiveWindow.addActuator("Pnuematics", "LeftSolenoid", intakeLeftSolenoid);
        
        intakeOpenSolenoid = new Solenoid(0, 4);
        LiveWindow.addActuator("Intake_OpenArms", "Open Arms Solenoid", intakeOpenSolenoid);
        
        //Intake Motors
        intakeLeftArmMotor = new Talon(8);
        LiveWindow.addActuator("Intake", "intakeLeftArmMotor", (Talon) intakeLeftArmMotor);
        intakeRightArmMotor = new Talon(9);
        LiveWindow.addActuator("Intake", "intakeRightArmMotor", (Talon) intakeRightArmMotor);

        
        //LEDs initialized as pneumatics, as we are putting them in the pneumatics module.
        ledKicker = new Solenoid(0,1);
        LiveWindow.addActuator("LED", "KickerLED", ledKicker);
        ledPID = new Solenoid(0,2);
        LiveWindow.addActuator("LED", "PIDLED", ledPID);
        ledBumper = new Solenoid(0,3);
        LiveWindow.addActuator("LED", "BumperLED", ledBumper);

        
        //Tote Sensor
        chassistoteSensor = new DigitalInput(2);
        LiveWindow.addSensor("chassis", "toteSensor", chassistoteSensor);
        
        //Jumper to determine comp vs practice bot
        competitionBot = new DigitalInput(0);
        LiveWindow.addActuator("Lift", "Competition Bot Set Points:", competitionBot);
        

        // liftAutoTote = new DigitalInput(3);

        // LiveWindow.addActuator("Lift", "AutoTote", liftAutoTote);
        
        //Power Distribution Board
        pdp = new PowerDistributionPanel();
        LiveWindow.addSensor("Lift", "PDP1", pdp);
        
        //usbCamera1 = CameraServer.getInstance();
        //usbCamera1.setQuality(50);
        //usbCamera1.setSize(0); 
        


        //GYRO - IMU initialization
	    	try {
	    	serial_port = new SerialPort(57600,SerialPort.Port.kOnboard);
			
			// You can add a second parameter to modify the 
			// update rate (in hz) from	to 100.  The default is 100.
			// If you need to minimize CPU load, you can set it to a
			// lower value, as shown here, depending upon your needs.
			
			// You can also use the IMUAdvanced class for advanced
			// features.
			
			byte update_rate_hz = 50;
			//imu = new IMU(serial_port,update_rate_hz);
			imu = new IMUAdvanced(serial_port,update_rate_hz);
    	} catch( Exception ex ) {
    		
    	}
    	
        if ( imu != null ) {
            LiveWindow.addSensor("IMU", "Gyro", imu);
        }
    	
        
    }
}
