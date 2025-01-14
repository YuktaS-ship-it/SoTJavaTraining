package com.pluralsight.calcEngine;

public class PowerOf implements MathProcessing{
    private String formattedOutput;
    @Override
    public String getKeyWord() {
        return "power";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        double powerRes = Math.pow(leftVal,rightVal);
        formattedOutput = leftVal + " to the power of " + rightVal + " is " + powerRes;
        return powerRes;
    }

    @Override
    public String getFormattedOutput() {
        return formattedOutput;
    }
}
