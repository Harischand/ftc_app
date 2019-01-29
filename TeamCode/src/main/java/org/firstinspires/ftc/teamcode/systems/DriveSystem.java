package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveSystem extends Mechanism {
    private DcMotor fLeft, bLeft, fRight, bRight;

    public DriveSystem() {
    }

    public DriveSystem(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    @Override
    public void init(HardwareMap hwMap) {
        fLeft = hwMap.dcMotor.get("Fleft");
        bLeft = hwMap.dcMotor.get("Bleft");
        bRight = hwMap.dcMotor.get("Bright");
        fRight = hwMap.dcMotor.get("Fright");

        fRight.setDirection(DcMotorSimple.Direction.REVERSE);

        bRight.setDirection(DcMotorSimple.Direction.REVERSE);

        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double left, double right) {
        fLeft.setPower(left);
        bLeft.setPower(left);
        fLeft.setPower(right);
        bRight.setPower(right);
    }

    public void drive(double y, double x, double turn) {
        fLeft.setPower(y - x - turn);
        bLeft.setPower(y + x - turn);
        fRight.setPower(y + x + turn);
        bRight.setPower(y - x + turn);
    }

    public void stop() {
        fLeft.setPower(0);
        bLeft.setPower(0);
        fRight.setPower(0);
        bRight.setPower(0);
    }

    public void log(Telemetry telemetry) {
        telemetry.addData("back right", bRight.getPower());
        telemetry.addData("front right", fRight.getPower());
        telemetry.addData("back left", bRight.getPower());
        telemetry.addData("front left", fLeft.getPower());
    }
}
