'''
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。

 '''

class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        n=len(nums)
        st,res=[],[-1]*n
        for i in range(n*2):
            x=nums[i%n]
            while st and nums[st[-1]]<x:
                res[st[-1]]=x
                st.pop()
            st.append(i%n)
        return res