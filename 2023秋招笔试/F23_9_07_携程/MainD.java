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
/*
 


 
 */

public class MainD{
    public static void main(String[] args) {
        ac in=new ac();
        new D(in);
        in.flush();
    }
}
class D{
    D(ac in){
        char[]arr=in.next().toCharArray();

        int pre[]=new int[arr.length+1];
        
        for(int i=0;i<arr.length;i++){

            if(arr[i]=='0')pre[i+1]=pre[i]+1;

            else{
                pre[i+1]=pre[i]==0?0:pre[i]-1;
            }
        }
        
        long cnt=0L;
        for(int i=0;i<=arr.length;i++){
            if(pre[i]>0)cnt+=pre[i];
        }
        in.println(cnt);
        in.println(Arrays.toString(pre));
    }
    //11000100
    //000110
}