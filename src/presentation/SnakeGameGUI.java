package presentation;
import domain.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

/**
 * Write a description of class SnakeGameGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeGameGUI extends JFrame{
    private SnakeGame game;
    private JLabel scoreLabel;
    private JPanel welcomePane;
    //private BoardPanel board;
    private static final String DEFAULT_SIZE = "30";
    
    public SnakeGameGUI() {
        super("Snake Game");
        prepareElements();
        prepareWelcome();
    }
    
    private void prepareElements() {
        setLayout(new BorderLayout());
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
        scoreLabel.setForeground(Color.WHITE);
        
        add(scoreLabel, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(40, 160, 80));
        scoreLabel.setVisible(false);
    }
    
    // private void prepareMenu() {
    //     JMenuBar menuBar = new JMenuBar();
    //     JMenu menu = new JMenu("Game");
    //     menu.setFont(new Font("SansSerif", Font.BOLD, 16));
    //     menu.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
        
    //     JMenuItem newItem = new JMenuItem("New Game");
    //     newItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "New Game button pressed"));
    //     newItem.setFont(new Font("SansSerif", Font.BOLD, 16));
        
    //     JMenuItem exitItem = new JMenuItem("Exit");
    //     exitItem.setFont(new Font("SansSerif", Font.BOLD, 16));
    //     exitItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Exit button pressed"));
        
    //     menu.add(newItem);
    //     menu.addSeparator();
    //     menu.add(exitItem);
    //     menuBar.add(menu);
    //     setJMenuBar(menuBar);
    // }
    
    private void prepareWelcome() {
        welcomePane = new JPanel(new GridLayout(3, 1, 0, 10));
        welcomePane.setBorder(BorderFactory.createEmptyBorder(150, 100, 200, 100));
        welcomePane.setBackground(Color.WHITE);
        
        JLabel welcomeTxt = new JLabel("Snake Game");
        welcomeTxt.setFont(new Font("Arial", Font.BOLD, 35));
        welcomeTxt.setForeground(new Color(30, 20, 30));
        welcomeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton playBtn = createButton(
            "Play",
            new Color(40, 160, 80),
            Color.WHITE,
            22
        );
        
        JButton exitBtn = createButton(
            "Exit",
            Color.RED,
            Color.WHITE,
            22
        );
        
        // Add elements to JPane component for this section
        welcomePane.add(welcomeTxt);
        welcomePane.add(playBtn);
        welcomePane.add(exitBtn);
        
        playBtn.addActionListener(e -> startGame());
        exitBtn.addActionListener(e -> dispose());
        
        // Add it to the window
        add(welcomePane, BorderLayout.CENTER);
    }
    
    private static JButton createButton(
        String text,
        Color bgColor,
        Color textColor,
        int size
    ) {
        JButton newBtn = new JButton(text);
        newBtn.setForeground(textColor);
        //newBtn.setOpaque(false); -> Transparent background
        newBtn.setBackground(bgColor);
        newBtn.setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
        newBtn.setBorderPainted(false);
        newBtn.setFocusPainted(false);
        newBtn.setFont(new Font("Arial", Font.PLAIN, size));
        
        return newBtn;
    }
    
    // Connects the keyboard with the game
    //private void prepareActions() {
    //    board.setFocusable(true);
    //    board.addKeyListener(new KeyControl(game));
    //}
    
    public static int[] askConfig(Component parent) {        
        JTextField widthField = new JTextField(DEFAULT_SIZE, 5);
        JTextField heightField = new JTextField(DEFAULT_SIZE, 5);
        JTextField fruitsField = new JTextField("1", 5);
        
        JPanel form = new JPanel(new GridLayout(5, 5, 8, 5));
        form.add(new JLabel("Width: "));
        form.add(widthField);
        
        form.add(new JLabel("Height: "));
        form.add(heightField);
        
        form.add(new JLabel("Fruits amount: "));
        form.add(fruitsField);
        
        int option = JOptionPane.showConfirmDialog(
            null, // Parent component
            form, // Message
            "New Game", // Title
            JOptionPane.OK_CANCEL_OPTION, // Option type
            JOptionPane.PLAIN_MESSAGE // Message type
        );
        
        if(option != JOptionPane.OK_OPTION) {
            return null;
        }
        
        int width  = Integer.parseInt(widthField.getText().trim());
        int height = Integer.parseInt(heightField.getText().trim());
        int fruits = Integer.parseInt(fruitsField.getText().trim());
        
        return new int[] { width, height, fruits };
    }
    
    public void showGameScreen() {
        remove(welcomePane);
        scoreLabel.setVisible(true);
        
        // Re calculate the layout
        revalidate();
        
        // Re draw the windows
        repaint();
    }
    
    public void startGame() {
        int[] config = askConfig(this);
        if (config == null) {
            return;
        }
        
        try {
            int width = config[0];
            int height = config[1];
            int fruits = config[2]; 
            game = new SnakeGame(width, height, fruits);
        } catch(SnakeGameException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid configuration: ", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        showGameScreen();
    }
    
    public static void main(String[] args) {
        SnakeGameGUI gui = new SnakeGameGUI();
        gui.setVisible(true);
    }
}