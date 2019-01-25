package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.systems.Vision;

@Autonomous(name="Creater1")
public class Creater1 extends AutoOpMode {

    private Robot robot = new Robot(this);
    @Override
    public void initialize() {
        robot.init(hardwareMap);
        robot.arm.setCarriage(1);
    }

    @Override
    public void run() {
        if (opModeIsActive()) {
            robot.arm.setClimberUp();
            sleep(40);
            robot.drive.drive(0, 0, 0);
            sleep(200);
            robot.drive.drive(0, 0, 1);
            sleep(200);

            robot.vision.trackMineralPosition();
            Vision.Position position = robot.vision.getPosition();
            if (position == Vision.Position.LEFT) {
                robot.drive.drive(-1, 0, 0);
                sleep(1000);
            } else if (position == Vision.Position.RIGHT) {
                //
            } else {


            }
        }
    }
}