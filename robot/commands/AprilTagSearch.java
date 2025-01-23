// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import org.photonvision.PhotonUtils;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AprilTagSearch extends CommandBase {
  /** Creates a new AprilTagSearch. */
  Joystick driver;
  public AprilTagSearch() {
    // Use addRequirements() here to declare subsystem dependencies.
    driver = new Joystick(Constants.driver);
    addRequirements(RobotContainer.mAprilTag);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //if (driver.getAButton()) {
      // Vision-alignment mode
      // Query the latest result from PhotonVision
      //var result = camera.getLatestResult();

      //if (result.hasTargets()) {
          // First calculate range
          //double range =
        //          PhotonUtils.calculateDistanceToTargetMeters(
                  //        1.5,     //CAMERA_HEIGHT_METERS,
                //          2,     //TARGET_HEIGHT_METERS,
              //            1,     //CAMERA_PITCH_RADIANS,
            //              Units.degreesToRadians(result.getBesttarget().getPitch()));

          // Use this range as the measurement we give to the PID controller.
          // -1.0 required to ensure positive PID controller effort _increases_ range
          //forwardSpeed = -driver.calculate(range, GOAL_RANGE_METERS);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
