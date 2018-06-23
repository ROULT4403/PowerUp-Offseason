package org.usfirst.frc.team4403.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4403.robot.subsystems.Brazos;
import org.usfirst.frc.team4403.robot.subsystems.Drivetrain;
import org.usfirst.frc.team4403.robot.subsystems.Elevator;
import org.usfirst.frc.team4403.robot.subsystems.Rollers;

/**
 * This is the main class
 * 
 * All subsystems are initialized and assigned to run
 */
public class Robot extends IterativeRobot {
	
	//Subsystems
	public static Drivetrain drivetrain;
	public static Rollers rollers;
	public static Elevator elevator;
	public static OI oi;
	public static Compressor comp;
	public static Brazos brazos;
    
	//auto mode chooser
    SendableChooser autoChooser;
    
    //auto command to be run
    Command autonomousCommand;

    /**
     * Function that runs when the robot is on for the first time
     */
    public void robotInit() {
        //Initialize subsystems
    	rollers = new Rollers();
    	elevator = new Elevator();
    	drivetrain = new Drivetrain();
    	brazos = new Brazos();
    	oi = new OI();
    	
    	//Init auto command to null.
    	autonomousCommand = null;
    	
    	//Create chooser
    	autoChooser = new SendableChooser();
    	

    	//Add chooser to the smart dashboard
    	SmartDashboard.putData("AUTO MODE CHOOSER", autoChooser);
    }
    
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        //get the command from the chooser
    	autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	comp = new Compressor(0);
    	
    	
    	
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//Run scheduler to run commands
        Scheduler.getInstance().run();
        if (comp.getPressureSwitchValue()) {
    		comp.stop();
    		} else {
    		comp.start();
    		}
    }
	
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }
}
