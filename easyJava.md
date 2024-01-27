

##### 二分：

```java

int binarySearch(int[] arr, int target) {
        int res = arr.length;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
/*
传入的是x就是找大于等于x的位置
x+1就是大于x的位置
if里相对于right是>=
此时left+1=right
*/

/*二分dp
给你一份工作时间表 `hours`，上面记录着某一位员工每天的工作小时数。

我们认为当员工一天中的工作小时数大于 `8` 小时的时候，那么这一天就是「**劳累的一天**」。

所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 **大于**「不劳累的天数」。

请你返回「表现良好时间段」的最大长度。

**示例 1：**


输入：hours = [9,9,6,0,6,6,9]
输出：3
解释：最长的表现良好时间段是 [9,9,6]。
*/
    int n;

    public int longestWPI(int[] hours) {
        n = hours.length;
        int[] sum = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
            dp[i] = Math.min(dp[i - 1], sum[i]);
        }
        int l = -1, r = n+1;
        while (l +1 < r) {
            int mid =( (l + r)>> 1);
            if (check(sum, dp, mid+1)) l = mid;
            else r = mid;
        }
        return r;
    }

    private boolean check(int[] sum, int[] dp, int len) {
        for (int i = len; i <= n; i++) {
            if (sum[i] - dp[i - len] > 0) return true;
        }
        return false;
    }

```
#### 滑动窗口
```java
 public long continuousSubarrays(int[] nums) {
        TreeMap<Integer,Integer>tr=new TreeMap<>();
        long res=0;
        int n=nums.length;
        for(int l=0, r=0; r<n; r++){
            tr.compute(nums[r],(key,val)->(val==null?1:val+1));
            while(tr.lastKey()-tr.firstKey()>2){
                tr.compute(nums[l++],(key,val)->(val==1?null:val-1));
            }
            res+=r-l+1;
        }
        return res;
    }
```


##### 数位dp:

```java
int solv(int i,int mask,boolean isLimit,boolean isNum){
    if(i==s.length){
        return isNum?1:0;
    }
    if(!isLimit && isNum &&dp[i][mask]!=-1){
        return dp[i][mask];
    }
    int res=0;
    if(!isNum){
        res=solv(i+1,mask,false,false);
    }
    int up=isLimit?s[i]-'0':9;
    System.out.println(up);
    for(int d=isNum?0:1;d<=up;d++){
        if((mask>>d&1)==0)res+=solv(i+1,mask|(1<<d),isLimit&&d==up,true);

    }
    if(!isLimit&&isNum)dp[i][mask]=res;
    return res;
}
/*

i:表示正在处理第几位数
mask：表示数的约束情况比如不能相邻只会有某id位有数，比如各位数不一样前idx的数都要在mask数位上变成一
isNum：是否是一个数比如不能是0开头
isLimit：是否被最大数限制
*/
"前n-1位数的和可以被最后一位整除的个数"
 long[][]dp=new long[10][205];
    char []s;
    int mod=998244353;
    A(ac in){
        String l=in.next(),r=in.next();
        long ans=cal(r);ans-=cal(l);
        long sum=0;
        for(int i=0;i<l.length()-1;i++){
            char c=l.charAt(i);
            sum+=c-'0';
        }
        if(l.charAt(l.length()-1)!='0'&&sum%(l.charAt(l.length()-1)-'0')==0)ans++;
        in.println((ans%mod+mod)%mod);
        
    }
    long cal(String t){
        
        s=t.toCharArray();
        long res=0L;
        for(int op=1;op<=9;op++){
            for(int i=0;i<10;i++)Arrays.fill(dp[i],-1);
             res=(res+solv(0, 0, true, false,op,0))%mod;
        }
           
        return res%mod;
    }
    long solv(int i,int mask,boolean isLimit,boolean isNum,int op,int yu){
        int n=s.length;
        if(i==s.length-1){
           // return isNum?1:0;
           if(!isNum)return 0;
           if(isLimit&&op>s[i]-'0')return 0;
           return yu%op==0?1:0;
        }
        if(!isLimit && isNum &&dp[yu][i]>=0){
            return dp[yu][i];
        }
        long res=0;
        if(!isNum){
            res=solv(i+1,0,false,false,op,yu);
        }
        int up=isLimit?s[i]-'0':9;
       // System.out.println(up);
        for(int d=isNum?0:1;d<=up;d++){
            if((mask>>d&1)==0)res+=solv(i+1,0,isLimit&&d==up,true,op,(yu+d)%op);
            res%=mod;
        }
        if(!isLimit&&isNum)dp[yu][i]=res;
        return res;
    }
```

