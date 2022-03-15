package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CircleWithException {
    private double radius;
    private int area;
    private int diameter;
    final static double PI = 3.14;

    public CircleWithException(double radius){
        try{
            if(radius <= 0){
                throw new IllegalArgumentException("No negative or zero value for the radius!");
            }
            else{
                this.radius = radius;
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getArea(){
        double area = 0;
        try{
            if((Math.pow(getRadius(), 2) * PI) < 1000){
                area =  Math.pow(getRadius(), 2) * PI;
                return area;
            }
            else{
                throw new Exception("Area is too large!");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return area;
    }

    public double getDiameter(){
        return 2*getRadius()*PI;
    }

    public static void main(String[] args){
            try{
                Scanner input = new Scanner(System.in);
                System.out.print("Input radius for circle: ");
                double radius = input.nextDouble();
                CircleWithException circle = new CircleWithException(radius);
                if(circle.getArea() != 0) {
                    System.out.println("Area of circle is: " + circle.getArea());
                }
            }
            catch(InputMismatchException e){
                System.out.println("Exception caught: Incorrect value data type!");
            }
        }
}
