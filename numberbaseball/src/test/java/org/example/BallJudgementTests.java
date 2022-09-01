package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BallJudgementTests {

    @MethodSource
    @ParameterizedTest
    void 몇_개의_볼이_있는지_판별할_수_있다(Player computerPlayer, Player userPlayer, String expectedResult) {

        BallJuDgement ballJuDgement = new BallJuDgement(computerPlayer, userPlayer);
        String actualResult = ballJuDgement.judge();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> 몇_개의_볼이_있는지_판별할_수_있다() {
        return Stream.of(
                Arguments.of(new ComputerPlayer("123"), new UserPlayer("456"), "0볼"),
                Arguments.of(new ComputerPlayer("123"), new UserPlayer("345"), "1볼"),
                Arguments.of(new ComputerPlayer("123"), new UserPlayer("325"), "2볼"),
                Arguments.of(new ComputerPlayer("123"), new UserPlayer("231"), "3볼")
        );
    }
}
