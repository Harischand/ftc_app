package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;
@Autonomous(name = "Depo1")

public class Depo1 extends LinearOpMode {
    private Robot robot = new Robot();

    private ElapsedTime runtime = new ElapsedTime();

    private void initialized (){
        robot.init(hardwareMap);
    }
    @Override
    public void runOpMode() throws InterruptedException {
        initialized();
        waitForStart();
        runtime.reset();
        robot.drive.drive(0, 1, 0);
        sleep(1000);
    }
}
