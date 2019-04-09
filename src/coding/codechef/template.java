package coding.codechef;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/*
Format string for debugging
System.out.print(String.format("Prev : %-5d curr: %-5d steps: %-5d index: %-5d",prev,curr,steps,index));

 */
class template{

    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = Integer.parseInt(br.readLine().trim()); t > 0; --t) {
            int n = Integer.parseInt(br.readLine().trim());

        }
    }

    static void print_array(String[] arr)
    {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(" "+arr[i]);
        }
        System.out.println();
    }

    static void print_list(LinkedList<Integer> list){

        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            System.out.print(" "+ itr.next());
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