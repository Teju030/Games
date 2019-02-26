package coding.codechef.feblong19;
//https://www.codechef.com/FEB19
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//HMAPPY2
public class HMAPPY2
{
    public static void  main(String []args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            String line[] = br.readLine().split(" ");
            long n =Long.parseLong(line[0]);
            long a =Long.parseLong(line[1]);
            long b =Long.parseLong(line[2]);
            long k =Long.parseLong(line[3]);
            System.out.println(new Solver().solve(n, a, b, k));
        }

    }

}
class Solver
{
    public String solve(long n, long a, long b, long k)
    {
        long temp = (n/a)+(n/b)-2*(n/LCM(a, b));
        //System.out.println(temp);
        if (temp>=k)
        {
            return "Win";
        }
        else
            return "Lose";
    }
    long LCM(long a, long b)
    {
        if( a%b == 0 || b%a == 0)
        {
            return Math.max(a,b);
        }
        return a*b;
    }
}
