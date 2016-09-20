JAVA_FILES := $(wildcard *.java)

default: all

all:
	javac -Xlint:unchecked compare/*.java concessionaria/*.java editors/*.java exceptions/*.java filters/*.java main/*.java menu/*.java menu/menuItem/*.java menu/menuItem/filterCreators/*.java menu/menuItem/sortingCreators/*.java
	
clean:
	$(RM) compare/*.class concessionaria/*.class editors/*.class exceptions/*.class filters/*.class main/*.class menu/*.class menu/menuItem/*.class menu/menuItem/filterCreators/*.class menu/menuItem/sortingCreators/*.class

doc:
	javadoc -d doc compare/*.java concessionaria/*.java editors/*.java exceptions/*.java filters/*.java main/*.java menu/*.java menu/menuItem/*.java menu/menuItem/filterCreators/*.java menu/menuItem/sortingCreators/*.java

.PHONY: clean concessionaria doc
