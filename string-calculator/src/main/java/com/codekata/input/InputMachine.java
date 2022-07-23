package com.codekata.input;

import com.codekata.calculator.ArithmeticExpression;
import java.io.IOException;

public interface InputMachine {

    ArithmeticExpression inputValue() throws IOException;

}
