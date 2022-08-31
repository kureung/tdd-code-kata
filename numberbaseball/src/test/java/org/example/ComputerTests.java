package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class ComputerTests {

    @Test
    void 컴퓨터는_숫자_생성기를_주입받아_생성될_때_예외가_발생하지_않는다() {
        NumberGenerator numberGenerator = new FakeNumberGenerator();
        assertThatCode(() -> new Computer(numberGenerator))
                .doesNotThrowAnyException();
    }

    class FakeNumberGenerator implements NumberGenerator {


    }


}
