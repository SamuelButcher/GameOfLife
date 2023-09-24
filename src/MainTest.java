import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @org.junit.jupiter.api.Test
    void testNextState() {
        //First, we test rule 1, Any live cell with fewer than 2 neighbors dies.
        int[][] grid = {{0,0,0},
            {0,1,0},
            {0,0,0}
        };
        grid = Main.nextState(grid, 3, 3);
        int[][] rule1Grid = {{0,0,0},
                {0,0,0},
                {0,0,0}
        };
        assert Arrays.deepEquals(grid, rule1Grid);
        grid = new int[][]{{0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        grid = Main.nextState(grid,3,3);
        assert Arrays.deepEquals(grid, rule1Grid);
        System.out.println("Rule 1 tested!");
        //Next we test rule 2, any live cell with more than 3 live neighbors dies.
        grid = new int[][]{{1, 1, 1},
                {1,1,1},
                {1,1,1}
        };
        int[][] rule2Grid = {{1,0,1},
                {0,0,0},
                {1,0,1}
        };
        grid= Main.nextState(grid, 3 ,3);
        assert Arrays.deepEquals(grid, rule2Grid);
        System.out.println("Rule 2 tested!");
        //next we test rule 3, any live cell with 2 or 3 live neighbors lives.
        grid = new int[][] {{1,1},
                {1,1}
        };
        int[][] rule3Grid = grid;
        grid = Main.nextState(grid, 2,2);
        assert Arrays.deepEquals(grid, rule3Grid);
        System.out.println("Rule 3 tested!");
        //next we test rule 4, any dead cell with exactly 3 live neighbors becomes a live cell.
        grid = new int[][] {{1,1},
                {1,0}
        };
        int[][] rule4Grid = {{1,1},
                {1,1}
        };
        grid = Main.nextState(grid, 2,2);
        assert Arrays.deepEquals(grid, rule4Grid);
        System.out.println("Rule 4 tested!");
    }
}