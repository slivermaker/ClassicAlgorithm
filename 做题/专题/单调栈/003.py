'''
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 

nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。

 https://leetcode.cn/problems/next-greater-element-i/description/

'''


class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        res,st=[],[]
        n=len(nums2)
        mpy={}
        for i in range(n-1,-1,-1):
            x=nums2[i]
            while st and st[-1]<=x:
                st.pop()
            mpy[x]=st[-1] if st else -1
            st.append(x)
        for x in nums1:
            res.append(mpy[x])
        return res