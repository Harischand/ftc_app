package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.systems.Vision;

@Autonomous(name = "Depo1")
public class Depo1 extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    public void initialize() {
        robot.init(hardwareMap);
    }

    @Override
    void run() {

        /*robot.arm.setClimberUp();
        sleep(6600);

        robot.drive.drive(0, 0, 0);
        sleep(1000);

        robot.drive.drive(1, 0, 0);
        sleep(200);

        robot.drive.drive(0, 1, 0);
        sleep(200);*/

        Vision.Position position = robot.vision.trackMineralPosition();;

        if (position == Vision.Position.LEFT) {
            runForTime(0.500, () -> robot.drive.drive(-1,0,0));

        }
        else if (position == Vision.Position.RIGHT) {

            //
        }
        else {
            robot.drive.drive(0, -1, 0);
            sleep(1000);

           // robot.arm.setMarkerDown(0.5);
            //sleep(100);
        }
    }
}
