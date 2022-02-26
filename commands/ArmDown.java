package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class ArmDown extends CommandBase {
    
    private final ArmSubsystem m_arm;

    public ArmDown(ArmSubsystem subsystem) {
        m_arm = subsystem;
        addRequirements(m_arm);
    }

    public void initialize() {
        m_arm.setArmDown();
    }

    public void execute() {
        m_arm.setArmDown();
    }

    public void end(boolean inturrupted) {
        m_arm.setArmStop();
    }

    public boolean isFinished() {
        return m_arm.getArmEncoder() >= Constants.DOWN_POSITION;
    }
}
