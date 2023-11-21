package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivingSubsystem;

public class MovmentCommand extends CommandBase {

    private DrivingSubsystem subsys;
    private Supplier<Double> ySupplier, zSupplier;

  public MovmentCommand(DrivingSubsystem subsystem, Supplier<Double> ySupplier, Supplier<Double> zSupplier) {
    this.subsys = subsystem;
    this.ySupplier = ySupplier;
    this.zSupplier = zSupplier;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    this.subsys.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.subsys.drive(ySupplier.get() * 0.5, zSupplier.get() * 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.subsys.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
}
