import java.util.*;
public class lc {
    
}
class Solution {
    int [] tasks;
     int [] workers;
     int pills; 
     int strength;
     public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
         Arrays.sort(tasks); Arrays.sort(workers);
         this.tasks = tasks;
         this.workers = workers;
         this.pills = pills;
         this.strength = strength;
         int l = -1, r = Math.min(tasks.length, workers.length)+1;
         while(l+1<r){
             int k=(l+r+1)>>>1;
             if(check(k)){
                 l=k;
             }else{
                 r=k;
             }
             
         }
         return r;
     }
     boolean check(int k){
             int p=pills;
             TreeMap<Integer,Integer>workersMap=new TreeMap<>();
             for(int i=workers.length-k;i<workers.length;i++){
                 workersMap.compute(workers[i],(key,v)->(v==null?1:v+1));
             }
             for(int i=k-1;i>=0;i--){
                 int task=tasks[i];
                 var en=workersMap.lastEntry();
                 if(en.getKey()>=task)
                     workersMap.compute(en.getKey(),(key,v)->(v<=1?null:v-1));
                 else if(p>0&&(en=workersMap.ceilingEntry(task-strength))!=null){
                     p--;
                     workersMap.compute(en.getKey(),(key,v)->(v<=1?null:v-1));
                     
                 }    
                 else return false;
             }
             return true;
         }
    
 }