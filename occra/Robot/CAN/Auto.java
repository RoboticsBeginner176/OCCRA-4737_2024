// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.CAN;

//import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import occra.Robot.CAN.PWMDrivetrain;

 import occra.Robot.subsystems.CANDrivetrain;
 import occra.Robot.subsystems.CANElevator;
 import occra.Robot.subsystems.CANLauncher;

public final class Autos {
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
  public static Command elevatorAuto(CANElevator elevator) {
    /**
     * RunCommand is a helper class that creates a command from a single method, in this case we
     * pass it the arcadeDrive method to drive straight back at half power. We modify that command
     * with the .withTimeout(1) decorator to timeout after 1 second, and use the .andThen decorator
     * to stop the drivetrain after the first command times out
     */
    return new RunCommand(() -> 

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

        launcher.setlauncher(.3), launcher)
        .withTimeout(1)
        .andThen(new RunCommand(() -> launcher.setlauncher(0), launcher));}

  private Autos() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
