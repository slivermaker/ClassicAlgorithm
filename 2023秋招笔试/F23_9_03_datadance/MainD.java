package F23_9_03_datadance;


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

public class MainD{
    public static void main(String[] args) {
        ac in=new ac();
        new D(in);
        in.flush();
    }
}
//           1-------------y---s/2---x--------------n

class D{
    D(ac in){
        int N = 105;
        int[] a = new int[N];
        int n = in.nextInt();
        int s = 0;

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            s += a[i];
        }

        int[] f = new int[N * N / 2];
        int[] vis = new int[N];

        f[0] = n + 1;
        int m = s / 2;

        for (int i = 1; i <= n; i++) {

            for (int j = m; j >= a[i]; j--) {

                if (f[j] == 0 && f[j - a[i]] != 0) {
                    f[j] = i;
                }
            }
        }
        
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int k;

        for (k = m; f[k] == 0; --k) ;
        for (int i = k; i > 0; i -= a[f[i]]) {
            neg.add(f[i]);
            vis[f[i]] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                pos.add(i);
            }
        }

        List<int[]> ans = new ArrayList<>();
        while (!neg.isEmpty() && !pos.isEmpty()) {
            int x = neg.get(neg.size() - 1);
            int y = pos.get(pos.size() - 1);
            int loss = Math.min(a[x], a[y]);

            a[x] -= loss;
            a[y] -= loss;
            if (a[x] == 0) neg.remove(neg.size() - 1);
            if (a[y] == 0) pos.remove(pos.size() - 1);
            ans.add(new int[]{x, y});
        }
        in.println(Math.abs(s - k - k));
        in.println(ans.size());
        for (int[] pair : ans) {
           in.println(pair[0] + " " + pair[1]);
        }
    }
}