
import java.io.*;
import java.util.*;

public class MainB {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        ac in = new ac();
        int _n = 1;
        _n = in.nextInt();
        while (_n-- > 0) {
            solv(in);

        }
        in.flush();
    }

    static void solv(ac io) {
        ac in = io;
        char[] s = in.next().toCharArray();
        char[] f = in.next().toCharArray();
        int n1 = s.length, n2 = f.length;
        int cnt[] = new int[4];
        if (n1 == n2) {
            for (int i = 0; i < n1; i++) {
                int tmp1 = s[i] - 'A', tmp2 = f[i] - 'A';
                cnt[tmp1]++;
                cnt[tmp2]--;
            }
            boolean f1 = false, f2 = false;
            for (int n : cnt) {
                if (n > 0)
                    f1 = true;
                else if (n < 0)
                    f2 = true;

            }
            if (f1)
                in.println("0");
            else
                in.println("10");
        } else if (n2 < n1)
            in.println("0");
        else {
            for (int i = 0; i < n1; i++) {
                cnt[s[i] - 'A']++;
            }
            for (int i = 0; i < n2; i++) {
                cnt[f[i] - 'A']--;
            }
            boolean f1 = false, f2 = false;

            for (int n : cnt) {
                if (n > 0)
                    f1 = true;
                else
                    f2 = true;
            }
            if (f1)
                in.println("0");
            else
                in.println("10");
        }

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

    long nextLong() {
        return Long.parseLong(next());
    }

}