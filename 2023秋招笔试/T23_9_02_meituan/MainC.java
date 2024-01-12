package T23_9_02_meituan;

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

public class MainC{
    public static void main(String[] args) {
        ac in=new ac();
        new C(in);
        in.flush();
    }
}



class C{

    C(ac love){
        ac in=love;
        int n = in.nextInt();
        long[] a = new long[n];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            a[i] = in.nextLong();
        }



        for (int k = 0; k < 32; ++k) {
            int t = cal(a, n, k);
            if (t == -1)
                break;
            ans = Math.min(ans, t);
        }



        System.out.println(ans);
    }

    public static int cal(long[] a, int n, int x) {
        if ((a[0] << x) > Integer.MAX_VALUE)
            return -1;

        int tmp = (int) (a[0] << x);
        int ret = x;
        
        for (int i = 1; i < n; ++i) {
            long t = a[i];
            
            while (t > tmp) {
                t >>= 1;
                ret++;
            }
        }
        
        return ret;
    }
}
