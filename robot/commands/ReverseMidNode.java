// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ReverseMidNode extends CommandBase {
  /** Creates a new ReverseMidNode. */
  Timer time = new Timer();

  public ReverseMidNode() {
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

  //Elevator comes down too much so reduce time
  //This should only be in the down command
  
  public void execute() {
    if(time.get()<0.1){
      RobotContainer.mArmSub.armIn();
  }
else if(time.get()>0.40 && time.get()<0.45){
  RobotContainer.mArmSub.armStop();
  RobotContainer.mElevatorSub.elevatorDown();
}
else if(time.get()>0.82 && time.get()<0.90){
  RobotContainer.mElevatorSub.elevatorStop();
  RobotContainer.mhHorizontalElevatorSub.horizontalElevatorIn();

}
else if(time.get()>1.62 && time.get()<1.66)
{
RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
  }
else if(time.get()>1.73 &&time.get()<=2.0)
{
  RobotContainer.mArmSub.armStop();
  RobotContainer.mhHorizontalElevatorSub.horizontalElevatorStop();
  RobotContainer.mElevatorSub.elevatorStop();
}
/////////////
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
    //return false;
    return time.get()>=2.05;
  }
}
