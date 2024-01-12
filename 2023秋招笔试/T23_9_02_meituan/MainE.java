package T23_9_02_meituan;

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

public class MainE {
    public static void main(String[] args) {
        ac in=new ac();
        new E(in);
        in.flush();
    }
}


class E{
    E(ac love){
        ac in=love;
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int [] arr = new int[n];
        List<Integer>cnts=new ArrayList<>();
        for (int i = 0; i < n; i++) {
             arr[i] = in.nextInt();
             map.compute(arr[i], (k,v)->(v==null?1:v+1));
             
        }


        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(map.get(o2).compareTo(map.get(o1))));

        for (var tmp : map.entrySet()) {
            pq.add(tmp.getKey());
            
        }
        //Collections.sort(cnts);

        
        while (!pq.isEmpty()) {
            int c = pq.poll();
            List<Integer>box=new ArrayList<>();
            
            while (!pq.isEmpty()) {
                
                int p = pq.poll();
                
                 //map.compute(p,(k,v)-> v - 1);
                 map.compute(c, (k,v)->v - 1);
                
                ans++;in.printf("(%d  %d)\n",c,p);
                if (map.get(p) != 1) {
                    box.add(p);
                }
                if (map.get(c)==0) break; 
            }
            for(int x:box){
                //in.printf("(%d  %d)\n",c,x);
                map.compute(x, (k,v)->v - 1);
                pq.add(x);
            }

            box=new ArrayList<>();

            if (map.get(c) >= 2) {
                ans++;
                in.printf("(%d  %d)\n",c,c);
            }
        }

        in.println(ans);
    }
}