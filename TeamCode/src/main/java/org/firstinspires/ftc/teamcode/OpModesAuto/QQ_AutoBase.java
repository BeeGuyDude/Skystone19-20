package org.firstinspires.ftc.teamcode.OpModesAuto;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Mechanisms.Robot;

import java.util.List;

abstract public class QQ_AutoBase extends OpMode {
    private Robot robot = new Robot();

    private List<QQ_AutoAction> autoSteps;
    private int stepNum;

    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    abstract List<QQ_AutoAction> getSteps();

    @Override
    public void start() {
        autoSteps = getSteps();
        stepNum = 0;
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        if (stepNum < autoSteps.size()) {
            QQ_AutoAction step = autoSteps.get(stepNum);
            telemetry.addData("auto", stepNum);
            if (step.run(robot, time, telemetry)) {
                stepNum++;
            }
        } else {
            telemetry.addData("auto", "Finished");
        }
    }
}