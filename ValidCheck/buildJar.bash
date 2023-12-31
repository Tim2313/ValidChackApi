FILE=out
MANIFEST_FILE=src/main/resources/MANIFEST.MF 

if [ -e "$FILE" ] 
then
	rm -rf $FILE/*
else 
	mkdir $FILE
fi

find ./src/ -type f -name "*.java" > sources.txt
javac -d ./out/ @sources.txt
rm sources.txt

cd $FILE

jar cfm ValidCheck.jar ../$MANIFEST_FILE ./* 

cd .. 

mkdir Test

mv out/ValidCheck.jar Test

