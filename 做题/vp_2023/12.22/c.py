from collections import Counter
import math
import sys
import heapq

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    n, k = iar()
    arr = iar()
    tail = arr[0] - k

    for i in range(1, n):
        if arr[i] + k >= tail:
            tail = max(tail, arr[i] - k)
        else:
            print("No")
            break
    else:
        print("Yes")


if __name__ == "__main__":
    t = 1
    t = int(io())
    for test in range(t):
        main()
