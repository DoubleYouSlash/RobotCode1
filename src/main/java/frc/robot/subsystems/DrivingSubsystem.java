package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DrivingSubsystem extends SubsystemBase{
    private CANSparkMax left1, left2, right1, right2;
    private MotorControllerGroup leftcg, rightcg;

    private DifferentialDrive dfd;

    public DrivingSubsystem(int[] left, int[] right) {
        this.left1 = new CANSparkMax(left[0], MotorType.kBrushless);
        this.left2 = new CANSparkMax(left[1], MotorType.kBrushless);
        this.right1 = new CANSparkMax(right[0], MotorType.kBrushless);
        this.right2 = new CANSparkMax(right[1], MotorType.kBrushless);
        
        this.left1.restoreFactoryDefaults();
        this.left2.restoreFactoryDefaults();
        this.right1.restoreFactoryDefaults();
        this.right2.restoreFactoryDefaults();
        this.left2.setInverted(true);
        this.right2.setInverted(true);
        this.left2.follow(left1);
        this.right2.follow(right1);

        // leftcg = new MotorControllerGroup(left1, null);
        // rightcg = new MotorControllerGroup(right1, null);

        dfd = new DifferentialDrive(left1, right1);
    }

    // public void driveForward() {
    //     left1.set(0.1);
    //     left2.set(0.1);
    //     right1.set(-0.1);
    //     right2.set(-0.1);
    // }

    public void stop() {
        left1.set(0);
        left2.set(0);
        right1.set(0);
        right2.set(0);
    }

    public void drive(double xspeed, double zRotation) {
        dfd.arcadeDrive(zRotation, xspeed);
    }

    // public void turnRight() {
    //     sparkmax1.set(0.5);
    //     sparkmax2.set(0.5);
    //     sparkmax3.set(0.5);
    //     sparkmax4.set(0.5);
    // }

    // public void turnLeft() {
    //     sparkmax1.set(-0.5);
    //     sparkmax2.set(-0.5);
    //     sparkmax3.set(-0.5);
    //     sparkmax4.set(-0.5);
    // }
}
