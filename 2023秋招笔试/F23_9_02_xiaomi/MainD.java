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
        int n = 0;
        int x0 = in.nextInt(); // 初始化 x0
        String s = in.next();
        int i = 0;
        int tmp = 0; // 初始化 tmp
        int op = 0;

        int[][] a = new int[1000005][2];

        while (i < s.length()) {

            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                op ^= 1; // 切换操作数标志
                tmp = s.charAt(i) - '0';
                i++;
            }
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                tmp = tmp * 10 + s.charAt(i) - '0';
                i++;
            }
            if (op == 1) {
                n++; // 数据集合数量加1
                a[n][0] = tmp; // 存储 x 坐标
            } else {
                a[n][1] = tmp; // 存储 y 坐标
            }
            i++;
        }


        int minlen = 2_000_000_000;
        double ans = 0;

        for (int j = 1; j <= n; ++j) {
            if (a[j][0] < x0) {
                if (x0 - a[j][0] < minlen) {
                    minlen = x0 - a[j][0]; // 更新最小距离
                    ans = a[j][1]; // 更新答案
                } else if (x0 - a[j][0] == minlen) {
                    ans = (ans + a[j][1]) / 2.0; // 若距离相同，求平均值
                }
            } else if (a[j][0] > x0) {
                if (a[j][0] - x0 < minlen) {
                    minlen = a[j][0] - x0; // 更新最小距离
                    ans = a[j][1]; // 更新答案
                } else if (a[j][0] - x0 == minlen) {
                    ans = (ans + a[j][1]) / 2.0; // 若距离相同，求平均值
                }
            } else {
                ans = a[j][1]; // 若 x 坐标相同，直接取 y 坐标
                break;
            }
        }

        in.printf("%.1f", ans); // 输出答案，保留一位小数
    }

}