from collections import Counter
import sys
io = lambda: sys.stdin.readline().strip()
iar = lambda:list(map(int,io().split()))


def main():
    arr=[[0]*2 for _ in range(4)]
    for i in range(4):
        arr[i]=iar()
    arr.sort(key=lambda x: x[0])
    print((abs(arr[0][1]-arr[1][1]))**2)
if __name__ == "__main__":
    #t = 1
    t=(int)(io())
    for test in range(t):
        main()
