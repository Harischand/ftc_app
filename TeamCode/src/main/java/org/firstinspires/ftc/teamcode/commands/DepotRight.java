package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.Robot;


@Autonomous(name = "DepotRight")


public class DepotRight extends AutoOpMode {

    private Robot robot = new Robot(this);

    @Override
    void initialize() {

        robot.init(hardwareMap);


    }

    @Override
    void run() {
        robot.arm.setClimberUpWithEncoders();

        runForTime(0.15, () -> robot.drive.drive(-1,0,0));

        runForTime(0.3, () -> robot.drive.drive(0,-1,0));

        runForTime(0.1, () -> robot.drive.drive(1,0,0));



        /*robot.drive.drive(0, 0, 0);
        sleep(1000);

        robot.drive.drive(1, 0, 0);
        sleep(250);

        robot.drive.drive(0, -1, 0);
        sleep(600);

        robot.drive.drive(-1, 0, 0);
        sleep(450);

        robot.drive.drive(0, -1, 0);
        sleep(2000);


        robot.arm.setMarkerDown(0.5);
        sleep(100);

        robot.drive.drive(0, 0, -1);
        sleep(200);

        robot.drive.drive(1, 0, 0);
        sleep(1500);*/
    }
}
