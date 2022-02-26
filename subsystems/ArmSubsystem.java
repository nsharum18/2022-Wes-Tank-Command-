package frc.robot.subsystems;

import frc.robot.Constants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
    
    private final CANSparkMax arm = new CANSparkMax(Constants.ARM_ID, MotorType.kBrushless);
    private final CANEncoder encoder = new CANEncoder(arm);

    public ArmSubsystem() {
        //arm.setClosedLoopRampRate(1);
    }

    public void resetArmEncoder() {
        encoder.setPosition(0);
    }

    public double getArmEncoder() {
        return encoder.getPosition();
    }

    public void setArmUp() {
        arm.set(-1*Constants.ARM_MAX_SPEED);
    }

    public void setArmDown() {
        arm.set(Constants.ARM_MAX_SPEED);
    }

    public void setArmStop() {
        arm.set(0.0);
    }
}
