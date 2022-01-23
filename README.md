Profeanu Ioana, 323CA
Proiect - Etapa 1 - Santa Claus is coming to ACS students
---------------------------------------------------------------------------------------------------
# GitHub Repository
 > https://github.com/ioanaprofeanu/Project--Santa-Claus-is-coming-to-ACS-students
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
     accordingly; it also contains a builder class, used for creating Child objects with or
     without the optional characteristics, in this case the niceScoreBonus.
     * Gift - contains the information about a gift and methods which change that information
     accordingly.
     * City - contains information about a city, including a list of children who live in that
     city, and methods that change the city's information accordingly.
     * Elf - abstract class which contains the operations performed by any elf; 
         * it is inherited by the classes BlackElf, PinkElf, WhiteElf and YellowElf, where 
         certain methods are overridden in order to make the specific changes for each elf;
         * ElvesFactory is used to create instances of the elves, depending on their color
 * database:
     * ChildrenDatabase - contains a sorted by id list of all children and methods for adding
     new kids to the list and to the cities' database, or modifying them.
     * GiftsDatabase - contains a hashmap of all gifts, having the category as key and a list of
     sorted by price gifts within that category as value, and methods for adding new gifts.
     * CitiesDatabase - contains a list of all cities and methods for adding new children to
     their specific city, as well as methods for modifying the data from the cities.
     * SantaDatabase - contains the two databases for children, gifts and cities.
 * simulations:
     * Simulation - interface on which each simulation is based.
     * GiftAssigmentSimulation - implements Simulation and contains all the methods used for
     calculating the average score of each child (including increasing or decreasing the budget,
     depending on the elf type) and distributing the gifts in each round of the simulation;
     during distribution, a new list of children is received depending on the strategy type of
     the gift assigment; for each child, gifts are given depending on the child's budget,
     preferences and the availability of the gifts (since the gifts' quantities are decreased
     after each assigment); in the end, apply the elves modifications (changes are made only by
     the yellow elf).
     * CompleteSimulation - implements Simulation and contains the method which executes the
     two simulation parts the program is composed of; it is also composed of two intern classes:
         * InitialSimulation - intern class which extends the GiftAssigmentSimulation and im-
         plements Simulation and performs the round 0 of the simulation.
         * YearSimulation - intern class which extends the GiftAssigmentSimulation and im-
         plements Simulation, which makes the annual changes.
 * Average Score Strategy - contains the three strategy classes which implement the
   AverageScoreStrategy interface, and which calculate and return the average value for each
   age group, to which the nice score bonus is added; the AverageScoreStrategyFactory contains
   the factory which returns an instance of a certain strategy, depending on the input child's
   age group.
 * Gift Assigment Strategy - contains three strategy classes which implement the interface
   GiftAssigmentStrategy, and which create and return a list of children, whose order depends on
   the type of gift assigment; the GiftAssigmentStrategyFactory contains the factory which returns
   an instance of a certain strategy, depending on the input type of gift assigment
 * Update Commands - contains the Command interface and the classes which implement the
 interface (such as AddNewGiftsCommand, UpdateChildrenCommand etc.), used for making yearly
 updates; the package also contains the AnnualChangeInvoker, which is used to initiate the
 request of the commands.
 * Comparators: - within the utils package, it implements the comparators used within the
 program of sorting children, gifts and cities.
---------------------------------------------------------------------------------------------------
# Simulation flow:
 ## Round 0:
  * By calling the makeSimulation method within the GiftAssigmentSimulation and interacting with
  the database of children, the gift assigment process is made; it consists of calculating the
  average score of each child using the average score strategy and its factory, then calculating
  the unit budget and using this, calculating the budget for each child and then distributing
  the gifts depending on the strategy; after than, add the current list of children to output
  list of children from all years.
 ## Rounds within the years:
  * Firstly, reassign Santa's budget and then using the command design pattern which interacts
  with the database of children, cities and/or gifts and the input data of annual changes,
  increases the children's ages, removes all young adults, adds new children in ascending order
  by id, updates given children, adds new gifts in ascending order by price, and similarly to the
  process done in Round 0, assign the gifts and adds the new list of children to the output list.
---------------------------------------------------------------------------------------------------
# Design Patterns - the design patterns used throughout the implementation:
 ## Strategy:
 * Average Score Strategy:
   * used for calculating the average score for each age group; the AverageScoreStrategy is the
   common interface which contains the getAverageScore() method and is implemented by the three
   specific strategies, in which the score is calculated according to the given formulas; if
   existing, the nice score bonus is also added, and the total score is truncated to the maximum
   value
 * Gift Assigment Strategy:
   * used for creating an ordered list of children, depending on the gift assigment strategy type;
   GiftAssigmentStrategy is the common interface which contains the getOrderedChildren() method and
   is implemented by the three specific strategies, where a list of children is sorted using
   comparators suited for each strategy type;
 ## Factory:
 * Average Score Strategy Factory and Gift Assigment Strategy Factory:
   * because for each strategy type there are several implementations of that specific strategy,
   a strategy factory for building instances for those strategies is needed;
     * for average score strategy factory, it verifies the age of the input child and returns a
       suitable strategy instance; it is used by the GiftAssigmentSimulation as argument for the
       method calculateAverageScore() within the Child class.
     * for gift assigment strategy factory, it verifies the given strategy type and returns a
     suitable strategy instance; it is used by the GiftAssigmentSimulation within the method
     assignGifts(), for creating a new list of ordered children on which the assigment should
     be made.
 * Elves Factory:
   * since there are several types of elves, an elves' factory is used for creating new instances,
   depending on the given elf color; it is used within the child builder, when creating a new
   child.
 ## Singleton:
 * Because for each factory (elves, gift assigment and average score) only one instance of that
 specific factory is needed for generating new objects, the lazy singleton design pattern is used
 to restrict the instantiation of those factories to only a single one.
 ## Command:
 * Considering that several changes must be done the within yearly rounds, the implementation of
 the update processes is made using a series of commands performing on the GiftsDatabase and
 ChildrenDatabase objects, commands which implement the Command interface that contains the
 execute() method; the AnnualChangeInvoker represents the invoker which initiates the request
 commands and is used within the YearSimulation inner class from the CompleteSimulation class.
 ## Builder:
 * Since not every child has a nice score bonus whose value is not zero, the nice score bonus can
 be considered optional; because of that, a builder class is used within the Child class, in order
 to create a child which can contain only the mandatory fields, or which can also contain the
 optional one; the builder is called whenever a new child is created within the ChildrenDatabase
 class.d
---------------------------------------------------------------------------------------------------
 