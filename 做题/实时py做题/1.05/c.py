from collections import Counter
import sys

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    n = int(io())
    rou = 0.0000000000000000001
    res = 0x3F3F3F3F
    arr = list(map(float, io().split()))
    for i in range(n):
        tmp = arr[i] + 1 - rou
        res = min(res, (tmp / (i + 1)))
    print(res)


if __name__ == "__main__":
    t = 1
    # t = int(io())
    for test in range(t):
        main()
