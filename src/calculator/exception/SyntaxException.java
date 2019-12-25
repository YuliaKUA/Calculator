package calculator.exception;

public class SyntaxException extends CalculatorException {

    public SyntaxException(String msg) {
        super(msg);
    }

    public SyntaxException(String msg, Exception cause) {
        super(msg, cause);
    }
}
