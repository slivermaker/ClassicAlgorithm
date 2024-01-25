from collections import Counter
import sys
import heapq

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    n, m, x, y = iar()
    if n - m >= y - x and x <= y:
        print("Yes")
    else:
        print("No")


if __name__ == "__main__":
    t = 1
    t = int(io())
    for test in range(t):
        main()
