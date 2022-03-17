package src.main.java.app;

import src.main.java.app.calculator.Calculator;

import java.io.IOException;

public class App
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator(System.in, System.out);
        try
        {
            calculator.execute();
        }
        catch (IOException e)
        {
            System.err.println("Error while performing operations on stdin/stdout");
        }
    }
}