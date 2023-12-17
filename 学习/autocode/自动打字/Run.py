import random
import time
import pyautogui

# 打开文件
file_path = 'code.txt'  # 替换为你的文本文件路径
time.sleep(5)
try:
    with open(file_path, 'r', encoding='utf-8') as file:
        # 读取文件内容
        content = file.read()

        # 逐字输入
        for char in content:
            if char == '\n':
                time.sleep(random.random() * 5)
            elif char == ' ':
                time.sleep(random.random() * 1)
           
            
            pyautogui.typewrite(char)
            time.sleep(random.random()/2)  # 可以根据需要调整输入速度

except FileNotFoundError:
    print(f"找不到文件：{file_path}")
except Exception as e:
    print(f"发生错误：{e}")
