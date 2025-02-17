package com.pluralsight.calcEngine;

public class Subtractor extends CalculateBase implements MathProcessing{
    public Subtractor() {
    }

    public Subtractor(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "subtract";
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
