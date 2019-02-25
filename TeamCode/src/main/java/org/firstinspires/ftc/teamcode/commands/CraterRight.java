package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous ( name = "CraterRight")

public class CraterRight extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    void initialize() {robot.init(hardwareMap);

    }

    @Override
    void run() {

        robot.arm.setClimberUpWithEncoders();

        runForTime(0.15, () -> robot.drive.drive(-1,0,0));

        runForTime(0.3, () -> robot.drive.drive(0,-1,0));

        runForTime(0.1, () -> robot.drive.drive(1,0,0));

        runForTime(0.4, () -> robot.drive.drive(0,-1,0));

        runForTime(0.6, () -> robot.drive.drive(-1,0,0));

        runForTime(0.8, () -> robot.drive.drive(0,-1,0));


    }
}
