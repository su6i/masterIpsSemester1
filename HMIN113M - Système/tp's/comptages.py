#!/usr/bin/env python3
# -*- coding: utf8 -*-


import sys,os


os.system("clear")

# Get the directory's name as an argument, by default, it is the current directory
if len(sys.argv)>1:
    repertoire = sys.argv[1]
else:
    repertoire = "."

print("repertoire = ",repertoire)

# all extensions
extensions = {}

# the name of files by extensions
files = {}

nbTotal = 0


def parcours (repertoire, depth) :
    # To use of function's variables out of the funcion, we need to use "global" keyword
    global nbTotal
    print("   "*depth, repertoire)
    liste = os.listdir(repertoire)
    for fichier in liste :
        if os.path.isdir(repertoire+"/"+fichier) :
            parcours(repertoire+"/"+fichier, depth+1)
        
        else :
            # Find the last extension
            chaines = fichier.split(".")
            lastExt = chaines[-1]
            
            # If it found any extension, it'll put it in the "extensions" dictionary 
            # and also put the name of the file in another dictionary "files"
            if len(chaines) > 1 :
                if lastExt not in extensions:
                    extensions[lastExt] = 1
                    files[lastExt] = [fichier]
                else:
                    extensions[lastExt] += 1
                    files[lastExt].append(fichier)
                nbTotal += 1


# Appel initial de la fonction récursive
parcours (repertoire, 0) 

# Shows the number of repetition of each extension
for (k,v) in extensions.items():
    print(k+": "+str(v)+" times \t", end="") 

# Shows the total number of files
print("Total files: ",nbTotal)

# Shows the name of each extension
for ext in extensions:
    print(ext)
    for f in files[ext]:
        print("  ",f)



