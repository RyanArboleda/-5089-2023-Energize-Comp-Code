// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MidCubeAutonEngage extends CommandBase {
  /** Creates a new MidCubeAuton. */
  Timer time = new Timer();
  int armCount = 0;
  boolean isBalancing = false;
  public MidCubeAutonEngage() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mArmSub);
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.mDriveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.stop();
    time.reset();
    time.start();
    RobotContainer.mDriveSub.disableRamp();
    RobotContainer.mDriveSub.setBrake();
    RobotContainer.mArmSub.EncoderReset();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (time.get()>0 && time.get()<1.0){
      RobotContainer.mArmSub.MidCubeArm();
    }

    else if(time.get()>1.0 && time.get()<1.4){ //Arm out
      //RobotContainer.mArmSub.armOut();
      RobotContainer.mIntakeSub.intakeIn();
      }
    
    else if(time.get()>1.5 && time.get()<1.7){
      RobotContainer.mIntakeSub.intakeStop();
    }

    else if(time.get()>1.7 && time.get()<2.7){
      RobotContainer.mArmSub.encoderBack();
    }

//DOES NOT WORK (Fighting?)

    else if(time.get()>2.8 && time.get()<4.65){ //2.8 ---> 4.65
      RobotContainer.mDriveSub.setRaw(0.3, 0.3);
    }
    
    else if(time.get()>4.75 && time.get()< 5.0){ // 4.75 ---> 5.0
      RobotContainer.mDriveSub.setRaw(0, 0);
      RobotContainer.mIntakeSub.intakeStop();
      RobotContainer.mArmSub.armStop();
    }

   }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mArmSub.armStop();
    RobotContainer.mDriveSub.setRaw(0, 0);
    RobotContainer.mIntakeSub.intakeStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
