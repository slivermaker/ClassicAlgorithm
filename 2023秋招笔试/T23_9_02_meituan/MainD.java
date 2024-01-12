package T23_9_02_meituan;
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

class D{

    D(ac love){
        ac in=love;
        int cnt=0;
        int n = in.nextInt();
        int k = in.nextInt();
        if (k == n) {
            System.out.println(1);
            return;
        }

        int[] a = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextInt();
        }

        ArrayList<ArrayList<Integer>> v = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            v.add(new ArrayList<>());
        }


        for (int i = 1; i <= n; ++i) {
            int t = a[i];
            for (int j = 0; j <= cnt; ++j) {

                if (j == cnt) {
                    v.get(cnt++).add(t);
                    break;
                }

                int ok = 1;
                for (int p = 0; p < v.get(j).size(); ++p) {
                    if (v.get(j).get(p) % t == 0 || t % v.get(j).get(p) == 0) ;
                    else {
                        ok = 0;
                        break;
                    }
                }

                if (ok == 1) {
                    v.get(j).add(t);
                    break;
                }
            }
        }


        
        long ans = 0;
        for (ArrayList<Integer> i : v) {
            int t = i.size();
            if(t>=n-k)
            ans += C(t, n-k);
        }

        in.println(ans);
        }

    
    
    public static int C(int n, int r) {
        if (n == r || r == 0) {
            return 1; // 边界条件
        } else {
            return C(n-1, r) + C(n-1, r-1); // 递推关系
        }
    }
}