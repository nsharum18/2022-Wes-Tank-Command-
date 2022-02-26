package frc.robot;

import frc.robot.Constants;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class RobotContainer {
    
    private final ArmSubsystem m_arm = new ArmSubsystem();
    private final DriveSubsystem m_drive = new DriveSubsystem();

    private final Command SimpleAuto = new SimpleAuto(m_arm, m_drive);
    private final Command ArmUp = new ArmUp(m_arm);

    SendableChooser<Command> m_chooser = new SendableChooser<>();

    XboxController x = new XboxController(0);

    public void configureButtonBindings() {
        new JoystickButton(x,4).whenPressed(new ArmUp(m_arm));
        new JoystickButton(x,3).whenPressed(new ArmDown(m_arm));
    }

    public void configureSmartDashboard() {
        SmartDashboard.putNumber("Arm Encoder", m_arm.getArmEncoder());
        SmartDashboard.putNumber("Left Encoder", m_drive.getLeftEncoder());
        SmartDashboard.putNumber("Right Encoder", m_drive.getRightEncoder());
        SmartDashboard.putNumber("Average Drive Encoder", m_drive.getEncoder());
    }

    public RobotContainer() {
        configureButtonBindings();
        configureSmartDashboard();
        m_drive.setDefaultCommand(new RunCommand(() -> m_drive.arcadeDrive(x.getRawAxis(1) * Constants.MAX_SPEED, x.getRawAxis(0) * Constants.MAX_ROTATION), m_drive));

        m_chooser.setDefaultOption("SimpleAuto", SimpleAuto);
        m_chooser.addOption("ArmUp", ArmUp);

        Shuffleboard.getTab("Auto").add(m_chooser);
    }

    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }
}

