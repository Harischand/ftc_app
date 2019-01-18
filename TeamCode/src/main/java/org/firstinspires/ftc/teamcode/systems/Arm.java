package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm extends Mechanism {
    private DcMotor armMotor, outTake, inTake;
    private Servo carriageOne, carriageTwo;//carriage1 is left and carriage2 right

    public Arm(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public Arm(){}

    @Override
    public void init(HardwareMap hwMap) {
        armMotor = hwMap.dcMotor.get("Arm");
        outTake = hwMap.dcMotor.get("OutTake");
        inTake = hwMap.dcMotor.get("InTake");
        carriageOne = hwMap.servo.get("1");
        carriageTwo = hwMap.servo.get("2");
        carriageTwo.setDirection(Servo.Direction.REVERSE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outTake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        inTake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setArmMotor(double power){
        armMotor.setPower(power);
    }


    public void setInTakeMotor(double power){
        inTake.setPower(power);
    }
    public void setCarriage(double position){
        carriageTwo.setPosition(position);
        carriageOne.setPosition(position);

    }

    public void setOutTakeMotor(double power) {
        outTake.setPower(power);

    }
}
