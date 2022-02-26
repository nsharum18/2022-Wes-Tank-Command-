package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class ResetEncoders extends CommandBase {
    
    private final ArmSubsystem arm;
    private final DriveSubsystem drive;

    public ResetEncoders(ArmSubsystem m_arm, DriveSubsystem m_drive ) {
        arm = m_arm;
        drive = m_drive;
        addRequirements(m_arm);
    }

    public void initialize() {
        arm.resetArmEncoder();
        drive.resetDriveEncoders();
    }

    public void execute() {
    }

    public void end(boolean inturrupted) {
    }

    public boolean isFinished() {
        return true;
    }
}
