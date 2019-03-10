package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "teleop")
public class TeleOpDrive extends OpMode {
    private Robot robot = new Robot();
    
    /* TeleOp code:
    To drive forward and backward using left joystick y axis on gamepad1
    to strafe use left joystick x axis on gamepad1, to turn use right joystick x axis on gamepad 1,
    to move arm use left joystick y axis on gamepad2, 
    to in take minerals use left trigger on gamepad2 
    to out take use right joystick y axis on gamepad 2
    to move carriage up or down use right trigger on gamepad2 
    to move climber up or down use dpad up and down buttons on gamepad 2
    
    */

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        robot.drive.drive(
                -gamepad1.left_stick_y, -gamepad1.left_stick_x,
                -gamepad1.right_stick_x);
        robot.arm.setArmMotor(gamepad2.left_stick_y);
        robot.arm.setInTakeMotor(gamepad2.left_trigger);
        robot.arm.setOutTakeMotor(0.3 * gamepad2.right_stick_y);
        robot.arm.setCarriage(gamepad2.right_trigger);

        if (gamepad2.dpad_up) {
            robot.arm.setClimberUp();
        } else if (gamepad2.dpad_down) {
            robot.arm.setClimberDown();
        } else {
            robot.arm.stopClimber();
        }

        robot.drive.log(telemetry);
        telemetry.addData("y axis", gamepad1.left_stick_y);
    }

    @Override
    public void stop() {
        robot.drive.stop();
    }
}
