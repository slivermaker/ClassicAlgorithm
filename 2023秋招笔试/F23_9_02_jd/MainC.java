package F23_9_02_jd;

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
        int n=in.nextInt();//每个商品价格

        int m=in.nextInt();//优惠券的数量

        int[] ps = new int[n];

        int[][] ms = new int[m][2]; //每个优惠券的使用条件和减少的价格

        for (int i = 0; i < n; i++) {
            ps[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            ms[i][0] = in.nextInt();
            ms[i][1] = in.nextInt();
        }

        Arrays.sort(ps);

        Arrays.sort(ms, (a, b) -> a[0] - b[0]);

        int tmp = 0;
        

        for (int i = 0, j = 0; i < n; i++) {

            while (j < m && ps[i] >= ms[j][0]) {
                tmp = Math.max(tmp, ms[j][1]);
                j++;
            }
            ps[i] -= tmp;
        }

        long res = 0L;
        for (int i = 0; i < n; i++) {
            res += ps[i];
        }
        in.println(res);

    }
}