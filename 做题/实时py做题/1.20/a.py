from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))

def main():
    n=(int)(io())
    a,b=0,0
    for i in range(n):
        ta,tb=iar()
        a+=ta
        b+=tb
    if a>b:print("Takahashi")
    elif a==b:print("Draw")
    else :print("Aoki")

    

if __name__ == "__main__":
    t = 1
    # t=(int)(io())
    for test in range(t):
        main()
