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

public class MainA {
    public static void main(String[] args) {
        ac in=new ac();
        new SolutionA(in);
        in.flush();
    }
}

class SolutionA{
    SolutionA(ac love){
        ac in=love;
        
        int n=in.nextInt();  //n要获取的个数
        int m=in.nextInt();  //分母上的权

        double sum=0.0;
        
        for(int i=0;i<n;i++){
            sum+=1.0*in.nextInt();
        }
        in.println(sum/(4*m));
    }
}