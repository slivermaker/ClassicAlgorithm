package F23_9_27_huawei;

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
    int num,tasks[],can[],add;//num加强装备的数量   tasks每个集装箱的重量   can每个叉车的上限   加强add
    C(ac in){
        int n1=in.nextInt(),n2=in.nextInt();
        num=in.nextInt();add=in.nextInt();
        tasks=new int[n1];can=new int[n2];
        for(int i=0;i<n1;i++)tasks[i]=in.nextInt();
        for(int i=0;i<n2;i++)can[i]=in.nextInt();
        Arrays.sort(tasks); Arrays.sort(can);
         
        int l = -1, r = Math.min(tasks.length, can.length)+1;
        while(l+1<r){
            int k=(l+r)>>>1;
            if(check(k,in)){
                 l=k;
            }else{
                 r=k;
            }
             
        }
        in.println(l);
        //in.println(Arrays.toString(tasks)+"  "+Arrays.toString(can));

    }
    boolean check(int k,ac in){
             int p=num;
             //in.println(p+" pp");
             TreeMap<Integer,Integer>workersMap=new TreeMap<>();
             for(int i=can.length-k;i<can.length;i++){
                 workersMap.compute(can[i],(key,v)->(v==null?1:v+1));
             }
             for(int i=k-1;i>=0;i--){
                 int task=tasks[i];
                 var en=workersMap.lastEntry();
                 if(en.getKey()>=task)
                     workersMap.compute(en.getKey(),(key,v)->(v<=1?null:v-1));
                 else if(p>0&&(en=workersMap.ceilingEntry(task-add))!=null){
                     p--;
                     workersMap.compute(en.getKey(),(key,v)->(v<=1?null:v-1));
                     
                 }    
                 else return false;
             }
             return true;
         }
}