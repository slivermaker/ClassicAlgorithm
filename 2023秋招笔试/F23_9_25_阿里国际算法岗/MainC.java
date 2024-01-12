package F23_9_25_阿里国际算法岗;

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

    long fac[];
    final int mod=(int)1e9+7;
    long fpow(long a,long n,long mod){
        long ans=1;
        a%=mod;
        while(n>0){
            if((n&1)==1)ans=(ans*a)%mod;
            a=(a*a)%mod;
            n>>=1;
        }
        return ans;
    } 
    long inv(int a,long m){ return fpow(fac[a],m-2,m); } //用费马小定理计算逆
    long Cnum(int n,int r,long m){          //用逆计算C(n mod m, r mod m) mod m
        if(r>n)return 0;
        return ((fac[n] * inv(r,m))%m * inv(n-r,m)%m);
    }

    C(ac in){
        int n=in.nextInt();
        int[] arr=Arrays.stream(in.next().split("")).mapToInt(i->Integer.parseInt(i)).toArray();
        int[]p=new int[n+1];
        fac=new long[n+1];
        fac[0]=1;p[0]=1;
        for(int i=1;i<=n;i++){
            fac[i]=(long)fac[i-1]*i%mod;
            p[i]=p[i-1]*2%mod;
        }
        List<Integer>lis=new ArrayList<>();
        int tmp=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)tmp++;
            else {
                if(tmp!=0){lis.add(tmp);tmp=0;}

                else continue;
            }
        }
        if(arr[n-1]==0)lis.add(tmp);
        int sum = lis.stream().mapToInt(Integer::intValue).sum();
        long res=1L;

        for(int r:lis){
            res = (res*Cnum(sum,r,mod) % mod *p[r-1])%mod;
            sum -= r;
        }
        if(arr[0]==0){
            res=(res*fpow(p[lis.get(0)-1], mod-2, mod))%mod;

        }
        if(arr[n-1]==0){
            res=(res*fpow(p[lis.get(lis.size()-1)-1], mod-2, mod))%mod;
        }
        in.println(res);
    }
}