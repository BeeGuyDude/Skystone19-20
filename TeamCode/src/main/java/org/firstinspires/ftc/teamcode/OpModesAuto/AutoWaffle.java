package org.firstinspires.ftc.teamcode.OpModesAuto;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Util.RobotPosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Autonomous(name = "Waffle", group = "ftc16072")
public class AutoWaffle extends QQ_AutoBase {
    double WAFFLE_WIDTH = 18.5;
    double FIELD_BOUNDARIES = 72;

    @Override
    public void init_loop() {
        super.init_loop();
        startDepot = false;
    }

    @Override
    public void start() {
        super.start();
        robot.flipper.holdUp();
    }

    List<QQ_AutoAction> getSteps() {
        List<QQ_AutoAction> steps = new ArrayList<>();
        QQ_ActionSetPosition startPosition =
                new QQ_ActionSetPosition(getStartPosition());
        if (redAlliance) {
            steps.addAll(Arrays.asList(
                    startPosition,
                    new QQ_ActionDriveTo(WAFFLE_RED_X + 4, WAFFLE_RED_Y, DistanceUnit.INCH),
                    new QQ_ActionDriveTo(WAFFLE_RED_X - 2, WAFFLE_RED_Y, DistanceUnit.INCH),
                    new QQ_ActionSnatcher(true),
                    new QQ_ActionDelayFor(1.25),
                    new QQ_ActionDriveTo(WAFFLE_RED_X + 8, WAFFLE_RED_Y, DistanceUnit.INCH),
                    new QQ_ActionRotateTo(90, AngleUnit.DEGREES),
                    new QQ_ActionDriveTo(WAFFLE_RED_X + 8, WAFFLE_RED_Y + 12, DistanceUnit.INCH), //to square on wall
                    new QQ_ActionSetPosition(new RobotPosition(30, FIELD_BOUNDARIES - (WAFFLE_WIDTH + 9), DistanceUnit.INCH, 90, AngleUnit.DEGREES)),
                    new QQ_ActionSnatcher(false),
                    new QQ_ActionDelayFor(1.25)
            ));
        } else {
            steps.addAll(Arrays.asList(
                    startPosition,
                    new QQ_ActionDriveTo(-(WAFFLE_RED_X + 4), WAFFLE_RED_Y, DistanceUnit.INCH),
                    new QQ_ActionDriveTo(-(WAFFLE_RED_X - 2), WAFFLE_RED_Y, DistanceUnit.INCH),
                    new QQ_ActionSnatcher(true),
                    new QQ_ActionDelayFor(1.25),
                    new QQ_ActionDriveTo(-(WAFFLE_RED_X + 8), WAFFLE_RED_Y, DistanceUnit.INCH),
                    new QQ_ActionRotateTo(90, AngleUnit.DEGREES),
                    new QQ_ActionDriveTo(-(WAFFLE_RED_X + 8), WAFFLE_RED_Y + 12, DistanceUnit.INCH), //to square on wall
                    new QQ_ActionSetPosition(new RobotPosition(-30, FIELD_BOUNDARIES - (WAFFLE_WIDTH + 9), DistanceUnit.INCH, 90, AngleUnit.DEGREES)),
                    new QQ_ActionSnatcher(false),
                    new QQ_ActionDelayFor(1.25)
            ));
        }
        steps.addAll(getParkSteps());
        return steps;
    }


    List<QQ_AutoAction> getParkSteps() {
        if (farPark) {
            return Arrays.asList(
                    new QQ_ActionDriveTo(farPark_x, 0, DistanceUnit.INCH));
        } else {
            return Arrays.asList(
                    new QQ_ActionDriveTo(nearPark_x, FIELD_BOUNDARIES - (WAFFLE_WIDTH + 14), DistanceUnit.INCH),
                    new QQ_ActionDriveTo(nearPark_x, 0, DistanceUnit.INCH));
        }
    }
}