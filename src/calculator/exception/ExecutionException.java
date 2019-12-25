package calculator.exception;

public class ExecutionException extends CalculatorException {

    public ExecutionException(String msg) {
        super(msg);
    }

    public ExecutionException(String msg, Exception cause) {
        super(msg, cause);
    }
}
