package calculator;

import calculator.exception.ExecutionException;

public interface Operation {
    void make( ExecutionContext context) throws ExecutionException;
}
