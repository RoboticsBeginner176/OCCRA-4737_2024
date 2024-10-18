// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Command;

//import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import occra.Robot.Subsystem.PWMDrivetrain;

 import occra.Robot.Subsystem.CANDrivetrain;
 import occra.Robot.Subsystem.CANElevator;
 import occra.Robot.Subsystem.CANLauncher;


public final class Auto {
  /** Example static factory for an autonomous command. */
  public static Command exampleAuto(CANDrivetrain drivetrain) {
    /**
     * RunCommand is a helper class that creates a command from a single method, in this case we
     * pass it the arcadeDrive method to drive straight back at half power. We modify that command
     * with the .withTimeout(1) decorator to timeout after 1 second, and use the .andThen decorator
     * to stop the drivetrain after the first command times out
     */
    return new RunCommand(() -> 

        drivetrain.arcadeDrive(.5, 0), drivetrain)
        .withTimeout(4)
        .andThen(new RunCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain));
        
        
  }
  //public static Command elevatorAuto(CANElevator elevator) {
    /**
     * RunCommand is a helper class that creates a command from a single method, in this case we
     * pass it the arcadeDrive method to drive straight back at half power. We modify that command
     * with the .withTimeout(1) decorator to timeout after 1 second, and use the .andThen decorator
     * to stop the drivetrain after the first command times out
     */
    /*return new RunCommand(() -> 

        elevator.setElevator(.3), elevator)
        .withTimeout(1)
        .andThen(new RunCommand(() -> elevator.setElevator(0), elevator));}

    public static Command launcher(CANLauncher launching) {
    /**
     * RunCommand is a helper class that creates a command from a single method, in this case we
     * pass it the arcadeDrive method to drive straight back at half power. We modify that command
     * with the .withTimeout(1) decorator to timeout after 1 second, and use the .andThen decorator
     * to stop the drivetrain after the first command times out
     */

     return new RunCommand(() -> 

        PrepareLaunch.setPrepareLauncher(.5), launcher);
        .withTimeout(1)
        .andThen(new RunCommand(() -> PrepareLauncher.setPreparelauncher(.5), launcher));}

    return new RunCommand(() -> 

        launcher.setLauncher(.5), m_launcher);
        .withTimeout(3)
        .andThen(new RunCommand(() -> launcher.setlauncher(0), m_launcher));}

  private Auto() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
