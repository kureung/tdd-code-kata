package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerPlayerTests {

    @Test
    void 컴퓨터는_랜덤값을_조회할_수_있다() {
        String randomNumbers = "123";
        final NumberGenerator numberGenerator = new FakeNumberGenerator(randomNumbers);
        ComputerPlayer computerPlayer = new ComputerPlayer(numberGenerator);
        String result = computerPlayer.number();
        assertThat(result).isEqualTo(randomNumbers);
    }

    class FakeNumberGenerator implements NumberGenerator {

        private String randomNumbers;

        public FakeNumberGenerator(String randomNumbers) {
            this.randomNumbers = randomNumbers;
        }

        @Override
        public String randomNumber() {
            return randomNumbers;
        }

    }


}
