package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;


public class PlusOperation implements Operation {
    @Override
    public void make(ExecutionContext context) throws ExecutionException {
        try {
            context.stack().add(context.stack().pop() + context.stack().pop());
       }  catch (RuntimeException e) {
            throw new ExecutionException("STACK ERROR, PLUS_OPERATION", e);
        }
    }
}
