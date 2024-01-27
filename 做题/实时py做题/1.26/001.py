from collections import Counter
import sys

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    n = (int)(io())
    cnt = Counter(io())
    res = 0
    for k, v in cnt.items():
        res += v + 1
    print(res)


if __name__ == "__main__":
    t = 1
    # t=(int)(io())
    for test in range(t):
        main()
