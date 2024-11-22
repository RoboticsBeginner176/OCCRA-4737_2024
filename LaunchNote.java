// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Command;

//import static occra.Robot.Constants.LauncherConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import occra.Robot.Subsystem.CANLauncher;


/*This is an example of creating a command as a class. The base Command class provides a set of methods that your command
 * will override.
 */
public class LaunchNote extends Command {
 // PWMLauncher m_launcher;
double setLeftLaunchWheel,setRightLaunchWheel;
LaunchNote mLauncher;
boolean bturnOff;
  CANLauncher m_Launcher;
  public LaunchNote(CANLauncher m_Launcher, double setRightLaunchWheel, double setLeftLaunchWheel,boolean bturnOff) {
    this.m_Launcher=m_Launcher;
    this.setLeftLaunchWheel=setLeftLaunchWheel;
    this.setRightLaunchWheel=setRightLaunchWheel;
    this.bturnOff=bturnOff;
    addRequirements(m_Launcher);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  /** Creates a new LaunchNote. */
  public LaunchNote(CANLauncher Launcher) {
    // save the launcher system internally
    m_Launcher = Launcher;

    // indicate that this command requires the launcher system
    addRequirements(m_Launcher);
  }

  public LaunchNote(LaunchNote mLauncher, int i, int j) {
    //TODO Auto-generated constructor stub
  }

  // The initialize method is called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set the wheels to launching speed
    m_Launcher.setLeftLaunchWheel(1.0);
    m_Launcher.setRightLaunchWheel(1.0);
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
    m_Launcher.stop();
  }

public static Object setLauncher(double d) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setLauncher'");
}
}
