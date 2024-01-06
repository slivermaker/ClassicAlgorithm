## 写在前面



```py
/**
 * 作者: SilveryZz
 * 日期: 2023/7/26    17:55
 * 描述: 根据oi-wike整理一些知识点，并对自己疑惑的地方进行注释
 * 地点: 卧室
 * 版本: 1.0
 * 状态:文件md格式(推荐用typora打开) 完全兼容pdf
 */
```



```py
/**
 * 作者: SilveryZz
 * 日期: 2023-12-17    0:26
 * 描述: 偶然发现这些残稿，睡前花了一点时间进行排版，加入新的理解，并删去了一些怪僻的问题，对一些过于深刻的原理删去复杂解释当
 * 成结论，更容易被人接受
 * 地点:宿舍
 * 版本:2.0
 * 状态:文件md格式 不完全兼容pdf(因为有链接，pdf打不开)
 */
```



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





### 输入输出
io = lambda:sys.stdin.readline().strip()和input()在我看来就差不多了，会快一点

1. **io = lambda:sys.stdin.readline().strip()：**
   - 这一行定义了一个lambda函数，并将其赋值给变量io。这个lambda函数不带参数，当调用`io()`时，它会执行`sys.stdin.readline().strip()`，返回标准输入的一行去掉行尾空白的字符串。这种方式将读取输入的逻辑封装在一个lambda函数中，可以在程序中的其他地方多次调用。

2. **io = sys.stdin.readline().strip()：**
   - 这一行直接将`sys.stdin.readline().strip()`的结果赋值给io。在这种情况下，io不再是一个函数，而是一个包含了从标准输入读取的一行去掉行尾空白的字符串。如果你多次使用`io`，它将保持相同的值，而不会再次读取新的输入。

所以，第一个例子使用lambda函数封装了读取输入的逻辑，并且每次调用`io()`都会重新读取新的输入行，而第二个例子在一开始就读取了一行输入，后续的使用将一直使用这个读取的结果。

**M = **lambda**:list(map(int,input().split()))**同理调用的时候M()就可以了把input换成io同理



u, v, w = [int(x) for x in input().split()]

```python
>>> N = 4; mat = [[int(x) for x in input().split()] for i in range(N)]
1 3 3 
1 4 1 
2 3 4 
3 4 1 
>>> mat  # 先按行读入二维数组
[[1, 3, 3], [1, 4, 1], [2, 3, 4], [3, 4, 1]]
>>> u, v, w = map(list, zip(*mat))   
# *将 mat 解包得到里层的多个列表
# zip() 将多个列表中对应元素聚合成元组，得到一个迭代器
# map(list, iterable) 将序列中的元素（这里为元组）转成列表
>>> print(u, v, w)  # 直接将 map() 得到的迭代器拆包，分别赋值给 u, v, w
[1, 1, 2, 3] [3, 4, 3, 4] [3, 1, 4, 1]
```



代码中的 `u, v, w = map(list, zip(*mat))` 是将二维数组 `mat` 的列转换为三个单独的列表 `u`, `v`, `w`。

让我们逐步解释这段代码：

1.  首先，`zip(*mat)` 使用 `*mat` 解包参数，将二维数组 `mat` 的每一行作为参数传递给 `zip()` 函数。
2.  `zip(*mat)` 将多个可迭代对象（这里是每一行）中对应位置的元素打包成元组的形式。这将返回一个迭代器，其中每个元素都是来自 `mat` 中相同位置的元素所组成的元组。
3.  `map(list, ...)` 将上一步得到的迭代器中的元组转换为列表。即将每个元组中的元素转换为列表的形式。
4.  最后，`u`, `v`, `w` 使用解包操作符将 `map()` 得到的可迭代对象拆开并分别赋值给变量 `u`, `v`, `w`。

问题出在输入的部分。你提供的输入没有按照正确的格式进行。根据你提供的输入，`mat` 实际上是一个 4×3 的二维列表，而不是你期望的 4×3 矩阵。这是因为输入时没有正确地将每一行的元素分隔开。

正确的输入应该像这样：

```
Copy Code1 3 3
1 4 1
2 3 4
3 4 1

```

将每一行的元素正确分隔开后，代码将按预期工作，并返回三个列表，即 `u`, `v`, `w`。

\*mat有什么用详细解释一下



在这段代码中，`*mat` 是将二维数组 `mat` 解包，也可以称为参数解包。

在 Python 中，使用 `*` 运算符可以对可迭代对象进行解包操作。当我们将 `*mat` 作为参数传递给函数或者用于其他操作时，它会将二维数组 `mat` 中的每一行作为单独的参数传递。

让我们来详细解释一下这个过程：

1.  `zip()` 函数接受多个可迭代对象作为参数，并将这些可迭代对象中对应位置的元素打包成元组的形式。
2.  在这段代码中，我们希望将 `mat` 中的每一列分别打包成元组。所以我们需要将二维数组 `mat` 解包，使得每一行成为单独的参数。
3.  使用 `*mat`，`mat` 将被解包成多个参数，每个参数代表了二维数组中的一行。
4.  这些解包后的行参数将作为多个参数传递给 `zip()` 函数。因此，`zip(*mat)` 实际上相当于 `zip(row1, row2, row3, ...)`
5.  `zip(*mat)` 将每个参数（即每行的元素）的相应位置组合成元组，并返回一个迭代器，其中每个元素都是来自 `mat` 中相同列的元素所组成的元组。

