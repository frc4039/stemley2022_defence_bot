package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private static Robot instance = null;

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
}
