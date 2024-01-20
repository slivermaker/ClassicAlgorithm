
import java.io.*;
import java.util.*;

public class MainC{
    static final int mod=1000000007;
    public static void main(String[] args) {
        ac in=new ac();
        int _n=1;
        //_n=in.nextInt();
        while(_n-->0){
            solv(in);

        }
        in.flush(); 
    }
   
     
    static void solv(ac io) {
        ac in = io;
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(m + "  " + n);
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++)
            arr[i] = in.nextInt();
        int f = 0;
        int clo[] = new int[n + 1];
        clo[0] = -1;
        for (int i = 2; i <= n; i++) {
            if (arr[i] != arr[i - 1]) {
                clo[i] = f++;
            } else {
                clo[i] = f;
            }
        }
        int[] pre = new int[n + 1];
        pre[1] = 1;
        for (int i = 2; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (clo[i] != clo[i - 1])
                pre[i]++;

        }
        while (m-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            int res = pre[b] - pre[a];
            if (clo[a] == clo[a - 1])
                res++;
            System.out.println(res);
        }

    }

 
}
class ac extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    ac() {
        this(System.in, System.out);
    }

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

    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }

}