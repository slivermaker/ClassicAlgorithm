from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))

def main():
    a,b,c,d=iar()
    if a/b>c/d:
        print("S")
    else:
        print("Y")
    

    

if __name__ == "__main__":
    t = 1
    t=(int)(io())
    for test in range(t):
        main()
