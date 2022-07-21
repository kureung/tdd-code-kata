package com.codekata.output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public final class ConsoleOutputMachine implements OutputMachine {

    private final UUID serialNumber;
    private final BufferedWriter bufferedWriter;

    private ConsoleOutputMachine(UUID serialNumber, BufferedWriter bufferedWriter) {
        this.serialNumber = serialNumber;
        this.bufferedWriter = bufferedWriter;
    }

    public static ConsoleOutputMachine of(UUID serialNumber, BufferedWriter bufferedWriter) {
        return new ConsoleOutputMachine(serialNumber, bufferedWriter);
    }

    @Override
    public void output(int value) throws IOException {
        bufferedWriter.write(String.valueOf(value));
        bufferedWriter.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConsoleOutputMachine that = (ConsoleOutputMachine) o;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

}