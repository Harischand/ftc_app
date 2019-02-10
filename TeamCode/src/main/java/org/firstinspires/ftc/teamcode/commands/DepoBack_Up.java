package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;
@Autonomous(name="DepoBackUp")

public class DepoBack_Up extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    void initialize() {
        robot.init(hardwareMap);


    }

    @Override
    void run() {
        if (opModeIsActive()) {

            //robot.arm.setClimberUp();
            //sleep(6700);

            // robot.drive.drive(0,0,0);
            //sleep(1000);

            // robot.drive.drive(-1,0,0);
            // sleep(250);

            //robot.drive.drive(0,-1,0);
            //sleep(600);

            //robot.drive.drive(-1,0,0);
            //sleep(200);

            robot.drive.drive(0, -0.8, 0);
            sleep(3500);

            //robot.drive.drive(-1,0,0);
            //sleep(200);


            robot.arm.setMarkerDown(0.5);
            sleep(100);

            robot.drive.drive(0, 0, 1);
            sleep(300);

            robot.drive.drive(0, -0.8, 0);
            sleep(300);

            robot.drive.drive(1, 0, 0);
            sleep(2600);


        }
    }
}







