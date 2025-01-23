// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class oneCubeAuton extends CommandBase {
  /** Creates a new oneCubeAuton. */
  Timer time = new Timer();
  public oneCubeAuton() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mArmSub);
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.mDriveSub);
    addRequirements(RobotContainer.mhHorizontalElevatorSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.stop();
    time.reset();
    time.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(time.get()<0.5){ //Arm out
      RobotContainer.mArmSub.armOut();
      }
     else if(time.get()>=0.51 && time.get()<=1.2){   //Stop time is about half a second
        RobotContainer.mArmSub.armStop();
      }
      else if(time.get()>=1.21 && time.get()<=1.5){ //0.3
        RobotContainer.mIntakeSub.intakeIn();
      }
      else if(time.get()>=1.51 && time.get()<=2.0){ //0.5
        RobotContainer.mIntakeSub.intakeStop();
      }
      else if(time.get()>=2.01 && time.get()<=2.4){ //0.4
        RobotContainer.mArmSub.armIn();
      }
      else if(time.get()>=2.41 && time.get()<=2.9){ //0.5
        RobotContainer.mArmSub.armStop();
      }
      else if(time.get()>=2.91 && time.get()<=4.7){ //1.8
        RobotContainer.mDriveSub.setRaw(0.5, 0.5);
      }
      else if(time.get()>=4.71 && time.get()<=5.2){ //0.5
        RobotContainer.mDriveSub.setRaw(0, 0);
      } 
      }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mDriveSub.setRaw(0, 0);
    RobotContainer.mArmSub.armStop();
    RobotContainer.mIntakeSub.intakeStop();
    RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
