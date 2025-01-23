// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class twoCubeRed extends CommandBase {
  /** Creates a new oneCubeAuton. */
  Timer time = new Timer();
  int armCount = 0;
  public twoCubeRed() {
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
      //Stop Arm
     else if(time.get()>0.6 && time.get()<1.0){   //Stop time is about half a second
        RobotContainer.mArmSub.armStop();
      }
      //Suck Cube
      else if(time.get()>=1.21 && time.get()<=1.5){ //0.3
        RobotContainer.mIntakeSub.intakeIn();
      }
      //Stop Intake
      else if(time.get()>=1.51 && time.get()<=2.0){ //0.5
        RobotContainer.mIntakeSub.intakeStop();
      }
      //Arm In
      else if(time.get()>=2.01 && time.get()<=2.4){ //0.4
        RobotContainer.mArmSub.armIn();
      }
      //Stop Arm In
      else if(time.get()>=2.41 && time.get()<=2.9){ //0.5
        RobotContainer.mArmSub.armStop();
      }
      //Drive Back
      else if(time.get()>=2.91 && time.get()<=4.7){ //1.8
        RobotContainer.mDriveSub.setRaw(0.5, 0.5);
      }
      //Stop
      else if(time.get()>=4.71 && time.get()<=5.2){ //0.5
        RobotContainer.mDriveSub.setRaw(0, 0);
      }  
      // Everything Above Works

      //Turn Around
      else if(time.get()>=5.2 && time.get()<=5.55){ //0.5
        RobotContainer.mDriveSub.setRaw(0.5, -0.5);
      }  
      //Stop Turn
      else if(time.get()>=5.56 && time.get()<=5.8){ //0.5
        RobotContainer.mDriveSub.setRaw(0.0, 0.0);
      }  
      //Arm Out and Start Rollers
      else if(time.get()>=5.8 && time.get()<=6.20){ //0.7
        RobotContainer.mArmSub.armOut();
        RobotContainer.mIntakeSub.intakeIn();
      }
      //Drive Forward Slowly
      else if(time.get()>=6.3 && time.get()<7.0){ //0.7
        RobotContainer.mDriveSub.setRaw(0.4, 0.4);
        RobotContainer.mArmSub.armStop();
        armCount =2;
      }
      //Stop Driving and Intake
      else if(time.get()>7.1 && time.get()<=7.2){
        RobotContainer.mDriveSub.setRaw(0, 0);
        RobotContainer.mIntakeSub.intakeStop();
      }
      //Bring the Arm In
      else if(time.get()>7.3 && time.get()<=7.8){
        RobotContainer.mArmSub.armIn();
      }
      //Stop Everything
      else if(time.get()>=7.9 && time.get()<8.0){
        RobotContainer.mDriveSub.setRaw(0, 0);
        RobotContainer.mArmSub.armStop();
        RobotContainer.mIntakeSub.intakeStop();
        RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
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
