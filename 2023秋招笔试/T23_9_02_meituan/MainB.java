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

public class MainB {
    public static void main(String[] args) {
        ac in=new ac();
        new B(in);
        in.flush();
    }
}
/*
 * 
 * 
 * 6 3
    ata
    bab
    zbc
    ijk
    efg
    cde
 */

class B{
    B(ac love){
        ac in=love;
        int n=in.nextInt();int m=in.nextInt();
        char f[]="tazige".toCharArray();

        int id=0;
        String res="";
        for(int i=0;i<n;i++){
            String tmp=in.next();
            if(tmp.indexOf(f[id])!=-1)
                id++;
            if(id==6){
                in.println("Yes");return;
            }
        }
        in.println("No");
      }
}