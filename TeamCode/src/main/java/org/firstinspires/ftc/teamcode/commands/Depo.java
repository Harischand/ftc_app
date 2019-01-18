package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Depo")
public class Depo extends LinearOpMode {
    private Robot robot = new Robot();
    private ElapsedTime runtime = new ElapsedTime();

    private void initialized (){
        robot.init(hardwareMap);


    }






    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        runtime.reset();

    }

}
