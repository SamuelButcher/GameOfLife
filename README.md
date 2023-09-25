# GameOfLife
For building and running:

Both the main method and the tests run perfectly in Intelij, my IDE, and the build for the .jar for the main works perfectly too, so running should be simple.

The only dependency is JUnit for the tests, which is easily installed at https://junit.org/junit5/, or my IDE did an automatic installation.

All requirements have been implemented fully, as the program flawlessly simulates the game of life and achieves the initial state -> new state process as shown on the Kata

I also included the ability to specify the number of rows and columns, which then is filled up with random values in order to give a different simulation every time, as well as the ability to simulate as many times as wanted. The original grid given in the kata is the default to verify.

For the algorithm/methodology: I originally considered doing the grid as a seperate class with the 2d array and column and row variables as internal variables but decided against it as only one grid would ever be used at a time and this would therefore save on performance by making smaller methods.

I made both the print grid and next state operations seperate methods as that helps with the looping and repeatability of the program; if it can be called every time, cutting down on bugtesting plus making the code much more readable.

If I had to add any more features, I would most likely add the ability to input your own grid yourself, in which case I would use a scanner object to iterate through the string that the user would input to place it into the array (the biggest reason I didn't do this is that I figured it would be tedious for the tester to manually input the grid and wanted to save you time)

Pseudo code for grid feeding implementation:

Ask if user wants random or user-designated grid

if user-designated{

  for loop that iterates through rows{
  
    ask user for that line of the grid
    
    check that line is right size, ask for reinput if wrong size
    
    for loop that iterates through columns
    
      use Java scanner to Scanner.next() the values in to each array position
      
    }
    
}
