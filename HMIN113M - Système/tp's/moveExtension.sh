#!/bin/bash

# To execute this file, you need to give two parameters, first parameter is an absolute address and the second one is 
# an extension, then this script will move all files with the given extension in the second parameter to the given address 
# in the first parameter.

# Ex. bash moveExtension.sh /home/su6 txt

clear
echo I look for $2 files in $1
echo --------------------------------------------------
for fichier in $1/* 
do
	if [ -f "$fichier" ]
	then
		r=$(find $fichier -name "*.$2")

		if [[ $r > 0 ]]
		then
			echo "$fichier" -----\> $1/DUMP
			mv "$fichier" $1/DUMP 
		fi
	fi

done

