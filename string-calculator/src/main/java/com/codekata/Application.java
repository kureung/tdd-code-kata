package com.codekata;

import com.codekata.calculator.CalculatingMachine;
import com.codekata.input.ConsoleInputMachine;
import com.codekata.input.InputMachine;
import com.codekata.output.ConsoleOutputMachine;
import com.codekata.output.OutputMachine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.UUID;

public final class Application {

    private final InputMachine inputMachine;
    private final OutputMachine outputMachine;

    private Application(InputMachine inputMachine, OutputMachine outputMachine) {
        this.inputMachine = inputMachine;
        this.outputMachine = outputMachine;
    }

    public static Application init() {
        return new Application(
                ConsoleInputMachine.of(UUID.randomUUID(), new BufferedReader(new InputStreamReader(System.in))),
                ConsoleOutputMachine.of(UUID.randomUUID(), new BufferedWriter(new OutputStreamWriter(System.out)))
        );
    }

    public void run() throws IOException {
        CalculatingMachine.of(UUID.randomUUID(), inputMachine, outputMachine)
                .printCalculatedValue();
    }

}
