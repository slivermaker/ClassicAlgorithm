package F23_9_20_alibaba;

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
        int n = in.nextInt();
        int m = in.nextInt();

        long m1 = 0, m2 = 0, id = 0;
        
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = 0; j < m; j++){
                long x;
                x = in.nextLong();
                sum += x;
            }
            if(sum > m1){
                m2 = m1; 
                m1 = sum;
                id = i;
            } else {
                if (m2 == 0) {
                    m2 = sum;
                }
            }
        }
        long ans = m1 - m2;
        in.println(id+1+" "+ans);
    }
}