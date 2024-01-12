package F23_8_24_alibaba;

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
class SolutionA{
    SolutionA(ac love){
        ac in=love;
        solv(in);
    }

    void solv(ac in){
        int n=in.nextInt();
        int k=in.nextInt();
        int num[]=new int[n];
        Queue<Integer>q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int tmp=in.nextInt();
            if(tmp==1)q.offer(i);
            num[i]=tmp;
        }

        for(int i=0;i<n;i++){
            if(q.isEmpty()){
                break;
            }
            int t=q.poll();
            if(k-(t-i)<=0)break;
            

            if(t>i&&k-(t-i)>=0&&num[i]==0){
                k-=t-i;
                swap(num, i, t);
            }
        }
        


    }
    void swap(int num[],int a,int b){
        int tmp=num[a];
        num[a]=num[b];
        num[b]=tmp;
    }


}
public class MainA {
    public static void main(String[] args) {
        ac in=new ac();
        new SolutionA(in);
        in.flush();
    }
}
