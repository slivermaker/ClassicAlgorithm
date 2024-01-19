'''

给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。

商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，

其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。

请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/description/
'''
class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n=len(prices)
        st=[]
        res=[0 for _ in  range(n)]
        for i in range(n):
            x=prices[i]
            while st and x<=prices[st[-1]]:
                id=st.pop()
                res[id]=prices[id]-x
            st.append(i)
            res[i]=prices[i]
        return res
                
            
