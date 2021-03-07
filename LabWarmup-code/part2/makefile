#For more information about makefiles go to: https://www.cs.swarthmore.edu/~newhall/unixhelp/howto_makefiles.html
#
# A simple makefile for compiling the HelloWorld java class
#

# define a makefile variable for the java compiler and java
#
JCC = javac
JVM = java

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: HelloWorld.class

# this target entry builds the HelloWorld class
#
HelloWorld.class: HelloWorld.java
	$(JCC) $(JFLAGS) HelloWorld.java

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean:
	$(RM) *.class

# To run the HelloWorld class, type 'make run'.
run:
	$(JVM) HelloWorld
