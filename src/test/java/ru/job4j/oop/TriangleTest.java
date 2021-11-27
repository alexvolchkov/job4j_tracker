package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void area8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(8, rsl, 0.001);
    }

    @Test
    public void area50() {
        Point a = new Point(0, 0);
        Point b = new Point(10, 4);
        Point c = new Point(0, 10);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(50, rsl, 0.001);
    }

    @Test
    public void area30() {
        Point a = new Point(10, 10);
        Point b = new Point(20, 4);
        Point c = new Point(0, 10);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        Assert.assertEquals(30, rsl, 0.001);
    }
}