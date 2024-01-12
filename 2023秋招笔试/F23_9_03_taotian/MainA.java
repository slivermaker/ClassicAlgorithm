package F23_9_03_taotian;

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
    int mod=(int)1e9+7;
    A(ac in){
        int n=in.nextInt();
        int arr[]=new int[n];
        
        int sum[]=new int[201];
        long res=0L;
        for(int i=0;i<n;i++)arr[i]=in.nextInt();

        if(n<4){in.println(0);return;}
        
        for(int i=2;i<=n-2;i++){
        
            int xor[]=new int[200];
        
            for(int j=i+1;j<n;j++){
                xor[arr[i]^arr[j]]++;
            }
            for(int j=0;j<i-1;j++){
                sum[arr[i-1]+arr[j]]++;
            }
            for(int m=0;m<130;m++)res=(res+xor[m]*sum[m]%mod)%mod;
        }
        in.println(res);
    }
}