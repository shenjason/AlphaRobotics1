
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;
@TeleOp(name = "Manual")
public class ManualControl extends OpMode {
    ColorSensor color_sensor;

    DcMotor motorLeft;
    DcMotor motorRight;


    @Override
    public void init(){
        color_sensor = hardwareMap.colorSensor.get("color");
    }


    @Override
    public void loop(){
        
    }
}
