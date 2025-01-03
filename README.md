# Board Game Simulation

This is a simple board game simulation implemented in Java. The game consists of different types of pieces that can move on an 8x8 grid, where each piece has specific movement capabilities. Players can create pieces, move them, and display the current state of the game board.

## Table of Contents

1. [Overview](#overview)
2. [Setup and Running the Game](#setup-and-running-the-game)
3. [Commands](#commands)
4. [Game Rules](#game-rules)

## Overview

The game is played on an 8x8 board, with each piece occupying one position. Each piece has a name, a color, and a position on the board. There are different types of pieces, each with unique movement rules:

- **Slow Pieces** move one step at a time in a horizontal direction.
- **Fast Pieces** can move multiple steps at once in a horizontal direction.
- **Slow Flexible Pieces** move one step at a time but can go up/down or left/right.
- **Fast Flexible Pieces** can move multiple steps in both horizontal and vertical directions.

## Setup and Running the Game

To run this project:

1. Clone the repository or download the Java source files.
2. Compile the Java files:
    ```
    javac *.java
    ```
3. Run the `GameDemo` class to start the game:
    ```
    java GameDemo
    ```
4. Follow the on-screen prompts to interact with the game.

## Commands

### `create location [fast][flexible]`
Creates a new piece at the given location on the board (specified by `x y`). You can also specify if the piece is `fast` or `flexible`. By default, pieces are slow and non-flexible.

- Example:
    - `create 1 1` → Creates a slow non-flexible piece at location (1, 1)
    - `create 1 1 fast` → Creates a fast non-flexible piece at location (1, 1)
    - `create 1 1 flexible` → Creates a slow flexible piece at location (1, 1)
    - `create 1 1 fast flexible` → Creates a fast flexible piece at location (1, 1)

After creating a piece, you'll be prompted to enter the piece's name and color.

### `move location direction [spaces]`
Moves a piece from the specified location (`x y`) in the given direction. If it's a fast piece, you can specify the number of spaces to move.

- Example:
    - `move 5 5 left` → Moves the piece at (5, 5) one space to the left
    - `move 5 5 up 2` → Moves the piece at (5, 5) two spaces up
    - `move 5 5 right 3` → Moves the piece at (5, 5) three spaces to the right

### `print`
Displays the current state of the game board, showing the name, color, and type of each piece at its current location.

### `help`
Displays a list of available commands.

### `exit`
Exits the game.

## Game Rules

1. **Board Size**: The game board is an 8x8 grid with coordinates ranging from (0, 0) to (7, 7).
2. **Movement**:
    - **Slow Pieces**: Can only move one space per move, either left or right.
    - **Fast Pieces**: Can move multiple spaces per move, either left or right.
    - **Slow Flexible Pieces**: Can move one space at a time, but in any of the four directions.
    - **Fast Flexible Pieces**: Can move multiple spaces at a time in any direction.
3. **Edge Constraints**: If a piece tries to move off the edge of the board, it won't move. An error message will be shown if this happens.
4. **Piece Creation**: A piece can be created only in an empty space. If a piece already exists at the specified location, an error message will be shown.
5. **Game End**: The game continues until the `exit` command is entered.

