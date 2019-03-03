package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "DepotCenter")

public class DepotCenter extends AutoOpMode {
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

        runForTime(2.60, () -> robot.drive.drive(0,-1,0));


        runForTime(0.1, () -> robot.arm.setMarkerDown(-0.5));

        runForTime(2.15, () -> robot.drive.drive(0,1,0));

        runForTime(1, () -> robot.drive.drive(1,0,0));

        runForTime(0.3, () -> robot.drive.drive(0,0,1));

        runForTime(1, () -> robot.drive.drive(1,0,0));




        //runForTime(3.0, () -> robot.drive.drive(1,0,0));

        /*
        First latch off by moving climber up using encoders,

        next move 150 milliseconds backwards

        next strafing right 0.3 seconds,

        move forward for 0.1 seconds,

        strafe for 2.3 seconds

        then drop marker into depot ,

        then turn left for 0.1 seconds,

        finally drive toward Crater for 3 seconds to partial park

         */






    }
}







