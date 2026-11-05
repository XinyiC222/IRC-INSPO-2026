package frc.robot.mechanisms;

import org.team4159.commandsv3backport.command3.Mechanism;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Drivetrain implements Mechanism {
    private final SparkMax leftMotor = new SparkMax(1, MotorType.kBrushless);
    private final SparkMax rightMotor = new SparkMax(2, MotorType.kBrushless);
    private final SparkMaxConfig leftMotorConfig = new SparkMaxConfig();
    private final SparkMaxConfig rightMotorConfig - new SparkMaxConfig();

    public Drivetrain() {
            
    }
}
