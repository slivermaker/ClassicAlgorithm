from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))

def main():
    p,s,r=print,input,range
    N=int(s())
    m=len(bin(N-1))-2
    p(m)
    for i in r(m)[::-1]:A=[j+1 for j in r(N)if j&(1<<i)];p(len(A),*A)
    p(int(s(),2)+1)

    

if __name__ == "__main__":
    t = 1
    # t=(int)(io())
    for test in range(t):
        main()


    