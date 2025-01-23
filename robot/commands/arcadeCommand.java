// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import java.sql.Driver;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class arcadeCommand extends CommandBase {
  /** Creates a new arcadeCommand. */
  Joystick driver, xBoxController;
  public arcadeCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mDriveSub);
    driver = RobotContainer.driver;
   // xBoxController = RobotContainer.xBoxController;
    
  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.mDriveSub.configRamp();

    RobotContainer.mDriveSub.setBrake();
    
    //RobotContainer.mDriveSub.setCoast();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double throttle = 0;
    double turn = 0;
    
//Logitech Controller
    throttle = driver.getRawAxis(1);
    turn = driver.getRawAxis(2);

//Xbox Controller
//    throttle = xBoxController.getRawAxis(1);
 //   turn = xBoxController.getRawAxis(2);

// RobotContainer.mDriveSub.diffDrive(throttle * RobotContainer.speedMult, turn, !driver.getRawButton(5));

  //RobotContainer.mDriveSub.diffDrive(throttle, turn, !driver.getRawButton(5));

RobotContainer.mDriveSub.setPower(-throttle * RobotContainer.speedMult, -turn * .60); // 70% before
  


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
