/**
 * @Description: This program will create a 2D array based on dimensions specified by user input. It will then check all of the values
 * to find the largest and the smallest number in the array, along with the number's location in the array, and print them to the screen.
 * 
 * @Inputs: The user will have to input the following:
 * 		=> 2 integers for the array dimensions
 * 		=> As many doubles as the array requires to be full.
 * 
 * @Outputs: The program will output:
 * 		=> A formatted version of the array.
 * 		=> The largest number in the array.
 * 		=> The coordinates of the largest number in the array.
 * 		=> The smallest number in the array.
 * 		=> The coordinates of the smallest number in the array.
 * 
 * @author Erik Jackson
 * @contact erik.jackson@my.century.edu
 * @since 10/20/2024
 * 
 * Institution: Century College
 * Professor: Mathew Nyamagwa
 * 
 */

import java.util.Scanner;
public class Driver {

	public static void main(String[] args) {
		// Defines the scanner for user inputs
		Scanner input = new Scanner(System.in);
		// Defines the variables to be used in the program.
		int height;
		int width;
		int columnIndex;
		int rowIndex;
		double largestNum[];
		double smallestNum[];
		
		// INPUTS
		System.out.println("This program will ask for user inputs for the dimensions of a 2D array, then it will create it.");
		System.out.println("It will then ask for number values to fill the array, and return the highest and lowest numbers,");
		System.out.println("along with the locations of both values in the array.\n");
		
		// The program collects an integer value for the height variable, which will define the number of rows.
		System.out.print("Please enter an integer for the number of rows of the array: ");
		height = input.nextInt();
		
		// The program collects another integer value for the width variable, which will define the number of columns.
		System.out.print("Please enter an integer for the number of columns in the array: ");
		width = input.nextInt();
		
		// This defines the numberGrid as a 2D array with the user inputs for height and width as its dimensions.
		double[][] numberGrid = new double[height][width];
		
		// Prompts the user for values to fill the array.
		System.out.println("Please enter " + (height * width)+ " values for the array:");
		
		/* Enter values for the 2D array.
		   Doubled up for-loops move through the 2D array one row at a time. The exterior for-loop moves through the columns, and the 
		   interior for-loop moves through the row. At each location, the program will collect a double from the user and input it into
		   the array.*/
		
		for(columnIndex = 0; columnIndex < height; ++columnIndex) {
			for(rowIndex = 0; rowIndex < width; ++rowIndex) {
				numberGrid[columnIndex][rowIndex] = input.nextDouble();
			}
		}
		
		//OUTPUTS
		System.out.println("\nThis is the 2D Array that you've entered:\n");
		
		/* Replicates the 2D array with all of the values in place, it does this by looping through the array the same way that the 
		   information was collected (with the nested for-loops for columns and rows). */
		for(columnIndex = 0; columnIndex < height; ++columnIndex) {
			for(rowIndex = 0; rowIndex < width; ++rowIndex) {
				// This displays the number value with regular spacing.
				System.out.printf("%6s", numberGrid[columnIndex][rowIndex]);
			}
			System.out.println();
		}
		
		// Formatting to set aside the output.
		System.out.println("\n========== OUTPUT ==========");
		
		// The following line calls the locateLargest function and saves the returned array as the variable largestNum.
		largestNum = locateLargest(numberGrid, height, width);
		
		System.out.println("\nHERE'S THE RESULTS:");
		// Displays the results of locateLargest().
		System.out.println("Largest Value: " + largestNum[0]);
		System.out.println("Location: [" + (int)largestNum[1] + ", " + (int)largestNum[2] + "]\n");
		
		// The following line calls the locateSmallest function and saves the returned array as the variable smallestNum.
		smallestNum = locateSmallest(numberGrid, height, width);
		//Displays the results of locateSmallest()
		System.out.println("Smallest Value: " + smallestNum[0]);
		System.out.println("Location: [" + smallestNum[1] + ", " + smallestNum[2] + "]");
		
		
	}
	
	/* This method is for searching through the array to find the largest value, then returning a small array that contains the largest 
	   value and the location of that value.*/
	public static double[] locateLargest(double grid[][], int columns, int rows) {
		// Defines the local variables
		int columnIndex;
		int rowIndex;
		//Sets the default value of the largestNumber array to be the very first item in the array, with the corresponding coordinates.
		double largestNumber[] = {grid[0][0], 0, 0};
		
		// Another double for-loop, looping through each row and column to find the largest Integer.
		for(columnIndex = 0; columnIndex < columns; ++columnIndex) {
			for(rowIndex = 0; rowIndex < rows; ++rowIndex) {
				/* This if statement checks the previously saved largestNumber values against the value stored in the current location
				   in the array. If it is larger, it will overwrite the saved values in the largestNumber array with the information
				   from the current location in the array.*/
				if(grid[columnIndex][rowIndex] >= grid[(int)largestNumber[1]][(int)largestNumber[2]]) {
					largestNumber[0] = grid[columnIndex][rowIndex];
					largestNumber[1] = columnIndex;
					largestNumber[2] = rowIndex;
				}
			}
		}
		// When the whole array has been looped through, it will return an array with the largest number and its location on the array.
		return largestNumber;
	}
	
	/* This method is for searching through the array to find the smallest value, then returning a small array that contains the 
	   smallest value and the location of that value.*/
	public static double[] locateSmallest(double grid[][], int columns, int rows) {
		// Defines the local values
		int columnIndex;
		int rowIndex;
		// Sets the default value of the smallestNumber array to be the very first item in the array, with the corresponding coordinates.
		double smallestNumber[] = {grid[0][0], 0, 0};
		
		// Another double for-loop, looping through each row and column to find the smallest Integer.
		for (columnIndex = 0; columnIndex < columns; ++columnIndex) {
			for(rowIndex = 0; rowIndex < rows; ++rowIndex) {
				/* This if statement checks the previously saved largestNumber values against the value stored in the current location
				   in the array. If it is smaller, it will overwrite the saved values in the smallestNumber array with the information
				   from the current location in the array.*/
				if(grid[columnIndex][rowIndex] <= grid[(int)smallestNumber[1]][(int)smallestNumber[2]]) {
					smallestNumber[0] = grid[columnIndex][rowIndex];
					smallestNumber[1] = columnIndex;
					smallestNumber[2] = rowIndex;
				}
			}
		}
		// When the whole array has been looped through, it will return an array with the smallest number and its location on the array.
		return smallestNumber;
	}

}
