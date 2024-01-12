package F23_9_07_meituan;


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
        int n=in.nextInt();int k=in.nextInt();
        Stack<Integer>st=new Stack<>();
        char[]ch=in.next().toCharArray();
        
        for(int i=0;i<n;i++){
            
            int tmp=ch[i]-'0';
            if(st.isEmpty()||st.peek()!=tmp){
                st.push(tmp);
            }else{
                st.pop();
            }//System.out.println(i+" "+tmp+" "+st.size());
        }
       
        int cnt=st.size()/2;
        int res=st.size();
        if(cnt>=k){
            res-=k*2;
        }
        else {
            res-=cnt*2;
            if(res==1);
            else{
                res=(k-cnt)%2==0?0:2;
            }
        }
        in.println(res);
    }
}