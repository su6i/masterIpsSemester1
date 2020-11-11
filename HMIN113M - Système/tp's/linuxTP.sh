
clear
for f in *
do
    echo $f
    if [ -f $f ]
    then
	    r=$(grep -c $1 "$f")
		#r=$(find -type f -exec grep $1 "$f")
		echo $r
		if [[ $r > 0 ]]
		then
			echo $1 trouvé dans "$f"
			mv $f ./DUMP
		fi
    fi
done
