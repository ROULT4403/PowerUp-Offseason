package org.usfirst.frc.team4403.robot.subsystems;

import org.usfirst.frc.team4403.robot.Robot;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
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
	//Gyro
	public ADXRS450_Gyro m_gyro = new ADXRS450_Gyro(kGyroPort);
	private static final double kAngleSetpoint = 0.0;
	private static final double kP = 0.1; // propotional turning constant

	private static final SPI.Port kGyroPort = SPI.Port.kOnboardCS0;
	private static final int kJoystickPort = 0;
	

	
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
	
	public void autoGo() {
		double turningValue = (kAngleSetpoint - m_gyro.getAngle()) * kP;
		// Invert the direction of the turn if we are going backwards
		turningValue = Math.copySign(turningValue, 0.5);
		
		drivetrain.arcadeDrive(0.5, turningValue);
		

	}
	
	public void autoGoBack () {
		double turningValue = (kAngleSetpoint - m_gyro.getAngle()) * kP;
		// Invert the direction of the turn if we are going backwards
		turningValue = Math.copySign(turningValue, -0.5);
		
		drivetrain.arcadeDrive(-0.5, -turningValue);
	}
	public void Spin() {
		double turningValue = (180-m_gyro.getAngle())*kP;
		if (m_gyro.getAngle()>178 && m_gyro.getAngle()<182) {
			drivetrain.arcadeDrive(0, 0);
		}
		drivetrain.arcadeDrive(0,0.15*turningValue);
	}
	
	/*
	public void autoGo() {
		drivetrain.arcadeDrive(0.5, 0);
	}
	public void autoGoBack() {
		drivetrain.arcadeDrive(-0.5, 0);
	}
	*/
	
}
