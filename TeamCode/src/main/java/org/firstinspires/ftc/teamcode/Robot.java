package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.systems.Arm;
import org.firstinspires.ftc.teamcode.systems.DriveSystem;
import org.firstinspires.ftc.teamcode.systems.Mechanism;
import org.firstinspires.ftc.teamcode.systems.Vision;

public class Robot extends Mechanism {
    public DriveSystem drive;
    public Arm arm;
    public Vision vision;

    public Robot(LinearOpMode opMode) {
        this.opMode = opMode;
        drive = new DriveSystem(opMode);
        arm = new Arm(opMode);
        vision = new Vision(opMode);
    }

    public Robot() {
        drive = new DriveSystem();
        arm = new Arm();
    }

    @Override
    public void init(HardwareMap hwMap) {
        drive.init(hwMap);
        arm.init(hwMap);
        if (opMode == null) {
            vision.init(hwMap);
        }
    }
}
