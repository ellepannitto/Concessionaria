JAVA_FILES := $(wildcard *.java)

default: all

all:
	javac -Xlint:unchecked menuItem/*.java filterCreators/*.java misc/*.java compare/*.java filters/*.java menu/*.java main/*.java exceptions/*.java
	
clean:
	$(RM) menuItem/*.class filterCreators/*.class misc/*.class compare/*.class filters/*.class menu/*.class main/*.class exceptions/*.class

doc:
	javadoc -d doc menuItem/*.java filterCreators/*.java misc/*.java compare/*.java filters/*.java menu/*.java main/*.java exceptions/*.java

.PHONY: clean concessionaria doc
