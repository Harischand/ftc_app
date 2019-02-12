package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "teleop")
public class TeleOpDrive extends OpMode {
    private Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        robot.drive.drive(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x);
         robot.arm.setArmMotor(gamepad2.left_stick_y);
         robot.arm.setInTakeMotor(gamepad2.left_trigger);
         robot.arm.setOutTakeMotor(0.3*gamepad2.right_stick_y);
        robot.arm.setCarriage(gamepad2.right_trigger);
        
        if (gamepad2.dpad_up) {
            robot.arm.setClimberUp();
        }

        else if (gamepad2.dpad_down) {
            robot.arm.setClimberDown();
        }
        else if (gamepad2.dpad_right){
            robot.arm.setStopClimber();
        }

        robot.drive.log(telemetry);
        telemetry.addData("y axis", gamepad1.left_stick_y);
    }

    @Override
    public void stop() {
        robot.drive.stop();
    }
}
