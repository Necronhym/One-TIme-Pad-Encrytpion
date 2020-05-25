CC = javac -d .
JAR = jar cfe

IN = src/*.java

PACKAGE = OneTimePad
MAIN = OneTimePad
MAINCLASS = $(PACKAGE)/$(MAIN)

OUTPUT = Encryption
Target:
	$(CC) $(IN)
	$(JAR) $(OUTPUT).jar $(MAINCLASS) $(PACKAGE) 
