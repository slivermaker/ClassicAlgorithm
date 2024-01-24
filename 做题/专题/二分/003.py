class Solution:
    def minimumTime(self, tim: List[int], tot: int) -> int:
        n, mx = len(tim), max(tim)
        l, r = 0, tot * mx + 1

        def check(t: int) -> bool:
            cnt = 0
            for i in range(n):
                cnt += t // tim[i]
            return cnt >= tot

        while l + 1 < r:
            mid = (l + r) // 2
            if check(mid):
                r = mid
            else:
                l = mid
        return r
