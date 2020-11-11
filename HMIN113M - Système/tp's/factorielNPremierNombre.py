#!/usr/bin/env python3
# -*- coding: utf8 -*-


import sys
import os
from nombrepremier import nombrepremier

n = int(sys.argv[1])
npnp = nombrepremier(n)

print ("len(npnp) ====================================================== ",len(npnp))

if len(sys.argv) == 2:
    n = int(sys.argv[1])
while (len(npnp) <n):
    #nombrepremier(n)
    npnp += nombrepremier(n)
print("Voila les",n,"premier nombre premier =",npnp)
