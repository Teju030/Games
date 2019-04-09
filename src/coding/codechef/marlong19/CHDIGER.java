package coding.codechef.marlong19;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class CHDIGER{

    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            String line[] = br.readLine().trim().split(" ");
            int d =Integer.parseInt(line[1]);
            int len = line[0].length();
            int []num = new int[len];
            String []number = line[0].split("");
            int min_index = 0;
            for( int i = 0; i< len; i++)
            {
                num[i] = Integer.parseInt(number[i]);
                if (num[min_index] > num[i])
                {
                    min_index = i;
                }
            }

            // minimun digit will be the first number
            for (int i = 0; i<min_index; i++)
            {
                num[i]  = -1;
            }

            // after min index replace all large number greater than d
            for (int i = min_index; i<len; i++)
            {
                if(num[i] > d)
                {
                    num[i] = -1;
                }
            }

            // make number string
            String res = "";
            for (int i = 0; i <len; i++) {
                if (num[i]!= -1)
                {
                    res += ""+num[i];
                }
            }
            for (int i= res.length(); i<len; i++)
            {
                res+= ""+d;
            }

            System.out.println(res);
        }
    }

    static void print_array(String[] arr)
    {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

}