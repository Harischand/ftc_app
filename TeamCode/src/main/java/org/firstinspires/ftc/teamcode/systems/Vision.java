package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

public class Vision extends Mechanism {
    private final String TFOD_MODEL_ASSET = "RoverRuckus.tflite";
    private final String LABEL_GOLD_MINERAL = "Gold Mineral";
    private final String LABEL_SILVER_MINERAL = "Silver Mineral";
    private final String VUFORIA_KEY = " AZ91PVj/////AAABmQ42d7c3E0x0mu7FXfOj6AVY0+raEDVgcszUXlzE9yKg6dU7+h/DGFNRY0XLYc1MBpurqQjdpdbeSBzqEP8K/hXP1s9LcCpGIFVC+TkIslUfEJ2FaB5TvY8FdoqHumXchWPZtt+R0+oAlICj8ckz4HrKJSf69KAcv0vMVuXZ0ld4wJNDegWBhi7aDlrbAqr9hp3xHo/wt63aFabxaMvn5zNnbbCdeha13nXlbosMmfmDV+k+w3nLX1OZYLiwJ2eogC95myUxGZHbSlss9Xtef4hkD6scFWv3RxImAHehEoUDNfq5gsqhDWmlymh/NXPukKGmdCU+SF5r9WDAxPwwjFCLreWFbfedMVzEabtwGv45 ";

    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    private Position position;

    public enum Position {
        LEFT, CENTER, RIGHT
    }

    public Vision(LinearOpMode opMode) {
        this.opMode = opMode;

    }

    private void initVuforia() {
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);
    }

    private void initTFOD(HardwareMap hardwareMap) {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
                "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
        tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
        tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_GOLD_MINERAL, LABEL_SILVER_MINERAL);
    }

    @Override
    public void init(HardwareMap hwMap) {
        initVuforia();
        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTFOD(hwMap);
        }
    }

    public void trackMineralPosition() {
        if (tfod != null) {
            tfod.activate();
        }
        while (opMode.opModeIsActive()) {
            if (tfod != null) {
                List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                if (updatedRecognitions != null) {
                    opMode.telemetry.addData("# Object Detected", updatedRecognitions.size());
                    if (updatedRecognitions.size() == 3) {
                        int goldMineralX = -1;
                        int silverMineral1X = -1;
                        int silverMineral2X = -1;
                        for (Recognition recognition : updatedRecognitions) {
                            if (recognition.getLabel().equals(LABEL_GOLD_MINERAL)) {
                                goldMineralX = (int) recognition.getLeft();
                            } else if (silverMineral1X == -1) {
                                silverMineral1X = (int) recognition.getLeft();
                            } else {
                                silverMineral2X = (int) recognition.getLeft();
                            }
                        }
                        if (goldMineralX != -1 && silverMineral1X != -1 && silverMineral2X != -1) {
                            if (goldMineralX < silverMineral1X && goldMineralX < silverMineral2X) {
                                opMode.telemetry.addData("Gold Mineral Position", "Left");
                                position = Position.LEFT;
                            } else if (goldMineralX > silverMineral1X && goldMineralX > silverMineral2X) {
                                opMode.telemetry.addData("Gold Mineral Position", "Right");
                                position = Position.RIGHT;
                            } else {
                                opMode.telemetry.addData("Gold Mineral Position", "Center");
                                position = Position.CENTER;
                            }
                        }
                    }
                    opMode.telemetry.update();
                }
            }
        }
    }

    public void shutdown() {
        if (tfod != null) {
            tfod.shutdown();
        }
    }

    public Position getPosition() {
        return position;
    }
}
