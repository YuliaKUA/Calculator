package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;

public class MinusOperation implements Operation {
    @Override
    public void make(ExecutionContext context) throws ExecutionException{
        try {
            Double a = context.stack().pop();
            Double b = context.stack().pop();
            context.stack().add(b-a);
        } catch (RuntimeException e){
            throw new ExecutionException("STACK ERROR, MINUS_OPERATION", e);
        }

    }
}
