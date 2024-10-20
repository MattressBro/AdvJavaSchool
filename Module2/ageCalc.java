package Module2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class ageCalc extends JFrame {
    private JSpinner daySpin, monthSpin, yearSpin;
    private JButton calc;
    private JLabel rLabel, yearLabel, monthLabel, dayLabel, tLabel;

    public ageCalc(){
        SpinnerNumberModel dayModel = new SpinnerNumberModel(1,1,31,1);
        SpinnerNumberModel monthModel = new SpinnerNumberModel(1,1,12,1);
        SpinnerNumberModel yearModel = new SpinnerNumberModel(2000,1900,2006,1);

        daySpin = new JSpinner(dayModel);
        monthSpin = new JSpinner(monthModel);
        yearSpin = new JSpinner(yearModel);
        calc = new JButton("Calculate Age");
        rLabel = new JLabel("");
        tLabel = new JLabel("Enter your birthday");
        yearLabel = new JLabel("Year:");
        monthLabel = new JLabel("Month:");
        dayLabel = new JLabel("Day:");
        calc.setPreferredSize(new Dimension(150, 30));
        rLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JSpinner.DefaultEditor dayEdit = (JSpinner.DefaultEditor) daySpin.getEditor();
        dayEdit.getTextField().setEditable(false);
        JSpinner.DefaultEditor monthEdit = (JSpinner.DefaultEditor) monthSpin.getEditor();
        monthEdit.getTextField().setEditable(false);
        JSpinner.DefaultEditor yearEdit = (JSpinner.DefaultEditor) yearSpin.getEditor();
        yearEdit.getTextField().setEditable(false);

        JPanel mp = new JPanel();
        mp.setLayout(new BoxLayout(mp, BoxLayout.Y_AXIS));
        mp.setAlignmentX(LEFT_ALIGNMENT);
        JPanel title = new JPanel();
        JPanel sp = new JPanel();
        JPanel result = new JPanel();
        JPanel button = new JPanel();
        title.add(tLabel);
        sp.add(dayLabel);
        sp.add(daySpin);
        sp.add(monthLabel);
        sp.add(monthSpin);
        sp.add(yearLabel);
        sp.add(yearSpin);
        mp.add(title);
        mp.add(sp);
        result.add(rLabel);
        button.add(calc);
        mp.add(result);
        mp.add(button);
        

        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                calcAge();
            }
        });
        add(mp);
        setTitle("Age Calculator");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void calcAge(){
        int day = (int) daySpin.getValue();
        int month = (int) monthSpin.getValue();
        int year = (int) yearSpin.getValue();
        LocalDate date = LocalDate.now();
        int age;
        age = date.getYear() - year;
        if((date.getMonthValue() - month) < 0){
            age -= 1;
        }
        else if((date.getMonthValue() - month)==0){
            if((date.getDayOfMonth() - day) < 0){
                age -= 1;
            }
        }
        rLabel.setText("Age: "+age);
    }
    public static void main(String[] args){
        new ageCalc();
        
    }
}
