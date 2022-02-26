package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class ArmUp extends CommandBase {
    
    private final ArmSubsystem m_arm;

    public ArmUp(ArmSubsystem subsystem) {
        m_arm = subsystem;
        addRequirements(m_arm);
    }

    public void initialize() {
        m_arm.setArmUp();
    }

    public void execute() {
        m_arm.setArmUp();
    }

    public void end(boolean inturrupted) {
        m_arm.setArmStop();
    }

    public boolean isFinished() {
        return m_arm.getArmEncoder() <= -10;
    }
}
