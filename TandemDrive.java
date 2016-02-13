package org.usfirst.frc.team6039.robot;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.GenericHID;


public class TandemDrive {
	List<RobotDriveMod> dList;
	public TandemDrive(RobotDriveMod drive1,RobotDriveMod drive2) {
		List<RobotDriveMod> dList = new ArrayList<RobotDriveMod>();
		dList.add(drive1);
		dList.add(drive2);
	}
	
   /**
   * Drive the motors at "outputMagnitude" and "curve".
   * Both outputMagnitude and curve are -1.0 to +1.0 values, where 0.0
   * represents stopped and not turning. {@literal curve < 0 will turn left and curve > 0}
   * will turn right.
   *
   * The algorithm for steering provides a constant turn radius for any normal
   * speed range, both forward and backward. Increasing m_sensitivity causes
   * sharper turns for fixed values of curve.
   *
   * This function will most likely be used in an autonomous routine.
   *
   * @param outputMagnitude The speed setting for the outside wheel in a turn,
   *        forward or backwards, +1 to -1.
   * @param curve The rate of turn, constant for different forward speeds. Set
   *        {@literal curve < 0 for left turn or curve > 0 for right turn.}
   * Set curve = e^(-r/w) to get a turn radius r for wheelbase w of your robot.
   * Conversely, turn radius r = -ln(curve)*w for a given value of curve and
   * wheelbase w.
   */
	public void drive(double oM,double c){
		this.dList.forEach((temp) -> {
			temp.drive(oM,c);
		});
	}
	
  /**
   * Arcade drive implements single stick driving. Given a single Joystick, the
   * class assumes the Y axis for the move value and the X axis for the rotate
   * value. (Should add more information here regarding the way that arcade
   * drive works.)
   *$
   * @param stick The joystick to use for Arcade single-stick driving. The
   *        Y-axis will be selected for forwards/backwards and the X-axis will
   *        be selected for rotation rate.
   */
	public void arcadeDrive(GenericHID stick) {
		this.dList.forEach((temp) -> {
			temp.arcadeDrive(stick);
		});
	}

}
