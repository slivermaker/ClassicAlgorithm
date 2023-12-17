
import java.io.*;
import java.util.*;

public class sayaplay {

    public static void main(String[] args) {
        Solver solver = new Solver();
    }

    static class Solver {
        IO io;

        public Solver() {
            this.io = new IO();
            try {
                solve();
            } catch (RuntimeException e) {
                if (!e.getMessage().equals("Clean exit")) {
                    throw e;
                }
            } finally {
                io.close();
            }
        }

        /****************************** START READING HERE ********************************/

        


        void solve() {
           
            
            
            

            
        }

        

        /************************** UTILITY CODE BELOW THIS LINE **************************/

        long MOD = (long)1e9 + 7;

        boolean closeToZero(double v) {
            return Math.abs(v) <= 0.0000000001;
        }

        class DrawGrid {

            void draw(boolean[][] d) {
                System.out.print("  ");
                for (int x=0; x<d[0].length; x++) {
                    System.out.print(" " + x + " ");
                }
                System.out.println("");
                for (int y=0; y<d.length; y++) {
                    System.out.print(y + " ");
                    for (int x=0; x<d[0].length; x++) {
                        System.out.print((d[y][x] ? "[x]" : "[ ]"));
                    }
                    System.out.println("");
                }
            }

            void draw(int[][] d) {
                int max = 1;
                for (int y=0; y<d.length; y++) {
                    for (int x=0; x<d[0].length; x++) {
                        max = Math.max(max, ("" + d[y][x]).length());
                    }
                }
                System.out.print("  ");
                String format = "%" + (max+2) + "s";
                for (int x=0; x<d[0].length; x++) {
                    System.out.print(String.format(format, x) + " ");
                }
                format = "%" + (max) + "s";
                System.out.println("");
                for (int y=0; y<d.length; y++) {
                    System.out.print(y + " ");
                    for (int x=0; x<d[0].length; x++) {
                        System.out.print(" [" + String.format(format, (d[y][x])) + "]");
                    }
                    System.out.println("");
                }
            }

        }

        class IDval implements Comparable<IDval> {
            int id;
            long val;

            public IDval(int id, long val) {
                this.val = val;
                this.id = id;
            }

            @Override
            public int compareTo(IDval o) {
                if (this.val < o.val) return -1;
                if (this.val > o.val) return 1;
                return this.id - o.id;
            }
        }

        private class ElementCounter {
            private HashMap<Long, Integer> elements;

            public ElementCounter() {
                elements = new HashMap<>();
            }

            public void add(long element) {
                int count = 1;
                Integer prev = elements.get(element);
                if (prev != null) count += prev;
                elements.put(element, count);
            }

            public void remove(long element) {
                int count = elements.remove(element);
                count--;
                if (count > 0) elements.put(element, count);
            }

            public int get(long element) {
                Integer val = elements.get(element);
                if (val == null) return 0;
                return val;
            }

            public int size() {
                return elements.size();
            }
        }

        class StringCounter {
            HashMap<String, Integer> elements;

            public StringCounter() {
                elements = new HashMap<>();
            }

            public void add(String identifier) {
                int count = 1;
                Integer prev = elements.get(identifier);
                if (prev != null) count += prev;
                elements.put(identifier, count);
            }

            public void remove(String identifier) {
                int count = elements.remove(identifier);
                count--;
                if (count > 0) elements.put(identifier, count);
            }

            public long get(String identifier) {
                Integer val = elements.get(identifier);
                if (val == null) return 0;
                return val;
            }

            public int size() {
                return elements.size();
            }
        }

        class DisjointSet {
            int[] size;
            int[] parent;
            int componentCount;

            public DisjointSet(int n) {
                componentCount = n;
                size = new int[n];
                parent = new int[n];
                for (int i=0; i<n; i++) parent[i] = i;
                for (int i=0; i<n; i++) size[i] = 1;
            }

            public void join(int a, int b) {
                int rootA = parent[a];
                int rootB = parent[b];
                while (rootA != parent[rootA]) rootA = parent[rootA];
                while (rootB != parent[rootB]) rootB = parent[rootB];

                if (rootA == rootB) {
                    return;
                }

                if (size[rootA] > size[rootB]) {
                    size[rootA] += size[rootB];
                    parent[rootB] = rootA;
                } else {
                    size[rootB] += size[rootA];
                    parent[rootA] = rootB;
                }
                componentCount--;
            }

        }

        class Trie {
            int N;
            int Z;
            int nextFreeId;
            int[][] pointers;
            boolean[] end;

            public Trie(int maxLenSum, int alphabetSize) {
                this.N = maxLenSum;
                this.Z = alphabetSize;
                this.nextFreeId = 1;
                pointers = new int[N+1][alphabetSize];
                end = new boolean[N+1];
            }

            public void addWord(String word) {
                int curr = 0;
                for (int j=0; j<word.length(); j++) {
                    int c = word.charAt(j) - 'a';
                    int next = pointers[curr][c];
                    if (next == 0) {
                        next = nextFreeId++;
                        pointers[curr][c] = next;
                    }
                    curr = next;
                }
                end[curr] = true;
            }

            public boolean hasWord(String word) {
                int curr = 0;
                for (int j=0; j<word.length(); j++) {
                    int c = word.charAt(j) - 'a';
                    int next = pointers[curr][c];
                    if (next == 0) return false;
                    curr = next;
                }
                return end[curr];
            }

        }

        private static class Prob {

