#!/usr/bin/env python3
# -*- coding: utf8 -*-


import sys
import os

def nombrepremier(n):
#    n = int(sys.argv[1])

    np=[2]

    if len(sys.argv) == 2:
        n = int(sys.argv[1])
    for candidat in range(3,n):
        isTrue = True
        print ("candidat = ",candidat)
        for diviseur in np:
            print ("%c[%d;%df" % (0x1B, 40, 25), end='')
            print("diviseur = ",diviseur)
            if (candidat % diviseur) == 0:
                print(candidat," is divisable by ",diviseur)
                isTrue = False
                break
            ## end of if
        if isTrue == True:
    return candidat

    ## end of for

np.append(candidat)
print("--------------------------")


print(nombrepremier(int(sys.argv[1])))