This is a Sudoku Java Application (JAR). Double-click to run.

The user can select any of four difficulty levels. They then try to complete the puzzle.
The goal is to fill a 9x9 grid so that each column, each row, and each of the regions contains each of the numbers 1 to 9.
A cell is the smallest block in the game. Each row, column, and region consists of 9 cells and the whole game consists of 81 cells.

The user will interact with the GUI controls by clicking the mouse. They will interact with the board using the keyboard and optionally the mouse.
To assign a cell a number the user will click the cell (or navigate to it using the arrow keys) and type the number they want to assign.
The game does not allow the user to input a naiive conflict (where the same number is assigned to two cells in the same row/column/region).
If the user tries to assign a naiive conflict the board will highlight the conflicting cells.
The game does not, however, tell the user if they have incorrectly assigned a cell. They have to figure that out on their own.
If the user correctly assigns every cell in a row/column/region the game will provide positive feedback to the user by flashing that section green and playing a chime.

If the user completes the board correctly they will be able to start a new game by pressing "n".
If the user wants to pause/unpause the game they can press "p".
If the user wants to mute/unmute the game music/sounds they can press "m".

All code in qqwing folder is borrowed from the following via the GNU liscense:
stephenostermiller/qqwing, QQWing, (2014), GitHub repository, https://github.com/stephenostermiller/qqwing
Some of the qqwing code has been adapted for this project