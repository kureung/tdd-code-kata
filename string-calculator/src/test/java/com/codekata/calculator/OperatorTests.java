package com.codekata.calculator;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class OperatorTests {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "0, 0, 0"
    })
    void 덧셈_테스트(int left, int right, int result) {
        assertThat(Operator.PLUS.execute(left, right)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 0",
            "0, 0, 0"
    })
    void 뺄셈_테스트(int left, int right, int result) {
        assertThat(Operator.MINUS.execute(left, right)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "0, 1, 0"
    })
    void 나눗셈_테스트(int left, int right, int result) {
        assertThat(Operator.DIVIDE.execute(left, right)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 1",
            "0, 0, 0"
    })
    void 곱셈_테스트(int left, int right, int result) {
        assertThat(Operator.MULTIPLY.execute(left, right)).isEqualTo(result);
    }

    @MethodSource
    @ParameterizedTest
    void 연산자_찾기_테스트(String stringOperation, Operator operator) {
        assertThat(Operator.findByArithmeticOperation(stringOperation)).isEqualTo(operator);
    }

    static Stream<Arguments> 연산자_찾기_테스트() {
        return Stream.of(
                Arguments.of("+", Operator.PLUS),
                Arguments.of("-", Operator.MINUS),
                Arguments.of("/", Operator.DIVIDE),
                Arguments.of("*", Operator.MULTIPLY)
        );
    }

}
