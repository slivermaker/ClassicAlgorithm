class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        n, mx = len(candies), sum(candies) // k
        l, r = -1, mx + 1
        if k > sum(candies):
            return 0

        def check(x) -> bool:
            cnt = 0
            for v in candies:
                cnt += v // x
            return cnt < k

        while l + 1 < r:
            mid = (l + r) // 2

            if mid != 0 and check(mid):
                r = mid
            else:
                l = mid
        return l
