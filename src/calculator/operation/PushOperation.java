package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;
import calculator.exception.SyntaxException;

public class PushOperation implements Operation {

    private String pushArg; // to push (name of constant or pure value)

    public PushOperation(String... args) throws SyntaxException {
        // validate preconditions
        if (args.length < 1) {
            throw new SyntaxException("Not enough arguments for \"push\" operation");
        }

        pushArg = args[0];

        if (!DefineOperation.NAME_PATTERN.matcher(pushArg).matches()
                && !DefineOperation.DOUBLE_PATTERN.matcher(pushArg).matches()) {
            throw new SyntaxException(String.format("Invalid argument '%s' for \"push\" operation", pushArg));
        }
    }

    @Override
    public void make(ExecutionContext context) throws ExecutionException {
        if (DefineOperation.NAME_PATTERN.matcher(pushArg).matches()) {
            if (context.mapParameter().containsKey(pushArg)) {
                context.stack().add(context.mapParameter().get(pushArg));
            } else {
                throw new ExecutionException(String.format("Undefined constant '%s", pushArg));
            }
        } else {
            context.stack().add(Double.valueOf(pushArg));
        }
    }
}