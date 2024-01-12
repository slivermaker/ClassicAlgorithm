package F23_9_07_meituan;


import java.util.*;
import java.io.*;
class ac extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;
    ac() {this(System.in, System.out);}
    ac(InputStream i, OutputStream o) {
        super(o);
        br = new BufferedReader(new InputStreamReader(i));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() {return Integer.parseInt(next());}
    long nextLong(){return Long.parseLong(next());}

}

public class MainB {
    public static void main(String[] args) {
        ac in=new ac();
        new B(in);
        in.flush();
    }
}
class B{
    B(ac in){
       
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> a = new ArrayList<>();
        a.add(1);

        int x = 1;
        int y = n - 1;
        
        while (y > 0) {
            if (a.get(a.size() - 1) + x + y - 1 <= m) {
                a.add(a.get(a.size() - 1) + x);
                x++;
            } else {
                a.add(a.get(a.size() - 1) + 1);
            }
            y--;
        }

        for (int num : a) {
            System.out.print(num + " ");
        }
    }
}