#### dijkstra

```java
int n,m;
boolean vis[][];
int add[]={1,0,-1,0,1};

public int minimumEffortPath(int[][] heights) {
    n=heights.length;m=heights[0].length;
    vis=new boolean[n][m];
    
    PriorityQueue<int[]>pq=new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
    
    int[][]dis=new int[n][m];
    for(int i=0;i<n;i++){
        Arrays.fill(dis[i],Integer.MAX_VALUE);
    }
    dis[0][0]=0;
    pq.offer(new int[]{0,0,0});
    while(!pq.isEmpty()){
        
        var p=pq.poll();
        int x=p[0],y=p[1],w=p[2];
        if(vis[x][y])continue;
        if(x==n-1&&y==m-1)break;
        for(int i=0;i<4;i++){
            int nx=x+add[i];int ny=y+add[i+1];
            
            if(nx<0||nx>=n||ny<0||ny>=m||vis[nx][ny])continue;

            if(Math.max(w,Math.abs(heights[nx][ny]-heights[x][y]))<dis[nx][ny]){

                dis[nx][ny]=Math.max(w,Math.abs(heights[nx][ny]-heights[x][y]));

                pq.offer(new int[]{nx,ny,dis[nx][ny]});
            }

        }
    }
    return dis[n-1][m-1];
}
----------------------------------------------------------------
int N=105;int M=6005;
int idx=0;
int he[]=new int[N];int e[]=new int[M];int ne[]=new int[M];int w[]=new int[M];
void add(int u,int v,int c){
    w[idx]=c;
    e[idx]=v;ne[idx]=he[u];he[u]=idx++;
}

boolean vis[];int dis[];
public int networkDelayTime(int[][] times, int n, int k){
    Arrays.fill(he,-1);
    for(var t:times){
        add(t[0],t[1],t[2]);
    }

    PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[1]-b[1]));
    vis=new boolean[n+1];dis=new int[n+1];
    Arrays.fill(vis,false);
    Arrays.fill(dis,Integer.MAX_VALUE);

    pq.offer(new int[]{k,0});

    dis[k]=0;
    while(!pq.isEmpty()){
        var tmp=pq.poll();
        int u=tmp[0];int wsm=tmp[1];
        if(vis[u])continue;
        vis[u]=true;

        for(int i=he[u];i!=-1;i=ne[i]){
            int v=e[i];
            if(dis[v]>dis[u]+w[i]){
                dis[v]=dis[u]+w[i];
                pq.offer(new int[]{v,dis[v]});
            }
        }
    }       
    int res=0;
    for(int i=1;i<=n;i++){

        res=Math.max(dis[i],res);
    }
    return res==Integer.MAX_VALUE?-1:res;
}
```

```java
//从k出发到达到达i至少需要dis[i]时间
class Solution {
    int N = 110, M = 6010;
    // 邻接表
    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
    int[] dist = new int[N];
    // 记录哪一个点「已在队列」中
    boolean[] vis = new boolean[N];
    int INF = 0x3f3f3f3f;
    int n, k, idx;
    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }
    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n; k = _k;
        // 初始化链表头
        Arrays.fill(he, -1);
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            add(u, v, c);
        }
        // 最短路
        spfa();
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }
    void spfa() {
        // 起始先将所有的点标记为「未入队」和「距离为正无穷」
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;
        // 使用「双端队列」存储，存储的是点编号
        Deque<Integer> d = new ArrayDeque<>();
        // 将「源点/起点」进行入队，并标记「已入队」
        d.addLast(k);
        vis[k] = true;
        while (!d.isEmpty()) {
            // 每次从「双端队列」中取出，并标记「未入队」
            int poll = d.pollFirst();
            vis[poll] = false;
            // 尝试使用该点，更新其他点的最短距离
            // 如果更新的点，本身「未入队」则加入队列中，并标记「已入队」
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[poll] + w[i]) {
                    dist[j] = dist[poll] + w[i];
                    if (vis[j]) continue;
                    d.addLast(j);
                    vis[j] = true;
                }
            }
        }
    }
}

```


