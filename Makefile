JAVA_FILES := $(wildcard *.java)

default: all

all:
	javac -Xlint:unchecked callMe/*.java filterCreators/*.java misc/*.java compare/*.java filters/*.java menu/*.java main/*.java exceptions/*.java
	
clean:
	$(RM) callMe/*.class filterCreators/*.class misc/*.class compare/*.class filters/*.class menu/*.class main/*.class exceptions/*.class

#~ doc:
#~ 	javadoc -d ../doc -cp ".:../misc:../SocialProtocol" *.java

.PHONY: clean concessionaria
