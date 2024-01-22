from collections import Counter
import sys

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def main():
    s = io()
    cnt = Counter(s)
    print("xiaohong", end="")
    cnt["x"] -= 1
    cnt["i"] -= 1
    cnt["a"] -= 1
    cnt["o"] -= 2
    cnt["h"] -= 1
    cnt["n"] -= 1
    cnt["g"] -= 1
    for k, v in cnt.items():
        if v == 0:
            continue
        print(k * v, end="")


if __name__ == "__main__":
    t = 1
    # t=(int)(io())
    for test in range(t):
        main()
