package com.pluralsight.calcEngine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        //MathCalculations using basic programming
        performCalculations();

        //Combining common operations in one base class and creating different
        //math operation classes using inheritance for code reusability
        System.out.println();
        calculationUsingBaseClass();

        //using constructorChaining
        System.out.println();
        calculationUsingSubClassConstruct();

        //Using Enums for performing dynamic mathOperations
        System.out.println();
        System.out.println("Using Enums for performing dynamic mathOperations");
        executeInteractively();

        //using Interface
        System.out.println();
        System.out.println("Using functionalities of Interface");
        dynamicInteractivity();

    }

    private static void dynamicInteractivity() {
        //You can specify which dynamic operations you can accept
        DynamicHelper helper = new DynamicHelper( new MathProcessing[]{
                new Adder(),
                new PowerOf()
        });

        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        helper.process(userInput);
    }

    private static void executeInteractively() {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] ops = userInput.split(" ");
        performOperation(ops);
    }

    private static void performOperation(String[] ops) {
        MathOperation operation = MathOperation.valueOf(ops[0].toUpperCase());
        double leftVal = Double.parseDouble(ops[1]);
        double rightVal = Double.parseDouble(ops[2]);

        CalculateBase calc = createCalculation(operation,leftVal,rightVal);
        calc.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calc.getResult());
    }

    private static CalculateBase createCalculation(MathOperation operation, double leftVal, double rightVal) {
        CalculateBase calculation = null;
        switch(operation) {
            case ADD:
                calculation = new Adder(leftVal, rightVal);
                break;
            case SUBTRACT:
                calculation = new Subtractor(leftVal, rightVal);
                break;
            case MULTIPLY:
                calculation = new Multiplier(leftVal, rightVal);
                break;
            case DIVIDE:
                calculation = new Divider(leftVal, rightVal);
                break;
        }

        return calculation;
    }

    private static void calculationUsingSubClassConstruct() {
        System.out.println("Using Constructor Chaining: ");
        CalculateBase[] calcs = {
                new Divider(100d, 50d),
                new Adder(25d,92d)
        };

        for(CalculateBase calc : calcs){
            calc.calculate();
            System.out.println("Calc Result = " + calc.getResult());
        }
    }

    private static void calculationUsingBaseClass() {
        System.out.println("Using Classes and Inheritance: ");
        Divider divider = new Divider();
        doCalculation(divider, 100.0d, 50.0d);

        Adder adder = new Adder();
        doCalculation(adder, 25.0d, 92.0d);
    }

    static void doCalculation(CalculateBase calc, double leftVal, double rightVal){
        calc.setLeftVal(leftVal);
        calc.setRightVal(rightVal);
        calc.calculate();
        System.out.println("Calc Result = " + calc.getResult());
    }

    private static void performCalculations() {
        //Using constructor overloading
        MathEquation[] equations = new MathEquation[2];
        equations[0] = new MathEquation(100d, 5d, 'd');
        equations[1] = new MathEquation(2d, 4d, 'a');

        for(MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = " + equation.getResult());
        }

        //using function overloading
        System.out.println();
        System.out.println("Using functional Overloading: ");
        MathEquation eqn = new MathEquation('d');
        int leftVal = 100;
        int rightVal = 8;
        eqn.execute(leftVal, rightVal);
        System.out.println("Result with Ints: "+ eqn.getResult());
        eqn.execute((double)leftVal, (double) rightVal);
        System.out.println("Result with Doubles: "+ eqn.getResult());


        System.out.println("Average result = " + MathEquation.getAverageResult());
    }

    private static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }

}