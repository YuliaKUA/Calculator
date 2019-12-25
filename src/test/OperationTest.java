package test;

import calculator.ExecutionContext;
import calculator.OperationFactory;
import calculator.exception.CalculatorException;
import calculator.exception.ExecutionException;
import calculator.operation.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OperationTest {

    public OperationFactory factory = new OperationFactoryImpl();
    public ExecutionContext context = new ExecutionContext(factory);

    @Test
    public void makeDefine() throws CalculatorException{
        new DefineOperation("a", "5").make(context);
        Map<String, Double> map = new HashMap<>();
        map.put("a", 5.);

        Assert.assertEquals(map, context.mapParameter());
    }

    @Test
    public void makeDivide() throws ExecutionException {
        context.stack().add(16);
        context.stack().add(4);
        new DivideOperation().make(context);
        Double a = 4.;
        Double b = context.stack().pop();

        Assert.assertEquals(a,b);
    }

    @Test
    public void makeExp() throws CalculatorException {
        new DefineOperation("a", "6").make(context);
        new ExpOperation("(a+10-8)*3").make(context);
        Double a = 24.;
        Double b = context.stack().pop();

        Assert.assertEquals(a,b);

        new ExpOperation("7*5-9*0").make(context);
        a = 35.;
        b = context.stack().pop();

        Assert.assertEquals(a,b);
    }

    @Test
    public void makeMinus() throws ExecutionException {
        context.stack().add(16);
        context.stack().add(4);
        new MinusOperation().make(context);
        Double a = 12.;
        Double b = context.stack().peek();

        Assert.assertEquals(a,b);
        context.stack().pop();
    }

    @Test
    public void makePlus() throws ExecutionException {
        context.stack().add(17);
        context.stack().add(4);
        new PlusOperation().make(context);
        Double a = 21.;
        Double b = context.stack().peek();

        Assert.assertEquals(a,b);
        context.stack().pop();
    }

    @Test
    public void makeMultiply() throws ExecutionException {
        context.stack().add(-3);
        context.stack().add(4);
        new MultiplyOperation().make(context);
        Double a = -12.;
        Double b = context.stack().peek();

        Assert.assertEquals(a,b);
        context.stack().pop();

        context.stack().add(0);
        context.stack().add(4);
        new MultiplyOperation().make(context);
        a = 0.;
        b = context.stack().peek();

        Assert.assertEquals(a,b);
        context.stack().pop();
    }

    @Test
    public void makePush() throws CalculatorException {
        new PushOperation("6").make(context);
        Double a = 6.;
        Double b = context.stack().peek();

        Assert.assertEquals(a,b);
    }

    // a 1
    // aa 2
    // aaa 3
    // a+aa+aaa
    @Test
    public void makeExp2()throws CalculatorException{
        new DefineOperation("a", "1").make(context);
        new DefineOperation("aa", "2").make(context);
        new DefineOperation("aaa", "3").make(context);

        new ExpOperation("a+aa+aaa").make(context);

        Double a = 6.;
        Double b = context.stack().pop();
        Assert.assertEquals(a, b);
    }
}