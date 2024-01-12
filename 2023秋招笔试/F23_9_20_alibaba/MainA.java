package F23_9_20_alibaba;

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
        int k=in.nextInt();
        
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int tmp=in.nextInt();
            
            map.compute(tmp%k, (key,val)->(val==null?1:val+1));
        }
        int res=-1;
        if(map.get(0)!=null&&map.get(0)>=2){  
            res=map.get(0);
        }
        if(k%2==0){  
            if(map.get(k/2)!=null)
                res=Math.max(res,map.get(k/2));
        }
        for(int ke:map.keySet()){
            if(map.get(k-ke)!=null){
                res=Math.max(res,2);
            }
        }
        in.println(res);
    }
    
}