package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;

public class DivideOperation implements Operation {
    @Override
    public void make(ExecutionContext context) throws ExecutionException {
        try {
            Double a = context.stack().pop();
            Double b = context.stack().pop();
            if(a.equals(0)){
                throw new ExecutionException("DIVISION BY 0");
            }
            context.stack().add(b / a);

        } catch (RuntimeException e) {
            throw new ExecutionException("STACK ERROR, DIVIDE_OPERATION", e);
        }
    }
}
