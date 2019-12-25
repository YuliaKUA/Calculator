package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;

public class PopOperation implements Operation {
    @Override
    public void make(ExecutionContext context) throws ExecutionException {
        try {
            context.stack().pop();
        } catch (RuntimeException e){
            throw new ExecutionException("STACK ERROR, POP_OPERATION", e);
        }
    }
}
