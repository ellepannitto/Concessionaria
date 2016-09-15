JAVA_FILES := $(wildcard *.java)

%.class: %.java
	javac $<

default: concessionaria

concessionaria: $(JAVA_FILES:.java=.class)
	
clean:
	$(RM) *.class

#~ doc:
#~ 	javadoc -d ../doc -cp ".:../misc:../SocialProtocol" *.java

.PHONY: clean concessionaria
