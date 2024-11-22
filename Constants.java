// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    // Port numbers for driver and operator gamepads. These correspond with the numbers on the USB
    // tab of the DriverStation
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }

  public static class DrivetrainConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kLeftRearID = 2;
    public static final int kLeftFrontID = 1;
    public static final int kRightRearID = 3;
    public static final int kRightFrontID = 4;

    // Current limit for drivetrain motors
    public static final int kCurrentLimit = 60;

    public static final double kLeftRearSpeed = 1;
    public static final double kRightRearSpeed = 1;
    public static final double kLeftFrontSpeed = 1;
    public static final double kRightFrontSpeed = -1;
  }

  public static class LauncherConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kFrontLauncherID = 6;
    public static final int kRearLauncherID = 5;

    // Current limit for launcher and feed wheels
    public static final int kLeftLauncherCurrentLimit = 100;
    public static final int kRightLauncherCurrentLimit = 100;

    // Speeds for wheels when intaking and launching. Intake speeds are negative to run the wheels
    // in reversed
    public static final double kLeftLauncherSpeed = 0.3;
    public static final double kRightLauncherSpeed = 0.5;
    public static final double kReverseLeftLauncherSpeed = -1;
    public static final double kReverseRightLauncherSpeed = -1;

    public static final double kAmpLeftLauncherSpeed = 0.1;
    public static final double kAmpRightLauncherSpeed = 0.25;

    public static final double kLauncherDelay = 2.5;
    
    
    
  }

  public static class IntakeConstants {
    // PWM ports/CAN IDs for motor controllers
    public static final int kIntakeID = 7;
   // public static final int kFeederID = 7;

    
    // Current limit for launcher and feed wheels
    public static final int kIntakeCurrentLimit = 80;
    public static final int kFeederCurrentLimit = 80;

    // Speeds for wheels when intaking. Intake speeds are negative to run the wheels
    // in reverse
    public static final double kIntakeSpeed = 0.2;
    public static final double kIntakeReverseSpeed = -0.2;

    public static final double kFeederSpeed = -0.5;
    public static final double kFeederReverseSpeed = 0.5;

    
    public static final double kIntakeFeederDelay = 2.0;


  }
  public static class ClimberConstants {
   
 
 public static final int kClimberID = 8;
    
    // Current limit for Elevator
  public static final int kClimberCurrentLimit = 80;

    // Speeds for wheels when Elevating. Elevating speeds are negative to run the wheels
    // in reverse
  public static final double kClimberSpeed = .6;
  public static final double kClimberReverseSpeed = -.6;

  public static final double kClimberDelay = 0.000176;
}

}
