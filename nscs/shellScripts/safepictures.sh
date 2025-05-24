#!/bin/sh
# Flora Dallinger

url="https://mb.sb/image_urls.txt"
txtDatei="bilder.txt"

curl -sL $url > $txtDatei

mkdir -p bilder_folder

cat $txtDatei | while read url; do
    echo $url
    curl --output bilder_folder/$(basename $url) "$url"
done

cd bilder_folder
for i in *.jpg *.JPG; do
    #yearOfPicture=$(exiftool -d '%Y' -DateTimeOriginal -S -s "$i")
    yearOfPicture=$(exiftool $i | grep "Create Date" | cut -c35-38)

    mkdir -p $yearOfPicture
    mv $i $yearOfPicture
    echo "moving pictures"
done

echo finished
