package F23_9_02_jd;

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
                    1-----1
            2-----2
   3---3




 */
class B{
    B(ac love){
        ac in=love;
        int[][]arr=new int[3][2];

        for(int i=0;i<3;i++){
            arr[i][0]=in.nextInt();arr[i][1]=in.nextInt();
        }

        Arrays.sort(arr,(a,b)->(b[1]-a[1]!=0?b[1]-a[1]:a[0]-b[0]));

        if(arr[1][1]>=arr[0][0])in.println(arr[1][1]);

        else if(arr[2][1]>=arr[1][0])in.println(arr[2][1]);

        else in.println(-1);
      }
}