package org.usfirst.frc.team4403.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4403.robot.commands.Close;
import org.usfirst.frc.team4403.robot.commands.Down;
import org.usfirst.frc.team4403.robot.commands.Eject;
import org.usfirst.frc.team4403.robot.commands.Intake;
import org.usfirst.frc.team4403.robot.commands.Open;
import org.usfirst.frc.team4403.robot.commands.StopElevator;
import org.usfirst.frc.team4403.robot.commands.StopRollers;
import org.usfirst.frc.team4403.robot.commands.Up;

/**
 * Operator Interface
 * 
 * Joystick controls pulled from here
 * 
 * We have two joyticks (navigator and extra)
 */
public class OI {

	// Navigator controller
	public Joystick navigator = new Joystick(RobotMap.navigatorPort);
	Button navigator_A = new JoystickButton(navigator, 1);
	Button navigator_B = new JoystickButton(navigator, 2);
	Button navigator_X = new JoystickButton(navigator, 3);
	Button navigator_Y = new JoystickButton(navigator, 4);
	Button navigator_LB = new JoystickButton(navigator, 5);
	Button navigator_RB = new JoystickButton(navigator, 6);
	Button navigator_Select = new JoystickButton(navigator, 7);
	Button navigator_Start = new JoystickButton(navigator, 8);
	Button navigator_LSClick = new JoystickButton(navigator, 9);
	Button navigator_RSClick = new JoystickButton(navigator, 10);

	// extra controller
	public Joystick extra = new Joystick(RobotMap.extraPort);
	Button extra_A = new JoystickButton(extra, 1);
	Button extra_B = new JoystickButton(extra, 2);
	Button extra_X = new JoystickButton(extra, 3);
	Button extra_Y = new JoystickButton(extra, 4);
	Button extra_LB = new JoystickButton(extra, 5);
	Button extra_RB = new JoystickButton(extra, 6);
	Button extra_Select = new JoystickButton(extra, 7);
	Button extra_Start = new JoystickButton(extra, 8);
	Button extra_LSClick = new JoystickButton(extra, 9);
	Button extra_RSClick = new JoystickButton(extra, 10);

	public OI() {

		//Rollers
		navigator_LB.whenPressed(new Eject());
		navigator_LB.whenReleased(new StopRollers());
		navigator_RB.whenPressed(new Intake());
		navigator_RB.whenReleased(new StopRollers());
		
		
		//Elevator
		navigator_Y.whenPressed(new Up());
		navigator_B.whenPressed(new Down());
		navigator_Y.whenReleased(new StopElevator());
		navigator_B.whenReleased(new StopElevator());
		
		//Brazos
		navigator_X.whenPressed(new Open());
		navigator_A.whenPressed(new Close());
		
		
		// Autonomous
		// navigator_RSClick.whenPressed(new Autonomous());

		
	
	}
}
