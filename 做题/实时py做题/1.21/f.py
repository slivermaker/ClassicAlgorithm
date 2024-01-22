from fractions import Fraction
from collections import Counter
import sys
import math

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))

MOD = int(1e9 + 7)


def main():
    N = 10000000
    x = 0
    pr = [0] * (N // 5)
    p = [0] * (N + 100)
    tot = 0
    cnt = [0] * N

    def prime():
        global tot
        p[1] = 1
        for i in range(2, N + 1):
            if not p[i]:
                p[i] = i
                tot += 1
                pr[tot] = i
            for j in range(1, tot + 1):
                if i * pr[j] > N:
                    break
                p[i * pr[j]] = pr[j]
                if pr[j] == p[i]:
                    break

    def check(a):
        if a == 1:
            return False
        for i in range(2, math.isqrt(a) + 1):
            if a % i == 0:
                return False
        return True

    prime()
    x = int(input())

    if check(x):
        print("1")
        print(x)
    else:
        if x == 1:
            print("-1")
        elif x == 2:
            print("1")
            print("2")
        elif x == 3:
            print("1")
            print("3")
        elif x == 4:
            print("-1")
        elif x == 5:
            print("1")
            print("5")
        else:
            for i in range(1, tot + 1):
                while x % pr[i] == 0:
                    x //= pr[i]
                    cnt[pr[i]] += 1

            if x != 1 and not check(x):
                print("-1")
            else:
                v = []
                ans = []
                for i in range(1, tot + 1):
                    if cnt[pr[i]] != 0:
                        v.append(pr[i])

                v.sort(key=lambda a: cnt[a], reverse=True)

                j = 0
                z = 0
                for i in range(len(v)):
                    while cnt[v[i]]:
                        j = max(j, i + 1)
                        if ans:
                            k = ans[-1]
                            if k == v[i]:
                                while cnt[v[j]] == 0 and j < len(v):
                                    j += 1
                                if j >= len(v):
                                    if z == 0:
                                        ans.append(x)
                                        z += 1
                                    else:
                                        print("-1")
                                        exit()
                                else:
                                    ans.append(v[j])
                                    cnt[v[j]] -= 1
                            ans.append(v[i])
                            cnt[v[i]] -= 1
                        else:
                            ans.append(v[i])
                            cnt[v[i]] -= 1

                if z == 0 and x != 1:
                    ans.append(x)

                print(len(ans))
                print(*ans)


if __name__ == "__main__":
    t = 1
    # t=(int)(io())
    for test in range(t):
        main()
