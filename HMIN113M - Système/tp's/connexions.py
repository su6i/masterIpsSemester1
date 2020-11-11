#!/usr/bin/env python3
# -*- coding: utf8 -*-


import sys,os,re


os.system("clear")
os.system("last -w > ./resources/last.txt")

if len(sys.argv) == 2:
    parameter = sys.argv[1].lower()
else:
    parameter = None



with open("./resources/last.txt", "r") as f:
    lines = f.readlines()

# régulière qui extrait : le login
def login():
    with open("./resources/connexionsLogin.txt", "w") as f:
        i = 1
        for line in lines:
            # Find the lines that have at least one "@" in it.
            if re.search(r'.@', line):
                j = str(i)
                # take the part before "@" as a username
                login = re.split("@",line)
                f.write(j+". "+login[0]+"\n")
                print(j+". "+login[0])
                i +=1
            else:
                # to print in the same line, I used "line[:-1]", to remove "\n" at the EOL
                print("----------------------------------------> This line is erased")
        
# régulière qui extrait : le nom du mois et le numéro du jour dans le mois (la date)

def dayAndMonth():
    with open("./resources/connexionsDayAndMonth.txt", "w") as f:
        i = 1
        for line in lines:
            # Find the lines that have at least one "@" in it.
            if re.search(r'.@', line):
                j = str(i)
                # take the part before "@" as a username
                date = line.rsplit(sep="       ",maxsplit=2)
                date = str(date[2:3])[2:9]
                
                f.write(j+". "+date+"\n")
                print(j+".",date)
                i +=1
            else:
                print("----------------------------------------")
   



# régulière qui extrait : le nombre d’heures
# régulière qui extrait : le nombre de minutes et affichez ces informations
# régulière qui Affichez: le nombre de connexions par login (via un dictionnaire)
# régulière qui Affichez: le nombre de connexions et le temps de connexions (en minutes) par login (via un dictionnaire de listes)
# régulière qui Affichez: puis par login et par date (via un dictionnaires de dictionnaires de listes)
# Suivant des paramètres indiquant un nombre maximal de connexions et/ou un temps de connexion cumulé maximal, affichez des alertes !


# un script python qui liste les jours de connexion des utilisateurs qui ont fréquenté cette machine
# (en sachant que vous désirez surveiller les (mauvaises) fréquentations de celle-ci).
# pompidor s’est connecté les : 25 septembre (1 fois), 24 septembre (1 fois), 23 septembre (4 fois)
# meynard s’est connecté les : 24 septembre (1 fois), 23 septembre (1 fois)



while parameter != ('quit' or None):

    if parameter == 'login':
        login()
    elif parameter == 'day':
        dayAndMonth()
    elif parameter == 'quit':
        break
    parameter = input("\nYour options are: login,day,quit: ").lower()


