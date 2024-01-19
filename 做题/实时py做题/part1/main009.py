from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))

def main():
    n=(int)(io())
    arr,brr,crr=io(),io(),io()
    f1,f2=False,False
    for i in range(n):
        
        if arr[i]==crr[i] or brr[i]==crr[i]:
            f1=True
        if arr[i]!=crr[i] and brr[i]!=crr[i]:
            f2=True
    if f2:print("YES")
    else :print("NO")
    
    

    

if __name__ == "__main__":
    t = 1
    t=(int)(io())
    for test in range(t):
        main()
