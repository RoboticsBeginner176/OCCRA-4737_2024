// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Command;

//import static occra.Robot.Constants.LauncherConstants.*;

//import java.util.spi.AbstractResourceBundleProvider;

//import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
//import edu.wpi.first.wpilibj2.command.InstantCommand;
//import edu.wpi.first.wpilibj2.command.RunCommand;
//import edu.wpi.first.wpilibj2.command.Subsystem;
//import occra.Robot.Subsystem.PWMDrivetrain;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import occra.Robot.Subsystem.CANDrivetrain;
import occra.Robot.Subsystem.CANIntake;
import occra.Robot.Subsystem.CANLauncher;
import occra.Robot.Constants;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
//import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
//import edu.wpi.first.wpilibj2.command.InstantCommand;
import static occra.Robot.Constants.LauncherConstants;
//import static occra.Robot.Constants.DrivetrainConstants;
import static occra.Robot.Constants.IntakeConstants;
import static occra.Robot.Command.automIntake;






 
 


public final class Auto {
  /** Example static factory for an autonomous command. */
   //public static Command exampleAuto(CANDrivetrain drivetrain){
    /**
     * RunCommand is a helper class that creates a command from a single method, in this case we
     * pass it the arcadeDrive method to drive straight back at half power. We modify that command
     * with the .withTimeout(1) decorator to timeout after 1 second, and use the .andThen decorator
     * to stop the drivetrain after the first command times out
     */
  //   return new RunCommand(() -> 

  //       drivetrain.arcadeDrive(.5, 0), drivetrain)
  //       .withTimeout(3)
  //       .andThen(new RunCommand(() -> drivetrain.arcadeDrive(0, 0), drivetrain));
        
        
  // }
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
        .andThen(new RunCommand(() -> elevator.setElevator(0), elevator));}*/

    //public static Command launcher(CANLauncher launching) {
    /**
     * RunCommand is a helper class that creates a command from a single method, in this case we
     * pass it the arcadeDrive method to drive straight back at half power. We modify that command
     * with the .withTimeout(1) decorator to timeout after 1 second, and use the .andThen decorator
     * to stop the drivetrain after the first command times out
     */
    /*   public static Command exampleAuto(CANLauncher launching){
      
   
      return new RunCommand(() -> 

        launching.setLeftLaunchWheel(kLeftLauncherSpeed)
        .andThen(new RunCommand(() -> 
          launching.setRightLaunchWheel(kRightLauncherSpeed))))
      .withTimeout(3)
          return new RunCommand(() ->     
      
      launching.setRightLaunchWheel(0)
      .andThen(new RunCommand(() -> 
      launching.setLEftLaunchWheel(0))));
*/


public static Command LEFTtwoBallAuton(CANDrivetrain m_drivetrain, CANLauncher m_Launcher, CANIntake m_Intake){

     return Commands.sequence(
      
     
    new DriveTime(m_drivetrain, .5, 0).withTimeout(2.5),
    //  new drivetrain.arcadeDrive(0, 0),
    new ParallelCommandGroup(
      new LaunchNote(m_Launcher, Constants.LauncherConstants.kLeftLauncherSpeed, LauncherConstants.kRightLauncherSpeed, false).withTimeout(5), 
      //new SequentialCommandGroup(
        new automIntake(m_Intake, Constants.IntakeConstants.kIntakeSpeed, Constant.IntakeConstants.kIntakeRot, false).withTimeout(5)
          
 
        //)
      ),
    //new LaunchNote(m_Launcher, Constants.LauncherConstants.kLeftLauncherSpeed, LauncherConstants.kRightLauncherSpeed, false).withTimeout(2),
    //new DriveTime(m_drivetrain, .5, 0).withTimeout(3), 

     new WaitCommand(2.5)
    
    );
     
   }

 /*  private Auto(){
  throw new UnsupportedOperationException("This is a utility class!");
  
  }
  }
  */
}