package src.main.java.app.calculator;

import src.main.java.app.calculator.data.BinaryExpressionLexeme;

import java.io.*;
import java.util.Optional;

final public class Calculator
{
    private final BufferedReader reader;
    private final PrintWriter writer;

    public Calculator(InputStream in, OutputStream out)
    {
        reader = new BufferedReader(new InputStreamReader(in));
        writer = new PrintWriter(out);
    }

    public void execute()
        throws IOException
    {
        try
        {
            writer.println("To make calculation type: \"<operation> <operator> <operation>\"");
            writer.println("To exit type: \"exit\"");
            writer.println();

            while (true)
            {
                writer.print(">>> ");
                writer.flush();
                String commandString = this.reader.readLine();
                if (commandString.equals("exit"))
                {
                    return;
                }

                Optional<BinaryExpressionLexeme> lexeme = BinaryExpressionLexemeParser.parse(commandString);
                if (lexeme.isEmpty())
                {
                    writer.println("Invalid format. Please, use <number> <operation> <number>");
                    writer.flush();
                }
                else
                {
                    double result = BinaryExpressionLexemeHandler.handle(lexeme.get());
                    writer.println("Result: " + result);
                    writer.flush();
                }
            }
        }
        catch (IOException exception)
        {
            writer.println("Error while reading or writing");
            writer.flush();
        }
    }
}
