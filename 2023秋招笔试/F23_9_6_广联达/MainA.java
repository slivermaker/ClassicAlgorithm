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

public class MainA {
    public static void main(String[] args) {
        ac in=new ac();
        new A(in);
        in.flush();
    }
}
class A{
    static int N=50005;
    static int[] a=new int[N];
    static int last;
    A(ac in) {
        int n=in.nextInt();
        for(int i=1;i<=n;i++)
        {
            a[i]=in.nextInt();
            last=a[i];
        }
        int ans=0,now=n;
        while(now>=1)
        {
            while(now>0&&a[now]==last)
            {
                now--;
            }
            if(now>0)ans++;
            int off=n-now;
            for(int i=0;i<off&&now>0;i++)
            {
                a[now]=last;
                now--;
            }
        }
        System.out.println(ans);
    }
    
}