            /** 用于概率的重要计算的类，提供比双精度浮点数更准确和高效的计算方式。
            * 数学解释：https://en.wikipedia.org/wiki/Log_probability
            * 快速开始：
            *    - 实例化概率，例如：Prob a = new Prob(0.75)
            *    - add()、multiply() 返回新对象，可以对空值和NaN执行操作。
            *    - get() 返回可读的概率值作为双精度浮点数 */

            /** 对于概率的繁重计算，该类提供比双精度浮点数更准确且高效的计算方式。
            * 数学解释：https://en.wikipedia.org/wiki/Log_probability
            * 快速入门：
            *    - 实例化概率，例如：Prob a = new Prob(0.75)
            *    - add()、multiply() 返回新对象，可以对 null 和 NaN 执行操作。
            *    - get() 以可读的双精度浮点数形式返回概率 */
            private double logP;
            /** 使用实际概率构造实例。 */
            public Prob(double real) {
                if (real > 0) this.logP = Math.log(real);
                else this.logP = Double.NaN;
            }

            /** 使用已经对数化的值构造实例。 */
            static boolean dontLogAgain = true;
            public Prob(double logP, boolean anyBooleanHereToChooseThisConstructor) {
                this.logP = logP;
            }

            /** Returns real probability as a double. */
            public double get() {
                return Math.exp(logP);
            }

            @Override
            public String toString() {
                return ""+get();
            }

            /*****************下面是静态方法：********************/

            /** 注意：仅当 a 和 b 都为 NaN/null 时返回 NaN。 */
            public static Prob add(Prob a, Prob b) {
                if (nullOrNaN(a) && nullOrNaN(b)) return new Prob(Double.NaN, dontLogAgain);
                if (nullOrNaN(a)) return copy(b);
                if (nullOrNaN(b)) return copy(a);

                double x = Math.max(a.logP, b.logP);
                double y = Math.min(a.logP, b.logP);
                double sum = x + Math.log(1 + Math.exp(y - x));
                return new Prob(sum, dontLogAgain);
            }

            public static Prob multiply(Prob a, Prob b) {
                if (nullOrNaN(a) || nullOrNaN(b)) return new Prob(Double.NaN, dontLogAgain);
                return new Prob(a.logP + b.logP, dontLogAgain);
            }

            private static boolean nullOrNaN(Prob p) {
                return (p == null || Double.isNaN(p.logP));
            }

            private static Prob copy(Prob original) {
                return new Prob(original.logP, dontLogAgain);
            }
        }

        class Binary implements Comparable<Binary> {

            /**
            * 使用示例：Binary b = new Binary(Long.toBinaryString(53249834L));
            *
            * 当处理较小的二进制字符串时，实例化新的 Binary(string)
            * 当仅读取大型二进制字符串时，实例化新的 Binary(string, true)
            * get(int i) 返回字符 '1' 或 '0'，而不是整数。
            */

            private boolean[] d;
            private int first; 
            public int length;


            public Binary(String binaryString) {
                this(binaryString, false);
            }
            public Binary(String binaryString, boolean initWithMinArraySize) {
                length = binaryString.length();
                int size = Math.max(2*length, 1);
                first = length/4;
                if (initWithMinArraySize) {
                    first = 0;
                    size = Math.max(length, 1);
                }
                d = new boolean[size];
                for (int i=0; i<length; i++) {
                    if (binaryString.charAt(i) == '1') d[i+first] = true;
                }
            }

            public void addFirst(char c) {
                if (first-1 < 0) doubleArraySize();
                first--;
                d[first] = (c == '1' ? true : false);
                length++;
            }

            public void addLast(char c) {
                if (first+length >= d.length) doubleArraySize();
                d[first+length] = (c == '1' ? true : false);
                length++;
            }

            private void doubleArraySize() {
                boolean[] bigArray = new boolean[(d.length+1) * 2];
                int newFirst = bigArray.length / 4;
                for (int i=0; i<length; i++) {
                    bigArray[i + newFirst] = d[i + first];
                }
                first = newFirst;
                d = bigArray;
            }

            public boolean flip(int i) {
                boolean value = (this.d[first+i] ? false : true);
                this.d[first+i] = value;
                return value;
            }

            public void set(int i, char c) {
                boolean value = (c == '1' ? true : false);
                this.d[first+i] = value;
            }

            public char get(int i) {
                return (this.d[first+i] ? '1' : '0');
            }

            @Override
            public int compareTo(Binary o) {
                if (this.length != o.length) return this.length - o.length;
                int len = this.length;
                for (int i=0; i<len; i++) {
                    int diff = this.get(i) - o.get(i);
                    if (diff != 0) return diff;
                }
                return 0;
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<length; i++) {
                    sb.append(d[i+first] ? '1' : '0');
                }
                return sb.toString();
            }


        }

        /************************** 区间查询 **************************/

        class FenwickMin {
            long n;
            long[] original;
            long[] bottomUp;
            long[] topDown;

            public FenwickMin(int n) {
                this.n = n;
                original = new long[n+2];
                bottomUp = new long[n+2];
                topDown = new long[n+2];
            }

