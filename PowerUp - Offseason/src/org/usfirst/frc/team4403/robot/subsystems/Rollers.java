package org.usfirst.frc.team4403.robot.subsystems;

import org.usfirst.frc.team4403.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Rollers subsystem
 * 
 * Two motors for rollers wheels
 * 
 * Digital infrared sensors at sides
 * 
 * Analog infrared sensor in the middle
 */

public class Rollers extends Subsystem {

	// Motor controllers
	Spark leftRoller = new Spark(RobotMap.leftRoller);
	Spark rightRoller = new Spark(RobotMap.rightRoller);

	// Auxiliary flags
	boolean flagl = false;
	boolean flagr = false;
	
	//Wheel speeds
	private static double rightIn = -1;
	private static double rightOut = 1;
	
	private static double leftIn = 1;
	private static double leftOut = -1;

	public void initDefaultCommand() {
		
	}

	//Intake a box
	public void intake() {
		leftRoller.set(leftIn);
		rightRoller.set(rightIn);
	}

	//Eject a box
	public void eject() {
		leftRoller.set(leftOut);
		rightRoller.set(rightOut);
	}
	

	//Stop both rollers
	public void stopRollers() {
		leftRoller.set(0);
		rightRoller.set(0);
	}

}
