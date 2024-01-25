from collections import Counter
import math
import sys
import heapq

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    n, q = iar()
    s = io()
    cnt_1 = lambda s: len([t for t in s.split("0") if t])
    cnt = cnt_1(s)
    s = "0" + s + "0"
    ans = 0
    for _ in range(q):
        l, r = iar()
        if s[l] == s[r]:
            ans = cnt
        elif s[r] == "0":
            ans = cnt
            if s[r + 1] == "1":
                ans -= 1
            if s[l - 1] == "1":
                ans += 1
        elif s[l] == "0":
            ans = cnt
            if s[r + 1] == "1":
                ans += 1
            if s[l - 1] == "1":
                ans -= 1
        print(ans)


if __name__ == "__main__":
    t = 1
    # t = int(io())
    for test in range(t):
        main()