            public void set(int modifiedNode, long value) {
                long replaced = original[modifiedNode];
                original[modifiedNode] = value;
                int i = modifiedNode;
                long v = value;
                while (i <= n) {
                    if (v > bottomUp[i]) {
                        if (replaced == bottomUp[i]) {
                            v = Math.min(v, original[i]);
                            for (int r=1 ;; r++) {
                                int x = (i&-i)>>>r;
                                if (x == 0) break;
                                int child = i-x;
                                v = Math.min(v, bottomUp[child]);
                            }
                        } else break;
                    }
                    if (v == bottomUp[i]) break;
                    bottomUp[i] = v;
                    i += (i&-i);
                }
                i = modifiedNode;
                v = value;
                while (i > 0) {
                    if (v > topDown[i]) {
                        if (replaced == topDown[i]) {
                            v = Math.min(v, original[i]);
                            for (int r=1 ;; r++) {
                                int x = (i&-i)>>>r;
                                if (x == 0) break;
                                int child = i+x;
                                if (child > n+1) break;
                                v = Math.min(v, topDown[child]);
                            }
                        } else break;
                    }
                    if (v == topDown[i]) break;
                    topDown[i] = v;
                    i -= (i&-i);
                }
            }

            public long getMin(int a, int b) {
                long min = original[a];
                int prev = a;
                int curr = prev + (prev & -prev); // 父节点的右侧
            
                while (curr <= b) {
                    min = Math.min(min, topDown[prev]); // 来自另一棵树的值
                    prev = curr;
                    curr = prev + (prev & -prev);
                }
            
                min = Math.min(min, original[prev]);
                prev = b;
                curr = prev - (prev & -prev); // 父节点的左侧
            
                while (curr >= a) {
                    min = Math.min(min, bottomUp[prev]); // 来自另一棵树的值
                    prev = curr;
                    curr = prev - (prev & -prev);
                }
            
                return min;
            }
            
        }

        class FenwickSum {
            public long[] d;

            public FenwickSum(int n) {
                d=new long[n+1];
            }

            public FenwickSum(long[] a) {
                d=new long[a.length];
                for (int i=1; i<a.length; i++) {
                    modify(i, a[i]);
                }
            }

                        /** 请勿修改 i=0。 */
            void modify(int i, long v) {
                while (i < d.length) {
                    d[i] += v;
                    // 移动到 i 右侧的下一个上级节点
                    i += (i & -i);
                }
            }

            /** 返回从 a 到 b 的总和，包括 a 和 b 两者。 */
            long getSum(int a, int b) {
                return getSum(b) - getSum(a - 1);
            }


            private long getSum(int i) {
                long sum = 0;
                while (i>0) {
                    sum += d[i];
// 移动到 i 左侧的下一个上级节点
                    i -= (i&-i);
                }
                return sum;
            }
        }

        class SegmentTree {

            /* 提供对以下操作的对数级别复杂度：

            范围查询（求和、最小值或最大值）
            范围更新（将索引为 4 到 94 之间的所有值都增加 8） */

            int N;
            long[] lazy;
            long[] sum;
            long[] min;
            long[] max;
            boolean supportSum;
            boolean supportMin;
            boolean supportMax;

            public SegmentTree(int n) {
                this(n, true, true, true);
            }

            public SegmentTree(int n, boolean supportSum, boolean supportMin, boolean supportMax) {
                for (N=2; N<n;) N*=2;
                this.lazy = new long[2*N];
                this.supportSum = supportSum;
                this.supportMin = supportMin;
                this.supportMax = supportMax;
                if (this.supportSum) this.sum = new long[2*N];
                if (this.supportMin) this.min = new long[2*N];
                if (this.supportMax) this.max = new long[2*N];
            }

            void modifyRange(long x, int a, int b) {
                modifyRec(a, b, 1, 0, N-1, x);
            }

            void setRange() {
                //TODO
            }

            long getSum(int a, int b) {
                return querySum(a, b, 1, 0, N-1);
            }

            long getMin(int a, int b) {
                return queryMin(a, b, 1, 0, N-1);
            }

            long getMax(int a, int b) {
                return queryMax(a, b, 1, 0, N-1);
            }

            private long querySum(int wantedLeft, int wantedRight, int i, int actualLeft, int actualRight) {
                if (wantedLeft > actualRight || wantedRight < actualLeft) {
                    return 0;
                }
                if (wantedLeft == actualLeft && wantedRight == actualRight) {
                    int count = wantedRight - wantedLeft + 1;
                    return sum[i] + count * lazy[i];
                }
                if (lazy[i] != 0) propagate(i, actualLeft, actualRight);
                int d = (actualRight - actualLeft + 1) / 2;
                long left = querySum(wantedLeft, min(actualLeft+d-1, wantedRight), 2*i, actualLeft, actualLeft+d-1);
                long right = querySum(max(actualLeft+d, wantedLeft), wantedRight, 2*i+1, actualLeft+d, actualRight);
                return left + right;
            }

            private long queryMin(int wantedLeft, int wantedRight, int i, int actualLeft, int actualRight) {
                if (wantedLeft > actualRight || wantedRight < actualLeft) {
                    return 0;
                }
                if (wantedLeft == actualLeft && wantedRight == actualRight) {
                    return min[i] + lazy[i];
                }
                if (lazy[i] != 0) propagate(i, actualLeft, actualRight);
                int d = (actualRight - actualLeft + 1) / 2;
                long left = queryMin(wantedLeft, min(actualLeft+d-1, wantedRight), 2*i, actualLeft, actualLeft+d-1);
                long right = queryMin(max(actualLeft+d, wantedLeft), wantedRight, 2*i+1, actualLeft+d, actualRight);
                return min(left, right);
            }

