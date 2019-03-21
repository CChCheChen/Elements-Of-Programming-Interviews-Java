package scenario.b.FinalsCram7Days;


/*
17.3 COUNT THE NUMBER OF WAYS TO TRAVERSE A 2D ARRAY
In this problem you are to count the number of ways of starting at the top-left comer of a 2D array and getting to the bottom-right comer. 
All moves must either go right or down. 
 
Write a program that counts how many ways you can go from the top-left to the bottom-right in a 2D array.
Hint: If i > 0 and j > 0, you can get to (i, j) from (i-1, j) or (j-1, i).
Solution: A brute-force approach is to enumerate all possible paths

P312(P325)

 */
public class Q_17_03_Number_of_Way_Traverse_2D_Array {

	public static void main(String[] args) {
		int row = 5;
		int column = 5;
		
		int totalWays = totalWays(row-1, column-1, new int[row][column]);
		
		System.out.println("Total Number of ways = " + totalWays);

	}

	//Time: O(r*c), r is row number & c is column number
	//Space:O(r*c)
	private static int totalWays(int r, int c, int[][] grid) {
		if(r==0 && c==0)//Reached the top-left corner
			return 1;
		
		if(grid[r][c] == 0) {//not being reached yet
			int waysUp = r==0 ? 0 : totalWays(r-1, c, grid);//go back up from lower cell
			int waysLeft = c==0 ? 0 : totalWays(r, c-1, grid);//go left from right cell
			grid[r][c] = waysUp + waysLeft;
		}
		
		return grid[r][c];
	}

}
