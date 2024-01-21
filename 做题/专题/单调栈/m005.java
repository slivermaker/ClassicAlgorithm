package 做题.专题.单调栈;

import java.util.*;

public class m005 {
    
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int n=0;
        ListNode tmp = head;
        ArrayList<Integer>lis=new ArrayList<>();
        while(tmp!=null){
            n++;
            lis.add(tmp.val);
            tmp=tmp.next;
        }
        int nodes[] = lis.stream().mapToInt(Integer::intValue).toArray();
        int res [] = new int[n];
        int id=0;
        Deque<Integer>dq=new ArrayDeque<>();
        for(int i =n-1;i>=0;i--){
            int x=nodes[i];
            while(!dq.isEmpty() && x>= dq.peek()){
                dq.pop();
            }
            if(!dq.isEmpty())res[i]=dq.peek();
            dq.push(x);
        }
        return res;
    }
}