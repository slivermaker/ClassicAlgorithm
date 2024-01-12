package F23_9_03_datadance;



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


/*
 * 
 * 
 * 
            n 
        a1    an

        3   5
 */
class A{
    A(ac in){
        int n=in.nextInt();
        int arr[]=new int[n];
        long sum=0L;

        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
            if(i==0)continue;
            sum+=Math.abs(arr[i]-arr[i-1]);
        }

        //in.println(sum+"***");
        if(n==1){in.println(0);return;}
        in.print(sum-Math.abs(arr[1]-arr[0])+" ");
        for(int i=1;i<n-1;i++){

            //int tmp=Math.max(Math.abs(arr[i]-arr[i-1]),Math.abs(arr[i+1]-arr[i]));

            int tmp=arr[i];
            int dif1=Math.abs(arr[i-1]-arr[i]);
            int dif2=Math.abs(arr[i+1]-arr[i]);

            long res=(long)sum-dif1-dif2+Math.abs(arr[i+1]-arr[i-1]);
            in.print(res+" ");
        }
         in.print(sum-Math.abs(arr[n-1]-arr[n-2]));

    }
}