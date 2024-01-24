from collections import Counter
import sys
import heapq

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    n, m = map(int, input().split())
    a = [0] + list(map(int, input().split()))
    s = [0 for i in range(n + 1)]
    v = []
    for i in range(1, n + 1):
        s[i] = s[i - 1] + a[i]
        if a[i] == 0:
            v.append(i)
    ans = 1e18
    for i in range(0, len(v) - 1):
        if s[v[i + 1] - 1] - s[v[i]] >= m:
            print("NO")
            exit(0)
    for i in range(1, n + 1):
        if a[i] == 0:
            if s[n] - s[i] < m:
                ans = min(ans, s[i - 1])
    print(ans + n - 1)


if __name__ == "__main__":
    t = 1
    # t = int(io())
    for test in range(t):
        main()


# 错误做法，40
def main_1():
    n, hp = iar()
    arr = iar()
    re, nhp = 0, hp
    time = 0
    f = True
    for i in range(1, n - 1):
        if arr[i] == 0:
            re += hp - nhp

        else:
            nhp -= arr[i]
            if nhp + re <= 0:
                f = False
                break
            else:
                re -= 1 - (nhp)
                nhp = 1
                time += 1 - nhp
    if f:
        print(n - 1 + time)
    else:
        print("NO")
