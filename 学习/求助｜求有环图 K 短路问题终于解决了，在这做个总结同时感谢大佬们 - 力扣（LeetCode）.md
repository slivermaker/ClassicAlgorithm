# 写在前面

作者：ENIAC
链接：https://leetcode.cn/circle/discuss/sIn96h/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 前言



最近有个项目需要求k条最短路径问题，在力扣上提了问题。感谢众多大佬的积极帮忙，同时将图的问题做个总结。

算法真的太美妙了。

## Yen's K-Shortest Paths Algorithm 算法

Yen's K-Shortest Paths Algorithm是一种用于在图中找到前k短路径的算法。它是由日本学者 Toshiyuki Yen 在1970年提出的。  
该算法的主要思想是通过在原始图中逐步删除已找到的路径中的边，然后重新运行最短路径算法，以找到次短路径、第三短路径，以此类推。

该算法对于数据量比较小还行，但是遇到数据量比较大的时候。会超时且内存溢出，我这边模拟的是1000个节点，3000条边。

## 迪杰斯特拉(Dijkstra)算法

后面想到的思路是，居然只是要求k条最短路径。那么就是把分叉点的删除，那么进行多次的迪杰斯特拉(Dijkstra)算法，那么也能求出来。  
试了效果，实现之后确实会出现。但是不是第k短了，是第n短的某一条。

## A\* 算法

A_搜寻算法(A_（念做：A Star）)，俗称A星算法，作为启发式搜索算法中的一种，这是一种在图形平面上，有多个节点的路径，求出最低通过成本的算法。常用于游戏中的NPC的移动计算，或线上游戏的BOT的移动计算上。

最开始大佬就建议用 A_算法，给了链接。无奈自己C++不是很懂，用chatgpt3.5转成Java报错了。最后用公司的chagpt4账号转对了。（人民币的力量）。  
然后又有个问题，没认真看chatgpt给的用例。运行代码，明显不对。想着这个可能有问题，实际最开始就是从 A_ 算法入手的。无奈自己没有认真，最后用公司的数据跑了代码。完全正确。就是自己想要的效果。关键运行速度，也太快了。

这就是算法的魅力，只要短短几行代码，用最低的成本解决最难的问题。

## Java代码

