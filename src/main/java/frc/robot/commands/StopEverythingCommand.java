package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class StopEverythingCommand extends CommandBase{
    private final DrivetrainSubsystem m_drivetrainSubsystem;

    public StopEverythingCommand(DrivetrainSubsystem drivetrainSubsystem) {
        m_drivetrainSubsystem = drivetrainSubsystem;

        addRequirements(m_drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        m_drivetrainSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
