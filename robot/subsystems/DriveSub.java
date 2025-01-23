// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSub extends SubsystemBase {
  /** Creates a new DriveSub. */

  WPI_TalonFX FLDrive, FRDrive, BLDrive, BRDrive;
  DifferentialDrive NerdBots;
  MotorControllerGroup Left, Right;
  private final AHRS navX = new AHRS(SerialPort.Port.kMXP); 
  
  public DriveSub() {

    FLDrive = new WPI_TalonFX(Constants.FLDrive);
    FRDrive = new WPI_TalonFX(Constants.FRDrive);
    BLDrive = new WPI_TalonFX(Constants.BLDrive);
    BRDrive = new WPI_TalonFX(Constants.BRDrive);

    FRDrive.setNeutralMode(NeutralMode.Brake);
    BRDrive.setNeutralMode(NeutralMode.Brake);
    FLDrive.setNeutralMode(NeutralMode.Brake);
    BLDrive.setNeutralMode(NeutralMode.Brake);

    // FLDrive.setInverted(false); 
    // BLDrive.setInverted(false); 
    // FRDrive.setInverted(true);
    // BRDrive.setInverted(true);

    BLDrive.set(ControlMode.Follower, FLDrive.getDeviceID());
    BRDrive.set(ControlMode.Follower, FRDrive.getDeviceID());
  
  //   Left = new MotorControllerGroup(FLDrive, BLDrive);  //Maybe this 
  //   Right = new MotorControllerGroup(FRDrive, BRDrive);
    
  //    NerdBots = new DifferentialDrive(Left, Right);  
  //   }

  //  public void diffDrive(double throttle, double turn, boolean quick){
  //    NerdBots.curvatureDrive(throttle, turn, quick);
   }

  public void setPower(double throttle, double turn){

    // double leftOutput = -throttle +turn;
    // double rightOutput = -throttle -turn;
    
    // FLDrive.set(ControlMode.PercentOutput, -leftOutput);
    // BLDrive.set(ControlMode.PercentOutput, -leftOutput);
    // FRDrive.set(ControlMode.PercentOutput, rightOutput);
    // BRDrive.set(ControlMode.PercentOutput, rightOutput);

    double leftOutput = -throttle +turn;
    double rightOutput = -throttle -turn;
    
    FLDrive.set(ControlMode.PercentOutput, leftOutput);
    BLDrive.set(ControlMode.PercentOutput, leftOutput); 
    FRDrive.set(ControlMode.PercentOutput, -rightOutput); 
    BRDrive.set(ControlMode.PercentOutput, -rightOutput); 
        
    }


    public void setRaw(double Right, double Left){
      FLDrive.set(ControlMode.PercentOutput, Left);
      BLDrive.set(ControlMode.PercentOutput, Left);
      FRDrive.set(ControlMode.PercentOutput, -Right);
      BRDrive.set(ControlMode.PercentOutput, -Right);
  
    }

   public void setBrake(){
      FLDrive.setNeutralMode(NeutralMode.Brake);
      BLDrive.setNeutralMode(NeutralMode.Brake);
      FRDrive.setNeutralMode(NeutralMode.Brake);
      BLDrive.setNeutralMode(NeutralMode.Brake);
    }       

    public void setCoast(){
      FLDrive.setNeutralMode(NeutralMode.Coast);
      BLDrive.setNeutralMode(NeutralMode.Coast);
      FRDrive.setNeutralMode(NeutralMode.Coast);
      BLDrive.setNeutralMode(NeutralMode.Coast);
    }

    public void configRamp(){
      FLDrive.configOpenloopRamp(Constants.rampRateTimeout);
      BLDrive.configOpenloopRamp(Constants.rampRateTimeout);
      FRDrive.configOpenloopRamp(Constants.rampRateTimeout);
      BRDrive.configOpenloopRamp(Constants.rampRateTimeout);
    }

    public void disableRamp(){
      FLDrive.configOpenloopRamp(0.0);
      BLDrive.configOpenloopRamp(0.0);
      FRDrive.configOpenloopRamp(0.0);
      BLDrive.configOpenloopRamp(0.0);
    }

    public void calibrateGyro(){
      navX.reset();
      navX.calibrate();
      
   
    }

    public double getPitch(){
      return navX.getPitch(); 
    }

    public double getYaw(){
      return navX.getYaw(); 
    }

    public double getRoll(){
      return navX.getRoll();
    }
    

    public CommandBase driveAuBase() {
      // Inline construction of command goes here.
      // Subsystem::RunOnce implicitly requires `this` subsystem.
      return runOnce(
          () -> {
            /* one-time action goes here */
          });
    }  


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Gyro Pitch (X)", getPitch()); 
    SmartDashboard.putNumber("Gyro Yaw (Z)", getYaw()); 
    SmartDashboard.putNumber("Gyro Roll (Z) ", getRoll()); 

  }
}
