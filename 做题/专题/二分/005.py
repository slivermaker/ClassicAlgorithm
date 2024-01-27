class Solution:
    def maxNumberOfAlloys(
        self,
        n: int,
        k: int,
        bu: int,
        comp: List[List[int]],
        stock: List[int],
        cost: List[int],
    ) -> int:
        l, r = -1, bu + min(stock)  # 左右边界
        res = 0

        def check(num) -> bool:
            for com in comp:
                money = 0
                f = True
                for s, nd, c in zip(stock, com, cost):
                    if s < nd * num:
                        money += (nd * num - s) * c
                        if money > bu:
                            f = False
                if f:
                    return True
            return False

        while l + 1 < r:
            mid = (l + r) // 2
            if check(mid + 1):
                l = mid
            else:
                r = mid
        return r
