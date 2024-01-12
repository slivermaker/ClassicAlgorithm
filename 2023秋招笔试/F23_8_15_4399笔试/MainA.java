package F23_8_15_4399笔试;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class MainA{
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
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int n=s.length;
        for(int i=n-1;i>=0;i--){
            char []c=s[i].toCharArray();
            int len=c.length;
            for(int j=len-1;j>=0;j--){
                if(c[j]>='a'&&c[j]<='z')in.print(Character.toChars(c[j]-'a'+'A'));
                else in.print(Character.toChars(c[j]-'A'+'a'));
            }
            in.print(" ");
        }
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