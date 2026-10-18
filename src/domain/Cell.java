package domain;


/**
 * Write a description of class Cell here.
 * 
 * @author Elián Ibarra
 * @version 1.0
 */
public class Cell
{
    private int posX;
    private int posY;

    /**
     * Constructor for objects of class Cell
     */
    public Cell(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    
    public int getX() { return posX; };
    public int getY() { return posY; };
    
    public boolean isFood() {
        return false;
    }
}