##### 最大团（最大完全图的点的集合）:

```cpp
int n,m;
bool G[N][N];
int cnt[N];//cnt[i]为>=i的最大团点数
int group[N];//最大团的点
int vis[N];//记录点的位置
int res;//最大团的数目
bool dfs(int pos,int num){//num为当前独立集中的点数
    for(int i=pos+1;i<=n;i++){
        if(cnt[i]+num<=res)//剪枝，若取i但cnt[i]+已经取了的点数仍<ans
            return false;
 
        if(G[pos][i]){//与当前团中元素比较，取Non-N(i)
            int j;
            for(j=0;j<num;j++)
                if(!G[i][vis[j]])
                    break;
            if(j==num){//若为空，则皆与i相邻，则此时将i加入到最大团中
                vis[num]=i;
                if(dfs(i,num+1))
                    return true;
            }
        }
    }
 
    if(num>res){//每添加一个点最多使最大团数+1,后面的搜索就没有意义了
        for(int i=0;i<num;i++)//最大团的元素
            group[i]=vis[i];
        res=num;//最大团中点的数目
        return true;
    }
    return false;
}
void maxClique(){
    res=-1;
    for(int i=n;i>0;i--){//枚举所有点
        vis[0]=i;
        dfs(i,1);
        cnt[i]=res;
    }
}

int main(){
    int T;
    scanf("%d",&T);
    while(T--){
        memset(G,0,sizeof(G));
 
        scanf("%d%d",&n,&m);
        for(int i=0;i<m;i++){
            int x,y;
            scanf("%d%d",&x,&y);
            G[x][y]=1;
            G[y][x]=1;
        }
 
        //建立反图
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j)
                    G[i][j]=0;
                else
                    G[i][j]^=1;
            }
        }
        maxClique();
 
        if(res<0)
            res=0;
        printf("%d\n",res);//最大团的个数
        for(int i=0;i<res;i++)//最大团中的顶点
            printf("%d ",group[i]);
        printf("\n");
    }
    return 0;
}
```

##### 拓扑排序（有向无环图课程表为例）

```java
public boolean canFinish(int n, int[][] pre  ) {
        int deg[]=new int[n];
        Queue <Integer>q=new ArrayDeque<>();
        ArrayList<Integer>gra[]=new ArrayList[n];
        Arrays.setAll(gra,(i->new ArrayList<>()));
        for(int []p:pre){
            gra[p[0]].add(p[1]);
            deg[p[1]]++;
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(deg[i]==0){
                q.offer(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:gra[u]){
                deg[v]--;
                if(deg[v]==0){q.offer(v);count++;}
            }
        }
        return count==n?true:false;

   }
```
#### 内向基环树
```java
/*
一个公司准备组织一场会议，邀请名单上有 `n` 位员工。公司准备了一张 **圆形** 的桌子，可以坐下 **任意数目** 的员工。

员工编号为 `0` 到 `n - 1` 。每位员工都有一位 **喜欢** 的员工，每位员工 **当且仅当** 他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 **不会** 是他自己。

给你一个下标从 **0** 开始的整数数组 `favorite` ，其中 `favorite[i]` 表示第 `i` 位员工喜欢的员工。请你返回参加会议的 **最多员工数目** 。
*/
class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int f : favorite) {
            deg[f]++; // 统计基环树每个节点的入度
        }

        List<Integer>[] rg = new List[n]; // 反图
        Arrays.setAll(rg, e -> new ArrayList<>());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) { // 拓扑排序，剪掉图上所有树枝
            int x = q.poll();
            int y = favorite[x]; // x 只有一条出边
            rg[y].add(x);
            if (--deg[y] == 0) {
                q.add(y);
            }
        }

        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) continue;

            // 遍历基环上的点
            deg[i] = 0; // 将基环上的点的入度标记为 0，避免重复访问
            int ringSize = 1; // 基环长度
            for (int x = favorite[i]; x != i; x = favorite[x]) {
                deg[x] = 0; // 将基环上的点的入度标记为 0，避免重复访问
                ringSize++;
            }

            if (ringSize == 2) { // 基环长度为 2
                sumChainSize += rdfs(i, rg) + rdfs(favorite[i], rg); // 累加两条最长链的长度
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize); // 取所有基环长度的最大值
            }
        }
        return Math.max(maxRingSize, sumChainSize);
    }

    // 通过反图 rg 寻找树枝上最深的链
    private int rdfs(int x, List<Integer>[] rg) {
        int maxDepth = 1;
        for (int son : rg[x]) {
            maxDepth = Math.max(maxDepth, rdfs(son, rg) + 1);
        }
        return maxDepth;
    }
}

```
#### 最近公共祖先+树上倍增



