package collection;

import calculator.exception.SyntaxException;

import java.util.*;
import java.lang.*;

import org.apache.log4j.Logger;

public class PostfixNotation {
    private static final Logger logger = Logger.getLogger(PostfixNotation.class);

    private static String operators = "+-*/";
    private static String delimiters = "() " + operators;

    private static boolean isDelimiter(String token) {
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    private static int priority(String token) {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    public static List<String> parse(String infix) throws SyntaxException {
        List<String> postfix = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();
        StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
        String prev = "";
        String curr = "";
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                logger.error("INCORRECT EXPRESSION");
                throw new SyntaxException(String.format("INCORRECT EXPRESSION"));
            }
            if (curr.equals(" ")) continue;
            else if (isDelimiter(curr)) {
                if (curr.equals("(")) stack.push(curr);
                else if (curr.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                        if (stack.isEmpty()) {
                            logger.error("BRACKETS ARE NOT MATCHED");
                            throw new SyntaxException(String.format("BRACKETS ARE NOT MATCHED"));
                        }
                    }
                    stack.pop();
                    if (!stack.isEmpty()) {
                        postfix.add(stack.pop());
                    }
                }
                else {
                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                            postfix.add(stack.pop());
                        }
                    stack.push(curr);
                }
            } else {
                postfix.add(curr);
            }
            prev = curr;
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) postfix.add(stack.pop());
            else {
                logger.error("BRACKETS ARE NOT MATCHED");
                throw new SyntaxException(String.format("BRACKETS ARE NOT MATCHED"));
            }
        }
        logger.info("postfix form" + postfix);
        return postfix;
    }
}