package F23_8_26_oppo;


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
        new SolutionB(in);
        
    }
}


class SolutionB{
    SolutionB(ac love){
        ac in=love;
        int n=in.nextInt();
        int len=n;
        char[][]p=new char[5*n][5*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<5*n;j++){
                p[i][j]='*';p[5*n-1-i][j]='*';
            }
            
            for(int j=0;j<len;j++){
                p[i][j]='.';p[5*n-1-i][j]='.';
                p[i][5*n-j-1]='.';p[5*n-1-i][5*n-1-j]='.';
            }
            len--; 
        }
        char []tmp=new char[5*n];
        for(int j=0;j<n;j++){
            tmp[j]='*';tmp[5*n-j-1]='*';
        }
        for(int j=n;j<4*n;j++)tmp[j]='o';
        for(int i=n;i<4*n;i++){
            System.arraycopy(tmp,0,p[i],0,5*n);
        }
        for(int i=2*n;i<3*n;i++){
            for(int j=2*n;j<3*n;j++){
                p[i][j]='.';
            }
        }
        for(int i=0;i<5*n;i++){
            in.println(String.copyValueOf(p[i]));
        }
        in.flush();
    }
}

/*n==3
 * 
...*********...
..***********..
.*************.     n 
***ooooooooo***
***ooooooooo***
***ooooooooo***     2n
***ooo...ooo***
***ooo...ooo***
***ooo...ooo***     3n
***ooooooooo***
***ooooooooo***
***ooooooooo***
.*************.     4n
..***********..
...*********...
 */


 /*
  * 
n==1


.***.
*ooo*
*o.o*
*ooo*
.***.


*/