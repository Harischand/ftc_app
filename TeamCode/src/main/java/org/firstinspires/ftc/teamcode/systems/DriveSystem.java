package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSystem extends Mechanism {
    private DcMotor frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;

    public DriveSystem() {}

    public DriveSystem(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    @Override
    public void init(HardwareMap hwMap) {
        frontLeftMotor = hwMap.dcMotor.get("FLeft");
        rearLeftMotor = hwMap.dcMotor.get("BLeft");
        rearRightMotor = hwMap.dcMotor.get("BRight");
        frontRightMotor = hwMap.dcMotor.get("FRight");

        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void drive(double left, double right) {
        frontLeftMotor.setPower(left);
        rearLeftMotor.setPower(left);
        frontLeftMotor.setPower(right);
        rearRightMotor.setPower(right);
    }

    public void drive(double y, double x, double turn) {
        frontLeftMotor.setPower(y - x - turn);
        rearLeftMotor.setPower(y + x - turn);
        frontLeftMotor.setPower(y + x + turn);
        rearRightMotor.setPower(y - x + turn);
    }

    public void stop() {
        frontLeftMotor.setPower(0);
        rearLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        rearRightMotor.setPower(0);

    }
}
