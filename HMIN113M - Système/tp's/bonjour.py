#!/usr/bin/env python3
# -*- coding: utf8 -*-


import sys
import os

os.system("last > fil.txt")



print("Bonjour ! ", end="")
if len(sys.argv) > 2:
        print(sys.argv[2:])


"""
for parameters in sys.argv[1:]:
    print(parameters)
"""

"""r = 1
if len(sys.argv) == 2:
    n = sys.argv[1]
    n = int(n)
if (n==1 or n==0):
    print(n,"! = 1")
else:
    while n>1:
        r *=n
        n -=1
print (sys.argv[1],"! = ",r)
"""




    