            private long queryMax(int wantedLeft, int wantedRight, int i, int actualLeft, int actualRight) {
                if (wantedLeft > actualRight || wantedRight < actualLeft) {
                    return 0;
                }
                if (wantedLeft == actualLeft && wantedRight == actualRight) {
                    return max[i] + lazy[i];
                }
                if (lazy[i] != 0) propagate(i, actualLeft, actualRight);
                int d = (actualRight - actualLeft + 1) / 2;
                long left = queryMax(wantedLeft, min(actualLeft+d-1, wantedRight), 2*i, actualLeft, actualLeft+d-1);
                long right = queryMax(max(actualLeft+d, wantedLeft), wantedRight, 2*i+1, actualLeft+d, actualRight);
                return max(left, right);
            }

            private void modifyRec(int wantedLeft, int wantedRight, int i, int actualLeft, int actualRight, long value) {
                if (wantedLeft > actualRight || wantedRight < actualLeft) {
                    return;
                }
                if (wantedLeft == actualLeft && wantedRight == actualRight) {
                    lazy[i] += value;
                    return;
                }
                if (lazy[i] != 0) propagate(i, actualLeft, actualRight);
                int d = (actualRight - actualLeft + 1) / 2;
                modifyRec(wantedLeft, min(actualLeft+d-1, wantedRight), 2*i, actualLeft, actualLeft+d-1, value);
                modifyRec(max(actualLeft+d, wantedLeft), wantedRight, 2*i+1, actualLeft+d, actualRight, value);
                if (supportSum) sum[i] += value * (min(actualRight, wantedRight) - max(actualLeft, wantedLeft) + 1);
                if (supportMin) min[i] = min(min[2*i] + lazy[2*i], min[2*i+1] + lazy[2*i+1]);
                if (supportMax) max[i] = max(max[2*i] + lazy[2*i], max[2*i+1] + lazy[2*i+1]);
            }

            private void propagate(int i, int actualLeft, int actualRight) {
                lazy[2*i] += lazy[i];
                lazy[2*i+1] += lazy[i];
                if (supportSum) sum[i] += lazy[i] * (actualRight - actualLeft + 1);
                if (supportMin) min[i] += lazy[i];
                if (supportMax) max[i] += lazy[i];
                lazy[i] = 0;
            }

        }

        /***************************** 图 *****************************/

        List<Integer>[] toGraph(IO io, int n) {
            List<Integer>[] g = new ArrayList[n+1];
            for (int i=1; i<=n; i++) g[i] = new ArrayList<>();
            for (int i=1; i<=n-1; i++) {
                int a = io.nextInt();
                int b = io.nextInt();
                g[a].add(b);
                g[b].add(a);
            }
            return g;
        }

        class Graph {
            HashMap<Long, List<Long>> edges;

            public Graph() {
                edges = new HashMap<>();
            }

            List<Long> getSetNeighbors(Long node) {
                List<Long> neighbors = edges.get(node);
                if (neighbors == null) {
                    neighbors = new ArrayList<>();
                    edges.put(node, neighbors);
                }
                return neighbors;
            }

            void addBiEdge(Long a, Long b) {
                addEdge(a, b);
                addEdge(b, a);
            }

            void addEdge(Long from, Long to) {
                getSetNeighbors(to); 
                List<Long> neighbors = getSetNeighbors(from);
                neighbors.add(to);
            }

            int UNTOUCHED = 0;
            int FINISHED = 2;
            int INPROGRESS = 1;
            HashMap<Long, Integer> vis;
            List<Long> topoAns;
            List<Long> failDueToCycle = new ArrayList<Long>() {{ add(-1L); }};

            List<Long> topoSort() {
                topoAns = new ArrayList<>();
                vis = new HashMap<>();
                for (Long a : edges.keySet()) {
                    if (!topoDFS(a)) return failDueToCycle;
                }
                Collections.reverse(topoAns);
                return topoAns;
            }

            boolean topoDFS(long curr) {
                Integer status = vis.get(curr);
                if (status == null) status = UNTOUCHED;
                if (status == FINISHED) return true;
                if (status == INPROGRESS) {
                    return false;
                }
                vis.put(curr, INPROGRESS);
                for (long next : edges.get(curr)) {
                    if (!topoDFS(next)) return false;
                }
                vis.put(curr, FINISHED);
                topoAns.add(curr);
                return true;
            }

        }

        public class StronglyConnectedComponents {

            /** Kosaraju's algorithm */

            ArrayList<Integer>[] forw;
            ArrayList<Integer>[] bacw;

            /** Use: getCount(2, new int[] {1,2}, new int[] {2,1}) */
            public int getCount(int n, int[] mista, int[] minne) {
                forw = new ArrayList[n+1];
                bacw = new ArrayList[n+1];
                for (int i=1; i<=n; i++) {
                    forw[i] = new ArrayList<Integer>();
                    bacw[i] = new ArrayList<Integer>();
                }
                for (int i=0; i<mista.length; i++) {
                    int a = mista[i];
                    int b = minne[i];
                    forw[a].add(b);
                    bacw[b].add(a);
                }
                int count = 0;
                List<Integer> list = new ArrayList<Integer>();
                boolean[] visited = new boolean[n+1];
                for (int i=1; i<=n; i++) {
                    dfsForward(i, visited, list);
                }
                visited = new boolean[n+1];
                for (int i=n-1; i>=0; i--) {
                    int node = list.get(i);
                    if (visited[node]) continue;
                    count++;
                    dfsBackward(node, visited);
                }
                return count;
            }

