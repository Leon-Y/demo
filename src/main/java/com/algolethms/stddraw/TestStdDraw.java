package com.algolethms.stddraw;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @Author: Administrator
 * @Date: 2020/1/8 :10:02
 * @Description:
 */
public class TestStdDraw {
    public static void main(String[] args) {
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2);

        StdDraw.setScale(-2, +2);
    StdDraw.enableDoubleBuffering();
 
    for (double t = 0.0; true; t += 0.02) {
        double x = Math.sin(t);
        double y = Math.cos(t);
        StdDraw.clear();
        StdDraw.filledCircle(x, y, 0.05);
        StdDraw.filledCircle(-x, -y, 0.05);
        StdDraw.show();
        StdDraw.pause(20);
    }
    }
}
