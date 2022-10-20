package frc.robot;

public final class Constants {
    public static final double CONTROLLER_DEADBAND = 0.075;
    public static final int DRIVER_CONTROLLER_PORT = 0;

    public static final class DrivetrainConstants {
        public static final int kDrivetrainMotorLeftForwardPort = 0;
        public static final int kDrivetrainMotorLeftRearPort = 1;
        public static final int kDrivetrainMotorRightForwardPort = 2;
        public static final int kDrivetrainMotorRightRearPort = 3;

        public static final Boolean kDrivetrainMotorLeftRearInverted = false;
        public static final Boolean kDrivetrainMotorLeftForwardInverted = false;
        public static final Boolean kDrivetrainMotorRightForwardInverted = true;
        public static final Boolean kDrivetrainMotorRightRearInverted = true;
    }
}
