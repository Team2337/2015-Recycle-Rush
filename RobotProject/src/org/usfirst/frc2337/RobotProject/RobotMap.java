package org.usfirst.frc2337.RobotProject;
    

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
    public static SpeedController chassisfrontLeft;
    public static SpeedController chassisbackLeft;
    public static SpeedController chassisfrontRight;
    public static SpeedController chassisbackRight;


    public static void init() {
        chassisfrontLeft = new VictorSP(2);
        LiveWindow.addActuator("chassis", "frontLeft", (VictorSP) chassisfrontLeft);
        
        chassisbackLeft = new VictorSP(0);
        LiveWindow.addActuator("chassis", "backLeft", (VictorSP) chassisbackLeft);
        
        chassisfrontRight = new VictorSP(3);
        LiveWindow.addActuator("chassis", "frontRight", (VictorSP) chassisfrontRight);
        
        chassisbackRight = new VictorSP(1);
        LiveWindow.addActuator("chassis", "backRight", (VictorSP) chassisbackRight);
    }
}
