package T23_9_02_meituan;



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




/*
 * 
 * 1.  数组严格升序，即a<a1<a2<...<an

    2.  对于1<=i<=n-1，我们定义bi= ai+1  -ai，
 
 
    i=1: 1 2 =1
    i=2: 2 4 =2
 
    */

 

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
        int arr[]=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        if(n==1){in.println("Yes");return;}


        int f=arr[1]-arr[0];

        for(int i=0;i<n-1;i++){
            //in.print(f+"---");
            if(arr[i]>=arr[i+1]){
                in.println("No");return;
            }
            if(i!=0&&f>=(arr[i+1]-arr[i])){
                in.println("No");return;
            }
            f=arr[i+1]-arr[i];
            
        }


        in.println("Yes");
    }
}