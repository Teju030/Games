package coding.codechef.feblong19;
//https://www.codechef.com/FEB19
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//CHEFING
public class CHEFING
{
    public static void main(String []args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            int n  = Integer.parseInt(br.readLine());
            int alpha[] = new int[26];
            int row =1;

            // update alpha for sp ingredient
            while(row <= n)
            {
                String line =br.readLine();
                for ( char ch: line.toCharArray())
                {
                    int index = ch - 97;
                    if (alpha[index] == (row-1))
                        alpha[index] = row;
                }
                row++;
            }

            // count the special ingredients
            int c =0;
            row--;
            //System.out.println(" Alpha array ");
            for ( int cnt : alpha) {
                //System.out.print(" " + cnt);
                if(cnt == row)
                    c++;
            }
            System.out.println(c);
        }
    }
}
