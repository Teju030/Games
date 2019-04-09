package coding.techgig.codegladiators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class WOL
{
    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            int N = Integer.parseInt(br.readLine());
            String line[] = new String[2];
            line[0] = br.readLine();
            line[1] = br.readLine();
            int player[] = new int[N];
            int villain[] = new int[N];
            String temp[] = line[1].split(" ");
            for (int i = 0; i < N; i++) {
                player[i] = Integer.parseInt(temp[i]);
            }
            temp = line[0].split(" ");
            for (int i = 0; i < N; i++) {
                villain[i] = Integer.parseInt(temp[i]);
            }
            Arrays.sort(player);
            Arrays.sort(villain);
            //print_array(player);
            //print_array(villain);
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                //System.out.print( " " + (player[i]-villain[i]));
                if (player[i]-villain[i]<=0)
                {
                    flag = false;
                    break;
                }

            }
            if (flag==true)
                System.out.println("WIN");
            else
                System.out.println("LOSE");
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