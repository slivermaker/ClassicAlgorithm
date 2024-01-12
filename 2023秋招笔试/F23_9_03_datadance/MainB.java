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

public class MainB {
    public static void main(String[] args) {
        ac in=new ac();
        new B(in);
        in.flush();
    }
}
class B{
    B(ac in){
        int k=in.nextInt();
        char[]arr=new char[26];
        
        for(int i=0;i<26;i++)arr[i]=(char)('a'+i);

        char[]res=new char[(int)1e5+5];

        Arrays.fill(res,'A');
        int i=0;
        int idx=0;

        W:while(true){
            int len=i+k;
            for(;i<len;i++){
                res[i]=arr[idx];
                res[i+k]=arr[idx++];
                if(idx==26)break W;
            }
            i=i+k;
        }
        int rid=0;
        for(int t=0;t<=i+k;t++){
            if(res[t]=='A')res[t]=arr[rid++];
        }
        in.println(String.valueOf(res,0,i+k+1));
    }
}
/*
 * 
 5
  e a b c d e a b c d  
 */