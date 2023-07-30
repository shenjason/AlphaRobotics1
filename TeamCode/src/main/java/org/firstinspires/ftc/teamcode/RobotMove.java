package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class RobotMove {

    public DcMotor motorLeft;
    public DcMotor motorRight;

    public double length;


    public RobotMove(DcMotor motorleft, DcMotor motorright, double Robotlen){
        motorLeft = motorleft;
        motorRight = motorright;
        length = Robotlen;
    }


    public void TurnRight(double degrees, double power){
        double fraction = degrees / 360.0;
        double distance = fraction * length * Math.PI;
        MotorEasy.MotorMoveDistance(motorLeft, distance, power, null);
        MotorEasy.MotorMoveDistance(motorRight, distance, power, null);
    }

    public void TurnLeft(double degrees, double power){
        double fraction = degrees / 360.0;
        double distance = fraction * length * Math.PI;
        MotorEasy.MotorMoveDistance(motorLeft, -distance, power, null);
        MotorEasy.MotorMoveDistance(motorRight, distance, power, null);
    }
}
