package frc.robot.subsystems;

import frc.robot.Constants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    
    private final CANSparkMax left1 = new CANSparkMax(Constants.left1ID, MotorType.kBrushless);
    private final CANSparkMax left2 = new CANSparkMax(Constants.left2ID, MotorType.kBrushless);
    private final CANSparkMax right1 = new CANSparkMax(Constants.right1ID, MotorType.kBrushless);
    private final CANSparkMax right2 = new CANSparkMax(Constants.right2ID, MotorType.kBrushless);

    private final SpeedController m_left = new SpeedControllerGroup(left1, left2);
    private final SpeedController m_right = new SpeedControllerGroup(right1, right2);

    private final DifferentialDrive m_drive = new DifferentialDrive(m_left,m_right);


    private final CANEncoder leftEncoder = new CANEncoder(left1);
    private final CANEncoder rightEncoder = new CANEncoder(right1);

    public DriveSubsystem() {


    }

    public void resetDriveEncoders() {
        leftEncoder.setPosition(0);
        rightEncoder.setPosition(0);
    }

    public double getLeftEncoder() {
        return -1*leftEncoder.getPosition();
    }

    public double getRightEncoder() {
        return rightEncoder.getPosition();
    }

    public double getEncoder() {
        return ((rightEncoder.getPosition() + (-1*leftEncoder.getPosition()))/2);
    }

    public void arcadeDrive(double velocity, double rotation) {
        m_drive.arcadeDrive(velocity, rotation);
    }


}
