# toyRobot
This is simulator of toy robot in java.

##Description

	- The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.
	- There are no other obstructions on the table surface.
	- The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.
 
Application can read in commands of the following form:
	PLACE X,Y, FACING
	MOVE
	LEFT
	RIGHT
	REPORT

PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.

The origin (0,0) can be considered to be the SOUTH WEST most corner.
	
The first valid command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the sequence until a valid PLACE command has been executed.

MOVE will move the toy robot one unit forward in the direction it is currently facing.
	
LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

REPORT will announce the X,Y and FACING of the robot. This can be in any form, but standard output is sufficient.
	
A robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT and REPORT commands.
	
##Example
PLACE 0,0,NORTH

MOVE

REPORT

Output: 0,1,NORTH
PLACE 0,0,NORTH

LEFT

REPORT

Output: 0,0,WEST
PLACE 1,2,EAST

MOVE

MOVE

LEFT

MOVE

REPORT

Output: 3,3,NORTH
 
# Classes

##App.java
This is main class which is starting point. This class is used to take standard console input.

##Table.java
This class is used for defining table or board.

##Robot.java
This class is robot defining its current position in terms of x ,y and direction (north, south, east, west).

##Simulator.java
This class does the work of placing and moving robot around the table.
 