from collections import Counter
import math
import sys
import heapq

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    x, y = iar()
    mul = x * y
    for a in range(math.ceil(math.sqrt(mul)) + 1):
        if mul % a == 0:
            b = mul // a
            if math.gcd(a, b) == x:
                print(a, b)
                return
    print(-1)


if __name__ == "__main__":
    t = 1
    t = int(io())
    for test in range(t):
        main()
