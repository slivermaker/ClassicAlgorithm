package F23_9_22_腾讯音乐;


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
    A(ac in){
        String n=in.next();
        int len= n.length();
        int res=0;
        for(int i=len-1;i>=0;i--){
            if(n.charAt(i)=='0'||n.charAt(i)=='5'){
                break;
            }
            res++;
        }
        in.println(res);
    }
    
}