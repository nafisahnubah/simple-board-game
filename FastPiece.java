//Name: Nafisah Nubah
//Dal ID: B00961732

public class FastPiece extends Piece {
    //constructor
    public FastPiece(String name, String colour, int[] position) {
        super(name, colour, position);
    }

    //toString() method
    @Override
    public String toString() {
        return this.name+this.colour+"F";
    }

    //other methods
    //moves the piece left or right by one space
    public void move (String direction, int n){
        if (n<0 || n>7){
            return;
        }
        else if(direction.equals("left") && position[0]>=n){
            position[0]-=n;
        }
        else if(direction.equals("right") && position[0]<=7-position[0]){
            position[0]+=n;
        }
    }
}
