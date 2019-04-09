package coding.techgig.codegladiators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;


class Disks
{
    public static void main(String []args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        if (n==0)
        {
            System.out.print("0");
            return;
        }

        LinkedList <Integer> list = new LinkedList<Integer>();
        int prev = -1;
        int curr =-1;
        int steps = 0;
        for (int i=0; i<n ; i++)
        {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        prev = n;
        curr = n-1;

        //print_list(list);

        while (curr >=0)
        {
            int index = list.indexOf(curr);
            //get the next max element add it to the top
            if ((index+1) !=n && index!=0 && list.get(index+1)!=prev )
            {
                list.remove(index);
                list.addFirst(curr);
                steps++;
            }
            else if (index+1 == n)
            {
                list.addFirst(list.removeLast());
                steps++;
            }
            //System.out.print(String.format("Prev : %-5d curr: %-5d steps: %-5d index: %-5d",prev,curr,steps,index));
            prev = curr;

            //print_list(list);
            curr--;
        }

        System.out.print(steps);
    }

    static void print_list(LinkedList <Integer> list){

        Iterator itr = list.iterator();
        while (itr.hasNext())
        {
            System.out.print(" "+ itr.next());
        }
        System.out.println();
    }
}