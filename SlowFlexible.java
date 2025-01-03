//Name: Nafisah Nubah
//Dal ID: B00961732

public class SlowFlexible extends SlowPiece{
    //constructor
    public SlowFlexible(String name, String colour, int[] position) {
        super(name, colour, position);
    }

    //toString() method
    @Override
    public String toString() {
        return this.name+this.colour+"SF";
    }

    //other methods
    //moves the piece left or right by one space
    public void move (String direction){
        if(direction.equals("left") && position[0]>0){
            position[0]--;
        }
        else if(direction.equals("right") && position[0]<7){
            position[0]++;
        }
        else if(direction.equals("up") && position[1]>0){
            position[1]--;
        }
        else if(direction.equals("down") && position[1]<7){
            position[1]++;
        }
    }
}
