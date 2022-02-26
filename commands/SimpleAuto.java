package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class SimpleAuto extends SequentialCommandGroup {

    public SimpleAuto(ArmSubsystem m_arm, DriveSubsystem m_drive) {
        addCommands(
            new ResetEncoders(m_arm, m_drive),
            new ArmUp(m_arm),
            new driveCommand(false, Constants.BACK_POSITION, Constants.MAX_SPEED, m_drive),
            new turnCommand(Constants.LEFT_ROTATION, Constants.MAX_ROTATION * -1, m_drive),
            new driveCommand(true, Constants.FORWARD_POSITION, Constants.MAX_SPEED * -1, m_drive),
            new ArmDown(m_arm)
        );
    }

    
}
