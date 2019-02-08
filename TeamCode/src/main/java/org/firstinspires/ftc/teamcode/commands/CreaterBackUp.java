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
        if (opModeIsActive()) {


            //robot.arm.setClimberUp();
            //sleep(6600);

            //robot.drive.drive(0,0,0);
            //sleep(1000);

            robot.drive.drive(0,-1,0);
            sleep(1000);

            robot.drive.drive(1,0,0);
            sleep(200);
            
            robot.drive.drive(0,0,1);
            sleep(500);
            
            robot.drive.drive(-1,0,0);
            sleep(150);
            
            robot.drive.drive(0,-1,0);
            sleep(2400);
            
            robot.drive.drive(-1,0,0);
            sleep(200);
            
            robot.arm.setMarkerDown(0.5);
            sleep(100);
            
            robot.drive.drive(0,0,1);
            sleep(450);
            
            robot.drive.drive(1,0,0);
            sleep(2300);
            
            robot.arm.setCarriage(1);
            sleep(100);
        }

    }
}
