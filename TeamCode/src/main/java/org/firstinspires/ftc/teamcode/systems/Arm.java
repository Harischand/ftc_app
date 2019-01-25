package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends Mechanism {
    private DcMotor armMotor, outTake, inTake, climberMotor;
    private Servo carriage, carriage2, marker;//carriage is left and carriage2 right
    private final double speed = 0.5;

    public Arm(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public Arm() {
    }

    @Override
    public void init(HardwareMap hwMap) {
        marker = hwMap.servo.get("marker");
        climberMotor = hwMap.dcMotor.get("climber");
        armMotor = hwMap.dcMotor.get("arm");
        outTake = hwMap.dcMotor.get("outTake");
        inTake = hwMap.dcMotor.get("inTake");
        carriage = hwMap.servo.get("carriage");
        carriage2 = hwMap.servo.get("carriage2");
        climberMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        inTake.setDirection(DcMotorSimple.Direction.REVERSE);
        carriage2.setDirection(Servo.Direction.REVERSE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outTake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        inTake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        climberMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setArmMotor(double power) {
        armMotor.setPower(power);
    }


    public void setInTakeMotor(double power) {
        inTake.setPower(power);
    }

    public void setCarriage(double position) {
        carriage2.setPosition(position);
        carriage.setPosition(position);

    }

    public void setOutTakeMotor(double power) {
        outTake.setPower(power);

    }

    public void setClimber(double power) {
        climberMotor.setPower(power);
    }

    public void setClimberUp() {
        climberMotor.setPower(speed);
    }

    public void setClimberDown() {
        climberMotor.setPower(-speed);
    }

    public void setMarkerDown(double position) {
        marker.setPosition(position);

    }
    public void setStopClimber(){
        climberMotor.setPower(0);

    }
}
