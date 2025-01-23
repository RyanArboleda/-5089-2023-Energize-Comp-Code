// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class armJoystick extends CommandBase {
  /** Creates a new armJoystick. */
  public armJoystick() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mArmSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double value = -RobotContainer.coDriver.getRawAxis(1);

   // RobotContainer.mArmSub.setArmJoy(value);

if(value>=0.5){
  RobotContainer.mArmSub.setArmJoy(0.5); // Arm DOWN?
}
else if(value<=-0.5){
  RobotContainer.mArmSub.setArmJoy(-0.5);  // Arm IN?
}
else{
  RobotContainer.mArmSub.setArmJoy(value);

}
}


  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
