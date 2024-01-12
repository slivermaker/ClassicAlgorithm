package F23_9_12_baidu;


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
    C(ac in){
        int n = in.nextInt();
        int m = in.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        int[][] mb = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            mb[i][0] = in.nextInt();
            mb[i][1] = in.nextInt();
        }

        int l = -1;
        int r = m+1;

        while (l +1< r) {
            int mid = (l+r+1)>>>1;
            if (check(mid, n, a, mb)) {
                l = mid;
            } else {
                r = mid ;
            }
        }
        /*
         while l < r:
            mid = (l + r + 1) // 2
            if check(mid):
                l = mid
            else:
                r = mid - 1
         */

        System.out.println(r-1);
    }
    public  boolean check(int x, int n, int[] a, int[][] mb) {
        int[] b = new int[n +5];
        for (int i = 1; i <= x; i++) {
            int x1 = mb[i][0];
            int x2 = mb[i][1];
            b[x1] += 1;
            b[x2 + 1] -= 1;
        }

        for (int i = 1; i <= n; i++) {
            b[i] += b[i - 1];
            if (b[i] > a[i]) {
                return false;
            }
        }

        return true;
    }
}