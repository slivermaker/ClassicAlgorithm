class Solution:
    def maxWidthRamp(self, A: List[int]) -> int:
        res, n = 0, len(A)
        st = []
        for i in range(n):
            x = A[i]
            if len(st) == 0 or A[st[-1]] > x:
                st.append(i)

        for i in range(n - 1, -1, -1):
            while st and A[st[-1]] <= A[i]:
                tmp = st.pop()
                res = max(res, i - tmp)
        return res