```java

class TreeAncestor {
    private int[] depth;
    private int[][] pa;

    public TreeAncestor(int[][] edges) {
        int n = edges.length + 1;
        int m = 32 - Integer.numberOfLeadingZeros(n); // n 的二进制长度
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) { // 节点编号从 0 开始
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        depth = new int[n];
        pa = new int[n][m];
        dfs(g, 0, -1);

        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }

    private void dfs(List<Integer>[] g, int x, int fa) {
        pa[x][0] = fa;
        for (int y : g[x]) {
            if (y != fa) {
                depth[y] = depth[x] + 1;
                dfs(g, y, x);
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (; k > 0; k &= k - 1)
            node = pa[node][Integer.numberOfTrailingZeros(k)];
        return node;
    }

    public int getLCA(int x, int y) {
        if (depth[x] > depth[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        // 使 y 和 x 在同一深度
        y = getKthAncestor(y, depth[y] - depth[x]);
        if (y == x)
            return x;
        for (int i = pa[x].length - 1; i >= 0; i--) {
            int px = pa[x][i], py = pa[y][i];
            if (px != py) {
                x = px;
                y = py;
            }
        }
        return pa[x][0];
    }
}

```


##### 线性筛

```java

    static int N=(int)1e6+5;
    static int p[]=new int[N+100];//i的最小素因子
    static int tot;
    static int pr[]=new int[N/5];//第i个素数是谁
    static int n= (int)1e6;
    static{
        for(int i=2;i<=n;i++){
            if(p[i]==0){p[i]=i;pr[++tot]=i;}
            for(int j=1;j<=tot&&pr[j]*i<=n;j++){
                p[i*pr[j]]=pr[j];
                if(i%pr[j]==0)break;
            }
        }
    }
```

##### 快速幂

```java
long fasterPow(long a,long n,long mod){
        long ans=1;
        a%=mod;
        while(n>0){
            if((n&1)==1)ans=(ans*a)%mod;
            a=(a*a)%mod;
            n>>=1;
        }
        return ans;
    } 
```
##### 最大公约数
```java
    public static int gcd (int a,int b) {
        int c;
        while (b!=0) {
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
```

#### Lazy线段树

