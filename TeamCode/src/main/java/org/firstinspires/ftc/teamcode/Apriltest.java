package org.firstinspires.ftc.teamcode;

import android.graphics.drawable.GradientDrawable;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.text.DecimalFormat;
import java.util.List;


@TeleOp(name = "AprilTest")
public class Apriltest extends OpMode {
    AprilTagProcessor myAprilTagProcessor;
    VisionPortal myVisionPortal;

    TfodProcessor myTfodProcessor;



    @Override
    public void init(){

        myTfodProcessor = TfodProcessor.easyCreateWithDefaults();
        myAprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
        myVisionPortal = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class, "Webcam 1"), myAprilTagProcessor, myTfodProcessor);

        telemetry.addLine("Init done");
        telemetry.update();



    }

    @Override
    public void loop(){
        List<AprilTagDetection> Detections;
        Detections = myAprilTagProcessor.getDetections();

        for (int i=0; i<Detections.size(); i++){
            if (Detections.get(i).metadata != null){

                Orientation rot = Orientation.getOrientation(Detections.get(i).rawPose.R, AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
                telemetry.addLine("ID: ");
                telemetry.addLine(String.valueOf(Detections.get(i).id));
                telemetry.addLine("X rot:");
                telemetry.addLine(String.valueOf(rot.firstAngle));
                telemetry.addLine("Y rot:");
                telemetry.addLine(String.valueOf(rot.secondAngle));
                telemetry.addLine("Z rot:");
                telemetry.addLine(String.valueOf(rot.thirdAngle));

            }
        }
        telemetry.update();

    }
}