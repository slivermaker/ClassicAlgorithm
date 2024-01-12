package F23_9_13微众;


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
        int n=in.nextInt();

        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            q.offer(in.nextInt());
        }
        
        while(q.size()>=2){
            in.print(q.poll()+" ");
            int tmp=q.poll();
            q.offer(tmp);
        }
        in.print(q.poll());
    }
}