```java
static
    class LazySegmentTree {

        int l, r;

        long val;
        long cnt;

        LazySegmentTree left, right;
        long change = 0;

        public LazySegmentTree(int l, int r) {
            this.l = l;
            this.r = r;
            if (l == r) {
                this.val = 0;
            } else {
                int m = l + (r - l) / 2;
                this.left = new LazySegmentTree(l, m);
                this.right = new LazySegmentTree(m + 1, r);
                this.val = 0;
            }
        }

        void update(int ul, int ur, int d) {
            if (isLeaf()) {
                this.change += d;
                this.handleLeaf();
                return;
            }

            if (ul <= this.l && ur >= this.r) {
                this.change += d;
                return;
            }

            pushdown();

            int m = this.l + (this.r - this.l) / 2;
            if (ur <= m) {
                this.left.update(ul, ur, d);
            } else if (ul > m) {
                this.right.update(ul, ur, d);
            } else {
                this.left.update(ul, m, d);
                this.right.update(m + 1, ur, d);
            }

            this.cnt = (this.left.getCnt() + this.right.getCnt()) % mod;
            this.val = (this.left.getValue() + this.right.getValue()) % mod;
        }

        void pushdown() {
            if (this.change > 0) {
                if (this.left != null) {
                    this.left.change += this.change;
                }
                if (this.right != null) {
                    this.right.change += this.change;
                }
                this.change = 0;
            }
        }

        public long query(int ql, int qr) {
            if (isLeaf()) {
                this.handleLeaf();
                return this.val;
            }

            if (ql <= this.l && qr >= this.r) {
                return this.getValue();
            }

            int m = this.l + (this.r - this.l) / 2;
            if (ql <= m && qr > m) {
                long val1 = this.left.query(ql, m);
                long val2 = this.right.query(m + 1, qr);
                return (val1 + val2) % mod;
            } else if (qr <= m) {
                return this.left.query(ql, qr);
            } else if (ql > m) {
                return this.right.query(Math.max(ql, m + 1), qr);
            }
            return this.getValue();
        }

        boolean isLeaf() {
            return this.l == this.r;
        }

        long getCnt() {
            if (isLeaf()) {
                this.handleLeaf();
                return this.cnt;
            }
            return (this.cnt + (r - l + 1) * this.change % mod) % mod;
        }

        long getValue() {
            if (isLeaf()) {
                handleLeaf();
                return this.val;
            } else {
                long r2 = change * change % mod * (r - l + 1) % mod;
                long s1 = this.val;
                long s2 = 2l * this.change % mod * cnt % mod;
                return (s1 + s2 + r2) % mod;
            }
        }

        void handleLeaf() {
            if (this.change > 0) {
                this.cnt += this.change;
                this.val = this.cnt * this.cnt % mod;
                this.change = 0;
            }
        }

    }

作者：珂朵莉
链接：https://leetcode.cn/circle/discuss/uqQfqX/

```







#### 树状数组

```java 

给你一个整数数组 `nums` 和一个整数 `k` 。

找到 `nums` 中满足以下要求的最长子序列：

-   子序列 **严格递增**
-   子序列中相邻元素的差值 **不超过** `k` 。

请你返回满足上述要求的 **最长子序列** 的长度。

**子序列** 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。

**示例 1：**


输入：nums = [4,2,1,4,3,4,5,8,15], k = 3
输出：5
解释：
满足要求的最长子序列是 [1,3,4,5,8] 。
子序列长度为 5 ，所以我们返回 5 。
注意子序列 [1,3,4,5,8,15] 不满足要求，因为 15 - 8 = 7 大于 3 


 public int lengthOfLIS(int[] nums, int k) {
        int cup = 0;
        for(int num:nums){
            cup = Math.max(cup, num);
        }
        int[] h = new int[cup + 1], values = new int[cup + 1];
        for (int num : nums) {
            int v = query(Math.max(1, num - k), num - 1, h, values) + 1;
            values[num] = v;
            update(num, h, values);
        }
        return query(1, cup, h, values);
    }

    private void update(int num, int[] h, int[] values) {
        int lx = num, n = values.length;
        while(num < n) {
            h[num] = Math.max(h[num], values[lx]);
            num += lowBit(num);
        }
    }
    //区间最值
    private int query(int l, int r, int[] h, int[] values) {
        int ans = 0;
        while(r >= l){
            ans = Math.max(values[r], ans);
            r--;
            for(; r - lowBit(r) >= l; r -= lowBit(r)){
                ans = Math.max(h[r], ans);
            }
        }
        return ans;
    }

    private int lowBit(int x){
        return x & -x;
    }
```

#### tanjan

