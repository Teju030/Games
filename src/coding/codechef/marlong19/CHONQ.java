package coding.codechef.marlong19;

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
            int left = 0;
            int right = n-1;

            while (left<right-1)
            {
                int mid = left + (right - left) / 2;
                int res = get_angry_cost(que,mid,right,k);
                //System.out.println(String.format("left : %-5d right: %-5d res: %-5d",left,right,res));
                if (res >0)
                {
                    left = mid;
                }
                else
                {
                    right = mid;
                    left++;
                    break;
                }
            }

            while (left<right)
            {
                int res = get_angry_cost(que,left,right,k);
                if (res > 0)
                {
                    left++;
                }

            }
            System.out.println(left+1);
        }
    }

    static int get_angry_cost( int[] que, int left, int right, int k)
    {
        long anger = 0L;
        for (int i = 1; i <=(que.length-left+1) ; i++) {
            anger+= (int)Math.floor((double)que[left]/i);
            left++;
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