// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intakeSub extends SubsystemBase {
  /** Creates a new intake. */
  //VictorSPX intakeMotor;
  CANSparkMax intakeMotor;

  public intakeSub() {

    //intakeMotor = new VictorSPX(Constants.intakeMotor);
    intakeMotor = new CANSparkMax(Constants.intakeMotor,MotorType.kBrushless);
   
    //bottomLimitSwitch = new DigitalInput(0);
    //topLimitSwitch = new DigitalInput(1);
    
    intakeMotor.restoreFactoryDefaults();

    intakeMotor.setInverted(false);
  }

  public void intakeIn(){
    // intakeMotor.set(ControlMode.PercentOutput, 0.5);
    intakeMotor.set(0.8);
  }

  public void intakeOut(){
    // intakeMotor.set(ControlMode.PercentOutput, 0.5);
    intakeMotor.set(-0.5);
  }

  public void intakeOut_AutoSpeed(){
    //intakeMotor.set(ControlMode.PercentOutput, -0.5);
    intakeMotor.set(-0.8);
  }
  public void intakeStop(){
    //intakeMotor.set(ControlMode.PercentOutput, 0.0);
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
