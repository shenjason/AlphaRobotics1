package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BHI260IMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class RobotMove {

    public DcMotor motorLeft;
    public DcMotor motorRight;
    public BHI260IMU bno;



    public RobotMove(DcMotor motorleft, DcMotor motorright, BHI260IMU bno){
        motorLeft = motorleft;
        motorRight = motorright;
        this.bno = bno;

    }


    public void TurnRight(double angle, double power){
        Orientation angles = bno.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
        double startangle = angles.firstAngle;
        while (Math.abs(angle-(angles.firstAngle-startangle)) >= 1){
            angles = bno.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
            if (angles.firstAngle-startangle < angle){
                motorRight.setPower(power);
                motorLeft.setPower(power);
            }
            else if (angles.firstAngle-startangle > angle){
                motorLeft.setPower(-power);
                motorRight.setPower(-power);
            }

        }
        motorRight.setPower(0);
        motorLeft.setPower(0);
    }

    public void TurnLeft(double angle, double power){
        Orientation angles = bno.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
        double startangle = angles.firstAngle;
        while (Math.abs(angle-(angles.firstAngle-startangle)) >= 1){
            angles = bno.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZXY, AngleUnit.DEGREES);
            if (angles.firstAngle-startangle < angle){
                motorRight.setPower(power);
                motorLeft.setPower(power);
            }
            else if (angles.firstAngle-startangle > angle){
                motorLeft.setPower(-power);
                motorRight.setPower(-power);
            }

        }
        motorRight.setPower(0);
        motorLeft.setPower(0);
    }

    public void MoveForward(double distance, double power){
        MotorEasy.MotorMoveDistance(motorLeft, -distance, power, null);
        MotorEasy.MotorMoveDistance(motorRight, distance, power, null);
    }

    public void MoveBackward(double distance, double power){
        MotorEasy.MotorMoveDistance(motorLeft, distance, power, null);
        MotorEasy.MotorMoveDistance(motorRight, -distance, power, null);
    }
}
