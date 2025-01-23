// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class sequenceUp extends CommandBase {
  /** Creates a new sequenceUp. */
  Timer time = new Timer();
  public sequenceUp() {
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
  //    RobotContainer.mElevatorSub.elevatorUp();
  RobotContainer.mElevatorSub.elavatorValue(-0.6);
  }//0.47->0.188+0.47
     else if (time.get()>0.85 && time.get()<1.43){
        RobotContainer.mElevatorSub.elevatorStop();
        RobotContainer.mhHorizontalElevatorSub.horizontalElevatorOut();
      }
  
      else if(time.get()>1.65 && time.get()<1.7){
        RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
        RobotContainer.mArmSub.armOut();
      }
  
      //Time for Cone (arm out) is 0.83 in between or [1.32 to 2.15]
      //Time for Cube (arm out) is _.__ in between or [1.32 to 2.02?]
  
  
      else if(time.get()>2.29 && time.get()<=2.35){
        RobotContainer.mArmSub.armStop();
        RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
        RobotContainer.mElevatorSub.elevatorStop();
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
    RobotContainer.mElevatorSub.elevatorStop();
    RobotContainer.mArmSub.armStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   // return false;
   return time.get()>=2.36;


  }
}
