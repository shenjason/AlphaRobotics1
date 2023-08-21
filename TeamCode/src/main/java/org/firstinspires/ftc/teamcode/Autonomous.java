package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
@TeleOp(name = "Auto")
public class Autonomous extends LinearOpMode {
    DcMotor motorLeft;

    BHI260IMU bno;

    DcMotor motorRight;

    DcMotor motorHand;

    DcMotor motorArm;

    boolean prevstate;

    RobotMove robot;
    double num;




    @Override
    public void runOpMode() {
        prevstate = false;
        num = 0.5;
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorHand = hardwareMap.get(DcMotor.class, "motorHand");
        bno = hardwareMap.get(BHI260IMU.class, "bno");

        bno.initialize();
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot = new RobotMove(motorLeft, motorRight, bno);

        waitForStart();
        while (opModeIsActive()){
            Orientation o = bno.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
            telemetry.addLine(String.valueOf(o.firstAngle));
            telemetry.addLine(String.valueOf(o.secondAngle));
            telemetry.addLine(String.valueOf(o.thirdAngle));
            telemetry.update();
            robot.TurnLeft(90, 0.5);
            robot.MoveForward(1000, 0.5);
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 3000 & opModeIsActive()) { }
        }
        
    }


}
