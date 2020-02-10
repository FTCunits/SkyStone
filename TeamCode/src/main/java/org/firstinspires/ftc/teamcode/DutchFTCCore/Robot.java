package org.firstinspires.ftc.teamcode.DutchFTCCore;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.DutchFTCCore.SubSystems.GuidanceSubSystem;
import org.firstinspires.ftc.teamcode.DutchFTCCore.SubSystems.IMUSubSystem;
import org.firstinspires.ftc.teamcode.DutchFTCCore.SubSystems.SubSystem;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    //instance
    public static Robot instance;

    //current opmode, set by constructor
    public OpMode opMode;

    //drivetrain
    public DcMotor MotorBackLeft;
    public DcMotor MotorFrontLeft;
    public DcMotor MotorFrontRight;
    public DcMotor MotorBackRight;
    public BNO055IMU imu;

    //list of subsystems
    public List<SubSystem> subSystems;


    public Robot (OpMode _opmode) {
        instance = this;
        opMode = _opmode;
        MotorBackLeft = opMode.hardwareMap.dcMotor.get(Robotconfig.MotorBackLeft);
        MotorFrontLeft = opMode.hardwareMap.dcMotor.get(Robotconfig.MotorFrontLeft);
        MotorFrontRight = opMode.hardwareMap.dcMotor.get(Robotconfig.MotorFrontRight);
        MotorBackRight = opMode.hardwareMap.dcMotor.get(Robotconfig.MotorBackRight);
        imu = opMode.hardwareMap.get(BNO055IMU.class,"imu");
        subSystems = new ArrayList<>();
    }

    public void Update (){
        for (SubSystem system : subSystems)
        {
          system.Update();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                           Create start functions for all subsystems here                                             //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void StartIMUSubSystem () {
        IMUSubSystem a = new IMUSubSystem();
        a.Start();
        subSystems.add(a);
    }

    public void getCurrentHeading(){

    }

    public void StartGuidanceSubSystem () {
        GuidanceSubSystem a = new GuidanceSubSystem();
        a.Start();
        subSystems.add(a);
    }
}