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

Features:

    Add/remove media to library system
    Add/remove readers
    View checked out media
    View fees by readers
    Checkout media for a reader