大家感兴趣可以看下，大佬之前给的链接[oi-wiki-k 短路](https://leetcode.cn/link/?target=https://oi-wiki.org/graph/kth-path/)。因为例子是控制台输入不太方便，这边附上Java代码。

```java
package demo.algorithm.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * AStar K短路
 * https://oi-wiki.org/graph/kth-path/
 *
 * @author jisl on 2023/12/20 15:54
 **/
public class AStarKPaths {
    // 定义常量：节点最大数量
    final int maxn = 5010;
    // 定义常量：边最大数量
    final int maxm = 400010;
    // 定义常量：表示无穷大的边权值
    final int inf = Integer.MAX_VALUE / 2;
    // 声明变量：节点数量、边数量、起始节点、目标节点、路径数量、临时变量
    int n, s, t, k;
    // 声明数组：存储节点的启发式值
    int[] H = new int[maxn];
    // 声明数组：记录节点在搜索过程中被访问的次数
    int[] cnt = new int[maxn];
    // 声明变量：记录当前处理的正向边和逆向边的数量
    int cur, cur1;
    // 正向图的邻接表
    int[] h = new int[maxn];  // 头结点
    int[] nxt = new int[maxm];  // 下一条边的索引
    int[] p = new int[maxm];    // 相邻节点的编号
    int[] w = new int[maxm];    // 边的权重
    // 逆向图的邻接表
    int[] h1 = new int[maxn];  // 头结点
    int[] nxt1 = new int[maxm];  // 下一条边的索引
    int[] p1 = new int[maxm];    // 相邻节点的编号
    int[] w1 = new int[maxm];    // 边的权重

    // 声明数组：记录节点是否被访问过
    boolean[] tf = new boolean[maxn];


    /**
     * 添加正向图的边
     *
     * @param x 起点
     * @param y 终点
     * @param z 边的权重
     */
    void addEdge(int x, int y, int z) {
        // 当前边的索引
        cur++;
        // 将当前边的下一条边指向原来的头结点
        nxt[cur] = h[x];
        // 更新头结点为当前边的索引
        h[x] = cur;
        // 记录相邻节点和边的权重
        p[cur] = y;
        w[cur] = z;
    }


    /**
     * 添加逆向图的边
     *
     * @param x 起点
     * @param y 终点
     * @param z 边的权重
     */
    void addEdge1(int x, int y, int z) {
        // 当前逆向边的索引
        cur1++;
        // 将当前逆向边的下一条边指向原来的逆向头结点
        nxt1[cur1] = h1[x];
        // 更新逆向头结点为当前逆向边的索引
        h1[x] = cur1;
        // 记录逆向相邻节点和边的权重
        p1[cur1] = y;
        w1[cur1] = z;
    }
    /**
     * 节点类，用于A*算法中表示搜索过程中的节点
     */
    class Node implements Comparable<Node> {
        int x, v; // 节点编号和从起点到该节点的累计代价
        List<Integer> path; // 存储路径

        /**
         * 构造方法，初始化节点
         *
         * @param x     节点编号
         * @param v     从起点到该节点的累计代价
         * @param path  从起点到该节点的路径
         */
        Node(int x, int v, List<Integer> path) {
            this.x = x;
            this.v = v;
            this.path = new ArrayList<>(path);
            this.path.add(x); // 将当前节点加入路径
        }

        /**
         * 优先队列比较方法，根据节点的估值（v + H[x]）升序排序
         *
         * @param a 另一个节点
         * @return 比较结果，1表示大于，-1表示小于
         */
        @Override
        public int compareTo(Node a) {
            return v + H[x] > a.v + H[a.x] ? 1 : -1;
        }
    }


    PriorityQueue<Node> q = new PriorityQueue<>();

    /**
     * 节点类，用于Dijkstra算法中表示搜索过程中的节点
     */
    class Node2 implements Comparable<Node2> {
        int x, v; // 节点编号和从起点到该节点的累计代价

        /**
         * 构造方法，初始化节点
         *
         * @param x 节点编号
         * @param v 从起点到该节点的累计代价
         */
        Node2(int x, int v) {
            this.x = x;
            this.v = v;
        }

        /**
         * 优先队列比较方法，根据节点的累计代价（v）升序排序
         *
         * @param a 另一个节点
         * @return 比较结果，1表示大于，-1表示小于
         */
        @Override
        public int compareTo(Node2 a) {
            return v > a.v ? 1 : -1;
        }
    }


    PriorityQueue<Node2> Q = new PriorityQueue<>();

    /**
     * 构建图并执行 A* K 短路算法
     *
     * @param graph  图的邻接矩阵，表示节点间的边权值
     * @param source 起点
     * @param target 目标节点
     * @param userK  要求的最短路径数量
     */
    public void build(int[][] graph, int source, int target, int userK) {
        // 包括节点数量n、边数量m、起点s、目标节点t、路径数量k等
        n = graph.length;
        s = source;
        t = target;
        k = userK;

        // 读取图的边信息并构建正向图和逆向图
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != Integer.MAX_VALUE / 2) {
                    addEdge(i, j, graph[i][j]);
                    addEdge1(j, i, graph[i][j]);
                }
            }
        }

        // 初始化启发式数组H，使用逆向边进行估值
        for (int i = 1; i <= n; i++) {
            H[i] = inf;
        }

        // 使用 Dijkstra 算法计算从目标节点 t 到其他节点的估值 H
        Q.add(new Node2(t, 0));
        while (!Q.isEmpty()) {
            Node2 x = Q.poll();
            if (tf[x.x]) {
                continue;
            }
            tf[x.x] = true;
//            启发式数组H 在Node节点比较的时候使用
            H[x.x] = x.v;
            for (int j = h1[x.x]; j != 0; j = nxt1[j]) {
                Q.add(new Node2(p1[j], x.v + w1[j]));
            }
        }

        // 使用 A* 算法计算从起点 s 到目标节点 t 的 k 条最短路径
        q.add(new Node(s, 0, new ArrayList<>())); // 将起点 s 加入优先队列 q，初始累计代价为 0，路径为空列表
        while (!q.isEmpty()) {
            Node x = q.poll(); // 弹出当前累计代价最小的节点
            cnt[x.x]++; // 增加当前节点的访问次数
            if (x.x == t) {
                // 如果当前节点是目标节点，输出 A* K 短路算法的相关信息，包括路径
                System.out.println(String.format("AStarKPaths对应值:x.v=%s,cnt[x.x]=%s,path=%s", x.v, cnt[x.x], getPath(x.path, source, target)));
            }
            if (x.x == t && cnt[x.x] == k) {
                System.out.println(x.v); // 如果找到第 k 条最短路径，输出累计代价并结束
                return;
            }
            if (cnt[x.x] > k) {
                continue; // 如果当前节点访问次数超过 k，跳过后续处理
            }
            for (int j = h[x.x]; j != 0; j = nxt[j]) {
                q.add(new Node(p[j], x.v + w[j], new ArrayList<>(x.path))); // 将该节点的邻接节点加入优先队列，并更新累计代价和路径
            }
        }
        System.out.println("-1");
    }


    private String getPath(List<Integer> path, int a, int b) {
        StringBuilder result = new StringBuilder();
        result.append("Shortest distance from ").append(a).append(" to ").append(b).append(": ");
        for (int i = 0; i < path.size(); i++) {
            result.append(" -> ").append(path.get(i));
        }
        result.append("\n==================================");
        return result.toString();
    }


    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] graph = {
                {INF, 4, 2, INF, INF},
                {4, INF, 6, 5, INF},
                {2, 1, INF, 8, 10},
                {INF, 5, 8, INF, 2},
                {INF, INF, 10, 2, INF}
        };
        final AStarKPaths aStarKPaths = new AStarKPaths();
        aStarKPaths.build(graph, 0, 3, 3);
    }
}



```

## 总结

算法的魅力，永远那么优雅