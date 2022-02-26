package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class turnCommand extends CommandBase {
    
    private final DriveSubsystem m_drive;
    private final double m_turn;
    private final double m_speed;

    public turnCommand(double turn, double speed, DriveSubsystem subsystem) {
        m_drive = subsystem;
        m_turn = turn;
        m_speed = speed;
        addRequirements(m_drive);
    }

    public void initialize() {
        m_drive.arcadeDrive(0,m_speed);
    }

    public void execute() {
        m_drive.arcadeDrive(0,m_speed);
    }

    public void end(boolean inturrupted) {
        m_drive.arcadeDrive(0,0);
    }

    public boolean isFinished() {
        return m_drive.getLeftEncoder() >= m_turn;
    }
}
