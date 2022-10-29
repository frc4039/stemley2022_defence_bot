package frc.robot.common.autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.*;

public class AutonomousChooser {
    private SendableChooser<AutonomousMode> autonomousModeChooser = new SendableChooser<>();

    public AutonomousChooser() {
        autonomousModeChooser.setDefaultOption("None", AutonomousMode.NONE);
        autonomousModeChooser.addOption("Drive forward", AutonomousMode.FORWARD);
    }

    public SendableChooser<AutonomousMode> getAutonomousModeChooser() {
        return autonomousModeChooser;
    }

    private SequentialCommandGroup getNoAutoCommand(RobotContainer container) {
        SequentialCommandGroup command = new SequentialCommandGroup();

        return command;
    }

    private SequentialCommandGroup getDriveForwardAutoCommand(RobotContainer container) {
        SequentialCommandGroup command = new SequentialCommandGroup();

        driveForward(command, container, 0.5, 0.5, 2.0);

        return command;
    }

    public Command getCommand(RobotContainer container) {
        switch (autonomousModeChooser.getSelected()) {
            case FORWARD:
                return getDriveForwardAutoCommand(container);
            default:
                return getNoAutoCommand(container);
        }
    }

    private void driveForward(SequentialCommandGroup command, RobotContainer container, Double speedLeft,
            Double speedRight, Double timeout) {
        command.addCommands(new DriveCommand(() -> speedLeft, () -> speedRight, container.getDrivetrainSubsystem())
                .withTimeout(timeout));
    }

    private enum AutonomousMode {
        NONE,
        FORWARD
    }
}