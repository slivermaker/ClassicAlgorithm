package F23_9_13_huawei;

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

public class MainA {
    public static void main(String[] args) {
        ac in=new ac();
        new A(in);
        in.flush();
    }
}
class A{

    A(ac in){
        int n=in.nextInt();
        int m=in.nextInt();
        DSU uf=new DSU(n);
        for(int i=0;i<m;i++){
            int x=in.nextInt();int y=in.nextInt();
            uf.union(x+1, y+1);
            in.println(Arrays.toString(uf.id));
        }
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(uf.id[i]==i)cnt++;
        }
        in.println(cnt);
    }
}
 class DSU{

    int id[];int rank[];

    DSU(int n){

      id=new int[n+1];rank=new int[n+1];

      for(int i=0;i<=n;i++){id[i]=i;rank[i]=1;}

    }

    int find(int x){

     if(x==id[x])return x;

      return id[x]=find(id[x]);

    }

    void union(int x,int y){

      int xroot=find(x);int yroot=find(y);

      if(xroot!=yroot){

        if(rank[y]<=rank[x])id[yroot]=xroot;

        else id[xroot]=yroot;

        if(rank[xroot]==rank[yroot])rank[xroot]++;

      }

    }

  }