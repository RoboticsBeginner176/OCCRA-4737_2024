// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Subsystem;

import static frc.robot.Constants.IntakeConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANIntake extends SubsystemBase {
  CANSparkMax m_IntakeWheel;
  CANSparkMax m_FeederWheel;

  /** Creates a new Intake. */
  public CANIntake() {
    m_IntakeWheel = new CANSparkMax(kIntakeID, MotorType.kBrushed);
    m_FeederWheel = new CANSparkMax(kFeederID, MotorType.kBrushless);

    m_IntakeWheel.setSmartCurrentLimit(kIntakeCurrentLimit);
    m_FeederWheel.setSmartCurrentLimit(kFeederCurrentLimit);
    
  }

  /**
   * This method is an example of the 'subsystem factory' style of command creation. A method inside
   * the subsytem is created to return an instance of a command. This works for commands that
   * operate on only that subsystem, a similar approach can be done in RobotContainer for commands
   * that need to span subsystems. The Subsystem class has helper methods, such as the startEnd
   * method used here, to create these commands.
   */
  public Command getIntakeNoteCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          
          setIntakeWheel(kIntakeSpeed);
          setFeederWheel(kFeederSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }

    public Command getIntakeNoteReverseCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          
          setIntakeWheel(kIntakeReverseSpeed);
          setFeederWheel(kFeederReverseSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }
 public Command getIntakeOutCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          
          setIntakeWheel(kIntakeReverseSpeed);
          setFeederWheel(kFeederReverseSpeed);
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }


  public Command getFeedShootCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          
          setIntakeWheel(kIntakeReverseSpeed);
          
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }
  // An accessor method to set the speed (technically the output percentage) of the launch wheel
  public void setIntakeWheel(double speed) {
    m_IntakeWheel.set(-speed);
    
  }
  public void setFeederWheel(double speed) {
    m_FeederWheel.set(speed);
  }

 

  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    m_IntakeWheel.set(0);
    m_FeederWheel.set(0);
    
  }
}
