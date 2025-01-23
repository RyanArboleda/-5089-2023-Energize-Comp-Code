// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class twoCubeBlue extends CommandBase {
  /** Creates a new oneCubeAuton. */
  Timer time = new Timer();
  public twoCubeBlue() {
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




    if(time.get()<0.1){
      RobotContainer.mElevatorSub.elevatorUp();
  }
     else if (time.get()>0.47 && time.get()<0.52){
        RobotContainer.mElevatorSub.elevatorStop();
        RobotContainer.mhHorizontalElevatorSub.horizontalElevatorOut();
      }
  
      else if(time.get()>1.27 && time.get()<1.32){
        RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
        RobotContainer.mArmSub.armOut();
      }
  
      else if(time.get()>2.02 && time.get()<=2.25){
        RobotContainer.mArmSub.armStop();
      }

      //Drive Back
      else if(time.get()>=2.91 && time.get()<=4.7){ //1.8
        RobotContainer.mDriveSub.setRaw(-0.5, -0.5);
      }
      //Stop
      else if(time.get()>=4.71 && time.get()<=5.2){ //0.5
        RobotContainer.mDriveSub.setRaw(0, 0);
      }  
      // Everything Above Works

      //Turn Around
      else if(time.get()>=5.2 && time.get()<=5.55){ //0.5
        RobotContainer.mDriveSub.setRaw(-0.5, 0.5);
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
      else if(time.get()>6.90 && time.get()<7.1){ //0.7         THIS ONE MAY NEED CHANGE and everything below
        RobotContainer.mDriveSub.setRaw(0.4, 0.4);
        RobotContainer.mArmSub.armStop();
        
      }
      //Stop Driving and Intake
      else if(time.get()>7.3 && time.get()<=7.7){
        RobotContainer.mDriveSub.setRaw(0, 0);
        RobotContainer.mIntakeSub.intakeStop();
      }
      //Bring the Arm In
      else if(time.get()>7.7 && time.get()<=8.2){
        RobotContainer.mArmSub.armIn();
      }
      //Stop Everything
      else if(time.get()>=8.2 && time.get()< 8.4){
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
