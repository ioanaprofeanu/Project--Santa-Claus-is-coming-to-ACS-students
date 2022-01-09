Profeanu Ioana, 323CA
Proiect - Etapa 1 - Santa Claus is coming to ACS students
---------------------------------------------------------------------------------------------------
# GitHub Repository
 > https://github.com/ioanaprofeanu/Proiect---Etapa-1---Santa-Claus-is-coming-to-ACS-students
---------------------------------------------------------------------------------------------------
# Overview
* The program simulates a database of gifts and children, allowing the user to distribute gifts to
certain kids based on different methods, similar to the way Santa Claus offers his presents.
---------------------------------------------------------------------------------------------------
# Dependencies
 ## Necessary libraries for the project:
  * Jackson Core
  * Jackson Databind
  * Jackson Annotations
---------------------------------------------------------------------------------------------------
# Entities
 ## Object classes:
 * Main class: - iterates through each input test, reads the data, runs the simulation and
    writes the output result in the output files.
 * Input and Output: -> fileio -> input and fileio -> output
     * The action of loading the input and the output is implemented within the InputLoader and
     OutputLoader using ObjectMapper, which requires a hierarchy of classes in order to build
     the wanted input or output. These hierarchies have SimulationDataInput as main class for
     the input part (which uses smaller classes such as ChildInput, GiftInput etc.), and
     AllYearsChildrenOutput as main class for the output part (which uses the smaller class
     AnnualChildrenOutput).
 * entities: - the individual entities used within the program
     * Child - contains the information about a child and methods which change that information
     accordingly.
     * Gift - contains the information about a gift and methods which change that information
     accordingly.
 * database:
     * ChildrenDatabase - contains a sorted by id list of all children and methods for adding
     new kids to the list or modifying them.
     * GiftsDatabase - contains a hashmap of all gifts, having the category as key and a list of
     sorted by price gifts within that category as value, and methods for adding new gifts.
     * SantaDatabase - contains the two databases for children and gifts.
 * simulations:
     * Simulation - interface on which each simulation is based.
     * GiftAssigmentSimulation - implements Simulation and contains all the methods used for
     calculating the average score of each child and distributing the gifts in each round of the
     simulation.
     * CompleteSimulation - implements Simulation and contains the method which executes the
     two simulation parts the program is composed of; it is also composed of two intern classes:
         * InitialSimulation - intern class which extends the GiftAssigmentSimulation and im-
         plements Simulation and implements the round 0 of the simulation.
         * YearSimulation - intern class which extends the GiftAssigmentSimulation and im-
         plements Simulation, which makes the annual changes.
 * Average Score Strategy - contains the three strategy classes which implement the
   AverageScoreStrategy interface and which calculate and return the average value for each
   age group; the AverageScoreFactory contains the factory which returns an instance of a
   certain strategy, depending on the input child's age group.
 * Update Commands - contains the Command interface and the classes which implement the
 interface (such as AddNewGiftsCommand, UpdateChildrenCommand etc.), used for making yearly
 updates; the package also contains the AnnualChangeInvoker, which is used to initiate the
 request of the commands.
 * Comparators: - within the utils package, it implements the comparators used within the
 program.
---------------------------------------------------------------------------------------------------
# Simulation flow:
 ## Round 0:
  * By calling the makeSimulation method within the GiftAssigmentSimulation and interacting with
  the database of children, the gift assigment process is made; it consists of calculating the
  average score of each child using the average score strategy and its factory, then calculating
  the unit budget and using this, calculating the budget for each child and then distributing
  the gifts; after than, add the current list of children to output list of children from all
  years.
 ## Rounds within the years:
  * Firstly, reassign Santa's budget and then using the command design pattern which interacts
  with the database of children and/or gifts and the input data of annual changes, increases
  the children's ages, removes all young adults, adds new children in ascending order by id,
  updates given children, adds new gifts in ascending order by price, and similar to the process
  done in Round 0, assign the gifts and adds the new list of children to the output list.
---------------------------------------------------------------------------------------------------
# Design Patterns - the design patterns used throughout the implementation:
 ## Strategy:
 * Used for calculating the average score for each age group; the AverageScoreStrategy is the
 common interface which contains the getAverageScore() method and is implemented by the three
 specific strategies, in which the score is calculated according to the given formulas.
 ## Factory:
 * Because we have several types of average score strategies, a strategy factory for building
 instances of these strategies is needed; it verifies the age of the input child and returns a
 suitable strategy instance; it is used by the GiftAssigmentSimulation as argument for the
 method calculateAverageScore within the Child class.
 ## Singleton:
 * Since only one factory instance is needed for generating the average score strategy, the lazy
 singleton design pattern is used to restrict the instantiation to only a single strategy factory.
 ## Command:
 * Considering that several changes must be done the within yearly rounds, the implementation of
 the update processes is made using a series of commands performing on the GiftsDatabase and
 ChildrenDatabase objects, commands which implement the Command interface that contains the
 execute() method; the AnnualChangeInvoker represents the invoker which initiates the request
 commands and is used within the YearSimulation inner class from the CompleteSimulation class.
---------------------------------------------------------------------------------------------------
 