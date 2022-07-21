package com.codekata.calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (left, right) -> left + right),
    MINUS("-", (left, right) -> left - right),
    DIVIDE("/", (left, right) -> left / right),
    MULTIPLY("*", (left, right) -> left * right),
    ;

    private final String arithmeticOperation;
    private final BinaryOperator<Integer> expression;

    Operator(String arithmeticOperation, BinaryOperator<Integer> expression) {
        this.arithmeticOperation = arithmeticOperation;
        this.expression = expression;
    }

    public int execute(int left, int right) {
        return expression.apply(left, right);
    }

    public static Operator findByArithmeticOperation(String arithmeticOperation) {
        return Arrays.stream(Operator.values())
                .filter(operator -> Objects.equals(arithmeticOperation, operator.arithmeticOperation))
                .findFirst()
                .orElseThrow();
    }
}
