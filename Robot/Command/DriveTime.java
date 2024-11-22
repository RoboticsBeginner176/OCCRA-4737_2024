// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Command;

import edu.wpi.first.wpilibj2.command.Command;
import occra.Robot.Subsystem.CANDrivetrain;

public class DriveTime extends Command {
/** Creates a new DriveTime. */
  CANDrivetrain drive;  
  double speed;
  double rot;
  public DriveTime(CANDrivetrain drivetrain, double arcadeSpeed, double arcadeRot ) {
    // Use addRequirements() here to declare subsystem dependencies.
    drive = drivetrain;
    speed = arcadeSpeed;
    rot = arcadeRot;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(speed, rot);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
