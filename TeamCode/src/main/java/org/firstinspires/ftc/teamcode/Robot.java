package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.systems.Arm;
import org.firstinspires.ftc.teamcode.systems.DriveSystem;
import org.firstinspires.ftc.teamcode.systems.Mechanism;

public class Robot extends Mechanism {
    public DriveSystem drive;
    public Arm arm;

    public Robot(LinearOpMode opMode) {
        this.opMode = opMode;
        drive = new DriveSystem(opMode);
        arm = new Arm(opMode);
    }

    public Robot() {
        drive = new DriveSystem();
    }

    @Override
    public void init(HardwareMap hwMap) {
        drive.init(hwMap);
    }
}
