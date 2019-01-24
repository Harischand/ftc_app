package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class AutoOpMode extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();

    abstract void initialize();
    abstract void run();

    @Override
    public void runOpMode() {
        initialize();
        waitForStart();
        runtime.reset();
        run();
    }
}
