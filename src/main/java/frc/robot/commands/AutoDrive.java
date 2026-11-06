package frc.robot.commands;

import org.team4159.commandsv3backport.command3.Command;

import frc.robot.mechanisms.Drivetrain;

public class AutoDrive {

    private final Drivetrain drivetrain;
    private final double leftSpeed;
    private final double rightSpeed;

    public AutoDrive(Drivetrain dt, double l, double r){
        drivetrain = dt;
        leftSpeed = l;
        rightSpeed = r;
    }

    public Command command() {
        return drivetrain.autoDriveCommand(leftSpeed, rightSpeed);
    }
}