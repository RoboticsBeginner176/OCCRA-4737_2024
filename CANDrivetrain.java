// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package occra.Robot.Subsystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import com.revrobotics.RelativeEncoder;
import com.revrobotics.RelativeEncoder;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* This class declares the subsystem for the robot drivetrain if controllers are connected via CAN. Make sure to go to
 * RobotContainer and uncomment the line declaring this subsystem and comment the line for PWMDrivetrain.
 *
 * The subsystem contains the objects for the hardware contained in the mechanism and handles low level logic
 * for control. Subsystems are a mechanism that, when used in conjuction with command "Requirements", ensure
 * that hardware is only being used by 1 command at a time.
 */
public class CANDrivetrain extends SubsystemBase {
  /*Class member variables. These variables represent things the class needs to keep track of and use between
  different method calls. */
  DifferentialDrive m_drivetrain;
  RelativeEncoder leftSideEncoder,rightSideEncoder;
  public boolean atTarget,atAngleTarget; 
  double leftFront,rightFront;
  //RelativeEncoder m_leftFrontSpeedEncoder;
  //RelativeEncoder m_rightFrontSpeedEncoder;


  /*Constructor. This method is called when an instance of the class is created. This should generally be used to set up
   * member variables and perform any configuration or set up necessary on hardware.
   */
  public CANDrivetrain() {
    CANSparkMax leftFront = new CANSparkMax(1, MotorType.kBrushed);
    CANSparkMax leftRear = new CANSparkMax(2, MotorType.kBrushed); 
    CANSparkMax rightFront = new CANSparkMax(4, MotorType.kBrushed);
    CANSparkMax rightRear = new CANSparkMax(3, MotorType.kBrushed); {
      /*Sets current limits for the drivetrain motors. This helps reduce the likelihood of wheel spin, reduces motor heating
       *at stall (Drivetrain pushing against something) and helps maintain battery voltage under heavy demand */
      leftFront.setSmartCurrentLimit(60);
      leftRear.setSmartCurrentLimit(60);
      rightFront.setSmartCurrentLimit(60);
      rightRear.setSmartCurrentLimit(60);

      // Set the rear motors to follow the front motors.
      leftRear.follow(leftFront);
      rightRear.follow(rightFront);
    } 
    
        // Invert the left side so both side drive forward with positive motor outputs
      leftFront.setInverted(true);
      rightFront.setInverted(false);
      
      //Get encoder's
      //m_leftFrontSpeedEncoder = leftFront.getEncoder();
      //m_rightFrontSpeedEncoder = rightFront.getEncoder();
      //m_leftFrontSpeedEncoder.setPosition(0);
      //m_rightFrontSpeedEncoder.setPosition(0);
      // Put the front motors into the differential drive object. This will control all 4 motors with
      // the rears set to follow the fronts
      m_drivetrain = new DifferentialDrive(leftFront, rightFront);
    }

  

  /*Method to control the drivetrain using arcade drive. Arcade drive takes a speed in the X (forward/back) direction
   * and a rotation about the Z (turning the robot about it's center) and uses these to control the drivetrain motors */
  public void arcadeDrive(double speed, double rotation) {
    m_drivetrain.arcadeDrive(-speed, rotation);
    
  }
  public void setautonDrive(double leftFront, double rightFront){
    //resets Encoders at start of Command
    this.leftFront = metersToEncoder(leftFront);
    this.rightFront = metersToEncoder(rightFront);

   leftSideEncoder.setPosition(0);
   rightSideEncoder.setPosition(0);
   
   atTarget=false;
  }
  private double metersToEncoder(double meters){
    return meters;
  }

  public void setStop(){
    arcadeDrive(0,0);
  }

  @Override
  public void periodic() {
    /*This method will be called once per scheduler run. It can be used for running tasks we know we want to update each
     * loop such as processing sensor data. Our drivetrain is simple so we don't have anything to put here */
    //SmartDashboard.putNumber("Left Drive Position", m_leftFrontSpeedEncoder.getPosition());
    //SmartDashboard.putNumber("Right Drive Position", m_rightFrontSpeedEncoder.getPosition());
    //SmartDashboard.putNumber("Left Drive Speed", m_leftFrontSpeedEncoder.getVelocity());
    //SmartDashboard.putNumber("Right Drive Speed", m_rightFrontSpeedEncoder.getVelocity());
  }
}
