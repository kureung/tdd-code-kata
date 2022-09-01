package org.example;

public class UserPlayer implements Player {

    private final String number;

    public UserPlayer(String number) {
        this.number = number;
    }

    @Override
    public String number() {
        return number;
    }

}
