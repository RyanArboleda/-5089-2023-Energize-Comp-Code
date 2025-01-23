// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ChargeStationAuton extends CommandBase {
  /** Creates a new ChargeStationAuton. */
  Timer time = new Timer();
  int armCount = 0;
  boolean isBalancing = false;
  public ChargeStationAuton() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.mDriveSub);
    addRequirements(RobotContainer.mArmSub);
    addRequirements(RobotContainer.mIntakeSub);
    addRequirements(RobotContainer.mElevatorSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time.stop();
    time.reset();
    time.start();
    RobotContainer.mDriveSub.disableRamp();
    RobotContainer.mDriveSub.setBrake();
    RobotContainer.mDriveSub.calibrateGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   
   /* 
    if(time.get()<0.05){ //Arm out
      //RobotContainer.mArmSub.armOut();
      RobotContainer.mElevatorSub.elevatorUp();
      }
      //Stop Arm
     else if(time.get()>=0.2 && time.get()<1.1){   //Stop time is about half a second
        //RobotContainer.mArmSub.armStop();
        RobotContainer.mElevatorSub.elevatorStop();
      }
      //Suck Cube
      else if(time.get()>=1.21 && time.get()<=1.5){ //0.3
        RobotContainer.mIntakeSub.intakeOut();
      }
      //Stop Intake
      else if(time.get()>=1.51 && time.get()<=2.0){ //0.5
        RobotContainer.mIntakeSub.intakeStop();
      }
      //Arm In
      else if(time.get()>=2.1 && time.get()<=2.15){ //0.4
        //RobotContainer.mArmSub.armIn();
        RobotContainer.mElevatorSub.elevatorDown();
      }
      //Stop Arm In
      else if(time.get()>=2.3 && time.get()<=2.9){ //0.5
        //RobotContainer.mArmSub.armStop();
        RobotContainer.mElevatorSub.elevatorStop();
      }
*/

      //Does NOT Engage or dock
       
      //Drive Back

      //  if(time.get()>=7.91 && time.get()<=10.82){ //1.8
        //RobotContainer.mDriveSub.setRaw(-0.3, 0.3); // - and +
    //    RobotContainer.mDriveSub.diffDrive(0.3, 0, false);
    //  }
      //Stop
      // else if(time.get()>=10.83 && time.get()<=10.95){ //was 5.15
      //   RobotContainer.mDriveSub.setRaw(0, 0);
      //   RobotContainer.mArmSub.armStop();
      //   RobotContainer.mElevatorSub.elevatorStop();
      // }
       //Does NOT Engage or dock
       
      // //Drive Back

      // else if(time.get()>=7.91 && time.get()<=10.82){ //1.8
      //   RobotContainer.mDriveSub.setRaw(-0.3, 0.3); // - and +
      // }
      // //Stop
      // else if(time.get()>=10.83 && time.get()<=10.95){ //was 5.15
      //   RobotContainer.mDriveSub.setRaw(0, 0);
      //   RobotContainer.mArmSub.armStop();
      //   RobotContainer.mElevatorSub.elevatorStop();
      // }
      


       if(time.get() >=1) {
        double speed = 0.3;
        double zero = 0;
        if (Math.abs(RobotContainer.mDriveSub.getRoll()) - zero > 1) {
          speed = 0.2 * Math .signum(RobotContainer.mDriveSub.getRoll());
          isBalancing = true;
        } else if (isBalancing) {
          speed = 0;
        }
        RobotContainer.mDriveSub.setRaw(speed, speed);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.mDriveSub.setRaw(0, 0);
    RobotContainer.mArmSub.armStop();
    RobotContainer.mElevatorSub.elevatorStop();
    RobotContainer.mDriveSub.configRamp();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
