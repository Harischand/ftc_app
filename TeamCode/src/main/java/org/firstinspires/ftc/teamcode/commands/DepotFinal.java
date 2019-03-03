package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.systems.Vision;

@Autonomous(name = "DepotFinal")
public class DepotFinal extends AutoOpMode {
    private Robot robot = new Robot(this);

    @Override
    public void initialize() {
        robot.init(hardwareMap);
    }

    @Override
    void run() {



        robot.vision.trackMineralPosition();
        Vision.Position position = robot.vision.getPosition();

        if (position == Vision.Position.LEFT) {

            robot.arm.setClimberUpWithEncoders();

            runForTime(0.15, () -> robot.drive.drive(-1,0,0));

            runForTime(0.3, () -> robot.drive.drive(0,-1,0));

            runForTime(0.1, () -> robot.drive.drive(1,0,0));

            runForTime(0.7, () -> robot.drive.drive(0,-1,0));

            runForTime(0.7, () -> robot.drive.drive(1,0,0));

            runForTime(1, () -> robot.drive.drive(0,-1,0));

            runForTime(0.2, () -> robot.drive.drive(0,0,-1));

            runForTime(0.8, () -> robot.drive.drive(0,-1,0));

            runForTime(0.2, () -> robot.arm.setMarkerDown(-0.5));

            runForTime(1.8, () -> robot.drive.drive(0,1,0));

            runForTime(0.4, () -> robot.drive.drive(1,0,0));

            runForTime(0.5, () -> robot.drive.drive(0,0,1));

            runForTime(0.6, () -> robot.drive.drive(1,0,0));

        }
        else if (position == Vision.Position.RIGHT) {

            robot.arm.setClimberUpWithEncoders();

            runForTime(0.15, () -> robot.drive.drive(-1,0,0));

            runForTime(0.3, () -> robot.drive.drive(0,-1,0));

            runForTime(0.1, () -> robot.drive.drive(1,0,0));

            runForTime(0.7, () -> robot.drive.drive(0,-1,0));

            runForTime(0.5, () -> robot.drive.drive(-1,0,0));

            runForTime(1.6, () -> robot.drive.drive(0,-1,0));

            runForTime(0.3, () -> robot.drive.drive(0,0,1));

            runForTime(1, () -> robot.drive.drive(0,-1,0));

            runForTime(.2,() -> robot.arm.setMarkerDown(-0.5));

            runForTime(0.7, () -> robot.drive.drive(0,-1,0));

            runForTime(0.3, () -> robot.drive.drive(0,1,0));

            runForTime(0.6, () -> robot.drive.drive(0.8,0,0));

            runForTime(0.2, () -> robot.drive.drive(0,-1,0));

            runForTime(0.8, () -> robot.drive.drive(1,0,0));

            runForTime(0.2, () -> robot.drive.drive(0,0,1));

            runForTime(1.4, () -> robot.drive.drive(1,0,0));


        }

        else {

            robot.arm.setClimberUpWithEncoders();

            runForTime(0.15, () -> robot.drive.drive(-1,0,0));

            runForTime(0.3, () -> robot.drive.drive(0,-1,0));

            runForTime(0.1, () -> robot.drive.drive(1,0,0));

            runForTime(2.60, () -> robot.drive.drive(0,-1,0));


            runForTime(0.1, () -> robot.arm.setMarkerDown(-0.5));

            runForTime(2.15, () -> robot.drive.drive(0,1,0));

            runForTime(1, () -> robot.drive.drive(1,0,0));

            runForTime(0.3, () -> robot.drive.drive(0,0,1));

            runForTime(1, () -> robot.drive.drive(1,0,0));


        }
    }
}
