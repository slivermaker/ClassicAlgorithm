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
 
  n<=10


 */
class A{
    // for(int i=1;i<=n;i++){
        //     res*=i;
        // }
        // in.println(res);


    
    boolean pri[]=new boolean[20];
    LinkedList<Integer>arr=new LinkedList<>();
    long res=0;
    A(ac in){
        int n=in.nextInt();
        
        for(int i=0;i<20;i++){
            pri[i]=is(i);
        }
        //in.println(Arrays.toString(pri));
        work(n ,in);

        in.println(res);
       
    }
    boolean is(int x){
        if(x<2)return false;
        for(int i=2;i<Math.sqrt(x+1);i++){
            if(x%i==0)return false;
        }
        return true;
    }


    void work(int n,ac in){
        if(arr.size()==n){
            in.println(arr.toString());
            for(int i=0;i<n-1;i++){
                int s=arr.get(i)+arr.get(i+1);
                if(pri[s])return;
            }
            res++;
        }
        for(int i=1;i<=n;i++){
            if(!arr.contains(i)){
                arr.add(i);
                work(n,in);
                arr.removeLast();
            }

        }
    }
}