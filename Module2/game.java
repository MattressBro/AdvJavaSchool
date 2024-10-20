package Module2;
import javax.swing.*;

public class game extends JFrame {
    public game() {
        setTitle("Puzzle Widget Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        puzWig gamePanel = new puzWig();
        add(gamePanel);
        setVisible(true); 
    }

    public static void main(String[] args) {
        new game();
    }
}
