package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.systems.Vision;

@Autonomous(name = "CraterFinal")
public class CraterFinal extends AutoOpMode {

    private Robot robot = new Robot(this);
    /* This code is for the Crater section:
    First we latch off the lander,
    next we sample by using vuforia and tensor flow object detection,
    then we partial park in the crater
    we earn a total of 65 points.
    */

    @Override
    public void initialize() {
        robot.init(hardwareMap);
    }

    @Override
    public void run() {



        robot.vision.trackMineralPosition();
        Vision.Position position = robot.vision.getPosition();

        if (position == Vision.Position.LEFT) {

            robot.arm.setClimberUpWithEncoders();

            runForTime(0.15, () -> robot.drive.drive(-1,0,0));

            runForTime(0.3, () -> robot.drive.drive(0,-1,0));

            runForTime(0.1, () -> robot.drive.drive(1,0,0));

            runForTime(0.7, () -> robot.drive.drive(0,-1,0));

            runForTime(0.700, () -> robot.drive.drive(1,0,0));

            runForTime(1, () -> robot.drive.drive(0,-1,0));

            runForTime(0.2, () -> robot.arm.setMarkerDown(-0.5));



        }

        else if (position == Vision.Position.RIGHT) {

            robot.arm.setClimberUpWithEncoders();

            runForTime(0.15, () -> robot.drive.drive(-1,0,0));

            runForTime(0.3, () -> robot.drive.drive(0,-1,0));

            runForTime(0.1, () -> robot.drive.drive(1,0,0));

            runForTime(0.7, () -> robot.drive.drive(0,-1,0));

            runForTime(0.5, () -> robot.drive.drive(-1,0,0));

            runForTime(1, () -> robot.drive.drive(0,-1,0));

            runForTime(0.2, () -> robot.arm.setMarkerDown(-0.5));


        }

        else {
            robot.arm.setClimberUpWithEncoders();

            runForTime(0.15, () -> robot.drive.drive(-1,0,0));

            runForTime(0.3, () -> robot.drive.drive(0,-1,0));

            runForTime(0.1, () -> robot.drive.drive(1,0,0));

            runForTime(1.2, () -> robot.drive.drive(0,-1,0));

            runForTime(0.2, () -> robot.arm.setMarkerDown(-0.5));

        }
    }
}
