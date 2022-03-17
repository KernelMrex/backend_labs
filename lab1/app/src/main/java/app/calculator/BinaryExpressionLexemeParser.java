package src.main.java.app.calculator;

import src.main.java.app.calculator.type.BinaryOperation;
import src.main.java.app.calculator.data.BinaryExpressionLexeme;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryExpressionLexemeParser
{
    private static final String LEXEME_REGEX = "(-?\\d+\\.?\\d*)\s*([+\\-*])\s*(-?\\d+\\.?\\d*)";

    public static Optional<BinaryExpressionLexeme> parse(String str)
    {
        Pattern pattern = Pattern.compile(LEXEME_REGEX);
        Matcher matcher = pattern.matcher(str);

        if (!matcher.matches())
        {
            return Optional.empty();
        }

        return Optional.of(new BinaryExpressionLexeme(
            Double.parseDouble(matcher.group(1)),
            Double.parseDouble(matcher.group(3)),
            parseOperation(matcher.group(2))
        ));
    }

    private static BinaryOperation parseOperation(String operationString)
        throws RuntimeException
    {
        return switch (operationString) {
            case "+" -> BinaryOperation.ADDITION;
            case "-" -> BinaryOperation.SUBTRACTION;
            case "*" -> BinaryOperation.MULTIPLICATION;
            case "\\" -> BinaryOperation.DIVISION;
            default -> throw new RuntimeException("Unknown operation");
        };
    }
}
