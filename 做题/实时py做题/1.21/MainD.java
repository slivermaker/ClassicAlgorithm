import java.io.*;
import java.util.*;
public class MainD {
    static final int mod = 1000000007;

    public static void main(String[] args) {
        ac in = new ac();

        int n = in.nextInt();
        int arr[] = new int[n];
        int tmp[]=new int[n];
        for (int i = 0; i < n; i++) {arr[i] = in.nextInt();tmp[i]=arr[i];}
        Arrays.sort(arr);
        if (n == 2) {
            in.printf("%.1f\n%.1f", (double) arr[1], (double) arr[0]);
        } else if (n % 2 == 1) {
            int mid = n / 2;
            double midv=arr[mid];
            int id1 = mid - 1, id2 = mid + 1;
            double res1 = (1.0 * arr[mid] + arr[id2]) / 2;
            double res2 = (1.0 * arr[id1] + arr[mid]) / 2;
            double res3 = (1.0 * arr[id1] + arr[id2]) / 2;
            for (int i = 0; i < n; i++) {
                if (tmp[i] < midv) in.printf("%.1f\n", res1);
                else if (tmp[i] == midv) in.printf("%.1f\n", res3);
                else in.printf("%.1f\n", res2);
            }
        } else {
            int mid = n / 2;
            double res1 = 1.0 * arr[mid];
            double res2 = 1.0 * arr[mid - 1];
            double midv=(res1+res2)/2;
            for (int i = 0; i < n; i++) {
                if (tmp[i] < midv) in.printf("%.1f\n", res1);
                else in.printf("%.1f\n", res2);
            }
        }
    }

    static final int[][] dirs = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
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

    void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
