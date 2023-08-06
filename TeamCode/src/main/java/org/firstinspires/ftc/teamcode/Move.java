package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.security.spec.EllipticCurve;

@TeleOp(name = "TestMove")
public class Move extends OpMode {
    DcMotor motorLeft;
    DcMotor motorRight;

    DcMotor motorArm;

    RobotMove robot;



    @Override
    public void init(){
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot = new RobotMove(motorLeft, motorRight, 370);
    }

    @Override
    public void loop(){
        robot.MoveForward(1830, 0.5);
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 5000) { }
        robot.TurnRight(90, 0.5);
    }
}
