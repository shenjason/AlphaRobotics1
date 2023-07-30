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



    @Override
    public void init(){
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        colorSensor = hardwareMap.colorSensor.get("color");
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop(){
//        double powerLeft = gamepad1.left_stick_y;
//        double powerRight = gamepad1.right_stick_y;

        if (gamepad1.a){
            MotorEasy.MotorMoveDistance(motorLeft, 1000, 0.6, null);
            MotorEasy.MotorMoveDistance(motorRight, -1000, 0.6, null);

        }

//        motorLeft.setPower(powerLeft * 0.8);\

//        motorRight.setPower(-powerRight * 0.8);
//
//        telemetry.addLine(String.valueOf(colorSensor.red()));
//        telemetry.addLine(String.valueOf(colorSensor.green()));
//        telemetry.addLine(String.valueOf(colorSensor.blue()));
//        telemetry.update();
    }
}
