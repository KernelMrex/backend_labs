package src.main.java.app.calculator;

import src.main.java.app.calculator.data.BinaryExpressionLexeme;

final public class BinaryExpressionLexemeHandler
{
    public static double handle(BinaryExpressionLexeme lexeme)
    {
        return switch (lexeme.getOperation()) {
            case ADDITION -> lexeme.getFirstArg() + lexeme.getSecondArg();
            case SUBTRACTION -> lexeme.getFirstArg() - lexeme.getSecondArg();
            case MULTIPLICATION -> lexeme.getFirstArg() * lexeme.getSecondArg();
            case DIVISION -> lexeme.getFirstArg() / lexeme.getSecondArg();
        };
    }
}
