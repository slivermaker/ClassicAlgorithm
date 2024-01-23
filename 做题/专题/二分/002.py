class Solution:
    def hIndex(self, cit: List[int]) -> int:
        n, mx = len(cit), max(cit)
        l, r = -1, min(n, mx + 1)

        def check(h) -> bool:
            cnt = 0
            for i in range(n):
                if cit[i] >= h:
                    cnt += 1
            return cnt >= h

        while l + 1 < r:
            mid = (l + r) // 2
            if check(mid + 1):
                l = mid
            else:
                r = mid
        return r
