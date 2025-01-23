// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
    public static double rampRateTimeout = 0.4; //0.6
//Drive
  public static int FLDrive = 3; //talon
  public static int BLDrive = 2; //talon
  public static int FRDrive = 1; //talon   //2
  public static int BRDrive = 20; //talon

//Arm
public static int armMotor = 0; //talon

//Elevator
public static int elevator1 = 1; //neo
public static int elevator2 = 2; //neo

//Horizontal Elevator
public static int horizontalElevator = 3; //neo

//Intake 
public static int intakeMotor = 4; //victor 10 


//intake pivot
public static int intakePivot = 11;

//Pnuematics
public static int compresser = 1;
public static int Extend = 0, Retract = 1;

//Controllers
  public static int driver = 0;
  public static int coDriver = 1;
  public static int xBoxContoller = 5;

//Encoders
  public static final int kSlotIdx = 0;

  public static final int kPIDLoopIdx = 0;

  public static final int kTimeoutMs = 30;

  //AutoBalance
  public static final double BEAM_BALANCED_GOAL_DEGREES = 0;
  public static final double BEAM_BALANACED_DRIVE_KP = 0.015; // P (Proportional) constant of a PID loop
  public static final double BEAM_BALANCED_ANGLE_TRESHOLD_DEGREES = 1;
}
