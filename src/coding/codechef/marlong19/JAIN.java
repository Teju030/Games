package coding.codechef.marlong19;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


class JAIN{

    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            int n = Integer.parseInt(br.readLine().trim());
            boolean[] dish_a = new boolean[n];
            boolean[] dish_e = new boolean[n];
            boolean[] dish_i = new boolean[n];
            boolean[] dish_o = new boolean[n];
            boolean[] dish_u = new boolean[n];

            //  set true if vowel is present in that string

            for ( int i = 0; i<n ;i++)
            {
                String[] line = br.readLine().trim().split("");
                Set<String> set = new HashSet<>();
                Collections.addAll(set, line);

                if(set.contains("a"))
                    dish_a[i] = true;
                if (set.contains("e"))
                    dish_e[i] = true;
                if (set.contains("i"))
                    dish_i[i] = true;
                if (set.contains("o"))
                    dish_o[i] = true;
                if (set.contains("u"))
                    dish_u[i] = true;
            }

            // count the combinations
            int comb = 0;

            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j<n; j++)
                {
                    if((dish_a[i] || dish_a[j] ) &&
                            (dish_e[i] || dish_e[j] )&&
                            (dish_i[i] || dish_i[j] )&&
                            (dish_o[i] || dish_o[j] )&&
                            (dish_u[i] || dish_u[j] ))
                    {
                        comb++;
                    }
                }

            }

            System.out.println(comb);

        }
    }
    static void print_array(boolean[] arr)
    {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    static void print_set(Set<String> set){

        Iterator itr = set.iterator();
        while (itr.hasNext())
        {
            System.out.print(" "+ itr.next());
        }
        System.out.println();
    }
}