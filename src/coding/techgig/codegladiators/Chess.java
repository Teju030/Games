package coding.techgig.codegladiators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Chess
{
    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        long moves = 2*(n+1)+1;
        moves = moves*moves;
        System.out.println(moves);

    }
}