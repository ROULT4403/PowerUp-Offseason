package org.usfirst.frc.team4403.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Timer;
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
    Timer timer = new Timer();

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
    	//drivetrain.m_gyro.calibrate();
    	
    	
    }
    
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        //get the command from the chooser
    	drivetrain.TankDrive();
    	timer.start();
    	
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	if (timer.get() <5) {
    	drivetrain.autoGo();
    	}
    	else if(timer.get()>5 && timer.get()<10) {
    	drivetrain.Spin();
    	}
    }

    public void teleopInit() {
    
    	
    	
    	
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
       
    }
	
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }
}
