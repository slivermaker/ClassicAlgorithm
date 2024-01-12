package F23_9_02_xiaomi;

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
    B(ac love){
        ac in=love;
        int n = 0;
        String s = in.next();
        int i = 0;
        int tmp = 0;
        int op = 0;

        int[][] a = new int[100005][2];

        // while (i < s.length()) {
        //     if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        //         op ^= 1; // 切换操作数标志
        //         tmp = s.charAt(i) - '0';
        //         i++;
        //     }
        //     while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        //         tmp = tmp * 10 + s.charAt(i) - '0';
        //         i++;
        //     }
        //     if (op == 1) {
        //         n++; // 数据集合数量加1
        //         a[n][0] = tmp; // 存储第一个整数
        //     } else {
        //         a[n][1] = tmp; // 存储第二个整数
        //     }
        //     i++;
        // }


        String[]ss=s.split(",");

        for(String ts:ss){
            String tmps[]=ts.split(":");
                n++;
                a[n][0]=Integer.parseInt(tmps[0]);
                a[n][1]=Integer.parseInt(tmps[1]);
            
        }
        Arrays.sort(a, 1, n + 1, (x, y) -> {
            int diffX = x[1] - x[0];
            int diffY = y[1] - y[0];
            if (diffX == diffY || (diffX <= 0 && diffY <= 0)) {
                return Integer.compare(x[0], y[0]);
            }
            return Integer.compare(y[1] - y[0], x[1] - x[0]);
        });

        //in.println(Arrays.toString(a[1]));

        
        int res = 0; 
        int pre = 0; // 当前值

        for (int j = 1; j <= n; ++j) {
            int d = Math.max(a[j][0], a[j][1]) - pre;
            if (d > 0) { // 如果d>0，说明初始值还需要加
                res += d;
                pre += d;
            }
            pre -= a[j][0]; 
        }

        
        if (res > 4800) {
            in.println(-1);
        } else {
            in.println(res);
        }
      }
}