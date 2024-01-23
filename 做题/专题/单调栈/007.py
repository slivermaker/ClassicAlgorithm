"""
2866. 美丽塔 II
已解答
第 364 场周赛
Q3
2072
相关标签
相关企业
提示
给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。

你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。

如果以下条件满足，我们称这些塔是 美丽 的：

1 <= heights[i] <= maxHeights[i]
heights 是一个 山脉 数组。
如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：

对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
请你返回满足 美丽塔 要求的方案中，高度和的最大值 。

 
"""


class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        st, n = [-1], len(maxHeights)
        pre = [0] * (n)
        if n == 1:
            return maxHeights[0]
        presum = 0
        for i in range(n):
            x = maxHeights[i]
            while len(st) > 1 and maxHeights[st[-1]] > x:
                id1 = st.pop()
                presum -= (maxHeights[id1]) * (id1 - st[-1])
            presum += x * (i - st[-1])
            st.append(i)
            pre[i] = presum

        sufsum, suf = 0, [0] * (n)
        st = [n]
        for i in range(n - 1, -1, -1):
            x = maxHeights[i]
            while len(st) > 1 and maxHeights[st[-1]] > x:
                id1 = st.pop()
                sufsum -= (st[-1] - id1) * (maxHeights[id1])
            sufsum += x * (st[-1] - i)
            st.append(i)
            suf[i] = sufsum

        res = 0
        for i in range(1, n, 1):
            res = max(res, suf[i] + pre[i - 1])
        print(pre, suf)
        return res
