#!/bin/sh
# Flora Dallinger

gehalt=0;

exec < einaus.txt
while read a b; do
# um Leerzeichen zu entfernen sed 's/ //g'
    newb=$(echo $b | sed 's/,/./')
    echo $a

    if test "$a" = "ein"; then
        gehalt=$(echo $gehalt + $newb | bc)
        echo $gehalt
    elif test "$a" = "aus"; then
        gehalt=$(echo $gehalt - $newb | bc)
        echo $gehalt
    fi  
done
