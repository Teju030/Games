package coding.techgig.codegladiators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Ascii
{
    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            String line = br.readLine();
            char []ch = line.toCharArray();
            for (char c:ch)
            {
                System.out.print((int)c);
            }
            System.out.println();
        }
    }
}