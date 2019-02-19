package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous (name ="ClimberTestEncoders")
public class ClimberTest extends AutoOpMode {
    private Robot robot = new Robot(this);
    @Override
    void initialize() {
       robot.init (hardwareMap) ;

    }

    @Override
    void run() {
       robot.arm.setClimberUpWithEncoders();
        //sleep(10);
      // runForTime(4.58, () -> robot.arm. setClimberUpWithEncoders());

    }
}
