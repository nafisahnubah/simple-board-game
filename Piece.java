//Name: Nafisah Nubah
//Dal ID: B00961732

public class Piece {
    //instance variables
    String name;
    String colour;
    int[] position = new int[2];

    //constructor
    public Piece(String name, String colour, int[] position) {
        this.name = name;
        this.colour = colour;
        this.position = position;
    }

    //getters and setters
    public String getName(){
        return this.name;
    }
    public String getColour(){
        return this.colour;
    }
    public int[] getPosition(){
        return this.position;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setPosition(int[] position){
        this.position = position;
    }

    //toString() method
    @Override
    public String toString() {
        return this.name+this.colour;
    }
}
