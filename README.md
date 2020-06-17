# Programming Fundamentals---assignment1
MyBlock is a simple tool which can help one design a block of land. 
Your program should consist of a MyBlock class. The class has a two dimensional array of
integers called block. The class also has a Boolean variable vacant that stores the information
of whether the block of land is vacant or not. The methods of this class are: displayBlock(),
addHouse(), and clearBlock().
## Task A
The constructor of the MyBlock class takes 2 parameters: the number of rows of the block, the
number of columns of the block. In the constructor of this class, write code to initialize the block
with the size of row and column. Initialize each value of the array block with the value 0, which
means that block is unused. Initialize the value of vacant to true. 
## Task B
Write a method of the MyBlock class called displayBlock() that prints the block as a two
dimensional array. Give a space between each element during printing, and use a line for each
row. An example of the output of displayBlock()is shown below, for a vacant block of 3 x 4
(row x column). 
## Task C
Write a method of the MyBlock class called clearBlock()that sets the value of each element of
the array ‘block’ to zero (0). Set the value of vacant to true. 
## Task D
From the main method, the user can enter the row and column of the block. The number of rows
and the number of columns should be an integer greater than 2 and less than or equal to 10. If
any input is incorrect, show an error message and ask for that input again. If all inputs are
correct, create an object of MyBlock class from main method. The row and column values are
passed as the parameter of its constructor.
## Task E
From the main method, show a menu to the user with the following options. If the input is neither
1,2,3,4, show an error message and ask the user for input again.
1. Add a house
2. Display the block
3. Clear the block
4. Quit
### Option 1 – Add a house
It prompts the user of the position of the house (x, y) and the number of rows and columns of the
house and then call the addHouse() method of the MyBlock class with those values as
parameters (in the order of x, y, row, column). Implementing the addHouse() method is a
separate task detailed in Task F. If a house cannot be added, show error then back to the menu.
### Option 2 – Display the block
Call the displayBlock() method.
### Option 3 – Clear the block
Call the clearBlock()method.
### Option 4 - Quit
If the input is 4, terminate the program.
## Task F
Implements the addHouse() method that takes four input parameters: the row position, the
column position, the number of rows, and the number of columns of the house. Parameters row
position and column position are the house’s top left corner position. For example (2, 1) means
the house starts from 2 rows down from the top and 1 column from the left edge of the block.
This method must observe the follow rules:
### Rule 1: 
If the block is empty, a house can be anywhere in the block, but not touching the edges.
That means there needs to be at least one row and one column gap between the house and the
four sides of the block. For example, the largest possible house in a 5 x 7 block is of size 3 x 5,
with a top-left corner position (1, 1) 
### Rule 2: 
If there is already a house or houses in the block, the new house must be one row or
one column away, yet still observing Rule 1 
### Rule 3: 
No part of a house can go outside of the block.
### Rule 4: 
The smallest house size is 1 x 1. 
If any of the rules is violated, the addHouse method should return with no house added. Consider
where and how an error message should be showed to user. 
If no rule is violated, the addHouse method should change the values in the block array for the
house(s). The value of vacant should be correct. After building the house, call displayBlock()
from the addHouse method to show the updated block. 
