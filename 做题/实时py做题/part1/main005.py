from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))


def main():
    
    n,f,a,b=iar()
    tim=[0]
    tim.extend(iar())

   # print(n,f,a,b,tim)
    for i in range(1,n+1):
        t=tim[i]-tim[i-1]
        f-=min(t*a,b)
        if f<=0:
            print("NO")
            break
    else:print("YES")


if __name__ == "__main__":
    #_t = 1
    _t=(int)(io())
    for test in range(_t):
        main()
