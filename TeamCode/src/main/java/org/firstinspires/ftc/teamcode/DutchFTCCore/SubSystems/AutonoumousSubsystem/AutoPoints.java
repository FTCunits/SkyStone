package org.firstinspires.ftc.teamcode.DutchFTCCore.SubSystems.AutonoumousSubsystem;

import org.firstinspires.ftc.teamcode.DutchFTCCore.Robotconfig;

import java.util.LinkedList;

public class AutoPoints {
    public LinkedList<Point> route = new LinkedList<>();

    public void addPoint(int x, int y){
        Point newPoint = new Point(x,y);
        route.add(newPoint);
    }

    public class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
