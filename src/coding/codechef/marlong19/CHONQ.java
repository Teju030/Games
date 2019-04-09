//package coding.codechef.marlong19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class CHONQ {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            String input[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            input = br.readLine().trim().split(" ");

            int que[] = new int[n];

            // integer queue
            for (int i = 0; i < n ; i++) {

                que[i] = Integer.parseInt(input[i]);
            }
            //print_array(que);
            //getting the cost of the function
            int num = -1;
            for (int i = 0; i < n ; i++) {

                int res = get_angry_cost(que,i,n,k);
                if (res<=0)
                {
                    num = i+1;
                    break;
                }
            }
            if (num == -1)
                num = n+1;
            System.out.println(num);
        }
    }

    static int get_angry_cost( int[] que, int left, int right, int k)
    {
        long anger = 0L;
        for (int i = 1; left < right ; i++,left++) {
            anger+= (int)Math.floor((double)que[left]/i);
        }
        //System.out.println(String.format("left : %-5d right: %-5d anger: %-5d",left,right,anger));
        if (anger > k)
            return 1;
        else if (anger < k )
            return -1;
        else
            return 0;
    }

    static void print_array(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
}