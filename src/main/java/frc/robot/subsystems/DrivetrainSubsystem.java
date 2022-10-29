package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants.DrivetrainConstants;

public class DrivetrainSubsystem implements Subsystem {

    private final MotorController m_leftForwardMotor;
    private final MotorController m_leftRearMotor;
    private final MotorController m_rightForwardMotor;
    private final MotorController m_rightRearMotor;

    private final DifferentialDrive m_drivetrain;

    public DrivetrainSubsystem() {
        m_leftForwardMotor = new VictorSP(DrivetrainConstants.kDrivetrainMotorLeftForwardPort);
        m_leftRearMotor = new VictorSP(DrivetrainConstants.kDrivetrainMotorLeftRearPort);
        m_rightForwardMotor = new VictorSP(DrivetrainConstants.kDrivetrainMotorRightForwardPort);
        m_rightRearMotor = new VictorSP(DrivetrainConstants.kDrivetrainMotorRightRearPort);

        m_leftForwardMotor.setInverted(DrivetrainConstants.kDrivetrainMotorLeftForwardInverted);
        m_leftRearMotor.setInverted(DrivetrainConstants.kDrivetrainMotorLeftRearInverted);
        m_rightForwardMotor.setInverted(DrivetrainConstants.kDrivetrainMotorRightForwardInverted);
        m_rightRearMotor.setInverted(DrivetrainConstants.kDrivetrainMotorRightRearInverted);

        m_drivetrain = new DifferentialDrive(m_leftForwardMotor, m_rightForwardMotor);
    }

    public void drive(double speedLeft, double speedRight) {
        m_drivetrain.feed();
        m_leftForwardMotor.set(speedLeft);
        m_rightForwardMotor.set(speedRight);
    }

    public double normalizeJoystickWithDeadband(double val, double deadband) {
        val = (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;

        if (val != 0)
            val = Math.signum(val) * ((Math.abs(val) - deadband) / (1.0 - deadband));

        return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
    }

    @Override
    public void periodic() {
        m_leftRearMotor.set(m_leftForwardMotor.get());
        m_rightRearMotor.set(m_rightForwardMotor.get());
    }

    public void stop() {
        m_leftForwardMotor.set(0.0);
        m_leftRearMotor.set(0.0);
        m_rightForwardMotor.set(0.0);
        m_rightRearMotor.set(0.0);
    }
}
