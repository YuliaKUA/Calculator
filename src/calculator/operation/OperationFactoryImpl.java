package calculator.operation;
import java.util.Arrays;
import java.util.Scanner;

import calculator.Operation;
import calculator.OperationFactory;
import calculator.exception.SyntaxException;

public class OperationFactoryImpl implements OperationFactory {
    @Override
    public Operation create(String input) throws SyntaxException {
        final String[] parts = input.split("\\s+");
        final String operation = parts[0];
        final String[] operationArgs = parts.length > 1 ? Arrays.copyOfRange(parts, 1, parts.length) : new String[]{};

                switch (operation) {
            case "define":
                return new DefineOperation(operationArgs);

            case "push":
                return new PushOperation(operationArgs);

            case "pop":
                return new PopOperation();

            case "+":
                return new PlusOperation();

            case "-":
                return new MinusOperation();

            case "*":
                return new MultiplyOperation();

            case "/":
                return new DivideOperation();

            case "sqrt":
                return new SqrtOperation();

            case "exp":
                return new ExpOperation(operationArgs);

            case "print":
                return new PrintOperation();
        }
        throw new SyntaxException(String.format("unknown command '%s'", operation));
    }
}
