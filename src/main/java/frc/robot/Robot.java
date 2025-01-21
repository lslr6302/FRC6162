package frc.robot;
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.util.sendable.SendableRegistry;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;




/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(01);
  private final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(02);
  private final WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(03);
  private final WPI_TalonSRX backRightMotor = new WPI_TalonSRX(04);    

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(backLeftMotor, backRightMotor);
  private final DifferentialDrive m_frontrobotDrive = new DifferentialDrive(frontLeftMotor, frontRightMotor);
  private final XboxController m_controller = new XboxController(0);
  private final Timer m_timer = new Timer();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  //public Robot() {
    //SendableRegistry.addChild(m_robotDrive, m_leftDrive);
    //SendableRegistry.addChild(m_robotDrive, m_rightDrive);
    //SendableRegistry.addChild(m_frontrobotDrive, m_frontleftDrive);
    //SendableRegistry.addChild(m_frontrobotDrive, m_frontrightDrive);
  //}
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    backLeftMotor.setInverted(false);
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);
    frontLeftMotor.setInverted(false);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.restart();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    /*
    // Drive for 2 seconds
    if (m_timer.get() < 10.0) {
      // Drive forwards half speed, make sure to turn input squaring off
      m_robotDrive.arcadeDrive(0.5, 0.0, false);
      m_frontrobotDrive.arcadeDrive(0.5, 0.0, false);
    } else {
      m_timer.reset();
      //m_robotDrive.stopMotor(); // stop robot
    }
    */
  } 

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    // m_robotDrive.arcadeDrive(m_controller.getLeftX(), m_controller.getLeftY());
    // m_frontrobotDrive.arcadeDrive(m_controller.getLeftX(), m_controller.getLeftY());
    m_robotDrive.arcadeDrive(-m_controller.getLeftY(), -m_controller.getRightX());
    m_frontrobotDrive.arcadeDrive(-m_controller.getLeftY(), -m_controller.getRightX());

  }
  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}