#!/bin/sh
# Flora Dallinger

if test $# -gt 1; then
    echo "Zu viele Parameter"
    exit
fi

verzeichnis="backup"

if test $# = 1; then
    verzeichnis=$1
fi


#if test ! -d $verzeichnis; then mkdir $verzeichnis fi

mkdir -p $verzeichnis

for i in *.sh *.txt; do
    test $i = "*.sh" -o $i = "*.txt" && continue
  
    diffFile="$i.diff"
    if test ! -e "$verzeichnis/$i" || test $i -nt "$verzeichnis/$i"; then
        time=$(expr $(date +%s) - $(date -d 2025-01-01 +%s))
        
        version="---Version $time---"
        echo $version >> $diffFile
        if test ! -e "$verzeichnis/$i"; then
            cat $i >> $diffFile
        else
            difference=$(diff "$verzeichnis/$i" $i)
            echo $difference >> "$diffFile"
        fi
        cp $i "$verzeichnis/$i.$time"
        cp $i "$verzeichnis/$i"
        echo "Kopiert"
    fi
done
