package org.usfirst.frc.team6039.robot;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */





public class Robot extends IterativeRobot {
	VictorSP driveFL,driveFR,driveBL,driveBR;
	RobotDriveMod drive1,drive2;
	//ArrayList<RobotDriveMod> drives = new ArrayList<RobotDriveMod>();
	TandemDrive drive;
	
	Joystick stick;
	int autoLoopCounter;
	Spark sucker,ramp;
	//CameraServer server;
	//USBCamera cam0;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	driveBL = new VictorSP(1);
    	driveBR = new VictorSP(0);
    	driveFL = new VictorSP(3);
    	driveFR = new VictorSP(2);
    	drive1 = new RobotDriveMod(driveBL,driveBR);
    	drive2 = new RobotDriveMod(driveFL,driveFR);
    	stick = new Joystick(0);
    	
    	drive = new TandemDrive(drive1,drive2);
    	
    	LiveWindow.addActuator("Drive", "Back-Left", driveBL);  	
    	LiveWindow.addActuator("Drive", "Back-Right", driveBR);
    	LiveWindow.addActuator("Drive", "Front-Left", driveFL);
    	LiveWindow.addActuator("Drive", "Front-Right", driveFR);
    	
    	sucker = new Spark(8);
    	ramp = new Spark(9);
    	
    	LiveWindow.addActuator("Sucker", 8, sucker);
    	LiveWindow.addActuator("Ramp Motor", 9, ramp);
    	
    	//server = CameraServer.getInstance();
    	//server.setQuality(50);
    	//server.startAutomaticCapture("cam0");
    	

    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	autoLoopCounter = 0;
    }

    /**
     * This function is called periodically during autonomous
	 * In this example, it will move the drive motors forward 1/2 speed for 2 seconds.
     */
    public void autonomousPeriodic() {
    	if(autoLoopCounter < 100) //Check if we've completed 100 loops (approximately 2 seconds)
		{
			drive.drive(-0.5, 0.0); 	// drive forwards half speed
			autoLoopCounter++;
			} else {
			drive.drive(0.0, 0.0); 	// stop robot
		}
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.arcadeDrive(stick);
        //drive2.arcadeDrive(stick);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
