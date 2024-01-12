package F23_9_25_阿里国际算法岗;


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
public class MainB{
    public static void main(String[] args) {
        ac in=new ac();
        new B(in);
        in.flush();
    }
}
class B{
    int mp[][];
    long dp[][];
    int addy[]=new int[]{2,2,1,1};
    int addx[]=new int[]{1,-1,2,-2};
    B(ac in){
        int n=in.nextInt();
        mp=new int[n][n];
        dp=new long[n][n];
        for(long []p:dp)Arrays.fill(p,Long.MIN_VALUE/2);
        for(int i=0;i<n;i++)for(int j=0;j<n;j++)mp[i][j]=in.nextInt();
        dp[0][0]=mp[0][0];

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<4;k++){
                    int x=j-addx[k],y=i-addy[k];
                    if(x<0||x>n-1||y<0||y>n-1)continue;
                    dp[j][i]=Math.max(dp[j][i],dp[x][y]+mp[j][i]);
                }
            }
        }
        
        long res=0L;
        for(int i=0;i<n;i++){
            res=Math.max(res,dp[i][n-1]);
        }
       // for(int i=0;i<n;i++)in.println(Arrays.toString(mp[i]));
        in.println(res);
    }
}