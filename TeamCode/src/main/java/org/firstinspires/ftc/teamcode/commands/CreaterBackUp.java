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
        //runForTime(5.5, robot.arm::setClimberUp);
        runForTime(4.4, () -> robot.arm. setClimberUpWithEncoders());
        robot.arm.stopClimber();
        runForTime(3, robot.drive::stop);

        runForTime(.15, () -> robot.drive.drive(-1, 0, 0));

        runForTime(.3, () -> robot.drive.drive(0, -1, 0));

        runForTime(.2, () -> robot.drive.drive(1, 0, 0));

        runForTime(0.4, () -> robot.drive.drive(0, -1, 0));

        runForTime( 1.0, () -> robot.drive.drive(1, 0, 0));

        runForTime(1.0, () -> robot.drive.drive(0, 0, 1));

        runForTime(.4, () -> robot.drive.drive(-1, 0, 0));

        runForTime(2.6, () -> robot.drive.drive(0, -1, 0));

       //  runForTime(.55, () -> robot.drive.drive(-1, 0, 0));

        runForTime(0.1, () -> robot.arm.setMarkerDown(-0.5));

        runForTime(.8, () -> robot.drive.drive(0, 0, 1));
        runForTime(2.6, () -> robot.drive.drive(1, 0, 0));
        runForTime(0.1, () -> robot.arm.setCarriage(1));
    }
}
