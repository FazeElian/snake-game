package domain;
import java.util.*;


/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake
{
    private static final int INITIAL_SIZE = 3;
    private ArrayList<Cell> body;
    private Direction direction;

    /**
     * Constructor for objects of class Snake
     */
    public Snake(int headX, int headY){
        body = new ArrayList<>(INITIAL_SIZE);
        direction = Direction.RIGHT;
    }
}