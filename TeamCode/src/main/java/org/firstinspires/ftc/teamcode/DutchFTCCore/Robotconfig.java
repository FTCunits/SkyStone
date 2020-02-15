package org.firstinspires.ftc.teamcode.DutchFTCCore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class Robotconfig {

    //drivetrain motors
    public static String MotorBackLeft = "MotorBackLeft";
    public static String MotorFrontLeft = "MotorFrontLeft";
    public static String MotorFrontRight = "MotorFrontRight";
    public static String MotorBackRight = "MotorBackRight";
    public static String MotorMiddle = "MotorMiddle";

    //servo ports
    public static String Servo0 = "Servo0";
    public static String Servo1 = "Servo1";
    public static String Servo2 = "Servo2";
    public static String Servo3 = "Servo3";
    public static String Servo4 = "Servo4";
    public static String Servo5 = "Servo5";

    //drivetrains
    public static Drivetraintypes.Drivetrains DriveTrain = Drivetraintypes.Drivetrains.MECHANUMDRIVE;

    //logging
    public static String teamName = "FTCunits";
    public static boolean isLoggingUsed;

    //guidance subsystem
    public static boolean posControl = false;
    public static boolean angleControl = true;
    public static double angleKp = 1/20;
    public static double angleKi = 1/100;
    public static double angleKd = 1/25;

    public void setConfigFile(){

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("Configfile.json")) {

            JSONObject robot = (JSONObject) parser.parse(reader);

            MotorBackLeft = (String) robot.get("MotorBackLeft");
            MotorFrontLeft = (String) robot.get("MotorFrontLeft");
            MotorBackRight = (String) robot.get("MotorBackRight");
            MotorFrontRight = (String) robot.get("MotorFrontRight");
            MotorMiddle = (String) robot.get("MotorMiddle");

            Servo0 = (String) robot.get("Servo0");
            Servo1 = (String) robot.get("Servo1");
            Servo2 = (String) robot.get("Servo2");
            Servo3 = (String) robot.get("Servo3");
            Servo4 = (String) robot.get("Servo4");
            Servo5 = (String) robot.get("Servo5");

            teamName = (String) robot.get("teamName");
            isLoggingUsed = (boolean) robot.get("isLoggingUsed");

            posControl = (boolean) robot.get("posContol");
            angleControl = (boolean) robot.get("angleControl");

            angleKd = (double) robot.get("angleKd");
            angleKi = (double) robot.get("angleKi");
            angleKp = (double) robot.get("angleKp");


        }catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
