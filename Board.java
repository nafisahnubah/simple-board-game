//Name: Nafisah Nubah
//Dal ID: B00961732

public class Board {
    //instance variables
    Piece[][] board;

    //constructor
    public Board() {
        this.board = new Piece[8][8];
    }

    //getter and setter
    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }

    //toString() method, displays the game board
    @Override
    public String toString() {
        return super.toString();
    }

    //other methods
    //Add a new Piece to the game board
    public void addPiece(Piece piece) {
        if(board[piece.getPosition()[0]][piece.getPosition()[1]]==null){
            board[piece.getPosition()[0]][piece.getPosition()[1]]=piece;
        }
        else{
            System.out.println("Error! Piece could not be added!");
        }
    }

    //move a Piece at a given location in a given direction by a given number of spaces
    public void movePiece(SlowPiece piece, String direction) {
        if(piece==null){
            System.out.println("Error! Piece could not be found!");
            return;
        }
        int prevX = piece.getPosition()[0];
        int prevY = piece.getPosition()[1];

        board[prevX][prevY]=null;
        piece.move(direction);

        int newX = piece.getPosition()[0];
        int newY = piece.getPosition()[1];

        if(board[newX][newY]==null && (newX!=prevX || newY!=prevY)){
            board[newX][newY]=piece;
            System.out.println("Piece at (" + prevX + "," + prevY + ") moved " + direction + ".");
        }
        //if another piece already exists, return board and piece to previous condition
        else{
            piece.setPosition(new int[]{prevX, prevY});
            board[prevX][prevY]=piece;
            System.out.println("Could not move piece!");
        }
    }

    public void movePiece(FastPiece piece, String direction, int n) {
        if(piece==null){
            System.out.println("Error! Piece could not be found!");
            return;
        }
        int prevX = piece.getPosition()[0];
        int prevY = piece.getPosition()[1];

        board[prevX][prevY]=null;
        piece.move(direction, n);

        int newX = piece.getPosition()[0];
        int newY = piece.getPosition()[1];

        if(board[newX][newY]==null && (newX!=prevX || newY!=prevY)){
            board[newX][newY]=piece;
            System.out.println("Piece at (" + prevX + "," + prevY + ") moved " + direction + " by " + n + " spaces.");
        }
        //if another piece already exists, return board and piece to previous condition
        else{
            piece.setPosition(new int[]{prevX, prevY});
            board[prevX][prevY]=piece;
            System.out.println("Could not move piece!");
        }
    }

    //displays the board
    public void display(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[j][i]==null){
                    System.out.print("    -    ");
                }
                else{
                    System.out.print(board[j][i] + " ");
                }
            }
            System.out.println();
        }
    }
}
