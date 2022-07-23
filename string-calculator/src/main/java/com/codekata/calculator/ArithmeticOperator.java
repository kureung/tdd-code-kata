package com.codekata.calculator;

import static java.util.stream.Collectors.toCollection;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public final class ArithmeticOperator {

    private static final Pattern OPERATORS_PATTERN = Pattern.compile("[+\\-/*]");
    private final Queue<Operator> operators;

    private ArithmeticOperator(Queue<Operator> operators) {
        this.operators = operators;
    }

    public static ArithmeticOperator from(String expression) {
        return new ArithmeticOperator(OPERATORS_PATTERN
                .matcher(expression)
                .results()
                .map(MatchResult::group)
                .map(Operator::findByArithmeticOperation)
                .collect(toCollection(ArrayDeque::new)));
    }

    public int execute(int num1, int num2) {
        return operators.poll().execute(num1, num2);
    }

}
