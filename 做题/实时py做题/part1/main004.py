from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))


def main():
    n=(int)(io())
    arr1=io()
    arr2=io()
    c1=c2=0
    for i in range(n):
        if(arr1[i]==arr2[i]):continue
        elif arr1[i]=='1':c1+=1
        elif arr2[i]=='1':c2+=1
    print(max(c1,c2)) 


if __name__ == "__main__":
    #t = 1
    t=(int)(io())
    for test in range(t):
        main()
