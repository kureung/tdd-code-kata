package org.example;

public class BallJuDgement {

    private final Player computerPlayer;
    private final Player userPlayer;

    public BallJuDgement(Player computerPlayer, Player userPlayer) {
        this.computerPlayer = computerPlayer;
        this.userPlayer = userPlayer;
    }

    public String judge() {
        String computerNumber = computerPlayer.number();
        String userNumber = userPlayer.number();

        int numberOfBalls = 0;
        for (int i = 0; i < computerNumber.length(); i++) {
            for (int k = 0; k < userNumber.length(); k++) {
                if (i == k) {
                    continue;
                }

                if (computerNumber.charAt(i) == userNumber.charAt(k)) {
                    numberOfBalls++;
                }
            }
        }

        return numberOfBalls + "볼";
    }
}
