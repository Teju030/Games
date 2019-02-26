package coding.codechef.feblong19;
//https://www.codechef.com/FEB19
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

2
4
1 1 4 1
3 4 2 1
7
5 4 5 4 5 4 5
3 2 4 7 2 5 9

 */
public class DEPCHEF {

    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine()); t > 0; --t) {
            int n = Integer.parseInt(br.readLine());
            String[] line = new String[2];
            line[0] = br.readLine();
            line[1] = br.readLine();
            int[] attack = new int[n];
            int[] defense = new int[n];
            int index = 0;
            for(String s : line[0].split(" "))
            {
                attack[index] = Integer.parseInt(s);
                index++;
            }
            index = 0;
            for (String s:line[1].split(" "))
            {
                defense[index] = Integer.parseInt(s);
                index++;
            }

            // calucalte the defense power
            int max_defense = 0;
            for ( index =0; index <n ; index++)
            {
                int lnr = attack[index] + attack[(index+2)%n];

                if(defense[(index+1)%n] > lnr && defense[(index+1)%n]>max_defense)
                {
                    max_defense = defense[(index+1)%n];
                }
            }

            if (max_defense == 0)
                max_defense = -1;
            System.out.println(max_defense);
        }
    }
}
