package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class Arm extends Mechanism {
    private DcMotor armMotor, outTake, inTake, climberMotor;
    // carriage is left and carriage2 right
    private Servo carriage, carriage2, marker;
    private final double speed = 0.5;
    private final double TICKS_PER_INCH = 0;

    public Arm(LinearOpMode opMode) {
        this.opMode = opMode;
    }

    public Arm() {}

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
        carriage2.setDirection(Servo.Direction.REVERSE);
        armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        outTake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        inTake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        climberMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        climberMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        climberMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
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

    public void stopClimber() {
        climberMotor.setPower(0);

    }

    private int convert(double inches) {
        return (int) (inches * TICKS_PER_INCH);
    }

    public void setClimberTarget(int targetTicks) {
        double kP = 0.00025;
        double kD = 0.0;
        int prevError = 0;
        try {
            while (opMode.opModeIsActive() && Math.abs(getError(targetTicks)) > 200) {
                double error = getError(targetTicks);
                double kP_Output = kP * error;
                double kD_Output = kD * (error - prevError);
                double PD_Output = kP_Output + kD_Output;
                double output = Range.clip(PD_Output, -1.0, 1.0);
                climberMotor.setPower(output);
                opMode.telemetry.addData("encoder", getClimberEncoderTicks());
                opMode.telemetry.update();
            }
        } catch (NullPointerException e) {
            System.out.println("Tried to use method only meant for " +
                               "autonomous!");
            e.printStackTrace();
        }
        stopClimber();
    }

    private int getError(int setpointInTicks) {
        return setpointInTicks - getClimberEncoderTicks();
    }

    public int getClimberEncoderTicks() {
        return climberMotor.getCurrentPosition();
    }

    public void setClimberUpWithEncoders(){
        setClimberTarget(8007);
    }
}
