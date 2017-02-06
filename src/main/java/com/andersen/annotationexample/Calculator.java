package com.andersen.annotationexample;

public class Calculator {

    @MethodTrace(logLevel = Logger.INFO)
    public static double calculatePow(int x, int y) {
        double result = Math.pow(x, y);
        return result;
    }

    @MethodTrace(logLevel = Logger.INFO)
    public static int multiply(int a, int b) {
        return a * b;
    }

}