            public void dfsForward(int i, boolean[] visited, List<Integer> list) {
                if (visited[i]) return;
                visited[i] = true;
                for (int neighbor : forw[i]) {
                    dfsForward(neighbor, visited, list);
                }
                list.add(i);
            }

            public void dfsBackward(int i, boolean[] visited) {
                if (visited[i]) return;
                visited[i] = true;
                for (int neighbor : bacw[i]) {
                    dfsBackward(neighbor, visited);
                }
            }
        }

        class LCAFinder {

            /* O(n log n) 初始化：new LCAFinder(graph)

            O(log n) 查询：find(a, b) 返回节点 a 和节点 b 的最近公共祖先（Lowest Common Ancestor） */

            int[] nodes;
            int[] depths;
            int[] entries;
            int pointer;
            FenwickMin fenwick;

            public LCAFinder(List<Integer>[] graph) {
                this.nodes = new int[(int)10e6];
                this.depths = new int[(int)10e6];
                this.entries = new int[graph.length];
                this.pointer = 1;
                boolean[] visited = new boolean[graph.length+1];
                dfs(1, 0, graph, visited);
                fenwick = new FenwickMin(pointer-1);
                for (int i=1; i<pointer; i++) {
                    fenwick.set(i, depths[i] * 1000000L + i);
                }
            }

            private void dfs(int node, int depth, List<Integer>[] graph, boolean[] visited) {
                visited[node] = true;
                entries[node] = pointer;
                nodes[pointer] = node;
                depths[pointer] = depth;
                pointer++;
                for (int neighbor : graph[node]) {
                    if (visited[neighbor]) continue;
                    dfs(neighbor, depth+1, graph, visited);
                    nodes[pointer] = node;
                    depths[pointer] = depth;
                    pointer++;
                }
            }

            public int find(int a, int b) {
                int left = entries[a];
                int right = entries[b];
                if (left > right) {
                    int temp = left;
                    left = right;
                    right = temp;
                }
                long mixedBag = fenwick.getMin(left, right);
                int index = (int) (mixedBag % 1000000L);
                return nodes[index];
            }
        }

        /**************************** jiji ****************************/

        class Point {
            int y;
            int x;

            public Point(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }

        boolean segmentsIntersect(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
            // 如果线段1-2与线段3-4相交，则返回true。

            if (x1 == x2 && x3 == x4) {
                if (x1 != x3) return false;
                if (min(y1,y2) < min(y3,y4)) {
                    return max(y1,y2) >= min(y3,y4);
                } else {
                    return max(y3,y4) >= min(y1,y2);
                }
            }
            if (x1 == x2) {
                double a34 = (y4-y3)/(x4-x3);
                double b34 = y3 - a34*x3;
                double y = a34 * x1 + b34;
                return y >= min(y1,y2) && y <= max(y1,y2) && x1 >= min(x3,x4) && x1 <= max(x3,x4);
            }
            if (x3 == x4) {
                
                double a12 = (y2-y1)/(x2-x1);
                double b12 = y1 - a12*x1;
                double y = a12 * x3 + b12;
                return y >= min(y3,y4) && y <= max(y3,y4) && x3 >= min(x1,x2) && x3 <= max(x1,x2);
            }
            double a12 = (y2-y1)/(x2-x1);
            double b12 = y1 - a12*x1;
            double a34 = (y4-y3)/(x4-x3);
            double b34 = y3 - a34*x3;
            if (closeToZero(a12 - a34)) {
                // 平行
                return closeToZero(b12 - b34);
            }
            double x = -(b12-b34)/(a12-a34);
            return x >= min(x1,x2) && x <= max(x1,x2) && x >= min(x3,x4) && x <= max(x3,x4);
        }

        boolean pointInsideRectangle(Point p, List<Point> r, boolean countBorderAsInside) {
            Point a = r.get(0);
            Point b = r.get(1);
            Point c = r.get(2);
            Point d = r.get(3);
            double apd = areaOfTriangle(a, p, d);
            double dpc = areaOfTriangle(d, p, c);
            double cpb = areaOfTriangle(c, p, b);
            double pba = areaOfTriangle(p, b, a);
            double sumOfAreas = apd + dpc + cpb + pba;
            if (closeToZero(sumOfAreas - areaOfRectangle(r))) {
                if (closeToZero(apd) || closeToZero(dpc) || closeToZero(cpb) || closeToZero(pba)) {
                    return countBorderAsInside;
                }
                return true;
            }
            return false;
        }

        double areaOfTriangle(Point a, Point b, Point c) {
            return 0.5 * Math.abs((a.x-c.x)*(b.y-a.y)-(a.x-b.x)*(c.y-a.y));
        }

        double areaOfRectangle(List<Point> r) {
            double side1xDiff = r.get(0).x - r.get(1).x;
            double side1yDiff = r.get(0).y - r.get(1).y;
            double side2xDiff = r.get(1).x - r.get(2).x;
            double side2yDiff = r.get(1).y - r.get(2).y;
            double side1 = Math.sqrt(side1xDiff * side1xDiff + side1yDiff * side1yDiff);
            double side2 = Math.sqrt(side2xDiff * side2xDiff + side2yDiff * side2yDiff);
            return side1 * side2;
        }

        boolean pointsOnSameLine(double x1, double y1, double x2, double y2, double x3, double y3) {
            double areaTimes2 = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
            return (closeToZero(areaTimes2));
        }

