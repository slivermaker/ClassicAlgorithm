from collections import Counter
import sys

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    n = (int)(io())
    print(n * 2 if n % 2 == 0 else n * 2 + 1)


if __name__ == "__main__":
    t = 1
    # t = (int)(io())
    for test in range(t):
        main()
