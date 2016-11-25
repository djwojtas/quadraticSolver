import java.io.PrintWriter;

public class QuadraticFunction
{
    public double a, b, c;
    public String error;
    public String inputLine;
    private boolean complex = false;
    private double re, im;

    public void print(PrintWriter out)
    {
        out.write(inputLine + " --> ");

        if(error == null)
        {
            if(!complex)
            {
                out.write((re-im) + "  " + (re+im));
            }
            else
            {
                out.write(re + " + " + (-im) + "i  " + re + " + " + im + "i");
            }
        }
        else
        {
            out.write(error);
        }

        out.write("\n");
        out.flush();
    }

    public void solve()
    {
        if(error == null)
        {
            double discriminant = b*b - 4*a*c;
            if(discriminant < 0) complex = true;

            re = -b/(2*a);
            im = Math.sqrt(Math.abs(discriminant))/(2*a);
        }
    }
}
