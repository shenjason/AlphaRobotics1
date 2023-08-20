package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
@TeleOp(name = "Auto")
public class Autonomous extends LinearOpMode {
    DcMotor motorLeft;

    BNO055IMU bno;

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
        BNO055IMU.Parameters parm = new BNO055IMU.Parameters();
        parm.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorHand = hardwareMap.get(DcMotor.class, "motorHand");
        bno = hardwareMap.get(BNO055IMU.class, "bno");

        bno.initialize(parm);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot = new RobotMove(motorLeft, motorRight, bno);

        waitForStart();
        while (opModeIsActive()){
            robot.TurnLeft(90, 0.5);
            robot.MoveForward(1000, 0.5);
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < 3000) { }
        }
        
    }


}
