import java.io.*;

public class QuadraticSolver
{
    PrintWriter out;
    BufferedReader in;

    public boolean init(String[] pathInOut)
    {
        try
        {
            if(pathInOut.length != 2)
            {
                System.out.println("Launch with 2 command line arguments - path to input file and path to output file");
                return false;
            }

            in = new BufferedReader(new InputStreamReader(new FileInputStream(pathInOut[0])));
            out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(pathInOut[1]), "UTF-8"));
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error occurred during reading input file or opening output file");
            return false;
        }
    }

    public static void main(String[] args)
    {
        QuadraticSolver solver = new QuadraticSolver();

        if(!solver.init(args))
        {
            System.exit(1);
        }

        QuadraticFunction toSolve;

        while((toSolve = Validator.getLine(solver.in)) != null)
        {
            toSolve.solve();
            toSolve.print(solver.out);
        }
    }
}
