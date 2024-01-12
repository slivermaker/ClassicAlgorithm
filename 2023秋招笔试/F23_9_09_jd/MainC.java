package F23_9_09_jd;


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
    int mod=(int)1e9+7;
    C(ac in){
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=in.nextInt();
        long res=0;

        for(int i=0;i<n;i++){
            res+=arr[i]*(sum(i+1)*(n-i)%mod)%mod;

            //in.println(sum(i+1)+" "+(i+1)*(n-i));
        }
        in.println(res%mod);

    }
    long sum(long n){
        return (n+1)*n/2;
    }
}