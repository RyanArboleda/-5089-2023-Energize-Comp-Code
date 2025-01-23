// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.elevatorJoystick;

public class elevatorSub extends SubsystemBase {
  /** Creates a new elevatorSub. */
  CANSparkMax elevator1, elevator2;
  DigitalInput bottomLimitSwitch; //topLimitSwitch;


  public elevatorSub() {

    elevator1 = new CANSparkMax(Constants.elevator1,MotorType.kBrushless);
    elevator2 = new CANSparkMax(Constants.elevator2,MotorType.kBrushless);
   
    //bottomLimitSwitch = new DigitalInput(0);
    //topLimitSwitch = new DigitalInput(1);
    
    elevator1.restoreFactoryDefaults();
    elevator2.restoreFactoryDefaults();

    elevator1.setInverted(false);
    elevator2.setInverted(true);
    
  }

  public void elevatorUp(){
    elevator1.set( -0.4);
    elevator2.set( -0.4); 

  }

  public void elavatorValue(double value){
    elevator1.set(value); 
    elevator2.set(value);
  }

  public void elevatorDown(){
    elevator1.set(0.4); 
    elevator2.set(0.4);
  }
  public void elevatorStop(){
    elevator1.set( 0.0);
    elevator2.set( 0.0);

  }

   public void limitSwtichStop(){ //Comment out if no limit Switch WILL NOT WORK WITH IT

    if (bottomLimitSwitch.get()) {
      // We are going up and top limit is tripped so stop
      elevator1.set(0);
      elevator2.set(0);

  } else {
      // We are going up but top limit is not tripped so go at commanded speed
      elevator1.set(1);
      elevator2.set(1);
  }
  }
  
  

  
  public void setElevatorJoy(double power){

   elevator1.set(power);
   elevator2.set(power);
/* 
    if (bottomLimitSwitch.get()){

    elevator1.set(0);
    elevator2.set(0);
  
  }
  else if(topLimitSwitch.get()){
    elevator1.set(power);
    elevator2.set(power);
  }
  */
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
