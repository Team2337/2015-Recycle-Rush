// RobotBuilder Version: 1.5

package org.usfirst.frc2337.RobotProject;
    

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import com.kauailabs.nav6.frc.IMUAdvanced;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import java.util.Vector;
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
    
    //MetaTrolley									=====================================================
    public static Solenoid metaTrolleyBrakeSolenoid;
    public static DoubleSolenoid metaTrolleyGrabberSolenoid;
      
    
    //Kicker > Actuator
    public static DoubleSolenoid kickerSolenoid;
    
    //Intake Solenoids, Motors, & Compressor
    public static Solenoid intakeRightSolenoid;
    public static Solenoid intakeLeftSolenoid;
    public static Solenoid intakeOpenSolenoid;
    public static Compressor pneumaticsCompressor;
    //Intake Motors for Arms
    public static SpeedController intakeLeftArmMotor;
    public static SpeedController intakeRightArmMotor;
    
    
    //Multi Purpose container solenoid.
    public static Solenoid containerSolenoid1;
    //public static DoubleSolenoid containerSolenoid1;
    
    //////////
    // LEDS //
    //////////
    //LED to show whether the kicker is out or in.
    public static Solenoid led;

    public static Solenoid testled;

    
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
    	
    	
        chassisfrontLeft = new VictorSP(0);		
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
        

        
        //Multipurpose Container Grabber
    	containerSolenoid1 = new Solenoid(0,0);
        //containerSolenoid1 = new DoubleSolenoid(0,0);
    	//LiveWindow.addActuator("MultiPurposeContainerGrabber", "Multi Purpose Container grabber", containerSolenoid1);
        
        
        //Kicker Solenoid
        kickerSolenoid = new DoubleSolenoid(0,7,6);
        LiveWindow.addActuator("Kicker", "Solenoid", kickerSolenoid);
        
        //Grabber Arm Solenoids
        metaTrolleyBrakeSolenoid = new Solenoid(0,3);
        LiveWindow.addActuator("Meta Trolley Brake", "Solenoid", metaTrolleyBrakeSolenoid);
        metaTrolleyGrabberSolenoid = new DoubleSolenoid(0,1,2);
        LiveWindow.addActuator("Meta Trolley Grabber", "Solenoid", metaTrolleyGrabberSolenoid);

        //Intake Solenoids
        //intakeRightSolenoid = new Solenoid(0, 4);									
        //LiveWindow.addActuator("Intake_ExtendArms", "RightSolenoid", intakeRightSolenoid);
        intakeLeftSolenoid = new Solenoid(0, 5);
        LiveWindow.addActuator("Intake_ExtendArms", "Solenoids", intakeLeftSolenoid);
        
        intakeOpenSolenoid = new Solenoid(0, 4);
        LiveWindow.addActuator("Intake_OpenArms", "Solenoids", intakeOpenSolenoid);
        
        //Intake Motors
        intakeLeftArmMotor = new Talon(8);
        LiveWindow.addActuator("IntakeMotors", "LeftArm", (Talon) intakeLeftArmMotor);
        intakeRightArmMotor = new Talon(9);
        LiveWindow.addActuator("IntakeMotors", "RightArm", (Talon) intakeRightArmMotor);

        
        //LEDs initialized as pneumatics, as we are putting them in the pneumatics module.
        led = new Solenoid(2,0);
        LiveWindow.addActuator("LED", "ledr", led);
        

        
        

        
        //Tote Sensor for Auton
        chassistoteSensor = new DigitalInput(2);
        LiveWindow.addSensor("ChassisPID", "toteSensor", chassistoteSensor);
        
        //Jumper to determine comp vs practice bot
        competitionBot = new DigitalInput(0);
        LiveWindow.addActuator("Lift", "Competition Bot Set Points:", competitionBot);
 
        
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
