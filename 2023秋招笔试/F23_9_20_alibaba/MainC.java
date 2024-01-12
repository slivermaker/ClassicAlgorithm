package F23_9_20_alibaba;



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
    char[]s;

    int dp[][];

    final int mod= (int)1e9+7;
    C(ac in){
        s=in.next().toCharArray();
        int n=s.length;
        
        dp=new int[n][1<<10];
        //in.println(Arrays.toString(s));
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        
        in.println(solv(0, 0, true, false,in));

    }

    int solv(int i,int mask,boolean isLimit,boolean isNum,ac in){//i=1   236  236
        if(i==s.length){
            
            return isNum?1:0;
        }
        
        if(!isLimit && isNum &&dp[i][mask]!=-1){
            return dp[i][mask];
        }

        int res=0;

        if(!isNum){
            res=solv(i+1,0,false,false,in);
        }

        int up=isLimit?s[i]-'0':9;
        
        for(int d=isNum?0:1;d<=up;d++){

            if((mask>>d&1)==0)res=(res+solv(i+1,(1<<d),isLimit&&d==up,true,in))%mod;

        }
        if(!isLimit&&isNum)dp[i][mask]=res;

        return res;
    }

}