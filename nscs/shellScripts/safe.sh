#!/bin/sh
# Flora Dallinger

if test $# -gt 1; then
    echo "Zu viele Parameter"
    exit
fi

if test $# != 1; then
    verzeichnis="backup"S
else
    verzeichnis=$1
fi


if test ! -d $verzeichnis; then
    mkdir $verzeichnis
fi

time=$(expr $(date +%s) - $(date -d 2025-01-01 +%s))

for i in *.sh *.txt; do
    test $i = "*.sh" -o $i = "*.txt" && continue
    if test ! -e "$verzeichnis/$i" || test $i -nt "$verzeichnis/$i"; then
        time=$(expr $(date +%s) - $(date -d 2025-01-01 +%s))
        cp $i "$verzeichnis/$i.$time"
        cp $i "$verzeichnis/$i"
        echo "Kopiert"
    fi
done
