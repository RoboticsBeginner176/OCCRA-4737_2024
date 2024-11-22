// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

 // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Command;

import edu.wpi.first.wpilibj2.command.Command;
import occra.Robot.Subsystem.CANDrivetrain;

public class autodrive extends Command {
  /** Creates a new autoDrive. */
  CANDrivetrain mDrive;
  double leftFront,rightFront;
  public autodrive(CANDrivetrain mDrive,double leftFront, double rightFront) {
    this.mDrive = mDrive;
    this.leftFront = leftFront;
    this.rightFront = rightFront;
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(mDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mDrive.setautonDrive(-leftFront, -rightFront);
  }

  // Called every time the scheduler runs while the command is scheduled.
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mDrive.setStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  return mDrive.atTarget;
  }
}