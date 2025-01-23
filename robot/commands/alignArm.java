// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class alignArm extends CommandBase {
  /** Creates a new alignArm. */
  Timer time = new Timer();
  public alignArm() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mArmSub);
    addRequirements(RobotContainer.mIntakeSub);
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

    if(time.get()<0.8){ //Arm out
      RobotContainer.mArmSub.armOut();
      }
     else if(time.get()>=0.81 && time.get()<=1.2){   //Stop time is about half a second
        RobotContainer.mArmSub.armStop();
      }
      /*else if(time.get()>=1.21 && time.get()<=1.5){ //0.3
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
      }*/
      }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mArmSub.armStop();
    RobotContainer.mIntakeSub.intakeStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
