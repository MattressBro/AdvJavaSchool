package Module2;
import javax.swing.*;
import java.awt.*;
public class test {
    public static void main(String[] args) {
        // Create a new JFrame (the window)
        JFrame frame = new JFrame("Test Window");

        // Set the size of the frame (width, height)
        frame.setSize(400, 300);

        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JButton with the label "Click Me"
        JButton button = new JButton("Click Me");

        // Add the button to the frame's content pane
        frame.getContentPane().add(button, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}
