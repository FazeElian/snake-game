package domain;

public class Fruit extends Cell {
    public static final int POINTS = 5;
    
    /**
     * Constructor for objects of class Fruit
     */
    public Fruit(int x, int y){
        super(x, y);
    }
    
    @Override
    public boolean isFood() {
        return true;
    }
}