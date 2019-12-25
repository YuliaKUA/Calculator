package calculator;

import calculator.exception.CalculatorException;
import calculator.exception.SyntaxException;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class);

    private final ExecutionContext context;

    public Calculator(OperationFactory factory) {
        context = new ExecutionContext(factory);
    }

    public void run(InputStream input) throws CalculatorException{
        try( Scanner sc = new Scanner(input)){
           while (true) {
                // ввод операций
                String str = sc.nextLine().trim();
                if (str.isEmpty()) {
                    continue;
                }

                // завершение программы
                if ("exit".equals(str)) {
                    logger.info("exit");
                    break;
                }
                try {
                    logger.info("token: " + str);
                    Operation operation = context.factory().create(str);
                    operation.make(context);
                } catch (SyntaxException e) {
                    // print syntax problem and continue
                    System.err.println("Got error: " + e.getMessage());
                    logger.error("Got error: " + e.getMessage());
                }
            }
        }
    }
}
