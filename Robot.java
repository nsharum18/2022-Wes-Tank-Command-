package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot { 
  
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  //  Variables:
  public static double velocity = 0;
  public static double rotation = 0;
  public static int armVariable = 0;

  public static int a1 = 700;
  public static int a2 = 1400;

  public static double MAX_V = 0.57; // Maximum Velocity
  public static double MAX_R = 0.5; // Maximum Angular Velocity
  public static double MAX_A = 0.35; // Maximum Arm Velocity
  
  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
  }
  
  @Override
  public void autonomousInit() {

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {

      m_autonomousCommand.schedule();
    }
   }

  @Override
  public void autonomousPeriodic() {

   }

  @Override
  public void teleopInit() { 

    if (m_autonomousCommand != null) {

      m_autonomousCommand.cancel();
    }
  }
	
  @Override
  public void teleopPeriodic() {

    

  }
	
  @Override
  public void disabledInit() { }

  @Override
  public void disabledPeriodic() { }
  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

    m_robotContainer.configureSmartDashboard();
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() { }
  
}