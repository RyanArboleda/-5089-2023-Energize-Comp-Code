// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.List;

//import org.photonvision.PhotonCamera;
//import org.photonvision.targeting.PhotonPipelineResult;
//import org.photonvision.targeting.PhotonTrackedTarget;
//import org.photonvision.targeting.TargetCorner;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class aprilTag extends SubsystemBase {
  /** Creates a new aprilTag. */
  public aprilTag() {

    

   // PhotonCamera camera = new PhotonCamera("photonvision");

            //var result = camera.getLatestResult();

            //boolean hasTargets = result.hasTargets();
            
            //List<PhotonTrackedTarget> targets = result.getTargets();


  }


  //public static PhotonTrackedTarget bestTargetGET(PhotonCamera camName){
    //var result = camName.getLatestResult();

    //PhotonTrackedTarget target = result.getBestTarget();

    //return target;

      //double yaw = target.getYaw();  
      //double pitch = target.getPitch();
      //double area = target.getArea();
      //double skew = target.getSkew();
      //Transform2d pose = target.getCameraToTarget();
      //List<TargetCorner> corners = target.getDetectedCorners();

      

      //int targetID = target.getFiducialId();
      //double poseAmbiguity = target.getPoseAmbiguity();
      //Transform3d bestCameraToTarget = target.getBestCameraToTarget();
      //Transform3d alternateCameraToTarget = target.getAlternateCameraToTarget();

      
 // }
  



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
