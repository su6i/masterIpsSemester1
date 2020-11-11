#!/usr/bin/env python3
# -*- coding: utf8 -*-


import sys, os, random


os.system("clear")

#countinueQuestions = int(sys.argv[1])

if len(sys.argv) == 2:
    countinueQuestions = int(sys.argv[1])
    findByCountry = "country"
elif len(sys.argv) == 3:
    countinueQuestions = int(sys.argv[1])
    if sys.argv[2] == "capital":
            findByCountry = "capital"
    else:
            findByCountry = "country"
else:
    countinueQuestions = 1
    findByCountry = "country"

    print("You didn't entered the correct parameters. You'll just play the game ONCE.")
    
print("You'll have: ",countinueQuestions,"questions. \t enter QUIT to exit or press ENTER to go to the next question.)")
print("Mode : ",findByCountry)



fd = open("capitales.csv", "r")

for line in fd.readlines() :

        subChaines = line.split(",")
        countryName = subChaines[0].split("(")[0]
        countryName = countryName.strip()
        country.append(countryName)
        capital.append(subChaines[1][:-1])

# la partie de liste
capital=[]
country=[]

        for s in subChaines:
        capitalsDic[countryName] = subChaines[1][:-1]



        #        questionNumber = random.randint(1, len(capitalsDic))
        #        question = random.choice(list(capitalsDic))
        #        random.sample(capitalsDic, 1)
        #        question = capitalsDic.pop()

# fin de la partie de liste
        


# la partie de dictionnaire

capitalsDic={}
score = 0
counter = 0

#print(country)

if findByCountry == 'country':

        while countinueQuestions > 0:
                counter +=1
                countinueQuestions -=1
                countryDic,capitalDic = random.sample(list(capitalsDic.items()),k=1)[0]

                """print("random.choice(list(capitalsDic.items())):::::",random.choice(list(capitalsDic.items())))
                print("countryDic:",countryDic, "random.sample(list(capitalsDic.items()),k=1)[0]",random.sample(list(capitalsDic.items()),k=1)[0])
                print("countryDic:",countryDic, "random.sample(capitalsDic.items(),k=1)",random.sample(capitalsDic.items(),k=1))
                print("countryDic:",countryDic, "random.sample(list(capitalsDic.items()),k=1)",random.sample(list(capitalsDic.items()),k=1))"""


                print("Question",counter, end="")
                question = "What is the capital of "+countryDic+"? "
                print(" \t Answer: ", capitalDic)
                answer = input(question)
                if answer.lower() == capitalDic.lower():
                        score +=1
                        print("Bravo.",end="")
                else:
                        print("Wrong answer.")
                print("Score:",score," out of",counter,", Correct answered ",(score/counter)*100,"%")
                print("The capital of",countryDic+"is :",capitalDic, end="\n\n")
                if answer.lower() == "quit":
                        break


elif findByCountry == 'capital':

        while countinueQuestions > 0:
                counter +=1
                countinueQuestions -=1
                countryDic,capitalDic = random.sample(list(capitalsDic.items()),k=1)[0]

                print("Question",counter, end="")
                question = "Which country's capital is: "+capitalDic+"? "
                print(" \t Answer: ", countryDic)

                answer = input(question)
                
                print("answer=",answer.lower()+"|")
                print("country=",countryDic.lower()+"|")
                
                if answer.lower() == countryDic.lower():
                        score +=1
                        print("Bravo.",end="")
                else:
                        print("Wrong answer.")
                print("Score:",score," out of",counter,", Correct answered ",(score/counter)*100,"%")
                print(capitalDic,"is the capital of",countryDic, end="\n\n")
                if answer.lower() == "quit":
                        break


#fin de la partie de dictionnaire









fd.close()


