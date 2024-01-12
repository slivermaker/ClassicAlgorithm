package F23_9_02_xiaomi;

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


 

public class MainA {
    public static void main(String[] args) {
        ac in=new ac();
        new A(in);
        in.flush();
    }
}
class A{
    A(ac love){
        ac in=love;
        int n = in.nextInt();  // 输入n表示有多少个数据集合

        long[][] dp = new long[5][1005];
        //dp[i][j]=val

        int[][] a = new int[1005][5];

        
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= 4; ++j) {
                a[i][j] = in.nextInt();
            }
        }

        for (int i = 1; i <= n; ++i) {
            if (a[i][1] <= 1000) {
                dp[1][a[i][1]]++;
            }
        }

        for (int j = 2; j <= 4; ++j) {
            for (int i = 1; i <= n; ++i) {

                for (int t = a[i][j]; t <= 1000; ++t) {

                    dp[j][t] +=     dp[j - 1][t - a[i][j]];

                }

            }
            
        }

        in.println(dp[4][1000]);
    }
}

/*
 




....
....
....
....
....
....
....
....
....
....
....
....
....
....
....
....
....

 */