import java.util.*;
import java.io.*;

class Qxx {
    int nex, t, v;

    public Qxx(int nex, int t, int v) {
        this.nex = nex;
        this.t = t;
        this.v = v;
    }
}

public class test {
    static Qxx[] e;
    static int[] h, dist;
    static int cnt;
    static PriorityQueue<int[]> q;

    static void addPath(int f, int t, int v) {
        e[++cnt] = new Qxx(h[f], t, v);
        h[f] = cnt;
    }

    static void dijkstra(int s) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        q.add(new int[]{0, s});
        while (!q.isEmpty()) {
            int[] u = q.poll();
            if (dist[u[1]] < u[0]) continue;
            for (int i = h[u[1]]; i != 0; i = e[i].nex) {
                int v = e[i].t, w = e[i].v;
                if (dist[v] <= dist[u[1]] + w) continue;
                dist[v] = dist[u[1]] + w;
                q.add(new int[]{dist[v], v});
            }
        }
    }

    public static void main(String[] args) {
        int N = 100005, M = 200005;
        e = new Qxx[M];
        h = new int[N];
        dist = new int[N];
        q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int n, m, s;

        // Reading input
        AC in = new AC();
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        for (int i = 1; i <= m; i++) {
            int u, v, w;
            u = in.nextInt();
            v = in.nextInt();
            w = in.nextInt();
            addPath(u, v, w);
        }

        // Using predefined values for testing
        

        dijkstra(s);

        for (int i = 1; i <= n; i++) {
            in.print(dist[i] + " ");
        }
        in.flush();
    }
}
class AC extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // 标准 IO
    public AC() { this(System.in, System.out); }
    public AC(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // 文件 IO
    public AC(String intput, String output) throws IOException {
        super(output);
        r = new BufferedReader(new FileReader(intput));
    }
    // 在没有其他输入时返回 null
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}