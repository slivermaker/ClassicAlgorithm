from typing import List, Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def nextLargerNodes(self, head: Optional[ListNode]) -> List[int]:
        def reverseList(head: Optional[ListNode]) -> Optional[ListNode]:
            pre, cur = None, head
            while cur:
                nxt = cur.next
                cur.next = pre
                pre = cur
                cur = nxt
            return pre

        head = reverseList(head)
        ans, st = [], []
        while head:
            while st and st[-1] <= head.val:
                st.pop()
            ans.append(st[-1] if st else 0)
            st.append(head.val)
            head = head.next
        return ans[::-1]
