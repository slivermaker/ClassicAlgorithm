package F23_9_13微众;


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
    int p[];
    int find(int x){
        if(x==p[x])return x;
        return p[x]=find(p[x]);
    }
    void union(int x,int y){
        int rx=find(x);
        int ry=find(y);
        if(rx!=ry){
            p[rx]=ry;
        }
    }

    B(ac in){
        int t=in.nextInt();
        int m=in.nextInt();
        int sta=in.nextInt();
        int end=in.nextInt();


        /* 
        List<Integer>gra[]=new ArrayList[t+1];
        Arrays.setAll(gra, (i->new ArrayList<>()));
        for(int i=0;i<p;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            gra[u].add(v);
            gra[v].add(u);
        */


        p=new int[t+1];

        Arrays.setAll(p, i->i);

        for(int i=0;i<m;i++){
            int x=in.nextInt();
            int y=in.nextInt();
            union(x,y);
        }

        if(find(end)==find(sta)){
            in.println(t*(t-1)/2);return;
        }

        int a=0,b=0;
        
        for(int i=1;i<=t;i++){
            if(find(i)==find(end))a++;
            if(find(i)==find(sta))b++;
        }
        in.println(a*b);
    }

    
}