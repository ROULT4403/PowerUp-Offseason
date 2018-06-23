package org.usfirst.frc.team4403.robot.subsystems;

import org.usfirst.frc.team4403.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Elevator extends Subsystem {

	// Elevator motors.
	Spark motorelevador = new Spark(RobotMap.elevadorPort);

	// Velocidades elevador 
	private static double speedUp = -0.65;
	private static double speedDown = 0.6;

	public void initDefaultCommand() {
		//No default command
	}
	public void up() {
		motorelevador.set(speedUp);
	}

	//Go down if it hasn't reach the bottom
	public void down() {
		motorelevador.set(speedDown);
		}
	
	

	public void stopElevator() {
		motorelevador.set(0);
		
	}
	
	}

	
	

