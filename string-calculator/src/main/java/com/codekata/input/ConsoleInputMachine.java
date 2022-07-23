package com.codekata.input;

import com.codekata.calculator.ArithmeticExpression;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public final class ConsoleInputMachine implements InputMachine {

    private final UUID serialNumber;
    private final BufferedReader bufferedReader;
    private ArithmeticExpression arithmeticExpression;

    private ConsoleInputMachine(UUID serialNumber, BufferedReader bufferedReader) {
        this.serialNumber = serialNumber;
        this.bufferedReader = bufferedReader;
        this.arithmeticExpression = ArithmeticExpression.from("0");
    }

    public static ConsoleInputMachine of(UUID serialNumber, BufferedReader bufferedReader) {
        return new ConsoleInputMachine(serialNumber, bufferedReader);
    }

    @Override
    public ArithmeticExpression inputValue() throws IOException {
        String inputValue = bufferedReader.readLine();
        bufferedReader.close();

        return arithmeticExpression.changeExpression(inputValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConsoleInputMachine that = (ConsoleInputMachine) o;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

}