        class PointToLineSegmentDistanceCalculator {

            double minDistFromPointToLineSegment(double point_x, double point_y, double x1, double y1, double x2, double y2) {
                return Math.sqrt(distToSegmentSquared(point_x, point_y, x1, y1, x2, y2));
            }

            private double distToSegmentSquared(double point_x, double point_y, double x1, double y1, double x2, double y2) {
                double l2 = dist2(x1,y1,x2,y2);
                if (l2 == 0) return dist2(point_x, point_y, x1, y1);
                double t = ((point_x - x1) * (x2 - x1) + (point_y - y1) * (y2 - y1)) / l2;
                if (t < 0) return dist2(point_x, point_y, x1, y1);
                if (t > 1) return dist2(point_x, point_y, x2, y2);

                double com_x = x1 + t * (x2 - x1);
                double com_y = y1 + t * (y2 - y1);
                return dist2(point_x, point_y, com_x, com_y);
            }

            private double dist2(double x1, double y1, double x2, double y2) {
                return Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
            }

        }

        /****************************** Math ******************************/

        long pow(long base, int exp) {
            if (exp == 0) return 1L;
            long x = pow(base, exp/2);
            long ans = x * x;
            if (exp % 2 != 0) ans *= base;
            return ans;
        }

        long gcd(long... v) {
            if (v.length == 1) return v[0];
            long ans = gcd(v[1], v[0]);
            for (int i=2; i<v.length; i++) {
                ans = gcd(ans, v[i]);
            }
            return ans;
        }

