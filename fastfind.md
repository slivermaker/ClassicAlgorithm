### main

```python
from collections import Counter
import sys
iar = lambda:list(map(int,input().split()))
io = lambda: sys.stdin.readline().strip()

def main():
    print()

if __name__ == "__main__":
    t = int(io())
    for test in range(t):
        main()

```

#### 输入
```python
u, v, w = [int(x) for x in input().split()]
```

```py
u, v, w = ([] for i in range(3))  # 多变量赋值
for i in range(4):  # 这里假设输入 4 行数据
    _u, _v, _w = [int(x) for x in input().split()]
    u.append(_u), v.append(_v), w.append(_w)
    # 不可进行类似 cin >> u[i] >> v[i] >> w[i] 的操作，因为必定超出列表当前的长度
    # 当然你可以选择初始化长度为 MAXN 的全 0 列表，不过需要记住真实长度并删掉多余元素
print(u, v, w)
```

```py
    arr = []
    for _ in range(3):
        arr.extend(io())#前面加个list就是二维，不加就是一维，字符串自带迭代所以直接extend就行
```

```py
a = []
with open('in.txt') as f:
    N = int(f.readline())  # 读入第一行的 N
    a[len(a):] = [[int(x) for x in f.readline().split()] for i in range(N)]

with open('out.txt', 'w') as f:
    f.write('1\n')
```

##### 数组
```py
vis1 = [[0] * 3 for _ in range(3)]
```
###### 排序
```py
arr = np.array([3, 1, 4, 2, 5])

arr.sort()

print(arr)  # [1 2 3 4 5]

```

```py
arr = np.array([3, 1, 4, 2, 5])

sorted_arr = np.sort(arr)

print(sorted_arr)  # [1 2 3 4 5]
print(arr)        # [3 1 4 2 5]
```
###### 自定义排序
```py
from functools import cmp_to_key
sorted(kids, key=cmp_to_key(cmp))
```
`cmp`就是def cmp():.....return ><;

**或者是lambda操作**

arr.sort(key=lambda x: x[0])

arr = sorted(arr, key=lambda x: x[0])

```py
# 先按照第一个元素升序，第二个元素降序排序
arr.sort(key=lambda x: (x[0], -x[1]))

# 或者使用 sorted 函数
# arr = sorted(arr, key=lambda x: (x[0], -x[1]))
```

```py
my_objects = [MyClass(2, 3), MyClass(1, 4), MyClass(1, 2), MyClass(2, 1)]

# 自定义排序规则的 lambda 函数
custom_sort = lambda obj: (obj.value1, -obj.value2)

# 使用 sort 方法进行排序
my_objects.sort(key=custom_sort)

# 或者使用 sorted 函数
# my_objects = sorted(my_objects, key=custom_sort)
```


##### 计数
    cnt = Counter(arr)#计数，但是要提前import
##### 字符数组计数
    chr()转化为数字
    ord()显示该字符的ascll码

##### 逐个统计，这很不py

```python
key = 'example_key'
try:
    dic[key] += 1
except KeyError:
    dic[key] = 1
print(dic)
# 输出: {'A': 65, 'B': 66, ..., 'Z': 90, 'a': 97, 'b': 98, 'example_key': 1}
```

##### 初始化映射
```py
 codedic = {chr(i): i for i in range(65, 91)}
   print(dic)
   # 输出: {'A': 65, 'B': 66, ..., 'Z': 90}
```

##### 改变输出格式
```python
res = ['bcd', 'bcd', 'bcd', 'bcd']
print(*res, sep='.')
```
##### 字典排序
```py
   dic = {k: v for k, v in sorted(dic.items(), key=lambda x: -x[1])}
   print(dic)
   # 输出: {90: 'Z', 89: 'Y', ..., 65: 'A'}
```

```
''.jion()  字符转添加
```
 




#### 回溯
```py
@lru_cache(maxsize = None)
def fib(n):
    if n < 2:
        return n
    return fib(n - 1) + fib(n - 2)
```