def add(a, b):
    return a + b  # 动态类型的优势，a和b也可以是字符串


def add_no_swap(a, b):
    print('in func #1:', id(a), id(b))
    a += b
    b, a = a, b
    print('in func #2:', id(a), id(b))  # a, b 已交换
    return a, b  # 返回多个值，其实就是返回元组，可以拆包接收


lst1 = [1, 2]; lst2 = [3, 4]
print('outside func #1:', id(lst1), id(lst2))
add_no_swap(lst1, lst2)
# 函数外 lst1, lst2 并未交换
print('outside func #2:', id(lst1), id(lst2))
# 不过值确实已经改变
print(lst1, lst2)