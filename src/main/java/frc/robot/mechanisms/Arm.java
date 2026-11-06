package frc.robot.mechanisms;

import org.team4159.commandsv3backport.command3.Command;
import org.team4159.commandsv3backport.command3.Mechanism;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Arm implements Mechanism {
    private final VictorSP motor;

    public Arm(){
        motor = new VictorSP(3);//set channel of arm
    }

    public void liftArm(double speed){
        motor.set(speed);
    }

    public void stopArm(){
        motor.stopMotor();
    }

    public Command liftCommand(double speed) {
        return runRepeatedly(() -> liftArm(speed))
            .whenExited(this::stopArm)
            .named("Lift Arm");
    }
}