from collections import Counter
from typing import List

class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        res = 0

        sorted_cnt = sorted(cnt.items(), key=lambda x: x[1], reverse=True)

        tmp=sorted_cnt[0][1]
        for i,x in cnt.items():
            if x==tmp:res+=tmp
        return res

