package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class defaultDrive extends CommandBase {
    
    private final DriveSubsystem m_drive;
    private final double m_fwd;
    private final double m_rot;

    public defaultDrive(double fwd, double rot, DriveSubsystem subsystem) {
        m_drive = subsystem;
        m_fwd = fwd;
        m_rot = rot;
        addRequirements(m_drive);
    }

    public void initialize() { }

    public void execute() {
        m_drive.arcadeDrive(m_fwd, m_rot);
    }

    public void end(boolean inturrupted) { }

    public boolean isFinished() {
        return false;
    }
}