\*

这种参数解包的方式非常方便，可以将数组的行或列作为单独的参数进行处理，例如在这段代码中用于分离二维数组的列。

```
res = ['bcd', 'bcd', 'bcd', 'bcd']
print(*res, sep='.')
```

这相当于：

```

print('bcd', 'bcd', 'bcd', 'bcd', sep='.')
```

$**$用于字典

```python
# 请注意从现在开始我们不再使用 REPL，请自行复制多行数据
u, v, w = ([] for i in range(3))  # 多变量赋值
for i in range(4):  # 这里假设输入 4 行数据
    _u, _v, _w = [int(x) for x in input().split()]
    u.append(_u), v.append(_v), w.append(_w)
    # 不可进行类似 cin >> u[i] >> v[i] >> w[i] 的操作，因为必定超出列表当前的长度
    # 当然你可以选择初始化长度为 MAXN 的全 0 列表，不过需要记住真实长度并删掉多余元素
print(u, v, w)
```

**读取多行数据变为一行**

```python
def main():
    arr = []
    for _ in range(3):
        arr.extend(io())#前面加个list就是二维，不加就是一维，字符串自带迭代所以直接extend就行
    
    cnt = Counter(arr)#计数，但是要提前import

    
    for k, v in cnt.items():
        if v == 2:
            print(k)
```









文件读写

```py
a = []
with open('in.txt') as f:
    N = int(f.readline())  # 读入第一行的 N
    a[len(a):] = [[int(x) for x in f.readline().split()] for i in range(N)]

with open('out.txt', 'w') as f:
    f.write('1\n')
```







### **内置库**

