package calculator;
import calculator.operation.OperationFactoryImpl;
import calculator.exception.CalculatorException;
import collection.PostfixNotation;

import java.io.*;
import java.util.*;
import java.lang.*;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Stack calculator. Enter commands one per line, type \"exit\" when finished:");
        logger.info("Stack calculator. Enter commands one per line, type \"exit\" when finished:");

        OperationFactory factory = new OperationFactoryImpl();
        logger.info("creature operation factory");

        try {
            logger.info("__Work__");
            new Calculator(factory).run(System.in);
        } catch (CalculatorException e) {
           e.printStackTrace();
           logger.error(e.getMessage());
        }
    }
}
