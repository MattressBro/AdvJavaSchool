package Module3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class userInterface extends JFrame {
    private JMenuBar bar;
    private JMenu menu;
    private JMenuItem m1, m2, m3, m4;
    private JTextField field;
    private String colors[] = {"#006600","#008000","#00ff00","#80ff80","#b3ffb3"};
    public userInterface(){
        this.setLayout(new BorderLayout()); 
        bar = new JMenuBar();
        m1 = new JMenuItem("Date and Time");
        m2 = new JMenuItem("Send to File");
        m3 = new JMenuItem("");
        m4 = new JMenuItem("Exit");
        menu = new JMenu("Menu");
        menu.add(m1);
        menu.add(m2);
        menu.add(m3);
        menu.add(m4);
        bar.add(menu);
        this.setJMenuBar(bar);
        field = new JTextField("");
        this.add(field);
        Random ran = new Random();
        int randomInt = ran.nextInt(colors.length);
        String colorChoice = colors[randomInt];
        Color bc = Color.decode(colorChoice);
        getContentPane().setBackground(bc);
        m3.setText("Changed background: " + colorChoice);
        m1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                LocalDateTime current = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                field.setText(current.format(format));
                field.setHorizontalAlignment(field.CENTER);
            }
        });
        m2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                try(FileWriter w = new FileWriter("Module3/log.txt", true)){
                    w.write(field.getText()+"\n");
                    JOptionPane.showMessageDialog(userInterface.this, "Text saved to log.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(userInterface.this, "Error saving to file: " + ex.getMessage());
                }
            }
        });
        m3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent E){
                Random ran = new Random();
                int randomInt = ran.nextInt(colors.length);
                String colorChoice = colors[randomInt];
                Color bc = Color.decode(colorChoice);
                field.setBackground(bc);
                m3.setText("Changed to Hue: " + colorChoice);
            }
        });
        m4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setTitle("Module 3 Critical Thinking");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        new userInterface();
    }
}