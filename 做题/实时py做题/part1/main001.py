from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))

def main():
    n=(int)(io())
    nums=iar()
    left,right=[0]*n,[0]*n
    left[0],right[n-1]=nums[0],nums[n-1]
    for i in range(1,n):
        left[i]=max(left[i-1],nums[i])
    for i in range(n-2,-1,-1):
        right[i]=max(right[i+1],nums[i])
    res=-1
    for i in range(1,n-1):
        res=max((left[i-1]+right[i+1])//nums[i],res)
    print(res)

    

if __name__ == "__main__":
    t = 1
    #t=(int)(io())
    for test in range(t):
        main()
