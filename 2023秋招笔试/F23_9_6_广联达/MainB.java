package F23_9_6_广联达;
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

public class MainB {
    public static void main(String[] args) {
        ac in=new ac();
        new A(in);
        in.flush();
    }
}
class A{
    static int N=50005;
    static long[] dp=new long[N];
    static long[] aft=new long[N];
    static long[] arr=new long[N];
    static long[] s=new long[N];
    static long[] t=new long[N];
    A(ac in){
        int n=in.nextInt();
        for(int i=0;i<n;i++)s[i]=in.nextInt();
        for(int i=0;i<n;i++)t[i]=in.nextInt();
        for(int i=0;i<n;i++)arr[i]=in.nextInt();
        dp[n-1]=arr[n-1];
        aft[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            long tt=0;
            int L=i+1,R=n-1;
            while(L<R)
            {
                int mid=(L+R)>>1;
                if(s[mid]<s[i]+t[i])L=mid+1;
                else R=mid;
            }
            if(s[L]>=s[i]+t[i])tt=aft[L];
            dp[i]=tt+arr[i];
            aft[i]=Math.max(dp[i],aft[i+1]);
        }
        in.println(aft[0]);
    }
    
}