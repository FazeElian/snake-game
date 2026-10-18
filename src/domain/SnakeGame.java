package domain;


/**
 * Write a description of class SnakeGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeGame
{
    private boolean finished = true;
    private Cell[][] board;
    private Snake player;
    private int fruits;

    /**
     * Constructor for objects of class SnakeGame
     */
    public SnakeGame(int width, int height, int fruits) throws SnakeGameException {
        Cell[][] board = new Cell[width][height];
        this.finished = false;
        this.fruits = fruits;
        
        int headX = 2; 
        int headY = height / 2;
        
        Snake player = new Snake(headX, headY);
    }
}