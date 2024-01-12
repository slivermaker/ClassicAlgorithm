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

public class MainB {
    public static void main(String[] args) {
        ac in=new ac();
        new B(in);
        in.flush();
    }
}

/*
[][] 
    t z g g
    z g a
    z

 
 */


class B{
    char[][]gri;
    int m,n;
    B(ac in){
        n=in.nextInt();
        m=in.nextInt();
        gri=new char[n][m];

        for(int i=0;i<n;i++){
            gri[i]=in.next().toCharArray();
        }


        int[][] ts = new int[2][1005];
        int[][] zs = new int[2][1005]; 
        int[][] gs = new int[2][1005];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char c=gri[i][j];
                if (c == 't') {
                    ts[0][i]++;
                    ts[1][j]++;
                } else if (c == 'z') {
                    zs[0][i]++;
                    zs[1][j]++;
                } else if (c == 'g') {
                    gs[0][i]++;
                    gs[1][j]++;
                }
                        
                
            }
        }
        long ans=0;
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = gri[i][j];
                if (c == 't') {
                    ans += zs[0][i] * gs[1][j] + zs[1][j] * gs[0][i]; 
                } else if (c == 'z') {
                    ans += ts[0][i] * gs[1][j] + ts[1][j] * gs[0][i]; 
                } else if (c == 'g') {
                    ans += zs[0][i] * ts[1][j] + zs[1][j] * ts[0][i]; 
                }
            }
        }
        in.println(ans);
    }
    
}