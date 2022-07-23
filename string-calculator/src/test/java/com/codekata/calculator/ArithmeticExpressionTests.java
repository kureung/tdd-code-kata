package com.codekata.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticExpressionTests {

    @ParameterizedTest
    @ValueSource(strings = {
            "1 + +",
            "+ + 1",
            "1 + ",
            "+"
    })
    void 올바른_연산식이_아니면_예외가_발생한다(String expression) {
        assertThatThrownBy(() -> ArithmeticExpression.from(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 연산식이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 + 1",
            "+1",
            "1",
            "-1",
            "11",
            "11 + 111 - 1"
    })
    void 올바른_연산식이면_예외가_발생하지_않는다(String expression) {
        assertThatCode(() -> ArithmeticExpression.from(expression))
                .doesNotThrowAnyException();
    }

    @Test
    void 숫자0으로_나누려고_하면_예외가_발생한다() {
        String expression = "1 / 0";

        assertThatThrownBy(() -> ArithmeticExpression.from(expression))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 1 : 2",
            "1 + 2 : 3",
            "11 - 1 : 10",
            "11 * 10 / 10 : 11"
    }, delimiter = ':')
    void 연산시_연산결과가_나온다(String expression, int expectedValue) {
        ArithmeticExpression arithmeticExpression = ArithmeticExpression.from(expression);
        assertThat(arithmeticExpression.calculate()).isEqualTo(expectedValue);
    }

}
