// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ReverseCommandNEW extends CommandBase {
  /** Creates a new ReverseCommandNEW. */
  Timer time = new Timer();

  public ReverseCommandNEW() {
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
      RobotContainer.mElevatorSub.elavatorValue(0.6);
  }
else if(time.get()>0.95 && time.get()<0.97){
  RobotContainer.mElevatorSub.elevatorStop();
  RobotContainer.mhHorizontalElevatorSub.horizontalElevatorIn();
}
else if (time.get()>1.75 && time.get()<1.77){
  RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
}
  ////////////////////

  
      // else if(time.get()>2.2 && time.get()<2.25){
      //   RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
        //RobotContainer.mArmSub.armIn();
     // }
  
      //Time for Cone (arm out) is 0.83 in between or [1.32 to 2.15]
      //Time for Cube (arm out) is _.__ in between or [1.32 to 2.02?]
  
  
      else if(time.get()>1.78 && time.get()<=1.8){
        RobotContainer.mArmSub.armStop();
        RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
        RobotContainer.mElevatorSub.elevatorStop();
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mElevatorSub.elevatorStop();
    RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
