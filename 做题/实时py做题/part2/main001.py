from functools import cache


class Solution:
    MOD=1e9+7
    def count(self, num1: str, num2: str, min_sum: int, max_sum: int) -> int:
        def calc(high:str)->int:
            @cache
            def dfs(i:int,s:int,is_limit:bool,max_sum:int):
                if s>max_sum:return 0
                if i==len(high):return s>=min_sum
                res=0
                up=int(high[i])if is_limit else 9

                for d in range(up+1):
                    res+=dfs(i+1,s+d,is_limit and d==up)
                return res
            
            return dfs(0,0,True)  
        tmp=min_sum<=sum(map(int,num1))<=max_sum

        return (calc(num2)-calc(num1)+tmp)%self.MOD