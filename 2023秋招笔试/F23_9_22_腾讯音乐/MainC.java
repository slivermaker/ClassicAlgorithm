package F23_9_22_腾讯音乐;


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
    int MOD =(int)1e9+7;

    int dp[]=new int[305];
    
    C(ac in){
        String t = in.next();
        int n = t.length();
        t = " " + t;

 //       int dp[]=new int[n+1];

        dp[0] = dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= n; ++i) {
            
            dp[i] = dp[i - 1];

            for (int len = 2; len <= i - 2; ++len) {


                String s = t.substring(i - len + 1, i + 1);
                
                for (int j = 1; j + len <= i - len + 1; ++j) {

                    if (t.substring(j, j + len).equals(s)) {

                        dp[i] =(dp[i]+ dp[i - len])%MOD;
                        
                            
                    }
                }
            }
        }

        in.println(dp[n]);
    }
}