package org.firstinspires.ftc.teamcode.OpModesAuto;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.Robot;

class QQ_ActionSetPosition extends QQ_AutoAction {
    private double x;
    private double y;
    private DistanceUnit distanceUnit;

    QQ_ActionSetPosition(double x, double y, DistanceUnit distanceUnit) {
        this.x = x;
        this.y = y;
        this.distanceUnit = distanceUnit;
    }

    @Override
    boolean run(Robot robot, double gameTime, Telemetry telemetry) {
        robot.nav.setPosition(x, y, distanceUnit);
        return true;
    }
}
