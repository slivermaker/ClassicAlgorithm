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

public class MainA {
    public static void main(String[] args) {
        ac in=new ac();
        new A(in);
        in.flush();
    }
}
class A{
    int n, A, B, M;

    int dfs(List<List<Integer>> g, List<Integer> a, int u, int fa) {
        if (g.get(u).size() == 0) return 0;
        int sum = 0;
        for (int v: g.get(u)) {
            if (v == fa) continue;
            int hv = dfs(g, a, v, u);
            sum = (sum + (int) ((1L * B * (hv + a.get(u))) % M)) % M;
        }

        return sum;
    }
    A(ac in){
        n = in.nextInt();
        A = in.nextInt();
        B = in.nextInt();
        M = in.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }

        for (int u = 1; u < n; u++) {
            int v = in.nextInt();
            v--;
            g.get(u).add(v);
            g.get(v).add(u);
        }

        List<Integer> a = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < n; ++i) {
            cur = (int) ((1L * cur * A) % M);
            a.add(cur);
        }

        System.out.println(dfs(g, a, 0, -1));

    }
}