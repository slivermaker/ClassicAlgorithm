package F23_8_15_4399笔试;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
 * 总的数量 n
 * 
 * 移动个数 1 2
 * 
 * dp[i]    i块石头有多种移动方法
 * 
 * dp[1] = 1
 * dp[2] = 2
 * dp[3] = 3
 * dp[4] = 5
 * dp[5] = 8
 * 
 * 三：i-2
 * 1 1 1
 * 1 2
 * 2 1
 * 
 * 四：i-1
 * 1 1 1 1
 * 1 1 2
 * 1 2 1
 * 2 1 1
 * 2 2
 * 
 * 五：i
 * 1 1 1 1 1
 * 1 1 1 2
 * 1 1 2 1
 * 1 2 1 1
 * 2 1 1 1
 * 2 2 1
 * 2 1 2
 * 1 2 2
 * 
 *    n (n+1)/2
 * 
 */
public class MainB{
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
        int n=in.nextInt();
        long []dp=new long[n+1];
        dp[1]=1;
        if(n==1){
            in.println(dp[1]);
            return;
        }
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        in.println(dp[n]);
    }
    static boolean cross(long[] a,long k){
        long x=k;
        for(int i=0;i<a.length;i++){
            if(x>(int)1e5)return true;
            if(x>a[i])x+=(x-a[i]);
            else x-=(a[i]-x);
            if(x<0)return false;
        }
        return true;
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
