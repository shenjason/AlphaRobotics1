package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Manual")
public class ManualControl extends OpMode {

    DcMotor motorLeft;
    DcMotor motorRight;


    @Override
    public void init(){
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");
    }


    @Override
    public void loop(){
        double powerLeft = gamepad1.left_stick_y;
        double powerRight = gamepad1.right_stick_y;

        motorLeft.setPower(-powerLeft * 0.8);
        motorRight.setPower(-powerRight * 0.8);
    }
}
