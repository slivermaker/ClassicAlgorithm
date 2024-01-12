package F23_9_13_huawei;
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

public class MainA_ {
    public static void main(String[] args) {
        ac in=new ac();
        new A(in);
        in.flush();
    }
}
class A{
    int p[];
    int find(int x){
        if(x!=p[x])return p[x]=p[find(p[x])];
        return x;
    }
    void union(int x,int y){
        int rx=find(x);int ry=find(y);
        if(rx!=ry){
            p[ry]=rx;
        }
    }
    A(ac in){
        int n=in.nextInt();
        int m=in.nextInt();
        int cnt=0;
        p=new int[n];
        for(int i=0;i<n;i++)p[i]=i;
        for(int i=0;i<m;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            union(x,y);
            
        }
        for(int i=0;i<n;i++){
            if(p[i]==i)cnt++;
        }
        //in.println(cnt+" "+Arrays.toString(p)+" ----");
        in.println(cnt);
    }
}