from collections import Counter
import sys

IO = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, IO().split()))

def main():
    n = (int)(IO())
    arr = [0] + iar()  # 修正此行，将 extend 改为 +
    suf = [0] * (n + 2)
    pre = [0] * (n + 2)
    pre[1] = 1
    suf[n] = 1

    for i in range(2, n):
        pre[i] = pre[i - 1]
        dis = arr[i+1] - arr[i]
        tmp = 1 if dis < arr[i] - arr[i-1] else dis
        pre[i]+=tmp

    for i in range(n-1 , 0, -1):
        suf[i] = suf[i + 1]
        dis = arr[i ] - arr[i - 1]
        tmp = 1 if dis < arr[i+1] - arr[i ] else dis
        suf[i]+=tmp
        
    m = (int)(IO())
    for _ in range(m):
        x, y = iar()
        if x > y:
            print(suf[y+1] - suf[x+1])
        else:
            print(pre[y-1] - pre[x-1])
    # print(arr,pre,suf,sep='\n')


if __name__ == "__main__":
    t = 1
    t = (int)(IO())
    for test in range(t):
        main()
