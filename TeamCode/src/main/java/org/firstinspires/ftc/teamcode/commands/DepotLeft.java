package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous( name = "DepotLeft")

public class DepotLeft extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    void initialize() { robot.init(hardwareMap);

    }

    @Override
    void run() {

        robot.arm.setClimberUpWithEncoders();

        runForTime(0.15, () -> robot.drive.drive(-1,0,0));

        runForTime(0.3, () -> robot.drive.drive(0,-1,0));

        runForTime(0.1, () -> robot.drive.drive(1,0,0));

        runForTime(0.7, () -> robot.drive.drive(0,-1,0));

        runForTime(0.7, () -> robot.drive.drive(1,0,0));

        runForTime(1, () -> robot.drive.drive(0,-1,0));

        runForTime(0.2, () -> robot.drive.drive(0,0,-1));

        runForTime(0.6, () -> robot.drive.drive(0,-1,0));

        runForTime(0.2, () -> robot.arm.setMarkerDown(-0.5));

        runForTime(2, () -> robot.drive.drive(0,1,0));

        runForTime(0.3, () -> robot.drive.drive(0,0,1));

        runForTime(1, () -> robot.drive.drive(1,0,0));









    }
}