        long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a%b);
        }

        int[] generatePrimesUpTo(int last) {
            /*  筛*/
            int[] div = new int[last+1];
            for (int x=2; x<=last; x++) {
                if (div[x] > 0) continue;
                for (int u=2*x; u<=last; u+=x) {
                    div[u] = x;
                }
            }
            return div;
        }

        long lcm(long a, long b) {
            return a * b / gcd(a,b);
        }

        class BaseConverter {

            /*在指定的进制中返回一个数字的表示形式”*/
            public String convert(Long number, int base) {
                return Long.toString(number, base);
            }

            /* 在给定源进制中，将一个数字作为字符串表示时，返回其在目标进制中的表示形式 */
            public String convert(String number, int baseFrom, int baseTo) {
                return Long.toString(Long.parseLong(number, baseFrom), baseTo);
            }

            /* 将以特定进制(base)表示的数字转换为十进制(long)*/
            public long longify(String number, int baseFrom) {
                return Long.parseLong(number, baseFrom);
            }
        }

        class BinomialCoefficients {
            /** 这段代码计算从一个大小为N的池中选取K个不重复元素的组合的总数（无序）：
            N! / ( K! (N - K)! )   */

        /** 对于简单的查询，其中输出适合使用long类型存储的情况。 */
            public long biCo(long n, long k) {
                long r = 1;
                if (k > n) return 0;
                for (long d = 1; d <= k; d++) {
                    r *= n--;
                    r /= d;
                }
                return r;
            }

            /**处理多个查询，其中n相同但k不同的情况 */
            public long[] precalcBinomialCoefficientsK(int n, int maxK) {
                long v[] = new long[maxK+1];
                v[0] = 1; // nC0 == 1
                for (int i=1; i<=n; i++) {
                    for (int j=Math.min(i,maxK); j>0; j--) {
                        v[j] = v[j] + v[j-1]; // Pascal's 三角
                    }
                }
                return v;
            }

            /** % MOD. */
            public long[] precalcBinomialCoefficientsK(int n, int k, long M) {
                long v[] = new long[k+1];
                v[0] = 1; // nC0 == 1
                for (int i=1; i<=n; i++) {
                    for (int j=Math.min(i,k); j>0; j--) {
                        v[j] = v[j] + v[j-1]; // Pascal's triangle
                        v[j] %= M;
                    }
                }
                return v;
            }
        }

        /**************************** Strings ****************************/

        class Zalgo {

            public int pisinEsiintyma(String haku, String kohde) {
                char[] s = new char[haku.length() + 1 + kohde.length()];
                for (int i=0; i<haku.length(); i++) {
                    s[i] = haku.charAt(i);
                }
                int j = haku.length();
                s[j++] = '#';
                for (int i=0; i<kohde.length(); i++) {
                    s[j++] = kohde.charAt(i);
                }
                int[] z = toZarray(s);
                int max = 0;
                for (int i=haku.length(); i<z.length; i++) {
                    max = Math.max(max, z[i]);
                }
                return max;
            }

            public int[] toZarray(char[] s) {
                int n = s.length;
                int[] z = new int[n];
                int a = 0, b = 0;
                for (int i = 1; i < n; i++) {
                    if (i > b) {
                        for (int j = i; j < n && s[j - i] == s[j]; j++)  z[i]++;
                    }
                    else {
                        z[i] = z[i - a];
                        if (i + z[i - a] > b) {
                            for (int j = b + 1; j < n && s[j - i] == s[j]; j++) z[i]++;
                            a = i;
                            b = i + z[i] - 1;
                        }
                    }
                }
                return z;
            }

            public List<Integer> getStartIndexesWhereWordIsFound(String haku, String kohde) {
                // alternative
                char[] s = new char[haku.length() + 1 + kohde.length()];
                for (int i=0; i<haku.length(); i++) {
                    s[i] = haku.charAt(i);
                }
                int j = haku.length();
                s[j++] = '#';
                for (int i=0; i<kohde.length(); i++) {
                    s[j++] = kohde.charAt(i);
                }
                int[] z = toZarray(s);
                List<Integer> indexes = new ArrayList<>();
                for (int i=haku.length(); i<z.length; i++) {
                    if (z[i] < haku.length()) continue;
                    indexes.add(i);
                }
                return indexes;
            }

        }

        class StringHasher {

            class HashedString {
                long[] hashes;
                long[] modifiers;

                public HashedString(long[] hashes, long[] modifiers) {
                    this.hashes = hashes;
                    this.modifiers = modifiers;
                }
            }

            long P;
            long M;

            public StringHasher() {
                initializePandM();
            }

            HashedString hashString(String s) {
                int n = s.length();
                long[] hashes = new long[n];
                long[] modifiers = new long[n];
                hashes[0] = s.charAt(0);
                modifiers[0] = 1;
                for (int i=1; i<n; i++) {
                    hashes[i] = (hashes[i-1] * P + s.charAt(i)) % M;
                    modifiers[i] = (modifiers[i-1] * P) % M;
                }
                return new HashedString(hashes, modifiers);
            }

            /**
             * 包括index.
             */
            long getHash(HashedString hashedString, int startIndex, int endIndex) {
                long[] hashes = hashedString.hashes;
                long[] modifiers = hashedString.modifiers;
                long result = hashes[endIndex];
                if (startIndex > 0) result -= (hashes[startIndex-1] * modifiers[endIndex-startIndex+1]) % M;
                if (result < 0) result += M;
                return result;
            }

            



           
            HashedString[] hashString(String first, String second) {
                HashedString[] array = new HashedString[2];
                int n = first.length();
                long[] modifiers = new long[n];
                modifiers[0] = 1;

                long[] firstHashes = new long[n];
                firstHashes[0] = first.charAt(0);
                array[0] = new HashedString(firstHashes, modifiers);

                long[] secondHashes = new long[n];
                secondHashes[0] = second.charAt(0);
                array[1] = new HashedString(secondHashes, modifiers);

                for (int i=1; i<n; i++) {
                    modifiers[i] = (modifiers[i-1] * P) % M;
                    firstHashes[i] = (firstHashes[i-1] * P + first.charAt(i)) % M;
                    secondHashes[i] = (secondHashes[i-1] * P + second.charAt(i)) % M;
                }
                return array;
            }

         
            HashedString[] hashString(String... strings) {
                HashedString[] array = new HashedString[strings.length];
                int n = strings[0].length();
                long[] modifiers = new long[n];
                modifiers[0] = 1;
                for (int j=0; j<strings.length; j++) {
                    if (strings[j].length() != n) {
                        for (int i=0; i<n; i++) {
                            array[i] = hashString(strings[i]);
                        }
                        return array;
                    }

                    long[] hashes = new long[n];
                    hashes[0] = strings[j].charAt(0);
                    array[j] = new HashedString(hashes, modifiers);
                }
                for (int i=1; i<n; i++) {
                    modifiers[i] = (modifiers[i-1] * P) % M;
                    for (int j=0; j<strings.length; j++) {
                        String s = strings[j];
                        long[] hashes = array[j].hashes;
                        hashes[i] = (hashes[i-1] * P + s.charAt(i)) % M;
                    }
                }
                return array;
            }

            void initializePandM() {
                ArrayList<Long> modOptions = new ArrayList<>(20);
                modOptions.add(353873237L);
                modOptions.add(353875897L);
                modOptions.add(353878703L);
                modOptions.add(353882671L);
                modOptions.add(353885303L);
                modOptions.add(353888377L);
                modOptions.add(353893457L);
                P = modOptions.get(new Random().nextInt(modOptions.size()));

                modOptions.clear();
                modOptions.add(452940277L);
                modOptions.add(452947687L);
                modOptions.add(464478431L);
                modOptions.add(468098221L);
                modOptions.add(470374601L);
                modOptions.add(472879717L);
                modOptions.add(472881973L);
                M = modOptions.get(new Random().nextInt(modOptions.size()));

            }
        }

        int editDistance(String a, String b) {
            a = "#"+a;
            b = "#"+b;
            int n = a.length();
            int m = b.length();
            int[][] dp = new int[n+1][m+1];
            for (int y=0; y<=n; y++) {
                for (int x=0; x<=m; x++) {
                    if (y == 0) dp[y][x] = x;
                    else if (x == 0) dp[y][x] = y;
                    else {
                        int e1 = dp[y-1][x] + 1;
                        int e2 = dp[y][x-1] + 1;
                        int e3 = dp[y-1][x-1] + (a.charAt(y-1) != b.charAt(x-1) ? 1 : 0);
                        dp[y][x] = min(e1, e2, e3);
                    }
                }
            }
            return dp[n][m];
        }

        /*************************** Technical ***************************/

        private class IO extends PrintWriter {
            private InputStreamReader r;
            private static final int BUFSIZE = 1 << 15;
            private char[] buf;
            private int bufc;
            private int bufi;
            private StringBuilder sb;

            public IO() {
                super(new BufferedOutputStream(System.out));
                r = new InputStreamReader(System.in);

                buf = new char[BUFSIZE];
                bufc = 0;
                bufi = 0;
                sb = new StringBuilder();
            }

            private int queryInt(String s) {
                io.println(s);
                io.flush();
                return nextInt();
            }

            private long queryLong(String s) {
                io.println(s);
                io.flush();
                return nextLong();
            }

            private String queryNext(String s) {
                io.println(s);
                io.flush();
                return next();
            }

            private void fillBuf() throws IOException {
                bufi = 0;
                bufc = 0;
                while(bufc == 0) {
                    bufc = r.read(buf, 0, BUFSIZE);
                    if(bufc == -1) {
                        bufc = 0;
                        return;
                    }
                }
            }

            private boolean pumpBuf() throws IOException {
                if(bufi == bufc) {
                    fillBuf();
                }
                return bufc != 0;
            }

            private boolean isDelimiter(char c) {
                return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f';
            }

            private void eatDelimiters() throws IOException {
                while(true) {
                    if(bufi == bufc) {
                        fillBuf();
                        if(bufc == 0) throw new RuntimeException("IO: Out of input.");
                    }

                    if(!isDelimiter(buf[bufi])) break;
                    ++bufi;
                }
            }

            public String next() {
                try {
                    sb.setLength(0);

                    eatDelimiters();
                    int start = bufi;

                    while(true) {
                        if(bufi == bufc) {
                            sb.append(buf, start, bufi - start);
                            fillBuf();
                            start = 0;
                            if(bufc == 0) break;
                        }

                        if(isDelimiter(buf[bufi])) break;
                        ++bufi;
                    }

                    sb.append(buf, start, bufi - start);

                    return sb.toString();
                } catch(IOException e) {
                    throw new RuntimeException("IO.next: Caught IOException.");
                }
            }

            public int nextInt() {
                try {
                    int ret = 0;

                    eatDelimiters();

                    boolean positive = true;
                    if(buf[bufi] == '-') {
                        ++bufi;
                        if(!pumpBuf()) throw new RuntimeException("IO.nextInt: Invalid int.");
                        positive = false;
                    }

                    boolean first = true;
                    while(true) {
                        if(!pumpBuf()) break;
                        if(isDelimiter(buf[bufi])) {
                            if(first) throw new RuntimeException("IO.nextInt: Invalid int.");
                            break;
                        }
                        first = false;

                        if(buf[bufi] >= '0' && buf[bufi] <= '9') {
                            if(ret < -214748364) throw new RuntimeException("IO.nextInt: Invalid int.");
                            ret *= 10;
                            ret -= (int)(buf[bufi] - '0');
                            if(ret > 0) throw new RuntimeException("IO.nextInt: Invalid int.");
                        } else {
                            throw new RuntimeException("IO.nextInt: Invalid int.");
                        }

                        ++bufi;
                    }

                    if(positive) {
                        if(ret == -2147483648) throw new RuntimeException("IO.nextInt: Invalid int.");
                        ret = -ret;
                    }

                    return ret;
                } catch(IOException e) {
                    throw new RuntimeException("IO.nextInt: Caught IOException.");
                }
            }

            public long nextLong() {
                try {
                    long ret = 0;

                    eatDelimiters();

                    boolean positive = true;
                    if(buf[bufi] == '-') {
                        ++bufi;
                        if(!pumpBuf()) throw new RuntimeException("IO.nextLong: Invalid long.");
                        positive = false;
                    }

                    boolean first = true;
                    while(true) {
                        if(!pumpBuf()) break;
                        if(isDelimiter(buf[bufi])) {
                            if(first) throw new RuntimeException("IO.nextLong: Invalid long.");
                            break;
                        }
                        first = false;

                        if(buf[bufi] >= '0' && buf[bufi] <= '9') {
                            if(ret < -922337203685477580L) throw new RuntimeException("IO.nextLong: Invalid long.");
                            ret *= 10;
                            ret -= (long)(buf[bufi] - '0');
                            if(ret > 0) throw new RuntimeException("IO.nextLong: Invalid long.");
                        } else {
                            throw new RuntimeException("IO.nextLong: Invalid long.");
                        }

                        ++bufi;
                    }

                    if(positive) {
                        if(ret == -9223372036854775808L) throw new RuntimeException("IO.nextLong: Invalid long.");
                        ret = -ret;
                    }

                    return ret;
                } catch(IOException e) {
                    throw new RuntimeException("IO.nextLong: Caught IOException.");
                }
            }

            public double nextDouble() {
                return Double.parseDouble(next());
            }

        }

        void print(Object output) {
            io.println(output);
        }

        void done(Object output) {
            print(output);
            done();
        }

        void done() {
            io.close();
            throw new RuntimeException("Clean exit");
        }

        long min(long... v) {
            long ans = v[0];
            for (int i=1; i<v.length; i++) {
                ans = Math.min(ans, v[i]);
            }
            return ans;
        }

        double min(double... v) {
            double ans = v[0];
            for (int i=1; i<v.length; i++) {
                ans = Math.min(ans, v[i]);
            }
            return ans;
        }

        int min(int... v) {
            int ans = v[0];
            for (int i=1; i<v.length; i++) {
                ans = Math.min(ans, v[i]);
            }
            return ans;
        }

        long max(long... v) {
            long ans = v[0];
            for (int i=1; i<v.length; i++) {
                ans = Math.max(ans, v[i]);
            }
            return ans;
        }

        double max(double... v) {
            double ans = v[0];
            for (int i=1; i<v.length; i++) {
                ans = Math.max(ans, v[i]);
            }
            return ans;
        }

        int max(int... v) {
            int ans = v[0];
            for (int i=1; i<v.length; i++) {
                ans = Math.max(ans, v[i]);
            }
            return ans;
        }

    }

}

