// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class encoderSeqArm extends CommandBase {
  /** Creates a new encoderSeqArm. */
  Timer time;
  Joystick coDriver;
  public encoderSeqArm() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mArmSub);
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.mhHorizontalElevatorSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = new Timer();
    coDriver = new Joystick(1);
    time.stop();
    time.reset();
    RobotContainer.mArmSub.EncoderReset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  //  int count = 0;

     if(coDriver.getRawButton(1)){
  //     time.reset();
  //     time.start();
       RobotContainer.mArmSub.encoderSeq();
       RobotContainer.mIntakeSub.intakeOut();
  //     RobotContainer.mhHorizontalElevatorSub.horizontalElevatorOut();
  //     if(time.get()>=0.2){
  //       RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
  //       }

     //}else {
  //     time.reset();
  //     time.start();
     //  RobotContainer.mArmSub.encoderBack();
      
  //     RobotContainer.mhHorizontalElevatorSub.horizontalElevatorIn();

  //     if(time.get()>=0.2){
  //       RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
  //       }
     }

   }
   

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mIntakeSub.intakeStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
