// Copyright 2021-2025 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot.subsystems.drive;

<<<<<<< HEAD
=======
import static frc.robot.subsystems.drive.DriveConstants.*;

>>>>>>> e3a6543de2e47dade2fd5fb281abb7c3e3031971
import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import java.util.Queue;

/** IO implementation for NavX. */
public class GyroIONavX implements GyroIO {
<<<<<<< HEAD
  private final AHRS navX = new AHRS(NavXComType.kMXP_SPI, (byte) Drive.ODOMETRY_FREQUENCY);
=======
  private final AHRS navX = new AHRS(NavXComType.kMXP_SPI, (byte) odometryFrequency);
>>>>>>> e3a6543de2e47dade2fd5fb281abb7c3e3031971
  private final Queue<Double> yawPositionQueue;
  private final Queue<Double> yawTimestampQueue;

  public GyroIONavX() {
<<<<<<< HEAD
    yawTimestampQueue = PhoenixOdometryThread.getInstance().makeTimestampQueue();
    yawPositionQueue = PhoenixOdometryThread.getInstance().registerSignal(navX::getYaw);
=======
    yawTimestampQueue = SparkOdometryThread.getInstance().makeTimestampQueue();
    yawPositionQueue = SparkOdometryThread.getInstance().registerSignal(navX::getAngle);
>>>>>>> e3a6543de2e47dade2fd5fb281abb7c3e3031971
  }

  @Override
  public void updateInputs(GyroIOInputs inputs) {
    inputs.connected = navX.isConnected();
<<<<<<< HEAD
    inputs.yawPosition = Rotation2d.fromDegrees(-navX.getYaw());
=======
    inputs.yawPosition = Rotation2d.fromDegrees(-navX.getAngle());
>>>>>>> e3a6543de2e47dade2fd5fb281abb7c3e3031971
    inputs.yawVelocityRadPerSec = Units.degreesToRadians(-navX.getRawGyroZ());

    inputs.odometryYawTimestamps =
        yawTimestampQueue.stream().mapToDouble((Double value) -> value).toArray();
    inputs.odometryYawPositions =
        yawPositionQueue.stream()
            .map((Double value) -> Rotation2d.fromDegrees(-value))
            .toArray(Rotation2d[]::new);
    yawTimestampQueue.clear();
    yawPositionQueue.clear();
  }
}
