package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;

public class SqrtOperation implements Operation {
    @Override
    public void make(ExecutionContext context) throws ExecutionException {
        try {
            Double a = context.stack().pop();
            if(a < 0){
                throw new ExecutionException(String.format("NEGATIVE NUMBER '%s'", a));
            }
            context.stack().add(Math.sqrt(a));
        } catch (RuntimeException e) {
            throw new ExecutionException("STACK ERROR, SQRT_OPERATION", e);
        }

    }
}
