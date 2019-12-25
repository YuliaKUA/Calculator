package calculator;

import calculator.exception.SyntaxException;

public interface OperationFactory {
    Operation create(String input) throws SyntaxException;
}
