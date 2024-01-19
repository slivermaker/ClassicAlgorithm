from collections import Counter
import sys

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))

def main():
    n = (int)(io())
    arr = iar()
    cnt = Counter(arr)
    res = 0
    for k, v in cnt.items():
        if v >= 3:
            res += (v * (v - 1) * (v - 2)) // 6
    
    base = 0
    for k, v in sorted(cnt.items()):  # 使用 sorted 进行排序
        if v >= 2:
            tmp = v * (v - 1) // 2
            res += tmp * base
        base += v
    
    print(res)

if __name__ == "__main__":
    t = 1
    t = (int)(io())
    for test in range(t):
        main()
