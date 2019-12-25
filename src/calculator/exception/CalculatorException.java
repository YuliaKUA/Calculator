package calculator.exception;

public class CalculatorException extends Exception {

    public CalculatorException(String msg) {
        super(msg);
    }

    public CalculatorException(String msg, Exception cause) {
        super(msg, cause);
    }
}
