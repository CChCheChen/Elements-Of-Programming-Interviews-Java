package scenario.b.FinalsCram7Days;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
19.2 PAINT A BOOLEAN MATRIX

Let A be a Boolean 2Darray encoding a black-and-white image. 
The entry A(a,b) can be viewed as encoding the color at entry (a,b). 

Call two entries adjacent if one is to the left, right, above or below the other. 
Note that the definition implies that an entry can be adjacent to at most four other entries, and that adjacency is symmetric, 
i.e., if e0 is adjacent to entry e1, then e1 is adjacent to e0.

Define a path from entry e0 to entry e1 to be a sequence of adjacent entries, starting at e0, ending at e1, with successive entries being adjacent. 

Define the region associated with a point (i, j) to be all points (i', j') such that there exists a path from (i, j) to (i', j') in which all entries are the same color. 
In particular this implies (i, j) and (i', j') must be the same color.
 
Implement a routine that takes an n X m Boolean array A together with an entry (x, y) and flips the color of the region associated with (x, y). 

Hint: Solve this conceptually, and then think about implementation optimizations.

P357(P370)

 */
public class Q_19_02_Paint_A_Boolean_Matrix {

	public static void main(String[] args) {
		boolean[][] matrix = new boolean[10][10];
		matrix[0] = new boolean[] {true, false, true, false, false, false, true, true, true, true};
		matrix[1] = new boolean[] {false, false, true, false, false, true, false, false, true, true};
		matrix[2] = new boolean[] {true, true, true, false, false, true, true, false, true, true};
		matrix[3] = new boolean[] {false, true, false, true, true, true, true, false, true, false};
		matrix[4] = new boolean[] {true, false, true, false, false, false, false, true, false, false};
		matrix[5] = new boolean[] {true, false, true, false, false, true, false, true, true, true}; 
		matrix[6] = new boolean[] {false, false, false, false, true, false, true, false, false, true};
		matrix[7] = new boolean[] {true, false, true, false, true, false, true, false, false, false};
		matrix[8] = new boolean[] {true, false, true, true, false, false, false, true, true, true};
		matrix[9] = new boolean[] {false, false, false, false, false, false, false, true, true, false,};
		
		System.out.println("Original Matrix: ");
		printMatrix(matrix);
		int xCoordinate = 4;
		int yCorrdinate = 5;
		filpRegionColor(matrix, xCoordinate, yCorrdinate);
		
		System.out.println("After Flipping Color: ");
		printMatrix(matrix);
		xCoordinate = 6;
		yCorrdinate = 3;
		filpRegionColor(matrix, xCoordinate, yCorrdinate);
		
		System.out.println("After Flipping Color Again: ");
		printMatrix(matrix);

	}

	//Time: O(row * col)
	//Space:O(row + col), because only 4 directions need to check for worst case
	private static void filpRegionColor(boolean[][] matrix, int xCoordinate, int yCorrdinate) {
		final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,-1}, {0,1}};
		boolean ogColor = matrix[xCoordinate][yCorrdinate];//Record Entry's original color
		
		Queue<Coordinate> queue = new LinkedList<>();
		
		//Flip Entry's color
		matrix[xCoordinate][yCorrdinate] = !ogColor;
		
		queue.add(new Coordinate(xCoordinate, yCorrdinate));
		
		while(!queue.isEmpty()) {
			Coordinate curr = queue.element();//similar to peek(), retrieve but not remove
			
			for(int[] dir : DIRECTIONS) {
				Coordinate adjacent = new Coordinate(curr.x+dir[0], curr.y+dir[1]);
				
				if(adjacent.x>=0 && adjacent.x<matrix.length &&
				   adjacent.y>=0 && adjacent.y<matrix[0].length &&
				   matrix[adjacent.x][adjacent.y]==ogColor) {
					
					matrix[adjacent.x][adjacent.y] = !ogColor;
					queue.add(adjacent);
				}
			}
			
			queue.remove();
		}
	}

	private static void printMatrix(boolean[][] matrix) {
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j])
					System.out.print("X" + " ");
				else
					System.out.print("O" + " ");
			}
			System.out.println();
		}
		
	}

}

class Coordinate{
	public int x;
	public int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
