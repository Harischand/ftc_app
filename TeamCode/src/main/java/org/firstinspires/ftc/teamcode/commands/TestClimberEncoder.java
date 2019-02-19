package org.firstinspires.ftc.teamcode.commands;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Climber Encoder Test Reading")
public class TestClimberEncoder extends OpMode {
    private Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad2.dpad_up) {
            robot.arm.setClimberUp();
        } else if (gamepad2.dpad_down) {
            robot.arm.setClimberDown();
        } else {
            robot.arm.stopClimber();
        }
        telemetry.addData(
                "climber encoder tick:",
                robot.arm.getClimberEncoderTicks());
    }
}
