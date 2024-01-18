package 做题.实时py做题.part1;


import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
 * 
 *没看到K超时做法
 */
public class Main008{
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
        int k=in.nextInt();
        int[]arr=new int[n];
        int brr[]=new int[n];
        for(int i=0;i<n;i++)arr[i]=in.nextInt();
        for(int i=0;i<n;i++)brr[i]=in.nextInt();
        PriorityQueue<int[]>pq=new PriorityQueue<>((o1,o2)->(o1[1]-o2[1]));
        int idval[][]=new int[n][2];
        for(int i=0;i<n;i++){
            idval[i][0]=i;
            idval[i][1]=arr[i];
        }
        pq.offer(new int[]{0,arr[0]});
        int pre=0;
        long res=0;
        while(k-->0){
            var tmp=pq.poll();
            res+=tmp[1];
            tmp[1]+=brr[tmp[0]];
            if(pre==tmp[0]){
                pre=pre==n-1?0:pre+1;
                pq.offer(new int[]{pre,arr[pre]});
            }
            pq.offer(tmp);
        }
        in.println(res);
    }

 
   /*      
    
    static boolean ispalin(String tmp){
        int n=tmp.length();
        for(int i=0;i<n/2;i++){
            if(tmp.charAt(i)!=tmp.charAt(n-1-i))return false;
        }return true;
    }
    
    static long fpow(long a,long n,long mod){
        long ans=1;
        while(n>0){
            if((n&1)==1)ans=ans*a%mod;
            a=a*a%mod;
            n>>=1;
        }
        return ans;
    }
        
    static void ruffleSort(int[] a) {
        Random random = new Random();
        int n = a.length;//随机，然后排序
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

*/
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