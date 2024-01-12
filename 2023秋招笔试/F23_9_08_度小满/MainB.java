package F23_9_08_度小满;

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
    static final int MOD = 1000000007;

    static int dfs(List<List<Integer>> g, List<Integer> c, int u) {
        if (g.get(u).size() == 0) return 1;
        int x = dfs(g, c, g.get(u).get(0));
        int y = dfs(g, c, g.get(u).get(1));
        if (c.get(u) == 1) return (int) ((1L * x * y) % MOD);
        return (x + y) % MOD;
    }
    B(ac in){
        int n = in.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }

        for (int u = 1; u < n; u++) {
            int v = in.nextInt();
            v--;
            g.get(v).add(u);
        }

        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(in.nextInt());
        }

        in.println(dfs(g, c, 0));
    }

}
