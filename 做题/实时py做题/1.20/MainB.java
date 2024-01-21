
import java.io.*;
import java.util.*;

public class MainB{
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
        ac in=io;
        char[]arr=in.next().toCharArray();
        Set<Character>set=new HashSet<>();
        boolean f=true;
        
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]==arr[i])continue;
            if(!set.add(arr[i])){
                f=false;
                break;
            }
        }
        int n=arr.length;
        if(n<3){
            in.println("Yes");return;
        }
        if(arr[n-1]!=arr[n-2]&&!set.add(arr[n-1])){
            in.println("No");
            return;
        }
        if(f)in.println("Yes");
        else in.println("No");
        
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