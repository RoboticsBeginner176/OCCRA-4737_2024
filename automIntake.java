// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Command;

import edu.wpi.first.wpilibj2.command.Command;
import occra.Robot.Subsystem.CANIntake;

public class automIntake extends Command {
/** Creates a new DriveTime. */
  CANIntake intake;  
  double speed;
  double rot;
  public automIntake(CANIntake mIntake, double kIntakeSpeed, double kIntakeRot ) {
    // Use addRequirements() here to declare subsystem dependencies.
    mIntake = intake;
    speed = kIntakeSpeed;
    rot = kIntakeRot;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    WaitCommand(3);
    intake.automIntake(speed, rot);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.automIntake(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
