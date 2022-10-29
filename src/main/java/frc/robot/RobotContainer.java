package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.*;
import frc.robot.common.autonomous.AutonomousChooser;
import frc.robot.common.util.DriverReadout;
import frc.robot.subsystems.DrivetrainSubsystem;

public class RobotContainer {
    private final XboxController m_driverController = new XboxController(Constants.DRIVER_CONTROLLER_PORT);

    private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();

    private AutonomousChooser autonomousChooser;

    private final DriverReadout driverReadout;

    public RobotContainer() {
        autonomousChooser = new AutonomousChooser();

        CommandScheduler.getInstance().registerSubsystem(m_drivetrainSubsystem);

        m_drivetrainSubsystem.setDefaultCommand(new DriveCommand(() -> m_driverController.getLeftY(),
                () -> m_driverController.getRightY(), m_drivetrainSubsystem));

        driverReadout = new DriverReadout(this);

        configureButtonBindings();
    }

    private void configureButtonBindings() {
    }

    public Command getAutonomousCommand() {
        return autonomousChooser.getCommand(this);
    }

    public DrivetrainSubsystem getDrivetrainSubsystem() {
        return m_drivetrainSubsystem;
    }

    public XboxController getDriverController() {
        return m_driverController;
    }

    public AutonomousChooser getAutonomousChooser() {
        return autonomousChooser;
    }

    public void stopEverything() {
        new StopEverythingCommand(m_drivetrainSubsystem);
    }
}
