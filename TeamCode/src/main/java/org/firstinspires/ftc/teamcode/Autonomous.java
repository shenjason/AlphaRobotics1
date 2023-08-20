package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class Autonomous extends OpMode {
    AngleUnit
    DcMotor motorLeft;
    YawPitchRollAngles robotOrientation;
    BNO055IMU bno;

    DcMotor motorRight;
    IMU.Parameters myIMUparameters;
    DcMotor motorHand;

    DcMotor motorArm;

    boolean prevstate;

    RobotMove robot;
    double num;




    @Override
    public void init(){
        prevstate = false;
        num = 0.5;
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorHand = hardwareMap.get(DcMotor.class,"motorHand");
        bno = hardwareMap.get(BNO055IMU.class, "bno");
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot = new RobotMove(motorLeft, motorRight, 370);



    }

    @Override
    public void loop() {
        double Yaw = bno.getAngularOrientation().firstAngle;
        double Roll = bno.getAngularOrientation().secondAngle;
        double Pitch = bno.getAngularOrientation().thirdAngle;




    }
    public voi

}