在这里介绍一些写算法可能用得到的内置库，具体用法可以自行搜索或者阅读 [官方文档](https://docs.python.org/3/library/index.html)。

| 库名                                                         | 用途                         |
| :----------------------------------------------------------- | :--------------------------- |
| [`array`](https://docs.python.org/3/library/array.html)      | 定长数组                     |
| [`argparse`](https://docs.python.org/3/library/argparse.html) | 命令行参数处理               |
| [`bisect`](https://docs.python.org/3/library/bisect.html)    | 二分查找                     |
| [`collections`](https://docs.python.org/3/library/collections.html) | 有序字典、双端队列等数据结构 |
| [`fractions`](https://docs.python.org/3/library/fractions.html) | 有理数                       |
| [`heapq`](https://docs.python.org/3/library/heapq.html)      | 基于堆的优先级队列           |
| [`io`](https://docs.python.org/3/library/io.html)            | 文件流、内存流               |
| [`itertools`](https://docs.python.org/3/library/itertools.html) | 迭代器                       |
| [`math`](https://docs.python.org/3/library/math.html)        | 数学函数                     |
| [`os.path`](https://docs.python.org/3/library/os.html)       | 系统路径等                   |
| [`random`](https://docs.python.org/3/library/random.html)    | 随机数                       |
| [`re`](https://docs.python.org/3/library/re.html)            | 正则表达式                   |
| [`struct`](https://docs.python.org/3/library/struct.html)    | 转换结构体和二进制数据       |
| [`sys`](https://docs.python.org/3/library/sys.html)          | 系统信息                     |



### 装饰器

装饰器是一个函数，接受一个函数或方法作为其唯一的参数，并返回一个新函数或方法，其中整合了修饰后的函数或方法，并附带了一些额外的功能。简而言之，可以在不修改函数代码的情况下，增加函数的功能。相关知识可以参考 [官方文档](https://docs.python.org/3/glossary.html#term-decorator)。

部分装饰器在竞赛中非常实用，比如 [`lru_cache`](https://docs.python.org/3/library/functools.html#functools.lru_cache)，可以为函数自动增加记忆化的能力，在递归算法中非常实用：

```
@lru_cache(maxsize=128,typed=False)
```

- 传入的参数有 2 个：`maxsize` 和 `typed`，如果不传则 `maxsize` 的默认值为 128，`typed` 的默认值为 `False`。
- 其中 `maxsize` 参数表示的是 LRU 缓存的容量，即被装饰的方法的最大可缓存结果的数量。如果该参数值为 128，则表示被装饰方法最多可缓存 128 个返回结果；如果 `maxsize` 传入为 `None` 则表示可以缓存无限个结果。
- 如果 `typed` 设置为 `True`，不同类型的函数参数将被分别缓存，例如，`f(3)` 和 `f(3.0)` 会缓存两次。

以下是使用 `lru_cache` 优化计算斐波那契数列的例子：

```py
@lru_cache(maxsize = None)
def fib(n):
    if n < 2:
        return n
    return fib(n - 1) + fib(n - 2)
```





### 语法知识点

[内置类型 — Python 3.12.1 文档](https://docs.python.org/zh-cn/3/library/stdtypes.html#text-sequence-type-str)

[5. 数据结构 列表递推式— Python 3.12.1 文档](https://docs.python.org/zh-cn/3/tutorial/datastructures.html#list-comprehensions)

**''.join(\[chr(ord(ch) - 65 + 97) for ch in s if ch >= 'A' and ch <= 'Z'\]) **

解释一下这个语法的知识点



这段代码是一个简单的字符串处理代码，它将输入字符串中的大写字母转换为小写字母，并拼接成一个新的字符串。

让我们逐步解释代码的各个部分：

1.  `for ch in s if ch >= 'A' and ch <= 'Z'`：这是一个循环语句，遍历输入字符串 `s` 中的每个字符 `ch`。但是只处理那些满足条件 `ch >= 'A'`（即 ASCII 值在大写字母 A 的 ASCII 值以上）和 `ch <= 'Z'`（即 ASCII 值在大写字母 Z 的 ASCII 值以下）的字符。
    
2.  `ord(ch) - 65`：`ord(ch)` 函数返回字符 `ch` 的 ASCII 值，减去 65 得到的结果是相应大写字母相对于大写字母 A 的偏移量。ASCII 码值中大写字母 A 的值是 65。
    
3.  `chr(...)`：`chr()` 函数将 ASCII 值转换为对应的字符。
    
4.  `... + 97`：将前面计算得到的偏移量加上 97，这样就得到了相应小写字母相对于小写字母 a 的 ASCII 值。ASCII 码值中小写字母 a 的值是 97。
    
5.  `''.join([...])`：使用空字符串作为连接符，将前面计算得到的小写字母字符列表拼接成一个字符串。
    



**vis1 = \[\[0\] \* 3 for \_ in range(3)\]**



这段代码使用列表推导式创建了一个二维列表 `vis1`，其中包含了 3 行 3 列的矩阵。

现在我们一步一步来解释代码的各个部分：

1.  `[[0] * 3 for _ in range(3)]`：这是一个列表推导式，用于快速创建一个二维列表。列表推导式由两部分组成：外部的 `[]` 表示创建一个列表，内部的 `[0] * 3` 表示创建一个包含3个元素的列表，其中每个元素都是 0。最后的 `for _ in range(3)` 部分表示对前面创建的列表进行三次循环，每次循环都会生成一个相同的列表作为循环的元素。
    
2.  `vis1 = ...`：将列表推导式生成的二维列表赋值给变量 `vis1`，这样就创建了一个名为 `vis1` 的变量，并将其指向这个二维列表对象。
    



在这个例子中，通过 `[[0] * 3 for _ in range(3)]` 的列表推导式，我们创建了一个二维列表 `vis1`。具体解释如下：

-   外部的 `[]` 表示我们正在创建一个列表。
-   内部的 `[0] * 3` 表示我们创建了一个包含三个元素为 0 的小列表。
-   `for _ in range(3)` 表示我们对这个小列表进行循环三次。
-   每次循环都会生成一个相同的小列表作为循环的元素。

因此，通过列表推导式，我们得到了一个包含三个相同小列表的大列表，形成了一个 3 行 3 列的二维列表。



**vis = \[\[0\] \* 3\] \* 3**

和这个有什么区别



`vis = [[0] * 3] * 3` 这段代码与之前的代码 `vis1 = [[0] * 3 for _ in range(3)]` 在实现上是有区别的，尽管它们都是用来创建一个 3 行 3 列的二维列表。

让我们解释一下这段代码的区别：

1.  `[[0] * 3] * 3`：这是一个列表乘法操作符应用于一个嵌套列表的例子。`[0] * 3` 表示创建一个包含三个元素为 0 的小列表，然后通过乘法操作符 `*` 来复制这个小列表三次，形成一个大列表。即整个表达式表示，复制包含三个元素为 0 的小列表三次，生成一个包含三个相同小列表的大列表。
    
2.  `vis = ...`：将上述生成的二维列表赋值给变量 `vis`，这样就创建了一个名为 `vis` 的变量，并将其指向这个二维列表对象。
    

**区别在于这两种方式生成的二维列表中的元素是否为独立的对象。**

在 `[[0] * 3 for _ in range(3)]` 中，通过列表推导式的循环机制，每次都会创建一个新的小列表 `[0, 0, 0]`，因此最终的二维列表中的小列表是独立的对象。修改其中某个小列表的值不会影响其他小列表。

而在 `[[0] * 3] * 3` 中，乘法操作符复制的是同一个小列表 `[0, 0, 0]` 的引用，并将它重复添加到大列表中。这意味着每个小列表实际上是同一个对象的引用，修改其中一个小列表的值将同时影响其他小列表。

因此，使用 `[[0] * 3] * 3` 生成的二维列表中的小列表之间存在关联，而使用列表推导式 `[[0] * 3 for _ in range(3)]` 生成的二维列表中的小列表是独立的。一般来说，建议使用列表推导式的方式创建二维列表，以避免潜在的问题。



**这样生成的数组可以使用vis\[:2, :2\] **嘛



对于 `vis = [[0] * 3] * 3` 这种方式生成的二维列表，不能像 `vis[:2, :2]`（**第一个是行第二个是列**） 这样使用切片来获取部分列表。这是因为乘法操作符复制的是同一个小列表的引用，所以实际上每个小列表都是相同的对象。

正确的做法是使用逐行切片的方式来获取部分列表。例如，要获取前两行和前两列的部分列表，可以使用 `vis[:2]` 来获取前两行的子列表，然后再使用列表推导式进行逐行切片，即 `sub_vis = [row[:2] for row in vis[:2]]`。

这段代码将首先获取 `vis` 的前两行，然后对前两行的每一行进行进一步的切片，只保留每行的前两个元素。最终，`sub_vis` 将是一个包含前两行和前两列的部分列表。

```python
import numpy as np

vis = np.array([[0] * 3] * 3)

subset = vis[:2, :2]

print("Original array:")
print(vis)

print("\nSubset array:")
print(subset)

```

这样可以



\[\[0\] \* 3 for \_ in range(3)\] 这个能不能

对于 `[[0] * 3 for _ in range(3)]` 这种方式生成的二维列表，是可以使用 `vis[:2][:2]` 这样的切片操作来获取部分列表的。这是因为每次循环时都会创建一个新的小列表 `[0, 0, 0]`，所以每个小列表都是独立的对象。

使用 `vis[:2]` 可以获取前两行的子列表，然后再使用 `[:2]` 对这个子列表进行切片，即 `vis[:2][:2]`。这将返回前两行中的前两个元素，形成一个部分列表。

因此，对于 `[[0] * 3 for _ in range(3)]` 这样生成的二维列表，可以使用 `vis[:2][:2]` 来获取部分列表。



```python
>>> b = 'A' == 65  # 明明在 C/C++ 中是成立的
>>> b  # 与众不同的是 True, False 首字母均大写，可能与内置常量的命名约定有关
False

```

因为类型不同



**numpy**

`import numpy as np` 是将 NumPy 模块导入到 Python 环境中，以便我们可以使用其中定义的函数和数据类型。通过使用 `np` 作为别名，我们可以更方便地使用 NumPy 中的函数和方法。

下面是对代码中出现的知识点进行解释：

-   `np.empty(3)`：这是一个创建形状为 (3,) 的一维数组的例子。它并没有初始化数组元素的值，而是返回了一些未知的数值。通常情况下，我们会使用 `np.zeros` 或 `np.ones` 来创建具有特定初始值的数组。
    
-   `np.zeros((3, 3))`：这是一个创建 3x3 形状的二维数组的例子。函数 `np.zeros` 创建一个由零组成的数组，并且接受一个元组作为参数来指定数组的形状。
    
-   `a1 = np.zeros((3, 3), dtype=int)`：这是一个创建具有整数类型的 3x3 数组的例子。在创建数组时，我们可以通过 `dtype` 参数指定所需的数据类型。在这个例子中，`dtype=int` 表示要创建一个整数类型的数组。
    
-   `a1[0][0] = 1` 和 `a1[0, 0] = 1`：这两个语句都是将数组 `a1` 的第一个元素设置为 1。使用方括号 `[]` 的方式是常规的二维数组访问和赋值的方法，其中第一个索引表示行，第二个索引表示列。使用逗号分隔的方式 `a1[0, 0]` 是更简洁、友好的语法。
    
-   `a1.shape`：这个属性返回数组 `a1` 的形状。对于二维数组，它返回一个元组，其中第一个元素表示行数，第二个元素表示列数。
    
-   `a1[:2, :2]`：这是一个从数组 `a1` 中获取前两行和前两列形成的子阵的例子。`:` 表示取所有的索引范围，所以 `:2` 表示取前两个索引。这种写法称为切片操作，能够在不进行拷贝的情况下获取原始数组的子集。
    
-   `a1[0, 2]`：这个操作用于获取数组 `a1` 的第 1 列和第 3 列的交叉点处的值。请注意，在这里 `0` 表示第 1 行，`2` 表示第 3 列。由于切片操作的结果是一个降低了维度的数组，所以返回的结果是一个 2x1 的二维数组。
    
-   `np.max(a1)`：这个函数用于获取数组 `a1` 中的最大值。
    
-   `a1.flatten()`：这个方法将多维数组 `a1` 平铺成一维数组。返回的结果是一个具有原始数组同样元素的一维数组。
    
-   `np.sort(a1, axis=1)`：这个函数用于对数组 `a1` 沿着指定轴进行排序。在这个例子中，`axis=1` 表示沿着行的方向进行排序。返回的结果是已排序的数组副本。
    
-   `a1.sort(axis=1)`：这个方法与 `np.sort` 函数类似，但它会直接在数组 `a1` 上原地排序，而不返回副本。
    



**如果我想创建多个数组呢**



如果你想创建多个数组，你可以使用`np.zeros`、`np.ones`或`np.empty`等函数，并将它们赋值给不同的变量。例如，你可以这样创建多个数组：

```
pythonCopy Codeimport numpy as np

a = np.zeros((3, 3))
b = np.ones((2, 4))
c = np.empty((5, 5))

# 打印创建的数组
print(a)
print(b)
print(c)

```



怎么获取vis的第一列和第三列呢



要获取二维数组 `vis` 的第一列和第三列，你可以使用切片操作或索引操作。这里有两种方法可以实现：

方法一：使用切片操作

```
pythonCopy Codeimport numpy as np

# 假设 vis 是一个形状为 (5, 4) 的二维数组
vis = np.array([[1, 2, 3, 4],
                [5, 6, 7, 8],
                [9, 10, 11, 12],
                [13, 14, 15, 16],
                [17, 18, 19, 20]])

first_column = vis[:, 0]  # 获取第一列
third_column = vis[:, 2]  # 获取第三列

print(first_column)
print(third_column)

```

`:` 表示对整个轴的切片操作，所以 `[:, 0]` 表示获取所有行的第一列，`[:, 2]` 表示获取所有行的第三列。

请注意，切片操作返回的是原始数组的一个视图，而不是副本。这意味着当你更改切片得到的数组时，原始数组也会相应地改变。如果你需要一个副本，可以使用 `np.copy()` 函数创建一个新的数组。



a1.flatten()：这个方法将多维数组 a1 平铺成一维数组。返回的结果是一个具有原始数组同样元素的一维数组。 这个不会改变原数组吗



对的，`a1.flatten()` 方法将多维数组 `a1` 平铺成一维数组，但它不会改变原始数组 `a1` 的形状或内容。返回的结果是一个新的一维数组，其中包含了 `a1` 中同样的元素。

这个方法可以用于将多维数组转换为一维数组，方便进行某些操作或计算。但请注意，它不会修改原始数组本身。

如果你想要在不创建副本的情况下改变原数组的形状，你可以使用 `a1.reshape()` 方法。这个方法返回一个具有指定形状的数组，但不会改变原始数组的内容。如果你需要一个修改了形状的新数组，可以将其赋值给另一个变量。

以下是一个示例：

```
pythonCopy Codeimport numpy as np

a1 = np.array([[1, 2, 3],
               [4, 5, 6]])

# 使用 flatten() 方法将多维数组平铺成一维数组
flatten_array = a1.flatten()

# 修改原数组的形状，不改变内容
reshaped_array = a1.reshape(3, 2)

print(flatten_array)   # [1 2 3 4 5 6]
print(a1)              # [[1 2 3]
                       #  [4 5 6]]
print(reshaped_array)  # [[1 2]
                       #  [3 4]
                       #  [5 6]]

```



sort怎么改变原数组怎么不改变来着



对于 NumPy 中的数组，你可以使用 `sort()` 方法来对数组进行排序。默认情况下，`sort()` 方法会改变原始数组的顺序。

示例：

```
pythonCopy Codeimport numpy as np

arr = np.array([3, 1, 4, 2, 5])

arr.sort()

print(arr)  # [1 2 3 4 5]

```

在这个示例中，原始数组 `arr` 在调用 `sort()` 方法后被修改为升序排列的结果。

如果你不想改变原始数组，而是想得到一个新的排序后的数组，你可以使用 `np.sort()` 函数。

示例：

```
pythonCopy Codeimport numpy as np

arr = np.array([3, 1, 4, 2, 5])

sorted_arr = np.sort(arr)

print(sorted_arr)  # [1 2 3 4 5]
print(arr)        # [3 1 4 2 5]

```

在这个示例中，我们使用 `np.sort()` 函数对数组 `arr` 进行排序，并将结果赋值给新的数组 `sorted_arr`。原始数组 `arr` 的顺序保持不变。

总结起来就是：

-   使用数组的 `sort()` 方法可以直接在原始数组上进行排序，改变原始数组。
-   使用 `np.sort()` 函数可以得到一个新的排序后的数组，而原始数组保持不变。



**\>>> a1.sort(axis = 1) # 沿行方向对数组进行原地排序 这是什么**



`a1.sort(axis=1)` 是对数组 `a1` 沿着行轴（即沿着每一行进行操作）进行原地排序的操作。

在 NumPy 中，`sort()` 方法可以接受一个可选的 `axis` 参数，用于指定要排序的轴。通过指定 `axis=1`，我们告诉 `sort()` 方法沿着行轴进行排序。

示例：

```
pythonCopy Codeimport numpy as np

a1 = np.array([[3, 1, 4],
               [2, 5, 0]])

a1.sort(axis=1)

print(a1)

```

输出结果：

```
Copy Code[[1 3 4]
 [0 2 5]]

```

在这个示例中，原始数组 `a1` 是一个 2x3 的二维数组。调用 `a1.sort(axis=1)` 方法后，它会对每一行进行排序，最终得到按行排序的结果。

请注意，原地排序意味着原始数组 `a1` 的顺序被修改。如果你不想修改原始数组，可以使用 `np.sort(a1, axis=1)` 函数进行排序，并将结果赋值给一个新的数组。这样可以保持原始数组的顺序不变。





```python
# 条件表达式两侧无括号
if 4 >= 3 > 2 and 3 != 5 == 5 != 7:
    print("关系运算符可以连续使用")
    x = None or [] or -2
    print("&&  ||  !", "与  或  非", "and or not", sep='\n')
    print("善用 and/or 可节省行数")
    if not x:
        print("负数也是 True，不执行本句")
    elif x & 1:
        print("用 elif 而不是 else if\n"
        "位运算符与 C 相近，偶数&1 得 0，不执行本句")
    else:
        print("也有三目运算符") if x else print("注意结构")
```



“：=”是这个符号



`:=` 这个符号在 Python 3.8 版本中引入，用于在表达式中进行赋值操作。它的作用是将一个值赋给变量，并在同一表达式中使用该变量。

以下是一个使用 `:=` 符号的例子：

```
pythonCopy Codewhile (line := input("请输入一行文本：")) != "quit":
    print("你输入的是：" + line)

```

在上述例子中，我们使用 `:=` 将用户输入的文本赋给变量 `line`，并在同一表达式中判断 `line != "quit"` 是否为真。

这样，程序会循环询问用户输入，直到输入的文本等于 "quit"，循环才会结束。

海象运算符可以用于简化某些代码逻辑，并在一行中同时进行赋值和判断。但请注意，它只能在 Python 3.8 及更高版本中使用。



**dict**

1. **基本形式：**

   ```
   pythonCopy codedic = {'key': "value"}
   print(dic)
   # 输出: {'key': 'value'}
   ```

2. **大写字母到对应 ASCII 码的映射：**

   ```
   pythonCopy codedic = {chr(i): i for i in range(65, 91)}
   print(dic)
   # 输出: {'A': 65, 'B': 66, ..., 'Z': 90}
   ```

3. **与上述效果相同：**

   ```
   pythonCopy codedic = dict(zip([chr(i) for i in range(65, 91)], range(65, 91)))
   print(dic)
   # 输出: {'A': 65, 'B': 66, ..., 'Z': 90}
   ```

4. **将键值对逆转：**

   ```
   pythonCopy codedic = {dic[k]: k for k in dic}
   print(dic)
   # 输出: {65: 'A', 66: 'B', ..., 90: 'Z'}
   ```

5. **和上一行作用相同：**

   ```
   pythonCopy codedic = {v: k for k, v in dic.items()}
   print(dic)
   # 输出: {65: 'A', 66: 'B', ..., 90: 'Z'}
   ```

6. **字典按值逆排序：**

   ```
   pythonCopy codedic = {k: v for k, v in sorted(dic.items(), key=lambda x: -x[1])}
   print(dic)
   # 输出: {90: 'Z', 89: 'Y', ..., 65: 'A'}
   ```

7. **访问字典中以 'A' 为键的项：**

   ```
   pythonCopy codeprint(dic['A'])
   # 输出: 65
   ```

8. **将字典中 'a' 对应的值设为 97：**

   ```
   pythonCopy codedic['a'] = 97
   print(dic)
   # 输出: {'A': 65, 'B': 66, ..., 'Z': 90, 'a': 97}
   ```

9. **检查 'b' 是否在字典中，如果是则打印值，否则将 'b' 插入字典：**

   ```
   pythonCopy codeif 'b' in dic:
       print(dic['b'])
   else:
       dic['b'] = 98
   print(dic)
   # 输出: {'A': 65, 'B': 66, ..., 'Z': 90, 'a': 97, 'b': 98}
   ```

10. **统计出现次数：**

```
pythonCopy codekey = 'example_key'
try:
    dic[key] += 1
except KeyError:
    dic[key] = 1
print(dic)
# 输出: {'A': 65, 'B': 66, ..., 'Z': 90, 'a': 97, 'b': 98, 'example_key': 1}
```

**map在python里有什么用**

2023/7/26 20:30:41

在 Python 中，`map()` 函数是一个内置函数，用于将一个函数应用于可迭代对象（如列表、元组等）的每个元素，并返回一个新的可迭代对象，其中包含了应用函数后的结果。

`map()` 函数的基本语法如下：

```
pythonCopy Codemap(function, iterable)

```

其中，`function` 是一个函数或可调用对象，`iterable` 是一个可迭代对象（如列表、元组、集合等）。

以下是 `map()` 函数的使用例子：

```
pythonCopy Code# 将列表中的每个元素平方
numbers = [1, 2, 3, 4, 5]
squared_numbers = list(map(lambda x: x**2, numbers))
print(squared_numbers)
# 输出：[1, 4, 9, 16, 25]

# 将字符串列表中的每个字符串转换为大写
fruits = ['apple', 'banana', 'orange']
uppercased_fruits = list(map(str.upper, fruits))
print(uppercased_fruits)
# 输出：['APPLE', 'BANANA', 'ORANGE']

```

在上面的例子中，我们使用 `map()` 函数对列表中的每个元素应用了不同的操作。在第一个例子中，我们使用 `lambda` 函数平方了每个数字；在第二个例子中，我们使用了内置的 `str.upper` 方法将每个字符串变成大写。

`map()` 函数返回的是一个迭代器，因此我们可以使用 `list()` 函数将其转换为列表。

通过使用 `map()` 函数，我们可以方便地对可迭代对象的每个元素应用同一个函数或操作，从而避免显式的循环。



**默认参数**

```py
def append_to(element, to=None):
    if to is None:
        to = []
    to.append(element)
    return to
```



**对象**

```py
class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"Vector({self.x}, {self.y})"

    def __repr__(self):
        return f"Vector({self.x}, {self.y})"

    def __len__(self):
        return 2  # 二维向量长度为2

    def __getitem__(self, index):
        if index == 0:
            return self.x
        elif index == 1:
            return self.y
        else:
            raise IndexError("Vector index out of range")

    def __setitem__(self, index, value):
        if index == 0:
            self.x = value
        elif index == 1:
            self.y = value
        else:
            raise IndexError("Vector index out of range")

    def __iter__(self):
        yield self.x
        yield self.y

# 创建向量对象
v = Vector(3, 4)

# 调用 __str__ 和 __repr__
print(str(v))    # 输出: Vector(3, 4)
print(repr(v))   # 输出: Vector(3, 4)

# 调用 __len__
print(len(v))    # 输出: 2

# 调用 __getitem__
print(v[0])      # 输出: 3
print(v[1])      # 输出: 4

# 调用 __setitem__
v[0] = 5
v[1] = 6
print(str(v))    # 输出: Vector(5, 6)

# 调用 __iter__
for coordinate in v:
    print(coordinate)
# 输出:
# 5
# 6

```

> 只需要注意两个    def __init__(self, x, y):    def __call__(self, x): 
>
> self相当于实例对象
>
> call生命对象时会直接得到里面的return
>
> 如下：

```py
class MyCallable:
    def __init__(self):
        pass

    def __call__(self, x):
        return x * x

# 创建类的实例
my_instance = MyCallable()

# 调用实例，实际上调用了 __call__ 方法
result = my_instance(5)

print(result)  # 输出 25

```





### 实战

好的你现在已经学会基本语法了，请做一道模板题吧

【模板】单源最短路径（标准版）

题目背景

2018 年 7 月 19 日，某位同学在 [NOI Day 1 T1 归程](https://www.luogu.org/problemnew/show/P4768) 一题里非常熟练地使用了一个广为人知的算法求最短路。

然后呢？

$100 \rightarrow 60$；

$\text{Ag} \rightarrow \text{Cu}$；

最终，他因此没能与理想的大学达成契约。

小 F 衷心祝愿大家不再重蹈覆辙。

题目描述

给定一个 $n$ 个点，$m$ 条有向边的带非负权图，请你计算从 $s$ 出发，到每个点的距离。

数据保证你能从 $s$ 出发到任意点。

输入格式

第一行为三个正整数 $n, m, s$。
第二行起 $m$ 行，每行三个非负整数 $u_i, v_i, w_i$，表示从 $u_i$ 到 $v_i$ 有一条权值为 $w_i$ 的有向边。

输出格式

输出一行 $n$ 个空格分隔的非负整数，表示 $s$ 到每个点的距离。

样例 #1

样例输入 #1

```
4 6 1
1 2 2
2 3 2
2 4 1
1 3 5
3 4 3
1 4 4
```

样例输出 #1

```
0 2 4 3
```

## 

样例解释请参考 [数据随机的模板题](https://www.luogu.org/problemnew/show/P3371)。

$1 \leq n \leq 10^5$；

$1 \leq m \leq 2\times 10^5$；

$s = 1$；

$1 \leq u_i, v_i\leq n$；

$0 \leq w_i \leq 10 ^ 9$,

$0 \leq \sum w_i \leq 10 ^ 9$。

本题数据可能会持续更新，但不会重测，望周知。

2018.09.04 数据更新 from @zzq

导入

```py
try: # 引入优先队列模块
    import Queue as pq #python version < 3.0
except ImportError:
    import queue as pq #python3.*

N = int(1e5 + 5)
M = int(2e5 + 5)
INF = 0x3f3f3f3f
```

链式前向星

```py
class qxx:  # 前向星类（结构体）
    def __init__(self):
        self.nex = 0
        self.t = 0
        self.v = 0

e = [qxx() for i in range(M)]  # 链表
h = [0 for i in range(N)]
cnt = 0

dist = [INF for i in range(N)]
q = pq.PriorityQueue()  # 定义优先队列，默认第一元小根堆

def add_path(f, t, v):  # 在前向星中加边
    # 如果要修改全局变量，要使用 global 来声明
    global cnt, e, h
    # 调试时的输出语句，多个变量使用元组
    # print("add_path(%d,%d,%d)" % (f,t,v))
    cnt += 1
    e[cnt].nex = h[f]
    e[cnt].t = t
    e[cnt].v = v
    h[f] = cnt
```

main

```py
if __name__ == '__main__':
    # 一行读入多个整数。注意它会把整行都读进来
    n, m, s = map(int, input().split())
    for i in range(m):
        u, v, w = map(int, input().split())
        add_path(u, v, w)

    dijkstra(s)

    for i in range(1, n + 1):
        print(dist[i], end = ' ')

    print()
```

下面给出Java和py代码

<img width="867" alt="image" src="https://github.com/slivermaker/ClassicAlgorithm/assets/86837593/92a2bd44-8d45-406b-8c78-287fb9549fb1">

```java
import java.util.*;
import java.io.*;

class Qxx {
    int nex, t, v;

    public Qxx(int nex, int t, int v) {
        this.nex = nex;
        this.t = t;
        this.v = v;
    }
}

public class test {
    static Qxx[] e;
    static int[] h, dist;
    static int cnt;
    static PriorityQueue<int[]> q;

    static void addPath(int f, int t, int v) {
        e[++cnt] = new Qxx(h[f], t, v);
        h[f] = cnt;
    }

    static void dijkstra(int s) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        q.add(new int[]{0, s});
        while (!q.isEmpty()) {
            int[] u = q.poll();
            if (dist[u[1]] < u[0]) continue;
            for (int i = h[u[1]]; i != 0; i = e[i].nex) {
                int v = e[i].t, w = e[i].v;
                if (dist[v] <= dist[u[1]] + w) continue;
                dist[v] = dist[u[1]] + w;
                q.add(new int[]{dist[v], v});
            }
        }
    }

    public static void main(String[] args) {
        int N = 100005, M = 200005;
        e = new Qxx[M];
        h = new int[N];
        dist = new int[N];
        q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int n, m, s;

        // Reading input
        AC in = new AC();
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        for (int i = 1; i <= m; i++) {
            int u, v, w;
            u = in.nextInt();
            v = in.nextInt();
            w = in.nextInt();
            addPath(u, v, w);
        }

        // Using predefined values for testing
        

        dijkstra(s);

        for (int i = 1; i <= n; i++) {
            in.print(dist[i] + " ");
        }
        in.flush();
    }
}
class AC extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // 标准 IO
    public AC() { this(System.in, System.out); }
    public AC(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // 文件 IO
    public AC(String intput, String output) throws IOException {
        super(output);
        r = new BufferedReader(new FileReader(intput));
    }
    // 在没有其他输入时返回 null
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}
```

```python
try:  # 引入优先队列模块
    import Queue as pq  # python version < 3.0
except ImportError:
    import queue as pq  # python3.*

N = int(1e5+5)
M = int(2e5+5)
INF = 0x3f3f3f3f

class qxx:  # 前向星类（结构体）
    def __init__(self):
        self.nex = 0
        self.t = 0
        self.v = 0

e = [qxx() for i in range(M)]  # 链表
h = [0 for i in range(N)]
cnt = 0

dist = [INF for i in range(N)]
q = pq.PriorityQueue()  # 定义优先队列，默认第一元小根堆

def add_path(f, t, v):  # 在前向星中加边
    # 如果要修改全局变量，要使用 global 来声名
    global cnt, e, h
    # 调试时的输出语句，多个变量使用元组
    # print("add_path(%d,%d,%d)" % (f,t,v))
    cnt += 1
    e[cnt].nex = h[f]
    e[cnt].t = t
    e[cnt].v = v
    h[f] = cnt

def nextedgeid(u):  # 生成器，可以用在 for 循环里
    i = h[u]
    while i:
        yield i
        i = e[i].nex

def dijkstra(s):
    dist[s] = 0
    q.put((0, s))
    while not q.empty():
        u = q.get()
        if dist[u[1]] < u[0]:
            continue
        for i in nextedgeid(u[1]):
            v = e[i].t
            w = e[i].v
            if dist[v] <= dist[u[1]]+w:
                continue
            dist[v] = dist[u[1]]+w
            q.put((dist[v], v))


# 如果你直接运行这个python代码（不是模块调用什么的）就执行命令
if __name__ == '__main__':
    # 一行读入多个整数。注意它会把整行都读进来
    n, m, s = map(int, input().split())
    for i in range(m):
        u, v, w = map(int, input().split())
        add_path(u, v, w)

    dijkstra(s)

    for i in range(1, n + 1):
        # 两种输出语法都是可以用的
        print("{}".format(dist[i]), end=' ')
        # print("%d" % dist[i],end=' ')

    print()  # 结尾换行
```





二位偏序问题：主要展示排序lambda

```python
class Solution:
    def maximumSumQueries(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        ans = [-1] * len(queries)
        a = sorted(((a, b) for a, b in zip(nums1, nums2)), key=lambda p: -p[0])
        j = 0
        st = []
        for i, (x, y) in sorted(enumerate(queries), key=lambda p: -p[1][0]):
            while j < len(a) and a[j][0] >= x:  # 下面只需关心 ay (a[j][1])
                ax, ay = a[j]
                while st and st[-1][1] <= ax + ay:  # ay >= st[-1][0]
                    st.pop()
                if not st or st[-1][0] < ay:
                    st.append((ay, ax + ay))
                j += 1
            p = bisect_left(st, (y,))
            if p < len(st):
                ans[i] = st[p][1]
        return ans

#https://leetcode.cn/problems/maximum-sum-queries/description/?envType=list&envId=0eYRM9Tb
```

