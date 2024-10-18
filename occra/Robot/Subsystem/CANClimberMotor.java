// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package occra.Robot.Subsystem;


import static frc.robot.Constants.ElevatorConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class CANClimber extends SubsystemBase {
  CANSparkMax m_climber;
  RelativeEncoder m_Encoder;
 

  /** Creates a new Elevator. */
public CANClimberMotor() {
    m_climber = new CANSparkMax(kClimberID, MotorType.kBrushless);
    
    m_climber.setSmartCurrentLimit(kClimberCurrentLimit);

    m_Encoder = m_Climber.getEncoder();
    m_Encoder.setPosition(0);
  }

public Command getClimberCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setClimber(kClimberSpeed);
          
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }
  public Command getClimberDownCommand() {
    // The startEnd helper method takes a method to call when the command is initialized and one to
    // call when it ends
    return this.startEnd(
        // When the command is initialized, set the wheels to the intake speed values
        () -> {
          setreverseClimber(kClimberReverseSpeed);
          
        },
        // When the command stops, stop the wheels
        () -> {
          stop();
        });
  }

  // An accessor method to set the speed (technically the output percentage) of the Elevator
  public void setElevator(double speed) {
    if (m_Encoder.getPosition() <= 47){
      m_Climber.set(speed);
    }
  }

  public void setreverseClimber(double speed) {
    if (m_Encoder.getPosition() >= 2){
      m_Climber.set(speed);
    }
  }

  // A helper method to stop both wheels. You could skip having a method like this and call the
  // individual accessors with speed = 0 instead
  public void stop() {
    m_Climber.set(0);
    
  }

  @Override
  public void periodic(){
    SmartDashboard.putNumber("Encoder", m_Encoder.getPosition());
  }
}
