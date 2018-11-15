# LIMS
Library Inventory Management System

https://github.com/klamonte/jexer is the library used for the GUI

    #inside src folder

    to build: 
    javac -cp jexer.jar App.java controllers/*.java models/*.java views/*.java 

    to run:
    java -cp .:jexer.jar App 

    to clean up the .class files:
    rm -rf *.class views/*.class models/*.class controllers/*.class

Working on getting maven set up to manage the package, but I don't know it well enough to deal with the outside library that needs to be inside the jar file.