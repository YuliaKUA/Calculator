package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;

import org.apache.log4j.Logger;

public class PrintOperation implements Operation {
    private static final Logger logger = Logger.getLogger(PrintOperation.class);
    @Override
    public void make(ExecutionContext context) throws ExecutionException {
       try {
           System.out.println(context.stack().peek());
           logger.info(context.stack().peek());
       } catch (RuntimeException e) {
           throw new ExecutionException("STACK ERROR, PRINT_OPERATION", e);
       }
    }
}
