package org.usfirst.frc2337.RobotProject;
    

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static SpeedController chassisFrontLeft;
    public static SpeedController chassisBackLeft;
    public static SpeedController chassisFrontRight;
    public static SpeedController chassisBackRight;
    public static RobotDrive chassisRobotDrive;


    public static void init() {
        chassisFrontLeft = new VictorSP(2);
        LiveWindow.addActuator("chassis", "frontLeft", (VictorSP) chassisFrontLeft);
        
        chassisBackLeft = new VictorSP(0);
        LiveWindow.addActuator("chassis", "backLeft", (VictorSP) chassisBackLeft);
        
        chassisFrontRight = new VictorSP(3);
        LiveWindow.addActuator("chassis", "frontRight", (VictorSP) chassisFrontRight);
        
        chassisBackRight = new VictorSP(1);
        LiveWindow.addActuator("chassis", "backRight", (VictorSP) chassisBackRight);
        
        chassisRobotDrive = new RobotDrive(chassisBackLeft, chassisFrontLeft, chassisBackRight, chassisFrontRight);
        
        chassisRobotDrive.setSafetyEnabled(true);
        chassisRobotDrive.setExpiration(0.1);
        chassisRobotDrive.setSensitivity(0.5);
        chassisRobotDrive.setMaxOutput(1.0);
    }
}
