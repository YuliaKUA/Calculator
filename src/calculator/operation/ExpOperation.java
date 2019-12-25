package calculator.operation;

import calculator.ExecutionContext;
import calculator.Operation;
import calculator.exception.ExecutionException;
import calculator.exception.SyntaxException;
import collection.PostfixNotation;

import java.util.ArrayList;
import java.util.List;

public class ExpOperation implements Operation {

    private final List<String> lexems;

    public ExpOperation(String... args) throws SyntaxException {
        String expression = String.join("", args);

        PostfixNotation p = new PostfixNotation();
        lexems = p.parse(expression);
        //System.out.println(lexems);
    }

    @Override
    public void make(ExecutionContext context) throws ExecutionException {
        for (String token : lexems) {
            Operation op;

            try {
                if (DefineOperation.NAME_PATTERN.matcher(token).matches()
                        || DefineOperation.DOUBLE_PATTERN.matcher(token).matches()) {
                    op = context.factory().create("push " + token);
                } else {
                    op = context.factory().create(token);
                }
            } catch (SyntaxException e) {
                throw new ExecutionException(String.format("failed to process '%s'", token));
            }

            op.make(context);
        }
    }
}
