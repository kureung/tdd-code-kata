package com.codekata.calculator;

public final class ArithmeticExpression {

    private final String expression;

    private ArithmeticExpression(String expression) {
        this.expression = expression;
    }

    public static ArithmeticExpression from(String expression) {
        if (!expression.matches("^([+\\-]?\\d+)( ?[+\\-/*] \\d+)*")) {
            throw new IllegalArgumentException("올바른 연산식이 아닙니다.");
        }

        if (expression.contains("/ 0")) {
            throw new IllegalArgumentException("숫자 0으로 나눌 수 없습니다.");
        }

        return new ArithmeticExpression(expression);
    }

    public ArithmeticExpression changeExpression(String expression) {
        return ArithmeticExpression.from(expression);
    }

    public int calculate() {
        ArithmeticOperator arithmeticOperator = ArithmeticOperator.from(expression);
        ArithmeticNumber arithmeticNumber = ArithmeticNumber.from(expression);
        return arithmeticNumber.calculateWith(arithmeticOperator);
    }

}
