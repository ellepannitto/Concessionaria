JAVA_FILES := $(wildcard *.java)

default: all

all:
	javac callMe/*.java filterCreators/*.java misc/*.java compare/*.java filters/*.java menu/*.java
	
clean:
	$(RM) *.class

#~ doc:
#~ 	javadoc -d ../doc -cp ".:../misc:../SocialProtocol" *.java

.PHONY: clean concessionaria
