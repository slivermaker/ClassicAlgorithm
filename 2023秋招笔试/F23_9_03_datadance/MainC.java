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

public class MainC{
    public static void main(String[] args) {
        ac in=new ac();
        new C(in);
        in.flush();
    }
}
class C{
    int N=(int)1e5+5;
    //int clr[]=new int[N];
    char[]clr;
    int p[]=new int[N];
    int cnt[]=new int[N];

    int head[]=new int[N];
    int ne[]=new int[2*N];
    int e[]=new int[2*N];


    boolean vis[]=new boolean [N];
    
    int idx=1;

    int find(int x){
        if(x==p[x])return x;
        return p[x]=find(p[x]);
    }
    
    void union (int x,int y){
        int rx=find(x);int ry=find(y);
        if(rx!=ry){
            p[ry]=rx;
        }
    }

    
    void add(int u, int v) {
        e[idx] = v;
        ne[idx] = head[u];
        head[u] = idx++;
        
    }
    C(ac in){
        int n=in.nextInt();int m=in.nextInt();

        String ch=" "+in.next();
        
        clr=ch.toCharArray();
        for(int i=1;i<=n;i++){
            p[i]=i;vis[i]=false;
        }
        for(int i=0;i<m;i++){
            int x=in.nextInt();int y=in.nextInt();
            add(x,y);add(y,x);
        }
        int num=0;

        for(int i=1;i<=n;i++){
            if(!vis[i]&&clr[i]=='R'){
                dfs(i,in);num++;
            }
        }

        for(int i=1;i<=n;i++){
            if(clr[i]=='R')in.println(num);
            
            else {
                in.println(num-icnt(i,in)+1);
            }
        }

    }
    void dfs(int u ,ac in){
        vis[u]=true;
        for(int i=head[u];i!=0;i=ne[i]){
            int v=e[i];
            if(clr[v]=='R'&&!vis[v]){
                union(u, v);
                dfs(v,in);
                
            }
        }
    }

    int icnt(int u ,ac in){
        Arrays.fill(vis,false);
        int cnt=0;
        for(int i=head[u];i!=0;i=ne[i]){
            int v=e[i];
            if(clr[v]=='R'&&!vis[find(v)]){
                
                cnt++;vis[find(v)]=true;
                
                
            }
            
        }
        return cnt;
    }

}
