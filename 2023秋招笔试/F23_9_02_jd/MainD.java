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

public class MainD{
    public static void main(String[] args) {
        ac in=new ac();
        new D(in);
        in.flush();
    }
}

class D{

    D(ac love){
        ac in=love;
        int n=in.nextInt();int m=in.nextInt();

        long[][] pre = new long[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                int x = in.nextInt();
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + x;
            }
        }

        long sum = pre[n][m];

        long half = (sum + 1) / 2;

        long ans = sum;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int l = -1;
                int r = Math.min(n - i + 1, m - j + 1);

                while (l +1< r) {

                    int mid = (l + r) >>> 1;
                    if (get(pre, i, j, i + mid - 1, j + mid - 1) >= half) {

                        r = mid;
                    } else {
                        l = mid;
                    }

                }


                ans = Math.min(ans, Math.abs(sum - 2L * get(pre, i, j, i + r - 1, j + r - 1)));

                if (r > 1) {
                    r -= 1;
                    ans = Math.min(ans, Math.abs(sum - 2L * get(pre, i, j, i + r - 1, j + r - 1)));
                }


            }
        }

        in.println(ans);
    }

    public static long get(long[][] pre, int a, int b, int c, int d) {
        return pre[c][d] - pre[c][b - 1] - pre[a - 1][d] + pre[a - 1][b - 1];
    }


}