package F23_9_23_huawei;

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
        new B(in);
        in.flush();
    }
}
class B{
    B(ac in){
        int n=in.nextInt();
        int arr[]=new int[n];
        int brr[]=new int[n];
        int pre[]=new int[n+1];
        int suf[]=new int[n+1];
        for(int i=0;i<n;i++)    arr[i]=in.nextInt();
        for(int i=0;i<n;i++)    brr[i]=in.nextInt();
        for(int i=1;i<=n;i++){
            pre[i]=pre[i-1]+brr[i-1];
            suf[n-i]=arr[n-i]+suf[n-i+1];
        }
       // in.println(Arrays.toString(pre)+" "+Arrays.toString(suf));
       int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int tmp=Math.max(pre[i],suf[i+1]);
            res=Math.min(res,tmp);
        }
        in.println(res);
        
    }
}