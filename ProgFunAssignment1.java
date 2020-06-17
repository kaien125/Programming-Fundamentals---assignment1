import java.util.Scanner;

public class ProgFunAssignment1 {

	static class MyBlock {

		private int block_row;
		private int block_column;
		private int[][] block;
		private boolean vacant;
		//An integer parameter houseNum is introduced to change the number displayed when adding more houses.
		private int houseNum;

		// Constructor of class MyBlock.
		public MyBlock(int maxRows, int maxColumns) {			
			block_row = maxRows;
			block_column = maxColumns;
			
			//clearBlock() method is used to initial vacant, houseNum and the block.
			clearBlock();
		}

		
		// Display the entire block as a matrix.
		public void displayBlock() {			
			System.out.println("Your block:");
			System.out.println(" ");
			
			//A nested loop is used to print the two dimensional array.
			for (int i = 0; i < block.length; i += 1) {
				for (int j = 0; j < block[i].length; j += 1) {
					System.out.print(block[i][j] + " ");
				}				
				System.out.println(" ");
			}
		}

		
		// Clear out the block by initializing vacant, houseNum and the block array. 
		public void clearBlock() {
			block = new int[block_row][block_column];
			vacant = true;
			houseNum = 1;
		}
		

		public boolean addHouse() {
			//Introduce a boolean value occupied for the following check.
			//Occupied is true means the house is out of block boundary or there has a house in position already. 
			//With the parameter occupied, an if-else clause is used to decide whether the house can be added or not.
			boolean occupied = false;
			
			Scanner sc = new Scanner(System.in);

			System.out.println(
					"Please input row position, column position, number of rows and number of columns in order: ");
			System.out.println("(Row position and column position are the house`s top left corner position.)");

			int rowPos = sc.nextInt();
			int colPos = sc.nextInt();
			int rows = sc.nextInt();
			int columns = sc.nextInt();

			//Check position and size of the house.
			//Any one of these four conditions violated means the house is out of the block boundary. 
			if (rowPos < 1 || colPos < 1 || rowPos + rows >= block_row || colPos + columns >= block_column) {
				System.out.println("Error: The house is out of bound.");
				
				occupied = true;
			//Vacant is false means there is other house on the block.
			//If the house is not out of boundary and the there is other house on the block, 
			//the relative position of new house and old house must be checked.
			//A nested for loop is used to check whether a two dimensional array has non-zero value.
			//Non-zero value in the 2D array means this position is occupied.
			//This 2D array is a round larger than the house to be added, 
			//which means it starts one digit less and ends one digit more than both row and column.
			} else if (vacant == false) {
				for (int i = rowPos - 1; i < rowPos + rows + 1; i += 1) {
					for (int j = colPos - 1; j < colPos + columns + 1; j += 1) {
						if (block[i][j] != 0) {
							occupied = true;
						}
					}
				}
			}
			
			//Position and size of the house is valid.
			//Assign houseNum value to all items in house array by a nested for loop.
			if (occupied == false) {
				for (int i = rowPos; i < rowPos + rows; i += 1) {
					for (int j = colPos; j < colPos + columns; j += 1) {
						block[i][j] = houseNum;
					}
				}
				
				vacant = false;
				
				System.out.println("Location available. House added.");
				System.out.println("");
				
				//houseNum add one so the next house will display the next integer.
				houseNum += 1;
				
				// Display block after house added.
				displayBlock();
				
				return true;
			//Position or size of the house is invalid. Error message printed.
			} else {
				System.out.println("Error: Invalid position. No house added.");
				System.out.println();
				
				return false;
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int row, column;
		
		System.out.println("Please define the size of the block.");
		System.out.println(
				"The number of rows and the number of columns should be an integer greater than 2 and less than or equal to 10.");
		
		//Input validation for row by a do-while loop and an if-else clause nested.
		//A do-while loop is used because it executes at least once.
		do {
			System.out.println("Please input the row of the block: ");
			
			row = sc.nextInt();
			
			if (row <= 2 || row > 10) {
				System.out.println("Invalid input.");
			}
		} while (row <= 2 || row > 10);

		//Input validation for column by a do-while loop and an if-else clause nested. 
		do {
			System.out.println("Please input the column of the block: ");
			
			column = sc.nextInt();
			
			if (column <= 2 || column > 10) {
				System.out.println("Invalid input.");
			}
		} while (column <= 2 || column > 10);

		System.out.println("Your " + row + " * " + column + " block is created.");

		// Create an object of class MyBlock using the 'new' operator, calling on the
		// MyBlock constructor.
		MyBlock newBlock = new MyBlock(row, column);
		
		int option = 0;
		
		//Menu list is stored in a string array and is printed by a for loop.
		String menu[] = { "\n Please select an option", "\n (1) Add a house", "\n (2) Display the block",
				"\n (3) Clear the block", "\n (4) Quit" };
		
		//A while loop is used to print the menu and then execute the switch clause.
		//Integer option is initialized with a number that is not 4, 
		//so the while loop with condition option not equals to 4 will be executed at the beginning. 
		//The while loop will terminate if and only if option equals to 4.
		//Error message will be printed if input if not in menu list. 
		while (option != 4) {
			for (int i = 0; i < menu.length; i++)
				System.out.println(menu[i]);

			option = sc.nextInt();

			switch (option) {
			case 1:
				newBlock.addHouse();
				break;
			case 2:
				newBlock.displayBlock();
				break;
			case 3:
				newBlock.clearBlock();
				System.out.println("Your block is clear.");
				break;
			case 4:
				System.out.println("Quiting...Thank you.");
				break;
			default:
				System.out.println("Error: Wrong option. Please select another.");
			}
		}

	}
}
