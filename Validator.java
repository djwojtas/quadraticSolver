import java.io.BufferedReader;

public class Validator
{
    public static QuadraticFunction getLine(BufferedReader in)
    {
        String line;
        try
        {
             if((line = in.readLine()) == null) return null;
        }
        catch(Exception e)
        {
            return null;
        }

        QuadraticFunction equation = new QuadraticFunction();
        equation.inputLine = line;

        String[] coeff = line.split(" ");
        if(coeff.length < 3)
        {
            equation.error = "Not enough coefficients";
            return equation;
        }
        else if(coeff.length > 3)
        {
            equation.error = "Too many coefficients";
            return equation;
        }

        try
        {
            equation.a = Double.parseDouble(coeff[0]);
            equation.b = Double.parseDouble(coeff[1]);
            equation.c = Double.parseDouble(coeff[2]);
        }
        catch(Exception e)
        {
            equation.error = "One or more coefficients is not a number";
        }

        return equation;
    }
}
