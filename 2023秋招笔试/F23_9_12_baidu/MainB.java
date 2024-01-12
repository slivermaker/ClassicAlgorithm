package F23_9_12_baidu;


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
        int as[]=new int[n];
        int bs[]=new int[n];
        long sa=0L,sb=0L;
        for(int i=0;i<n;i++){
            as[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            bs[i]=in.nextInt();
        }
        int arr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=as[i]-bs[i];
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i]>0)sa+=arr[i];
            else sb-=arr[i];
        }
        in.println(Math.max(sa,sb));
    }
}