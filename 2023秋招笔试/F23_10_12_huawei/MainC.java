package F23_10_12_huawei;

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
        ac in=new ac();
        new C(in);
        in.flush();
    }
}
class C{
    static int n;
    static List<Integer> g[];
    static final int N = 1510;
    static int[][] f = new int[N][2];
    static int[] d = new int[N];

    static void dfs(int u) {
        f[u][1] = 1;
        f[u][0] = 0;
        for (int x : g[u]) {
            dfs(x);
            f[u][1] += Math.min(f[x][0], f[x][1]);
            f[u][0] += f[x][1];
        }
    }

    C(ac in){
        int n=in.nextInt();
        g=new ArrayList[n];
        Arrays.setAll(g,i->new ArrayList<>());
        for(int i=0;i<n;i++){
            String a[]=in.next().split(":");
            int u=Integer.parseInt(a[0]);
            
            int len=a[1].charAt(1)-'0';
            //System.out.println(len);
            for(int j=0;j<len;j++){
                int v=Integer.parseInt(in.next());
                g[u].add(v);
                
            }
        }
        dfs(0);
        int res = Math.min(f[0][0], f[0][1]);
        System.out.println(res);
    }
    
}