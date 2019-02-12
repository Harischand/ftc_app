package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "CreaterBackUp")
public class CreaterBackUp extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    void initialize() {
        robot.init(hardwareMap);

    }

    @Override
    void run() {
        //            robot.arm.setClimberUp();
        //            sleep(5500);

        runForTime(5.5, robot.arm::setClimberUp);

        //            robot.drive.stop();
        //            sleep(3000);

        runForTime(3, robot.drive::stop);

        //            robot.drive.drive(-1,0,0);
        //            sleep(300);

        runForTime(.3, () -> robot.drive.drive(-1, 0, 0));

        //            robot.drive.drive(0, -1, 0);
        //            sleep(1300);

        runForTime(1.3, () -> robot.drive.drive(0, -1, 0));

        //            robot.drive.drive(1, 0, 0);
        //            sleep(700);

        runForTime(.7, () -> robot.drive.drive(1, 0, 0));

        //            robot.drive.drive(0, 0, 1);
        //            sleep(1200);

        runForTime(1.2, () -> robot.drive.drive(0, 0, 1));

        //            robot.drive.drive(-1, 0, 0);
        //            sleep(300);

        runForTime(.3, () -> robot.drive.drive(-1, 0, 0));

        //            robot.drive.drive(0, -1, 0);
        //            sleep(2800);

        runForTime(2.8, () -> robot.drive.drive(0, -1, 0));

        //            robot.drive.drive(-1, 0, 0);
        //            sleep(550);

        runForTime(.55, () -> robot.drive.drive(-1, 0, 0));

        //            robot.arm.setMarkerDown(0.5);
        //            sleep(100);

        runForTime(0.1, () -> robot.arm.setMarkerDown(0.5));

        //            robot.drive.drive(0, 0, 1);
        //            sleep(600);

        runForTime(.6, () -> robot.drive.drive(0, 0, 1));

        //            robot.drive.drive(1, 0, 0);
        //            sleep(1800);

        runForTime(1.8, () -> robot.drive.drive(1, 0, 0));

        //            robot.arm.setCarriage(1);
        //            sleep(100);

        runForTime(0.1, () -> robot.arm.setCarriage(1));
    }
}
