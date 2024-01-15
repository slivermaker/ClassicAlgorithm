import os
import sys
import numpy as np

io=lambda : sys.stdin.readline().strip()
iar=lambda : list(map(int ,io().split()))
# 请在此输入您的代码
def main():
  n=(int)(io())
  arr=io()
  tmp1=tmp2=0
  c1=c2=0
  for i in range(n):
    if(arr[i]=='0'):
      c1+=1
      tmp1+=i-c1+1
    

  for i in range(n):
    
    if(arr[i]=='1'):
      c2+=1
      tmp2+=i-c2+1
  print(min(tmp1,tmp2))


  


if __name__=='__main__':
  t=1
  #t=(int)io()
  for _ in range(t):
    main()