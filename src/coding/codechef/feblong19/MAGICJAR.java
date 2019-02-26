package coding.codechef.feblong19;
//https://www.codechef.com/FEB19
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//MAGICJAR
public class MAGICJAR{

    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            int n = Integer.parseInt(br.readLine().trim());
            String line[] = br.readLine().trim().split(" ");
            long total_jars =0L;

            for (int i=0; i<n; i++)
            {
                int j = Integer.parseInt(line[i]);
                total_jars +=j;
            }
            total_jars = total_jars - n + 1;
            System.out.println(total_jars);
        }
    }
}