```java
    //关键节点
    int id=0;List<List<Integer>>res;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        List<Integer>[]adt=new ArrayList[n];
        for(int i=0;i<n;i++)adt[i]=new ArrayList<>();
        for(var lis:con){
            int u=lis.get(0);int v=lis.get(1);
            adt[u].add(v);adt[v].add(u);
        }
        res=new ArrayList<>();
        int dfn[]=new int[n];int low[]=new int[n];
        
        dfs(0,0,adt,dfn,low);
        return res;
    }
    void dfs(int u,int p,List<Integer>[] adt,int []dfn,int [] low){
        low[u]=dfn[u]=++id;
        for(int v:adt[u]){
            if(dfn[v]==0){
                dfs(v,u,adt,dfn,low);
                low[u]=Math.min(low[u],low[v]);
                if(low[v]>dfn[u])res.add(Arrays.asList(u,v));
            }
            else if(dfn[v]<dfn[u] && v !=p){
                low[u]=Math.min(low[u],dfn[v]);
            }
        }
    }
```

#### 最大流最小费用

```java
static class MinCostFlowAlgorithm {

    static
    public class Edge {
        public int from, to;
        public int capacity;
        public long cost;
        public int flow;
        public Edge complement;
        // public int iniflow;

        public Edge(int from, int to, int capacity, long cost) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge [from=" + from + ", to=" + to + ", capacity="
                    + capacity + ", cost=" + cost + "]";
        }
    }

    public static Edge[][] compileWD(int n, List<Edge> edges) {
        Edge[][] g = new Edge[n][];
        // cloning
        for (int i = edges.size() - 1; i >= 0; i--) {
            Edge origin = edges.get(i);
            Edge clone = new Edge(origin.to, origin.from, origin.capacity, -origin.cost);
            clone.flow = origin.capacity;
            clone.complement = origin;
            origin.complement = clone;
            edges.add(clone);
        }

        int[] p = new int[n];
        for (Edge e : edges) p[e.from]++;
        for (int i = 0; i < n; i++) g[i] = new Edge[p[i]];
        for (Edge e : edges) g[e.from][--p[e.from]] = e;
        return g;
    }

    public long solveMinCostFlow(Edge[][] g, int source, int sink, long all) {
        int n = g.length;
        long mincost = 0;
        long[] potential = new long[n];

        final long[] d = new long[n];
        MinHeapL q = new MinHeapL(n);
        while (all > 0) {
            // shortest path src->sink
            Edge[] inedge = new Edge[n];
            Arrays.fill(d, Long.MAX_VALUE / 2);
            d[source] = 0;
            q.add(source, 0);
            while (q.size() > 0) {
                int cur = q.argmin();
                q.remove(cur);
                for (Edge ne : g[cur]) {
                    if (ne.capacity - ne.flow > 0) {
                        long nd = d[cur] + ne.cost + potential[cur] - potential[ne.to];
                        if (d[ne.to] > nd) {
                            inedge[ne.to] = ne;
                            d[ne.to] = nd;
                            q.update(ne.to, nd);
                        }
                    }
                }
            }

            if (inedge[sink] == null) break;

            long minflow = all;
            long sumcost = 0;
            for (Edge e = inedge[sink]; e != null; e = inedge[e.from]) {
                if (e.capacity - e.flow < minflow) minflow = e.capacity - e.flow;
                sumcost += e.cost;
            }
            mincost += minflow * sumcost;
            for (Edge e = inedge[sink]; e != null; e = inedge[e.from]) {
                e.flow += minflow;
                e.complement.flow -= minflow;
            }

            all -= minflow;
            for (int i = 0; i < n; i++) {
                potential[i] += d[i];
            }
        }
        return mincost;
    }

    public class MinHeapL {
        public long[] a;
        public int[] map;
        public int[] imap;
        public int n;
        public int pos;
        public static long INF = Long.MAX_VALUE;

        public MinHeapL(int m) {
            n = Integer.highestOneBit((m + 1) << 1);
            a = new long[n];
            map = new int[n];
            imap = new int[n];
            Arrays.fill(a, INF);
            Arrays.fill(map, -1);
            Arrays.fill(imap, -1);
            pos = 1;
        }

        public long add(int ind, long x) {
            int ret = imap[ind];
            if (imap[ind] < 0) {
                a[pos] = x;
                map[pos] = ind;
                imap[ind] = pos;
                pos++;
                up(pos - 1);
            }
            return ret != -1 ? a[ret] : x;
        }

        public long update(int ind, long x) {
            int ret = imap[ind];
            if (imap[ind] < 0) {
                a[pos] = x;
                map[pos] = ind;
                imap[ind] = pos;
                pos++;
                up(pos - 1);
            } else {
                a[ret] = x;
                up(ret);
                down(ret);
            }
            return x;
        }

        public long remove(int ind) {
            if (pos == 1) return INF;
            if (imap[ind] == -1) return INF;

            pos--;
            int rem = imap[ind];
            long ret = a[rem];
            map[rem] = map[pos];
            imap[map[pos]] = rem;
            imap[ind] = -1;
            a[rem] = a[pos];
            a[pos] = INF;
            map[pos] = -1;

            up(rem);
            down(rem);
            return ret;
        }

        public long min() {
            return a[1];
        }

        public int argmin() {
            return map[1];
        }

        public int size() {
            return pos - 1;
        }

        public long get(int ind) {
            return a[imap[ind]];
        }

        private void up(int cur) {
            for (int c = cur, p = c >>> 1; p >= 1 && a[p] > a[c]; c >>>= 1, p >>>= 1) {
                long d = a[p];
                a[p] = a[c];
                a[c] = d;
                int e = imap[map[p]];
                imap[map[p]] = imap[map[c]];
                imap[map[c]] = e;
                e = map[p];
                map[p] = map[c];
                map[c] = e;
            }
        }

        private void down(int cur) {
            for (int c = cur; 2 * c < pos; ) {
                int b = a[2 * c] < a[2 * c + 1] ? 2 * c : 2 * c + 1;
                if (a[b] < a[c]) {
                    long d = a[c];
                    a[c] = a[b];
                    a[b] = d;
                    int e = imap[map[c]];
                    imap[map[c]] = imap[map[b]];
                    imap[map[b]] = e;
                    e = map[c];
                    map[c] = map[b];
                    map[b] = e;
                    c = b;
                } else {
                    break;
                }
            }
        }
    }
}

模板来自uwi
链接：https://leetcode.cn/circle/discuss/UAy2CS/

```

