// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.BalanceTestGyro;
import frc.robot.commands.ChargeStationAuton;
//import frc.robot.commands.DriveOutAuton;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MidCubeArmBut_In;
import frc.robot.commands.MidCubeArmButton;
import frc.robot.commands.MidCubeAuton;
import frc.robot.commands.MidCubeAutonEngage;
import frc.robot.commands.MidNode;
import frc.robot.commands.PneumaticEXTENDCommand;
import frc.robot.commands.PneunaticRETRACTCommand;
import frc.robot.commands.ReverseCommandNEW;
import frc.robot.commands.ReverseMidNode;
import frc.robot.commands.alignArm;
import frc.robot.commands.arcadeCommand;
import frc.robot.commands.arm90Command;
import frc.robot.commands.armInCommand;
import frc.robot.commands.armJoystick;
import frc.robot.commands.armOutCommand;
//import frc.robot.commands.autonTest;
import frc.robot.commands.elevatorDownCommand;
import frc.robot.commands.elevatorInCommand;
import frc.robot.commands.elevatorJoystick;
import frc.robot.commands.elevatorOutCommand;
import frc.robot.commands.elevatorUpCommand;
import frc.robot.commands.encoderSeqArm;
import frc.robot.commands.encoderSeqArmCone;
import frc.robot.commands.encoderSeqIn;
import frc.robot.commands.encoderSeqInCone;
import frc.robot.commands.intakeIN_Command;
import frc.robot.commands.intakeOUT_Command;
import frc.robot.commands.oneCubeAuton;
import frc.robot.commands.sequenceDown;
import frc.robot.commands.sequenceUp;
import frc.robot.commands.testAuton;
import frc.robot.commands.twoCubeBlue;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PneumaticSub;
import frc.robot.subsystems.aprilTag;
import frc.robot.subsystems.armSub;
import frc.robot.subsystems.elevatorSub;
import frc.robot.subsystems.horizontalElevatorSub;
import frc.robot.subsystems.intakePivotSub;
import frc.robot.subsystems.intakeSub;

//import java.sql.Driver;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  
  public static DriveSub mDriveSub = new DriveSub();

  public static double speedMult = 1;

  public static arcadeCommand mArcadeCommand = new arcadeCommand();

  //public static autonTest mAutonTest = new autonTest();

  //public static DriveOutAuton mDriveOutAuton = new DriveOutAuton();

  public static armSub mArmSub = new armSub();

  public static elevatorSub mElevatorSub = new elevatorSub();

  public static intakeSub mIntakeSub = new intakeSub();

  public static PneumaticSub mPneumaticSub = new PneumaticSub();

 // public static intakePivotSub mIntakePivotSub = new intakePivotSub();

  public static horizontalElevatorSub mhHorizontalElevatorSub = new horizontalElevatorSub();

  public static aprilTag mAprilTag = new aprilTag();
 



  public static Joystick driver = new Joystick(Constants.driver);
  public static Joystick coDriver = new Joystick(Constants.coDriver);
  //public static Joystick xBoxController = new Joystick(Constants.xBoxContoller);


  //Controls

  
  //JoystickButton elevatorUp = new JoystickButton(coDriver, 5);
  //JoystickButton elevatorDown = new JoystickButton(coDriver, 7);

  /*
   * 1 = X
   * 2 = A
   * 3 = B
   * 4 = Y
   * 5 = LB
   * 6 = RB
   * 7 = LT
   * 8 = RT
   */

  JoystickButton elevatorUp = new JoystickButton(driver,1); // X    
  JoystickButton elevatorDown = new JoystickButton(driver,2); // A  
  JoystickButton speedDown = new JoystickButton(driver, 6);    // RB

  //JoystickButton autoArmAlign = new JoystickButton(driver,3); // B   Auto Align Arm for intake
  //JoystickButton ReverseMidNode = new JoystickButton(driver,3); // B   Auto Align Arm for intake
  //JoystickButton MidNode = new JoystickButton(driver,4); // Y   


  JoystickButton horizontalElevatorIn = new JoystickButton(coDriver,8); // RT   
  JoystickButton horizontalElevatorOut = new JoystickButton(coDriver,7); // LT

  JoystickButton armUp = new JoystickButton(coDriver, 5); // LB 
  JoystickButton armDown = new JoystickButton(coDriver, 6); //RB 

  JoystickButton intakeUp = new JoystickButton(coDriver, 3); // B
  JoystickButton intakeDown = new JoystickButton(coDriver, 4); // Y

 JoystickButton encoderSequenceArm = new JoystickButton(coDriver,1); // X   
 JoystickButton encoderSeqIn = new JoystickButton(coDriver,1); // X   
 JoystickButton encoderSequenceArmCone = new JoystickButton(coDriver,2); // A   
 JoystickButton encoderSequenceInCone = new JoystickButton(coDriver,2); // A  

 JoystickButton midCubeArmButton = new JoystickButton(driver, 3);   // B

 // 



  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  mDriveSub.setDefaultCommand(new arcadeCommand());
    //mDriveSub.setDefaultCommand(mArcadeCommand);
  //mElevatorSub.setDefaultCommand(new elevatorJoystick());
  //mArmSub.setDefaultCommand(new armJoystick() ); //DOWN IS FORWARD
  //mArmSub.setDefaultCommand(new encoderSeqArm());
}

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

    elevatorUp.whileTrue(new elevatorUpCommand());
    elevatorDown.whileTrue(new elevatorDownCommand());
    horizontalElevatorIn.whileTrue(new elevatorInCommand());
    horizontalElevatorOut.whileTrue(new elevatorOutCommand());


    armUp.whileTrue(new armOutCommand());
    armDown.whileTrue(new armInCommand());
    intakeUp.whileTrue(new intakeIN_Command());
    intakeDown.whileTrue(new intakeOUT_Command());

    encoderSequenceArm.whileTrue(new encoderSeqArm());
    encoderSequenceArm.whileFalse((new encoderSeqIn()));

    encoderSequenceArmCone.whileTrue(new encoderSeqArmCone());
    encoderSequenceInCone.whileFalse(new encoderSeqInCone());

    midCubeArmButton.whileTrue(new MidCubeArmButton());
    midCubeArmButton.whileFalse(new MidCubeArmBut_In());


    // CHANGE HERE
    speedDown.whenPressed(new InstantCommand(() -> {
      speedMult = 0.2;
    }));
    speedDown.whenReleased(new InstantCommand(() -> {
      speedMult = 1;
    }));

    //autoArmAlign.toggleOnTrue(new alignArm());

    //ReverseMidNode.toggleOnTrue(new ReverseCommandNEW()); //used to be sequenceDown
    //MidNode.toggleOnTrue(new sequenceUp());

    //intakePivotUp.whileTrue(new intakePivotUpCommand());
    //intakePivotDoewn.whileTrue(new intakePivotDownCommand());


    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return Autos.exampleAuto(m_exampleSubsystem);
    //return new twoCubeRed();
    //return new twoCubeBlue;
   // return new ChargeStationAuton();
    //mDriveSub.calibrateGyro(); //MAY NEED TO DELETE THIS FROM HERE  

    //return new MidCubeAuton();
    return new MidCubeAutonEngage();
    //return new BalanceTestGyro();

    //return new arm90Command();

    //return new twoCubeBlue();
  }
}
