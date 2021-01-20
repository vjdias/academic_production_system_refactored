# Academic Production System Refactored
* Bug handling
* Exception handling
* Addition of Singleton design pattern
* Addition of Facade design pattern
* Addition of Factory Method design pattern

# Notes on Refactoring
# Singleton 
The Singleton method is a design pattern that ensures that a class has only one instance to provide global and unique access to that instance.
This standard was implemented in the com/aps/util/TextCmd.java class. It was necessary because this class contains almost all the texts of the program and it is initialized only once for the correct execution of the program.

# Facade
The Facade method provides an interface to access a set of similar classes to facilitate their treatment and use for other classes.
The Facade was used in the com/aps/controller/APS.java class to serve as an interface between the application controls that were (based on generics and reflects) and the program's View.

# Factory Method
The Factory Method is a design pattern that provides an interface for creating objects in a superclass, but allows subclasses to change the steps of creating the objects.

The Factory Method standard was implemented in the add_test function of the com/aps/controller/Manage.java class. As each child class of Manage can have different checks to accept the addition of its data, I found it interesting to create this function and make it be called by the add function for each addition requested by the user.

Note: I did not implement the add_test() function as an abstract or interface because most classes that are children of Manage will use it without having to override its content.

# MVC
MVC is a software architecture standard that separates the application into 3 layers. The user interaction layer (view), the data manipulation layer (model) and the control layer (controller). I used MVC to develop this whole project.

# About
This project consists of an academic productivity management system in which production management can be done research laboratory, including information on research projects and collaborators.

  The program was written using eclipse 2020-09.
  The program's initial screen consists of:

  0:Gerenciar dados  
  1:Atualizar projetos  
  2:Imprimir relatorio de produção academica  
  3:Sair  

  Option 0 gives the user the ability to add data to the program's model class sets;  
  Option 1 makes it possible to update project data already added to the data;  
  Option 2 allows the printing of a report that summarizes some of the project data;  
  Option 3 terminates the program.  
  
  Note to add relationships between models, you must first add the model to be related (0: Manage data) so that you can get your reference and add it to another model.
  
  Example 
```  
  
Digite os valores correspondentes aos seguintes campos:

Title:
>Teste

FinancingCompany:
>Teste

FinancingAmount:
>Teste

Description:
>Teste

StartYear:
>2020

ConclusionYear:
>2021

Status:
>in preparation

CollaboratorsFk
Digite o Id(s) que deseja associar a este modelo.
 _____________________________________________________________________________________________________________________________________________
|Name__________|Id________|Email__________|AcademicDegree____________|HistoryProjectParticipationFk________|HistoryProjectProductionFk________|
|Maria         |0         |ma@com         |Professor                 |[0]                                  |[]                                |
|João          |1         |jo@com         |Professor                 |[1]                                  |[]                                |
|Camila        |2         |ma@com         |University student        |[0]                                  |[]                                |
|Valdir        |3         |va@com         |University student        |[]                                   |[]                                |
|José__________|4_________|jos@com________|University student________|[1]__________________________________|[]________________________________|

> 0 2
```

  Diagrams:   
  
  Model 
![Model](https://github.com/vjdias/acadmic_production_system/blob/master/diagram/model.PNG)
  
  Controller
![Model](https://github.com/vjdias/acadmic_production_system/blob/master/diagram/controller.PNG)
  
  View and Utils   
![Model](https://github.com/vjdias/acadmic_production_system/blob/master/diagram/view_util.PNG)
