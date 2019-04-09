package coding.techgig.codegladiators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
5
5
-1 7 8 -5 4
4
3 2 1 -1
4
11 12 -2 -1
4
4 5 4 3
4
5 10 4 -1
===============
48
13
12
44
10

 */

class MaxSum
{
    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            int N = Integer.parseInt(br.readLine());
            String line[] = br.readLine().split(" ");
            int in[] = new int[N];
            for (int i = 0; i <N ; i++) {
                in[i] = Integer.parseInt(line[i]);
            }

            int incl = in[0];
            int excl = 0;
            int temp = 0;

            for (int i = 1; i < N; i++) {

                temp =  (incl>excl)? incl:excl;
                incl = excl + in[i];

                excl = temp;
            }

            temp =  (incl>excl)? incl:excl;
            System.out.println(temp);
        }
    }
    static void print_array(int[] arr)
    {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }
}