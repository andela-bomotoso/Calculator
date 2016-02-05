package com.example.bukola_omotoso.calculator;

/**
 * Created by bukola_omotoso on 05/02/16.
 */
public class Calculator {

    private double firstNum;
    private double secondNum;
    private double answer;

    private static Calculator calculator;

    private Calculator() {

    }

    public static Calculator getCalculatorInstance() {

        if(calculator == null) {

            calculator = new Calculator();
        }
        return calculator;
    }

    public static Calculator getCalculator() {
        return calculator;
    }

    public static void setCalculator(Calculator calculator) {
        Calculator.calculator = calculator;
    }

    public void setAnswer(double answer){
        this.answer = answer;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public double getAnswer() {
        return answer;
    }

    public void addNumbers() {

       answer = firstNum + secondNum;
    }

    public void subtractNumbers() {

        answer = firstNum - secondNum;
    }

    public void multiplyNumbers() {

        answer = firstNum * secondNum;
    }
}
