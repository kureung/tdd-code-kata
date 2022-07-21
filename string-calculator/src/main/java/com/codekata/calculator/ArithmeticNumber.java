package com.codekata.calculator;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public final class ArithmeticNumber {

    private static final Pattern NUMBERS_PATTERN = Pattern.compile("-?\\d+");
    private final List<Integer> numbers;

    private ArithmeticNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ArithmeticNumber from(String expression) {
        return new ArithmeticNumber(NUMBERS_PATTERN.matcher(expression)
                .results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .toList());
    }

    public int calculateWith(ArithmeticOperator arithmeticOperator) {
        return numbers.stream()
                .reduce(arithmeticOperator::execute)
                .orElse(0);
    }

}
