//Name: Nafisah Nubah
//Dal ID: B00961732

import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Board board = new Board();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a command (type help for details):");
        String command = input.nextLine();

        //ends while loop with "exit" command
        while(!command.equals("exit")) {
            if(command.equals("help")) {
                System.out.println("Possible commands are as follows:\n create location [fast][flexible]: Creates a new piece.\n move location direction [spaces]: Moves a piece.\n print: Displays the board.\n help: Displays help.\n exit: Exits the program.");
            }
            else if(command.equals("print")) {
                board.display();
            }
            else{
                boolean inputFormatCorrect = true;
                String[] tokens = command.split(" ");
                //for "create" and "move", ensures location input is integer
                if(tokens.length>2 && (tokens[0].equals("create") || tokens[0].equals("move"))) {
                    try
                    {
                        Integer.parseInt(tokens[1]);
                        Integer.parseInt(tokens[2]);
                    }
                    catch(NumberFormatException ex)
                    {
                        inputFormatCorrect = false;
                    }
                }
                //carries out "create" commands
                if(tokens[0].equals("create") && inputFormatCorrect && tokens.length>2 && Integer.parseInt(tokens[1])>=0 && Integer.parseInt(tokens[1])<=7 && Integer.parseInt(tokens[2])<=7 && Integer.parseInt(tokens[2])>=0) {
                    int[] location = {Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])};
                    if(tokens.length == 4) {
                        //only allows "fast" or "flexible" as 4th input
                        if(tokens[3].equals("flexible")) {//creates SlowFlexible type
                            System.out.println("Input a name for the new piece:");
                            String name = input.nextLine();
                            System.out.println("Input a colour for the new piece:");
                            String colour = input.nextLine();
                            SlowFlexible piece = new SlowFlexible(name, colour, location);
                            board.addPiece(piece);
                        }
                        else if(tokens[3].equals("fast")) {//creates FastPiece type
                            System.out.println("Input a name for the new piece:");
                            String name = input.nextLine();
                            System.out.println("Input a colour for the new piece:");
                            String colour = input.nextLine();
                            FastPiece piece = new FastPiece(name, colour, location);
                            board.addPiece(piece);
                        }
                        else{
                            System.out.println("Invalid command.");
                        }
                    }
                    //only allows "flexible" as 5th input for FastPiece type
                    else if(tokens.length == 5 && tokens[3].equals("fast") && tokens[4].equals("flexible")) {//creates FastFlexible type
                        System.out.println("Input a name for the new piece:");
                        String name = input.nextLine();
                        System.out.println("Input a colour for the new piece:");
                        String colour = input.nextLine();
                        FastFlexible piece = new FastFlexible(name, colour, location);
                        board.addPiece(piece);
                    }
                    else if (tokens.length == 3){//creates SlowPiece type
                        System.out.println("Input a name for the new piece:");
                        String name = input.nextLine();
                        System.out.println("Input a colour for the new piece:");
                        String colour = input.nextLine();
                        SlowPiece piece = new SlowPiece(name, colour, location);
                        board.addPiece(piece);
                    }
                    else {
                        System.out.println("Invalid command.");
                    }
                }
                //handles invalid "move" commands
                else if(tokens[0].equals("move") && inputFormatCorrect && tokens.length==3){
                    int[] location = {Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])};
                    if(board.getBoard()[location[0]][location[1]]==null){
                        System.out.println("Error: no piece at (" + location[0] + "," + location[1] + ")");
                    }
                    else{
                        System.out.println("Please provide direction.");
                    }
                }
                //carries out "move" commands only if direction input is valid
                else if(tokens[0].equals("move") && inputFormatCorrect && tokens.length>3 && (tokens[3].equals("up") || tokens[3].equals("down") || tokens[3].equals("left") || tokens[3].equals("right"))) {
                    int[] location = {Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])};
                    String direction = tokens[3];
                    if(tokens.length == 5 && tokens[4].equals("1") && ((board.getBoard()[location[0]][location[1]] instanceof SlowPiece) || (board.getBoard()[location[0]][location[1]] instanceof SlowFlexible))){
                        SlowPiece piece = (SlowPiece) board.getBoard()[location[0]][location[1]];
                        //only allows "right" and "left" directions for SlowPiece type
                        if(!(board.getBoard()[location[0]][location[1]] instanceof SlowFlexible) && (direction.equals("up") || direction.equals("down"))) {
                            System.out.println("Invalid direction for SlowPiece type.");
                        }
                        else {
                            board.movePiece(piece, direction);
                        }
                    }
                    else if(tokens.length == 4) {
                        //doesn't allow FastPiece to be moved without spaces specified
                        if(board.getBoard()[location[0]][location[1]] instanceof FastPiece) {
                            System.out.println("Please also enter number of spaces for FastPiece type.");
                        }
                        else{
                            SlowPiece piece = (SlowPiece) board.getBoard()[location[0]][location[1]];
                            //only allows "right" and "left" directions for SlowPiece type
                            if(!(board.getBoard()[location[0]][location[1]] instanceof SlowFlexible) && (board.getBoard()[location[0]][location[1]] instanceof SlowPiece) && (direction.equals("up") || direction.equals("down"))) {
                                System.out.println("Invalid direction for SlowPiece type.");
                            }
                            else {
                                board.movePiece(piece, direction);
                            }
                        }
                    }
                    else if(tokens.length == 5) {
                        //checks if spaces specified is integer
                        try
                        {
                            Integer.parseInt(tokens[4]);
                        }
                        catch(NumberFormatException ex)
                        {
                            inputFormatCorrect = false;
                        }
                        //doesn't allow SlowPiece to move spaces greater than 1
                        if(((board.getBoard()[location[0]][location[1]] instanceof SlowPiece) || (board.getBoard()[location[0]][location[1]] instanceof SlowFlexible)) && inputFormatCorrect) {
                            System.out.println("Cannot move SlowPiece type more than 1 space.");
                        }
                        else if(inputFormatCorrect){
                            FastPiece piece = (FastPiece) board.getBoard()[location[0]][location[1]];
                            //only allows "right" and "left" directions for FastPiece type
                            if(!(board.getBoard()[location[0]][location[1]] instanceof FastFlexible) && (board.getBoard()[location[0]][location[1]] instanceof FastPiece) && (direction.equals("up") || direction.equals("down"))) {
                                System.out.println("Invalid direction for FastPiece type.");
                            }
                            else{
                                int n = Integer.parseInt(tokens[4]);
                                board.movePiece(piece, direction, n);
                            }
                        }
                        else{
                            System.out.println("Please ensure spaces is valid(0-7).");
                        }
                    }
                    else{
                        System.out.println("Invalid command.");
                    }
                }
                else{
                    System.out.println("Invalid command, please try again.");
                }
            }
            System.out.println("Enter a command (type help for details):");
            command = input.nextLine();
        }
    }
}
