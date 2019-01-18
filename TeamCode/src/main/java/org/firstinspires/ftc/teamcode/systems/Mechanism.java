package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class Mechanism {
    protected LinearOpMode opMode;

    public abstract void init(HardwareMap hwMap);
}
