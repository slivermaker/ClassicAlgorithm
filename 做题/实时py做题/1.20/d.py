from collections import Counter
import sys

io = lambda: sys.stdin.readline().strip()
iar = lambda: list(map(int, io().split()))


def find_min_o_count(x, k):
    cnt=0
    for i in range(k):
        if x[i]=='o':
            cnt+=1
    tmp=cnt
    for i in range(k,len(x)):
        if x[i]=='o':cnt+=1
        if x[i-k]=='o':cnt-=1
        tmp=max(tmp,cnt)
    # print(x,len(x),k-tmp)
    return k-tmp

def main():
    h, w, k = iar()
    mp = [io() for _ in range(h)]
    res = float('inf')

    for i in range(h):
        ts = mp[i].split('x')
        
        for x in ts:
            if len(x) < k:
                continue
            res = min(res, find_min_o_count(x, k))
            
    mp = [''.join(map(str, row)) for row in zip(*mp)]
    

    for i in range(w):
        ts = mp[i].split('x')
        for x in ts:
            if len(x) < k:
                continue
            res = min(res, find_min_o_count(x, k))

    print(res if res != float('inf') else -1)


if __name__ == "__main__":
    t = 1
    for test in range(t):
        main()
