from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))

def main():
    s=list(io())
    ts=sorted(s)
    n=len(s)
    setpy=set()
    f=True
    if s!=ts:
        print("No")
        return
    for i in range(n-1):
        if s[i+1]==s[i]:continue
        if s[i] in setpy:
            f=False
            
        setpy.add(s[i])
    if n<3:
        print("Yes")
        return
    if  s[n-1]!=s[n-2] and s[n-1] in setpy:f=False
    if f:print("Yes")
    else: print("No")


    

if __name__ == "__main__":
    t = 1
    # t=(int)(io())
    for test in range(t):
        main()
