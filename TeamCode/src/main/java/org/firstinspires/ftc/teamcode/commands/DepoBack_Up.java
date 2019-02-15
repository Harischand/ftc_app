package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "DepoBack_Up")

public class DepoBack_Up extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    void initialize() {
        robot.init(hardwareMap);


    }

    @Override
    void run() {

        //robot.arm.setClimberUp();
        //sleep(5600);


        //robot.drive.drive(0,0,0);
        // sleep(1000);
        // robot.drive.stop();
        //sleep(3000);

        // robot.drive.drive(-1,0,0);
        // sleep(300);


        // robot.drive.drive(0, -0.8, 0);
        // sleep(200);

        //robot.drive.drive(1,0,0);
        //sleep(200);

        runForTime(2.6, () -> robot.drive.drive(0, -1, 0));
        //robot.drive.drive(0,-0.8,0);
        //sleep(3500);
        runForTime(0.1, () -> robot.arm.setMarkerDown(-0.5));


        //robot.arm.setMarkerDown(0.5);
        //sleep(100);
        runForTime(0.4, () -> robot.drive.drive(0,0,1));

        //robot.drive.drive(0, 0, 1);
        //sleep(300);
        //runForTime(0.3, () -> robot.drive.drive(0,-0.8,0));

        //robot.drive.drive(0, -0.8, 0);
        //sleep(300);
        runForTime(2.8, () -> robot.drive.drive(1,0,0));

        //robot.drive.drive(1, 0, 0);
        //sleep(2600);
    }
}







