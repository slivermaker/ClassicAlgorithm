package F23_9_07_携程;


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
        int _t=in.nextInt();

        while(_t-->0)
            new C(in);

        in.flush();
    }
}

/*
 * 
 * 
 
 */
class C{
    C(ac in){
        long n=in.nextLong();

        long l=in.nextLong();
        long r=in.nextLong();
        long z=0;
        long f=0;
        long sum=0;
        for(int i=0;i<n;i++){
            long tmp=in.nextLong();
            sum+=tmp;

            if(tmp>r)z+=tmp-r;
            else if(tmp<l)f+=l-tmp;
            //in.println(z+"   "+f);
        }
        
        if(sum>r*n||sum<l*n){
            in.println(-1);return;
        }

        in.println(Math.max(z,f));

    }
}