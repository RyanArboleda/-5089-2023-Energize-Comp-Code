// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import javax.print.attribute.standard.Compression;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticSub extends SubsystemBase {
  /** Creates a new PneumaticSub. */
  DoubleSolenoid IN_OUT;
  PneumaticHub hub = new PneumaticHub(1);

  /**
   * 
   */
  public PneumaticSub() {

    //IN_OUT = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,Constants.Extend,Constants.Retract);
   // Compressor = new Compressor(PneumaticsModuleType.REVPH);
   // IN_OUT = new DoubleSolenoid(PneumaticsModuleType.REVPH, Constants.Extend,Constants.Retract);
  IN_OUT = hub.makeDoubleSolenoid(Constants.Extend, Constants.Retract);

  
  }
    public void Compressor(){
    {
      boolean pressureSwitch = hub.getPressureSwitch();
      
      if(pressureSwitch)
      {
       // Compressor.start();
hub.enableCompressorDigital();
}else
      {
        //Compressor.stop();
      hub.disableCompressor();
      }
 
    }
 
  }
  public void Extend()
  {
 // IN_OUT.set(Value.kForward);
   IN_OUT.set(DoubleSolenoid.Value.kForward);
 
 
  }

  public void Retract()
  {
    IN_OUT.set(DoubleSolenoid.Value.kReverse);
  }

  public void STOP(){
    IN_OUT.set(DoubleSolenoid.Value.kOff);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
