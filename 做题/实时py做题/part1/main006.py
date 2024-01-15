from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))


def main():
    
    n,m=iar()
    arr1=iar()
    arr2=iar()
    arr1.sort()
    arr2.sort()
    #print(arr1,arr2)

    res=0
    idx=0
    left,right=0,n-1
    while(left<=right):
        #print(left,right,"+++")
        tmp1,tmp2=abs(arr2[idx]-arr1[right]),abs(arr2[-1]-arr1[left])
        if tmp1>tmp2:
           # print(arr2[idx],arr1[right])
            idx+=1
            right-=1
            res+=tmp1
            
        else:
           # print(arr2[-1],arr1[left])
            arr2.pop()
            left+=1
            res+=tmp2
    print(res)


if __name__ == "__main__":
    #_t = 1
    _t=(int)(io())
    for test in range(_t):
        main()
