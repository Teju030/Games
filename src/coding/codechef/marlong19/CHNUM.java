package coding.codechef.marlong19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CHNUM
{
    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            int n = Integer.parseInt(br.readLine().trim());
            int size_p = 0, size_n = 0;
            String[] line = br.readLine().trim().split(" ");

            for (String str : line) {
                int num = Integer.parseInt(str);
                if (num>0)
                {
                    size_p++;
                }
                else
                    size_n++;
            }
            size_p = (size_p > 0)?size_p : size_n;
            size_n = (size_n > 0)?size_n : size_p;
            if (size_p > size_n)
                System.out.println(size_p+" "+size_n);
            else
                System.out.println(size_n+" "+size_p);
        }
    }
}