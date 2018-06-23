package org.usfirst.frc.team4403.robot.subsystems;


import org.usfirst.frc.team4403.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;



public class Brazos extends Subsystem {

	// Pneumatic arms
		DoubleSolenoid arms = new DoubleSolenoid(RobotMap.armForward,
				RobotMap.armReverse);
		DoubleSolenoid right = new DoubleSolenoid(RobotMap.rightForward,
				RobotMap.rightReverse);
	
		public void open() {
			arms.set(DoubleSolenoid.Value.kForward);
			
		}
		
		public void close() {
			arms.set(DoubleSolenoid.Value.kReverse);

		}
	
	public void initDefaultCommand() {
		
	}
}
	

