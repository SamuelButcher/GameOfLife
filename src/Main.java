import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int columns = 8;
        int rows = 6; //hardcoding columns and rows here just in case.
        int[][] grid = {{0,0,0,0,0,0,1,0},
                {1,1,1,0,0,0,1,0},
                {0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0},
                {0,0,0,1,1,0,0,0}
        }; //I'm using a 2D array here as ints are easy to work with and low on space/computation time.
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Would you like a random grid? Type Y if yes, otherwise example grid will be used.");
        if(input.next().equals("Y")){
            System.out.println("Please input number of columns you would like: ");
            columns = input.nextInt();
            System.out.println("Please input number of rows you would like: ");
            rows = input.nextInt();
            grid = new int[rows][columns];
            //fill up the new grid with the random values
            for(int r=0; r < rows; r++){
                for(int c = 0; c < columns; c++){
                    grid[r][c] = rand.nextInt(2);
                }
            }
        }
        System.out.println("Here is the initial state:");
        printGrid(grid, columns, rows);
        System.out.print("How many iterations would you like to go through?");
        int iterations =  input.nextInt();
        for (int i =0; i< iterations; i++){
            grid = nextState(grid, columns, rows);
            System.out.println("Here is the state after iteration " + (i+1) + ":");
            printGrid(grid, columns, rows);
        }
    }

    //function to print the current state of the grid.
    public static void printGrid(int[][] grid, int columns, int rows){
        for(int r=0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                if (grid[r][c] == 0){
                    System.out.print(".");
                }
                else{
                    System.out.print("O");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[][] nextState(int[][] originalGrid, int columns, int rows){
        int[][] newGrid = new int[rows][columns];
        for (int r=0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                int livingNeighbors = 0;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        if(((c + i >= 0) && (c + i < columns)) && ((r + j >= 0) && (r + j < rows))){
                            livingNeighbors += originalGrid[r + j][c + i];
                        }
                    }
                }
                //We iterated right through the cell itself, so we need to subtract it as it can't be its own neighbor
                livingNeighbors -= originalGrid[r][c];
                //Implementation of the rules
                //Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
                if ((originalGrid[r][c] == 1) && (livingNeighbors < 2)){
                    newGrid[r][c] = 0;
                }
                //Any live cell with more than three live neighbors dies, as if by overcrowding.
                else if ((originalGrid[r][c] == 1) && (livingNeighbors > 3)) {
                    newGrid[r][c] = 0;
                }
                //Any dead cell with exactly three live neighbors becomes a live cell.
                else if ((originalGrid[r][c] == 0 ) && (livingNeighbors == 3)){
                    newGrid[r][c] = 1;
                }
                //Any live cell with two or three live neighbors lives on to the next generation.
                else{
                    newGrid[r][c] = originalGrid[r][c];
                }
            }
        }
        return newGrid;
    }
}