#!/usr/bin/env python3
# -*- coding: utf8 -*-


import sys, os

os.system("clear")

r=1
if len(sys.argv) == 2:
    n = int(sys.argv[1])
if n<0:
    print("Please enter a number superior than 2")
elif n<2 and n>0:
    print(n,"!= 1")
else:
    while n >= 2:
        r *=n
        n -=1
print(sys.argv[1]+"! = ",r)



