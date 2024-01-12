package F23_8_26_oppo;

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

public class MainC {
    public static void main(String[] args) {
        new SolutionC(new ac());
    }
}


    

class SolutionC{

        SolutionC(ac love){
            ac in=love;
            String flg="oppo";
            String s=in.next();
            int n=s.length();
            long res=0L;

            
            //     oppoooppo
            
            for(int i=0;i<=n-4;i++){
                
                String tmp=s.substring(i, i+4);

                if(tmp.equals(flg)){

                    //res++;
                    
                    res+=(long)(i+1) * (n-i-4+1);    
                }
                //oppo
            }

            in.println(res);
            in.flush();
        }
    }