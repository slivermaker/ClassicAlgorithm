package F23_9_22_腾讯音乐;


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
        int m = in.nextInt();
        int n = in.nextInt();

        List<Integer> maxnum = new ArrayList<>();

        for (int i = 0; i < m; ++i) {
            int len = in.nextInt();

            List<Integer> g[] = new ArrayList[len];

            Arrays.setAll(g,(val->new ArrayList<>()));

            for (int j = 1; j < len; ++j) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                g[a].add(b);
                g[b].add(a);
            }

            List<Integer> d = new ArrayList<>(Collections.nCopies(len, 0));//int[]d=new int[len]

            int md = bfs(g, d);

            int c = 0;
            for (int j = 0; j < len; ++j) {
                if (d.get(j) == md) c++;
            }
            maxnum.add(c);
        }

        long muls = 1;
        for (int i = 0; i < m; ++i) {
            muls = muls * maxnum.get(i) % MOD * 2 % MOD;
        }

        long fac = 1;
        for (int i = 1; i < m; ++i) {
            fac = fac * i % MOD;
        }

        long ans = 0;
        for (int i = 0; i < m; ++i) {
            
            long tmul = muls * fpow(maxnum.get(i) * 2 % MOD, MOD - 2) % MOD;

            ans = (ans + tmul * fac % MOD) % MOD;
        }

        in.println(ans);
    }
    static final int MOD = (int)1e9 + 7;

    public static long fpow(long a, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            n >>= 1;
        }
        return res;
    }
    
    public static int bfs(List<Integer> g[], List<Integer> d) {


        
        int md = 1;
        d.set(0, 1);
        Queue<Integer> q = new ArrayDeque();
        q.add(0);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v: g[u]) {
                if (d.get(v) == 0) {
                    d.set(v, d.get(u) + 1);
                    md = Math.max(md, d.get(v));
                    q.offer(v);
                }
            }
        }

        return md;
    }
}