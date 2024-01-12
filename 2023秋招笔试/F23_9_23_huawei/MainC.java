package F23_9_23_huawei;


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
        //int _t=in.nextInt();

        //while(_t-->0)
            new C(in);

        in.flush();
    }
}
class C{
    C(ac in){
        int n=in.nextInt();
        long x=in.nextInt();
        long y=in.nextInt();
        long arr[]=new long[n];
         for(int i=0;i<n;i++){
            arr[i]=in.nextLong();
        }
        Arrays.sort(arr);
        int tmp=binsearch(arr, n, x);
        if(tmp+x<y&&tmp-(n-tmp)<=0){
            in.println(-1);return;
        }
        long cur=x;
        long cnt=0;
        while(true){
            if(cur+tmp>=y){
                cnt+=y-cur;break;
            }else{
                cur+=tmp-(n-tmp);cnt+=n;
            }
            tmp=binsearch(arr, n, cur);
        }
        in.println(cnt);
    }
    int binsearch(long arr[],int n,long x){
        int l=-1;int r=n;
        while(l+1<r){
            int m=(l+r)>>>1;
            if(arr[m]<x)l=m;
            else r=m;
        }
        while(r<n&&arr[r]<=x+r)r++;
        return r;
    }
}