package com.codekata.calculator;

import com.codekata.input.InputMachine;
import com.codekata.output.OutputMachine;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public final class CalculatingMachine {

    private final UUID serialNumber;
    private final InputMachine inputMachine;
    private final OutputMachine outputMachine;

    private CalculatingMachine(UUID serialNumber,
                               InputMachine inputMachine,
                               OutputMachine outputMachine
    ) {
        this.serialNumber = serialNumber;
        this.inputMachine = inputMachine;
        this.outputMachine = outputMachine;
    }

    public static CalculatingMachine of(UUID serialNumber,
                                        InputMachine inputMachine,
                                        OutputMachine outputMachine
    ) {
        return new CalculatingMachine(
                serialNumber,
                inputMachine,
                outputMachine);
    }

    public void printCalculatedValue() throws IOException {
        outputMachine.output(calculatedValue());
    }

    public int calculatedValue() throws IOException {
        return inputMachine.inputValue()
                .calculate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalculatingMachine that = (CalculatingMachine) o;
        return Objects.equals(serialNumber, that.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber);
    }

}
