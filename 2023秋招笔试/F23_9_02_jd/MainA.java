package F23_9_02_jd;



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
    A(ac love){
        ac in=love;
        
        int n=in.nextInt();

        int m=in.nextInt();

        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();//a市场每个商品的价格

        }
        for(int i=0;i<n;i++){
            arr[i]=Math.min(arr[i],in.nextInt());
        }
        long sum=0L;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        in.println(Math.min(sum,m));
    }
}