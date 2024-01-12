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

public class MainC{
    public static void main(String[] args) {
        ac in=new ac();
        //int _t=in.nextInt();

        //while(_t-->0)
            new C(in);

        in.flush();
    }
}
class C{
    int mod = (int) 1e9 + 7;

    C(ac in){
        int n = in.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        long ans = 0;
        for (int j = 29; j >= 0; --j) {
            int[] cnt = new int[2];
            int v = 1 << j;
            for (int i = n - 1; i >= 0; --i) {
                int b = a[i] >> j & 1;
                ans += (long) cnt[b ^ 1] * (i + 1) % mod * v % mod;
                ans %= mod;

                cnt[b] += n - i;
                cnt[b] %= mod;
            }
        }

        System.out.println(ans);
    }
}

        