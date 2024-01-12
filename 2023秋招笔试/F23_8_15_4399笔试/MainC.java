package F23_8_15_4399笔试;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
 * n 1e5长度
 * 
 * 
 * a[i] 1e5 第i的能量
 * 
 * 
 */

public class MainC{
    static final int mod=1000000007;
    public static void main(String[] args) {
        ac in=new ac();
        int _n=1;
        //_n=in.nextInt();
        while(_n-->0){
            solv(in);

        }
        in.flush(); 
    }
   
     
    static void solv(ac io) {
        ac in = io;
        int n=in.nextInt();
        long a[]=new long[n];
        for(int i=0;i<n;i++)a[i]=in.nextLong();
        long l=-1,r=(long) 1e10+5;

        while(l+1<r){
            long mid=(l+r)>>>1;

            if(cross(a,mid))r=mid;
            else l=mid; 
        }

        in.println(r);
    }



    static boolean cross(long[] a,long k){
        long x=k;

        for(int i=0;i<a.length;i++){
          
            if(x>(int)1e5)return true;
            
           
            if(x>a[i])x+=(x-a[i]);
            else x-=(a[i]-x);
            if(x<0)return false;

        }
        return true;

    }
     
}


class ac extends PrintWriter {
    BufferedReader br;
    StringTokenizer st;

    ac() {
        this(System.in, System.out);
    }

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

    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong(){
        return Long.parseLong(next());
    }

}