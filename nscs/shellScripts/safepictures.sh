#!/bin/sh
# Flora Dallinger

url="https://mb.sb/image_urls.txt"
txtDatei="bilder.txt"
touch $txtDatei
curl -sL $url >> $txtDatei

mkdir -p bilder_folder

cat $txtDatei | while read url; do
    echo $url
    curl --output bilder_folder/$(basename $url) "$url"
    
done

for i in $(find bilder_folder -type f \( -iname "*.jpg" -o -iname "*.JPG" \)); do
    yearOfPicture=$(exiftool -d '%Y' -DateTimeOriginal -S -s "$i")

    mkdir -p "bilder_folder/$yearOfPicture"
    mv $i "bilder_folder/$yearOfPicture"
    echo "moving pictures"
done

echo finished
