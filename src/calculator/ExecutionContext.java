package calculator;

import collection.Stack;

import java.util.HashMap;
import java.util.Map;

public class ExecutionContext {
    private final Stack stack = new Stack();

    private final Map<String, Double> mapParameter = new HashMap<>();
    private final OperationFactory factory;

    public ExecutionContext(OperationFactory factory){
        this.factory = factory;
    }

    public Stack stack(){
        return stack;
    }

    public OperationFactory factory() {
        return factory;
    }

    public Map<String, Double> mapParameter(){
        return mapParameter;
    }

}
