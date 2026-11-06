// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.BasicAuto;
import org.team4159.commandsv3backport.command3.Command;
import org.team4159.commandsv3backport.command3.Trigger;
import org.team4159.commandsv3backport.command3.button.CommandNiDsXboxController;

import frc.robot.mechanisms.Arm;
import frc.robot.mechanisms.Drivetrain;


public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final CommandNiDsXboxController controller = new CommandNiDsXboxController(0);
  private final Command driveCommand = drivetrain.driveCommand(controller);
  private final Arm arm = new Arm();
  private final Trigger armButtonUp = controller.rightTrigger();
  private final Trigger armButtonDown = controller.leftTrigger();

  public RobotContainer() {
    drivetrain.setDefaultCommand(driveCommand);
  
    configureBindings();
  }

  private void configureBindings() {
    armButtonUp.whileTrue(arm.liftCommand(0.1));//arm speed
    armButtonDown.whileTrue(arm.liftCommand(-0.1));//arm speed
  }

  public Command getAutonomousCommand() {
    return new BasicAuto(drivetrain, arm).command();
  }
}