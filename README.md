# RuleGen - Business Rule Generator

RuleGen provides a means to generate business rules prepared inside a tools database to be transformed into a database specific triggers and constraints to be applied on a target database. The focus of the project has been to support oracle databases, but the intention has been to support any tool and target database.

The generator supports the following functions through a RESTful webservice:

* A simple check to confirm the service is running.
* Analyse target database by supplying a project ID.
* Generate business rule from a queue-ticket into the tools database and responds in JSON.
 
Additionally there are some intended but not fully implemented features:
* Updating tools database database by supplying a project ID.
* Push code to target database by supplying a queue-ticket ID.

Current issues:
* Database connection implementation currently causes a delay.

The original project that was assigned required an APEX front-end to initiate the creation of a project, business rules and the comunication with the Java back-end. Due to this, there has been no extensive tests to check if analysing or applying business rules to a non oracle database is functional.


###### Dependencies:
* [Java Spark Framework](http://sparkjava.com/)
* [Oracle 12c JDBC Driver](http://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html)
* Additional dependencies can be found in the [pom.xml](https://github.com/Mrvek/SparkWorkshop/blob/master/pom.xml)

###### Tools used:
* [HUSSACT](http://husacct.github.io/HUSACCT/) has been used to check if the project has been been architecturally compliant.
