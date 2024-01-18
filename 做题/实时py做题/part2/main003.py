from collections import Counter
from typing import List

"""
https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/?envType=daily-question&envId=2024-01-18
"""


class Solution:
    def minimumRemoval(self, beans: List[int]) -> int:
        tot = sum(beans)
        beans.sort()
        n = len(beans)
        res = tot
        for i, x in enumerate(beans):
            # tmp=(tot-pre-x)-(n-1-i)*x+pre
            # pre+=x
            tmp = tot - (n - i) * x

            res = min(res, tmp)

        return res
