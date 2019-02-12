package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class AutoOpMode extends LinearOpMode {
    protected ElapsedTime runtime = new ElapsedTime();

    abstract void initialize();
    abstract void run();

    @Override
    public void runOpMode() {
        initialize();
        waitForStart();
        runtime.reset();
        run();
    }

    protected void runForTime(double seconds, Runnable action) {
        double currentTime = runtime.seconds();
        double end = currentTime + seconds;
        while (runtime.seconds() < end) {
            action.run();
        }
    }
}