#### 完全图数量

```java
class Solution {
    
    static class Dsu {
        int n;
        int[] arr;
        public Dsu(int n) {
            this.n = n;
            this.arr = new int[n];
            Arrays.fill(arr, -1);
        }
        int find(int u) {
            if (arr[u] == -1) return u;
            return arr[u] = find(arr[u]);
        }
        void union(int u, int v) {
            int ai = find(u);
            int bi = find(v);
            if (ai != bi) {
                arr[ai] = bi;
            }
        }
    }
    

    public int countCompleteComponents(int n, int[][] edges) {

        Dsu dsu = new Dsu(n);
        
        for (int[] e: edges) {
            dsu.union(e[0], e[1]);
        }
        
        // 每个连通分量的点集
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int g = dsu.find(i);
            hash.merge(g, 1, Integer::sum);
        }
        
        // 每个连通分量的边集
        Map<Integer, Integer> ehash = new HashMap<>();
        for (int[] e: edges) {
            int g = dsu.find(e[0]);
            ehash.merge(g, 1, Integer::sum);
        }
        
        // 完全图满足  n * (n - 1) / 2 == 边的个数 
        int ans = 0;
        for (var e: hash.entrySet()) {
            int cnt = e.getValue();
            int ecnt = ehash.getOrDefault(e.getKey(), 0);
            
            long need = (long)cnt * (cnt - 1) / 2;
            if (need == ecnt) {
                ans++;
            }
        }
        
        return ans;
        
    }
    
}

作者：珂朵莉
链接：https://leetcode.cn/circle/discuss/I5FOFr/
```
#### lca
```java
//董晓老师的lca模板
//https://leetcode.cn/problems/minimum-edge-weight-equilibrium-queries-in-a-tree/description/
class LCA {
        //倍增求LCA模板
        static final int N  = (int) (4e5 + 10);
        int n, s;
        List<int[]>[] g;
        int[] dep;
        int[][] fa;
        int[][] cnt; // cnt[i][x] 表示从节点1到节点i边权为x出现的次数

        /**
         * dfs树上倍增
         * @param u
         * @param father
         */
        public void dfs(int u, int father) { //树增dep,fa
            dep[u] = dep[father] + 1;
            // 向上跳1，2，4...步的祖先节点
            fa[u][0] = father;
            for (int i = 1; i <= 20; i++) {
                fa[u][i] = fa[fa[u][i-1]][i-1];
            }
            for (int[] next : g[u]) {
                int v = next[0], w = next[1];
                if (v != father) {
                    for (int i = 1; i <= 26; i++) {
                        cnt[v][i] += cnt[u][i];
                    }
                    cnt[v][w]++;
                    dfs(v, u);
                }

            }
        }
        /**
         * 返回u和v的最近公共祖先
         * @param u
         * @param v
         * @return
         */
        public int lca(int u, int v) {
            if (dep[u] < dep[v]) {
                // swap(u, v)
                int temp = u;
                u = v;
                v = temp;
            }
            //u先大步后小步向上跳，直到与v同层
            for (int i = 20; i >= 0; i--) {
                if (dep[fa[u][i]] >= dep[v]) {
                    u = fa[u][i];
                }
            }
            if (u == v) return v;
            //u,v一起向上跳，直到lca的下面
            for (int i = 20; i >= 0; i--) {
                if (fa[u][i] != fa[v][i]) {
                    u = fa[u][i];
                    v = fa[v][i];
                }
            }
            return fa[u][0];
        }

        public LCA(int n) {
            g = new List[n+1];
            dep = new int[n+1];
            fa = new int[n+1][22];
            cnt = new int[n+1][27];
            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<>();
            }
        }
    }


//endlesschen
class TreeAncestor {
    private int[] depth;
    private int[][] pa;

    public TreeAncestor(int[][] edges) {
        int n = edges.length + 1;
        int m = 32 - Integer.numberOfLeadingZeros(n); // n 的二进制长度
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) { // 节点编号从 0 开始
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        depth = new int[n];
        pa = new int[n][m];
        dfs(g, 0, -1);

        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }

    private void dfs(List<Integer>[] g, int x, int fa) {
        pa[x][0] = fa;
        for (int y : g[x]) {
            if (y != fa) {
                depth[y] = depth[x] + 1;
                dfs(g, y, x);
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (; k > 0; k &= k - 1)
            node = pa[node][Integer.numberOfTrailingZeros(k)];
        return node;
    }

    public int getLCA(int x, int y) {
        if (depth[x] > depth[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        // 使 y 和 x 在同一深度
        y = getKthAncestor(y, depth[y] - depth[x]);
        if (y == x)
            return x;
        for (int i = pa[x].length - 1; i >= 0; i--) {
            int px = pa[x][i], py = pa[y][i];
            if (px != py) {
                x = px;
                y = py;
            }
        }
        return pa[x][0];
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/solutions/2305895/mo-ban-jiang-jie-shu-shang-bei-zeng-suan-v3rw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


```
#### 查询某个节点第k祖先
```java 

class TreeAncestor {
    private int[][] pa;

    public TreeAncestor(int n, int[] parent) {
        int m = 32 - Integer.numberOfLeadingZeros(n); // n 的二进制长度
        pa = new int[n][m];
        for (int i = 0; i < n; i++)
            pa[i][0] = parent[i];
        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k); // k 的二进制长度
        for (int i = 0; i < m; i++) {
            if (((k >> i) & 1) > 0) { // k 的二进制从低到高第 i 位是 1
                node = pa[node][i];
                if (node < 0) break;
            }
        }
        return node;
    }

    // 另一种写法，不断去掉 k 的最低位的 1
    public int getKthAncestor2(int node, int k) {
        for (; k > 0 && node != -1; k &= k - 1)
            node = pa[node][Integer.numberOfTrailingZeros(k)];
        return node;
    }
}

作者：灵茶山艾府
链接：https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/solutions/2305895/mo-ban-jiang-jie-shu-shang-bei-zeng-suan-v3rw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```