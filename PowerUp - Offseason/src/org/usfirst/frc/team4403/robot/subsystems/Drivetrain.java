package org.usfirst.frc.team4403.robot.subsystems;

import org.usfirst.frc.team4403.robot.Robot;
import org.usfirst.frc.team4403.robot.RobotMap;
import org.usfirst.frc.team4403.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drivetrain subsystem
 */
public class Drivetrain extends Subsystem {

	// Drivetrain
	public DifferentialDrive drivetrain = new DifferentialDrive (new Talon(RobotMap.leftMotors), new Talon(RobotMap.rightMotors));



	// Variables for controlling acceleration
	public double previousX = 0;
	public double dx = 0.3;

	public double previousY = 0;
	public double dy = 0.3;

	public double maxX = 0.8;
	public double maxY = 0.8;
	

	

	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new TankDrive());
	}

	
	public void TankDrive() {
		
		//Show current values to debug previous parragraph		
		SmartDashboard.putNumber("DX",dx);
		SmartDashboard.putNumber("DY",dy);
		
		// Restrict x acceleration
		double x = Robot.oi.navigator.getRawAxis(4) * maxX;
		if (x > previousX + dx) {
			x = previousX + dx;
		} else if (x < previousX - dx) {
			x = previousX - dx;
		}
		previousX = x;
		// Restrict y acceleration
		double y = Robot.oi.navigator.getRawAxis(1) * maxY;
		if (y > previousY + dy) {
			y = previousY + dy;
		} else if (y < previousY - dy) {
			y = previousY - dy;
		}
		previousY = y;
		
		drivetrain.arcadeDrive(y, x);
		
	}
}
