package coding.hackerearth.jancircuit19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class EqualMultiset
{
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size  = Integer.parseInt(br.readLine());
        int a[] = new int[size];
        int b[] = new int[size];
        //a = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        String str[] =  br.readLine().trim().split(" ");
        int moves = 0;
        for(int i=0; i < size; i++)
        {
            a[i] =Integer.parseInt(str[i]);
        }
        str = br.readLine().trim().split(" ");
        for(int i = 0; i<size; i++)
        {
            b[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i = 0; i<size; i++)
        {
            moves += Math.abs(a[i]-b[i]);
            //System.out.println(moves);
        }

        System.out.println(moves);

    }

}