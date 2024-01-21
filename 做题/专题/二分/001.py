"""
410. 分割数组的最大值
困难

给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。

设计一个算法使得这 k 个子数组各自和的最大值最小。
"""


class Solution:
    def splitArray(self, nums: List[int], k: int) -> int:
        def check(mid: int) -> bool:
            cnt, tmp = 1, 0
            for x in nums:
                if tmp + x <= mid:
                    tmp += x
                else:
                    if cnt == k:
                        return False
                    cnt += 1
                    tmp = x  # 修正此行，重置 tmp 的值
            return True

        n, r = len(nums), sum(nums)
        l = max(max(nums) - 1, (r - 1) // k)
        while l + 1 < r:
            mid = (l + r) // 2
            if check(mid):  # 修正此行，传递 mid 参数
                r = mid
            else:
                l = mid
        return r
