package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.function.Function;

public class MotorEasy {

    public static double defaultticks = 560;
    public static double defualtdiameter = 90;

    public static void MotorMoveDistance(DcMotor motor, double distanceInmm, double power, double ticks, double diameter, Function callback){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        double turnage = distanceInmm / (diameter * Math.PI);

        double Target = ticks * turnage;

        motor.setTargetPosition((int)Target);
        motor.setPower(power);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    public static void MotorMoveDistance(DcMotor motor, double distanceInmm, double power, Function callback){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        double turnage = distanceInmm / (defualtdiameter * Math.PI);

        double Target = defaultticks * turnage;

        motor.setTargetPosition((int)Target);
        motor.setPower(power);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

}
