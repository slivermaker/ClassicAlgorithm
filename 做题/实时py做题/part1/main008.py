from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))


def main():
    n,k=iar()
    arr,brr=iar(),iar()
    res=tmp=2e18
    pre=0
    for i in range(min(n,k)):
        pre+=arr[i]
        tmp=min(tmp,arr[i]+brr[i])
        res=min(res,pre+(k-1-i)*tmp)

    print(res)    

    
    

if __name__ == "__main__":
    _t = 1
    # _t=(int)(io())
    for test in range(_t):
        main()
