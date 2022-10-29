package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private static Robot instance = null;

    private Command m_autonomousCommand;

    private RobotContainer m_robotContainer = new RobotContainer();

    public Robot() {
        instance = this;
    }

    public static Robot getInstance() {
        return instance;
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
        m_robotContainer.stopEverything();
    }

    @Override
    public void autonomousInit() {
        m_robotContainer.getAutonomousCommand().schedule();
    }

    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }
}
