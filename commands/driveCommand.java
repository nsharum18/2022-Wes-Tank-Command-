package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class driveCommand extends CommandBase {
    
    private final DriveSubsystem m_drive;
    private final double m_fwd;
    private final double m_speed;
    private final boolean m_forward;

    public driveCommand(boolean forward, double fwd, double speed, DriveSubsystem subsystem) {
        m_drive = subsystem;
        m_fwd = fwd;
        m_speed = speed;
        m_forward = forward;
        addRequirements(m_drive);
    }

    public void initialize() {
        m_drive.resetDriveEncoders();
        m_drive.arcadeDrive(m_speed,0);
    }

    public void execute() {
        m_drive.arcadeDrive(m_speed,0);
    }

    public void end(boolean inturrupted) {
        m_drive.arcadeDrive(0,0);
    }

    public boolean isFinished() {
        if (m_forward) {
            return m_drive.getLeftEncoder() <= m_fwd;
        } else {
            return m_drive.getLeftEncoder() >= m_fwd;
        }
    }
}
