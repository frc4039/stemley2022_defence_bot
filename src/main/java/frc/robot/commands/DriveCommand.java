package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommand extends CommandBase {
    private final DrivetrainSubsystem m_drivetrainSubsystem;
    private DoubleSupplier speedLeft;
    private DoubleSupplier speedRight;

    public DriveCommand(DoubleSupplier speedLeft, DoubleSupplier speedRight, DrivetrainSubsystem drivetrainSubsystem) {
        m_drivetrainSubsystem = drivetrainSubsystem;
        this.speedLeft = speedLeft;
        this.speedRight = speedRight;

        addRequirements(m_drivetrainSubsystem);
    }

    @Override
    public void execute() {
        double m_speedLeft = speedLeft.getAsDouble();
        double m_speedRight = speedRight.getAsDouble();

        m_drivetrainSubsystem.drive(m_speedLeft, m_speedRight);
    }

    @Override
    public void end(boolean interrupted) {
        m_drivetrainSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
