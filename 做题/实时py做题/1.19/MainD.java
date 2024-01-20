import java.io.*;
import java.util.*;

public class MainD {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        ac in = new ac();

        int n = in.nextInt();
        int m = in.nextInt();
        char[][] grids = new char[n][];
        for (int i = 0; i < n; i++) {
            grids[i] = in.next().toCharArray();
        }

        int res = 0;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grids[i][j] == '.' && !vis[i][j]) {
                    if (check(i, j, grids, vis)) {
                        res++;
                    }
                }
            }
        }
        System.out.println(res);
    }

    static final int[][] dirs = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static boolean check(int y, int x, char[][] grid, boolean[][] vis) {
        int h = grid.length, w = grid[0].length;

        int minY = y, minX = x;
        int maxY = y, maxX = x;
        int cnt = 1;

        Deque<int[]> deq = new ArrayDeque<>();
        deq.offer(new int[] {y, x});
        vis[y][x] = true;

        while (!deq.isEmpty()) {
            int[] pos = deq.poll();
            for (int i = 0; i < dirs.length; i++) {
                int ty = pos[0] + dirs[i][0];
                int tx = pos[1] + dirs[i][1];
                if (ty >= 0 && ty < h && tx >= 0 && tx < w) {
                    if (grid[ty][tx] == '.' && !vis[ty][tx]) {
                        vis[ty][tx] = true;
                        deq.offer(new int[] {ty, tx});
                        cnt++;

                        minY = Math.min(minY, ty);
                        minX = Math.min(minX, tx);
                        maxY = Math.max(maxY, ty);
                        maxX = Math.max(maxX, tx);
                    }
                }
            }
        }

        return minY == y && minX == x && (maxX - minX + 1) * (maxY - minY + 1) == cnt;
    }
}

class ac {
    BufferedReader br;
    StringTokenizer st;

    ac() {
        br = new BufferedReader(new InputStreamReader(System.in));
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
}
