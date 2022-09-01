package org.example;

import org.junit.jupiter.api.Test;

class JudgementTests {

    @Test
    void 두_개의_숫자를_판별할_수_있다() {
        Player computerPlayer = new ComputerPlayer("123");
        Player userPlayer = new UserPlayer("345");
        Judgement judgement = new Judgement(computerPlayer, userPlayer);
        judgement.judge();
    }

}
