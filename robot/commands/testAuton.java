// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class testAuton extends CommandBase {
  /** Creates a new testAuton. */
  Timer time = new Timer();
  public testAuton() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mDriveSub);
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
    
    if(time.get()<0.5){
    RobotContainer.mDriveSub.setRaw(0.5, 0.5);
    }
   else if(time.get()>=1.3 && time.get()<=1.8){   //Stop time is about half a second

      RobotContainer.mDriveSub.setRaw(0.0, 0.0);
    }

  }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mDriveSub.setRaw(0.0, 0.0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
