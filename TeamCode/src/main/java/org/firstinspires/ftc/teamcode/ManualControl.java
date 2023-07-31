package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.security.spec.EllipticCurve;

@TeleOp(name = "Manual")
public class ManualControl extends OpMode {
    DcMotor motorLeft;
    DcMotor motorRight;
    ColorSensor colorSensor;

    RobotMove robot;



    @Override
    public void init(){
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        colorSensor = hardwareMap.colorSensor.get("color");
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot = new RobotMove(motorLeft, motorRight, 370);
    }

    @Override
    public void loop(){
        //Move with joystick
        double y = gamepad1.right_stick_y;
        double x = gamepad1.right_stick_x;
        if (Math.abs(x) > Math.abs(y)){
            motorLeft.setPower(y);
            motorRight.setPower(y);
        }else{
            motorLeft.setPower(y);
            motorRight.setPower(-y);
        }

    }
}
