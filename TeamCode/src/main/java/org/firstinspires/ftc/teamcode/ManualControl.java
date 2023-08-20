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

    BNO055IMU bno;
    DcMotor motorRight;

    DcMotor motorHand;

    DcMotor motorArm;

    boolean prevstate;

    RobotMove robot;
    double num;




    @Override
    public void init(){
        prevstate = false;
        num = 0.5;
        BNO055IMU.Parameters parm = new BNO055IMU.Parameters();
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
        motorArm = hardwareMap.get(DcMotor.class, "motorArm");
        motorHand = hardwareMap.get(DcMotor.class,"motorHand");
        bno = hardwareMap.get(BNO055IMU.class, "bno");
        bno.initialize(parm);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot = new RobotMove(motorLeft, motorRight, bno);
    }

    @Override
    public void loop(){
        //Move with joystick
        double y = gamepad1.left_stick_y;
        double x = gamepad1.right_stick_x * 0.5;

        double powerLeft = y - x;
        double powerRight = y + x;

        powerLeft = Math.min(powerLeft, 1);
        powerRight = Math.min(powerRight, 1);
        powerLeft = Math.max(powerLeft, -1);
        powerRight = Math.max(powerRight, -1);

        motorLeft.setPower(powerLeft);
        motorRight.setPower(-powerRight);

        if (gamepad1.dpad_down){
            motorArm.setPower(-1);
        }else if (gamepad1.dpad_up){
            motorArm.setPower(1);
        }else{
            motorArm.setPower(0);
        }

        if (gamepad1.b){
            motorHand.setPower(0.5);
        }

        else if (gamepad1.y){
            motorHand.setPower(-0.5);
        }
        else{
            motorHand.setPower(0);

        }

    }
}
