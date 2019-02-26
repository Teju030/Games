//package coding.codechef.feblong19;
//https://www.codechef.com/FEB19

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class ARTBALAN{

    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            char[] line = br.readLine().trim().toCharArray();
            int len = line.length;
            int []alpha = new int[26];

            for (int i=0; i<len ; i++)
            {

                alpha[line[i]-65] ++;
            }
            Arrays.sort(alpha);
            // String balancing logic
            int ans = Integer.MAX_VALUE;
            for (int i=1; i<=26; i++)
            {
                if( len % i ==0 )
                {
                    int count = 0;
                    int freq = len/i;
                    for (int j=25; j>= 25-i+1 ; j--)
                    {
                        count+= Math.min(freq, alpha[j]);
                    }

                    ans = Math.min(ans, len - count);
                }
            }

            System.out.println(ans);

        }
    }
}