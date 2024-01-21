
import java.io.*;
import java.util.*;

public class MainC{
    static final int mod=1000000007;
    public static void main(String[] args) {
        ac in=new ac();
        int _n=1;
        //_n=in.nextInt();
        while(_n-->0){
            solv(in);

        }
        in.flush(); 
    }
   
    static List<Integer>g[];
    static void solv(ac io) {
        ac in=io;
        int n=in.nextInt();
        g=new ArrayList[n+1];
        Arrays.setAll(g,(i->new ArrayList<>()));
        for(int i=1;i<=n;i++){
            int u=in.nextInt();
            int v=i;
            if(u<0)u++;
            g[u].add(v);
        }
        
        dfs(g[0].get(0),in);
        
    }
    static void dfs(int u,ac in){
        in.print(u+" ");
        if(g[u].size()>0)
            dfs(g[u].get(0),in);
            else return;
    }

 
}
class ac extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    ac() {
        this(System.in, System.out);
    }

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

    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }

}