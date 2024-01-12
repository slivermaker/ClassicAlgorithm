import java.util.*;

public class Main {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g,(i->new ArrayList<>()));
        Arrays.fill(d, 0);
        for (int i = 0; i < n; i++) {
            String[] data = sc.next().split(":");
            int t = Integer.parseInt(data[0]);
            int cnt = Integer.parseInt(data[1].substring(1, data[1].length() - 1));
            while (cnt-- > 0) {
                int a = sc.nextInt();
                g[t].add(a);
            }
        }
        int root = 0;

        dfs(root);
        int res = Math.min(f[0][0], f[0][1]);
        System.out.println(res);
    }
}
