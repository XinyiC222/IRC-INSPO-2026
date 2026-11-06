package frc.robot.mechanisms;

import org.team4159.commandsv3backport.command3.Command;
import org.team4159.commandsv3backport.command3.Mechanism;
import org.team4159.commandsv3backport.command3.button.CommandNiDsXboxController;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Drivetrain implements Mechanism {
    private final VictorSP leftMotor;
    private final VictorSP rightMotor;

    public Drivetrain() {
            leftMotor = new VictorSP(1); //set left channel
            rightMotor = new VictorSP(2); //set right channel

            leftMotor.setInverted(true);
            
    }
    
    public void drive(double leftSpeed,double rightSpeed) {
        leftMotor.set(leftSpeed);
        rightMotor.set(rightSpeed);
    }

    public void stop() {
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

    public Command driveCommand (CommandNiDsXboxController controller) {
        return runRepeatedly(() -> {
            drive(controller.getLeftY() * 0.2, controller.getRightY() * 0.2);
        })
        .whenExited(this::stop)
        .named("Drive");
    }
    public Command autoDriveCommand (double leftSpeed, double rightSpeed) {
        return runRepeatedly(() -> drive(leftSpeed, rightSpeed))
            .whenExited(this::stop)
            .named("Auto Drive");
    }
}
