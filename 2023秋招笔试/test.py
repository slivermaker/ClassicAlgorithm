MOD = int(1e9) + 7

t = input()
n = len(t)
t = " " + t

f = [0] * (n + 1)
f[0] = f[1] = f[2] = f[3] = 1

for i in range(4, n + 1):
    f[i] = f[i - 1]
    for leng in range(2, i - 1 + 1):
        s = t[i - leng + 1: i + 1]
        for j in range(1, i - leng + 1):
            if t[j: j + leng] == s:
                f[i] += f[i - leng]
                if f[i] >= MOD:
                    f[i] -= MOD

print(f[n])
