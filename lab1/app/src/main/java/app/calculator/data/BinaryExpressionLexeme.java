package src.main.java.app.calculator.data;

import src.main.java.app.calculator.type.BinaryOperation;

final public class BinaryExpressionLexeme
{
    private final double firstArg;
    private final double secondArg;
    private final BinaryOperation operation;

    public BinaryExpressionLexeme(
        double firstArg,
        double secondArg,
        BinaryOperation operation
    ) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.operation = operation;
    }

    public double getFirstArg()
    {
        return firstArg;
    }

    public double getSecondArg()
    {
        return secondArg;
    }

    public BinaryOperation getOperation()
    {
        return operation;
    }
}
