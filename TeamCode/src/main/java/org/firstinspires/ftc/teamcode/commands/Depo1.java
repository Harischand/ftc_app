package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.systems.Vision;

@Autonomous(name = "Depo1")
public class Depo1 extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    void initialize() {
        robot.init(hardwareMap);
        robot.arm.setCarriage(1);

    }

    @Override
    void run() {
        if (opModeIsActive()) {
            robot.vision.trackMineralPosition();
            Vision.Position position = robot.vision.getPosition();
            if (position == Vision.Position.LEFT) {
                robot.drive.drive(1.0, 1.0);
                sleep(1000);
            } else if (position == Vision.Position.RIGHT) {
                //
            } else {
                //
            }
        }
    }
}
