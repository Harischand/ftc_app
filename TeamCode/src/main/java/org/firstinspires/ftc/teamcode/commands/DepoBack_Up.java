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



        robot.arm. setClimberUpWithEncoders();

        runForTime(0.15, () -> robot.drive.drive(-1,0,0));

       runForTime(1.8, () -> robot.drive.drive(0,-1,0));

        runForTime(0.1, () -> robot.arm.setMarkerDown(-0.5));

        runForTime(0.500, () -> robot.drive.drive(0,0,1));

        runForTime(3.0, () -> robot.drive.drive(1,0,0));

        /*
        First latch off by moving climber up for 10 seconds,

        next move 150 milliseconds backwards

        next strafing right 1.8 seconds,

        then drop marker into depot ,

        then turn left for 0.5 seconds,

        finally drive toward Crater for 3 seconds to partial park

         */






    }
}







