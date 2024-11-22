// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Command;

//import static occra.Robot.Constants.IntakeConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
//import frc.robot.subsystems.PWMLauncher;

import occra.Robot.Subsystem.CANIntake;

/*This is an example of creating a command as a class. The base Command class provides a set of methods that your command
 * will override.
 */
public class IntakeNote extends Command {
 // PWMLauncher m_launcher;

  CANIntake m_intake;
  double setIntakeWheel;
  IntakeNote mIntake;
  boolean bturnOff;
  CANIntake m_Intake;
  public IntakeNote(CANIntake m_Intake, double setIntakeWheel, boolean bturnOff) {
    this.m_Intake=m_Intake;
    this.setIntakeWheel=setIntakeWheel;
    this.bturnOff=bturnOff;
    addRequirements(m_Intake);
  }
  /** Creates a new IntakeNote. */
  public IntakeNote(CANIntake intake) {
    // save the Intake system internally
    m_intake = intake;

    // indicate that this command requires the Intake system
    addRequirements(m_intake);
  }

  public IntakeNote(IntakeLauncher mIntake, int i, int j) {
    //TODO Auto-generated constructor stub
}

// The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set the wheels to intaking speed
    m_intake.setIntakeWheel(1.0);
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // There is nothing we need this command to do on each iteration. You could remove this method
    // and the default blank method
    // of the base class will run.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use the
    // scheduler to end the command when the button is released.
    return false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends.
    m_intake.stop();
    
  }
  public static Object setIntake(double d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setIntake'");
}
}