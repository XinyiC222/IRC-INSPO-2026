package frc.robot.commands;

import static edu.wpi.first.units.Units.Seconds;

import org.team4159.commandsv3backport.command3.Command;

import frc.robot.mechanisms.Arm;
import frc.robot.mechanisms.Drivetrain;

public class BasicAuto {
    public BasicAuto(Drivetrain drivetrain, Arm arm){
        command = Command.noRequirements(coroutine -> {
            coroutine.await(new AutoDrive(drivetrain, 0.5, 0.5).command().withTimeout(Seconds.of(2)));
            coroutine.await(arm.liftCommand(0.4).withTimeout(Seconds.of(1)));
            coroutine.await(new AutoDrive(drivetrain, -0.5, -0.5).command().withTimeout(Seconds.of(2)));
        }).named("Basic Auto");
    }

    private final Command command;

    public Command command() {
        return command;
    }
}