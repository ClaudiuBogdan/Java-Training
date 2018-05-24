# Project 7.10 The Game of Life (page369)

The Game of Life is a well-known mathematical game that gives rise to amazingly
complex behavior, although it can be specified by a few simple rules. (It is not
actually a game in the traditional sense, with players competing for a win.) Here are
the rules. The game is played on a rectangular board. Each square can be either
empty or occupied. At the beginning, you can specify empty and occupied cells in
some way; then the game runs automatically. In each
generation, the next generation is computed. A new cell is
born on an empty square if it is surrounded by exactly
three occupied neighbor cells. A cell dies of overcrowding
if it is surrounded by four or more neighbors, and it dies of
loneliness if it is surrounded by zero or one neighbor. A
neighbor is an occupant of an adjacent square to the left,
right, top, or bottom or in a diagonal direction. Figure 21
shows a cell and its neighbor cells.
Many configurations show interesting behavior when subjected to these rules.
Figure 22 shows a glider, observed over five generations. After four generations, it is
transformed into the identical shape, but located one square to the right and below.
One of the more amazing configurations is the glider gun: a complex collection of
cells that, after 30 moves, turns back into itself and a glider (see Figure 23).
Program the game to eliminate the drudgery of computing successive generations by
hand. Use a two-dimensional array to store the rectangular configuration. Write a
program that shows successive generations of the game. Ask the user to specify the
original configuration, by typing in a configuration of spaces and o characters.