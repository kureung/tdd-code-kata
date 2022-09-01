package org.example;

public class ComputerPlayer implements Player {

    private final String randomNumber;

    public ComputerPlayer(NumberGenerator numberGenerator) {
        this(numberGenerator.randomNumber());
    }

    public ComputerPlayer(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public String number() {
        return randomNumber;
    }

}
