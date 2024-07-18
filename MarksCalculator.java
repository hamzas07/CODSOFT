import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarksCalculator extends JFrame {
    private JTextField engField, physField, chemField, bioField, mathField;
    private JLabel totalLabel, avgLabel, gradeLabel;

    public MarksCalculator() {
        
        setTitle("STUDENT GRADE CALCULATOR");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(true);

        
        JLabel engLabel = new JLabel("English:");
        engLabel.setBounds(50, 50, 100, 30);
        add(engLabel);

        engField = new JTextField();
        engField.setBounds(150, 50, 150, 30);
        add(engField);

        JLabel physLabel = new JLabel("Physics:");
        physLabel.setBounds(50, 100, 100, 30);
        add(physLabel);

        physField = new JTextField();
        physField.setBounds(150, 100, 150, 30);
        add(physField);

        JLabel chemLabel = new JLabel("Chemistry:");
        chemLabel.setBounds(50, 150, 100, 30);
        add(chemLabel);

        chemField = new JTextField();
        chemField.setBounds(150, 150, 150, 30);
        add(chemField);

        JLabel bioLabel = new JLabel("Biology:");
        bioLabel.setBounds(50, 200, 100, 30);
        add(bioLabel);

        bioField = new JTextField();
        bioField.setBounds(150, 200, 150, 30);
        add(bioField);

        JLabel mathLabel = new JLabel("Mathematics:");
        mathLabel.setBounds(50, 250, 100, 30);
        add(mathLabel);

        mathField = new JTextField();
        mathField.setBounds(150, 250, 150, 30);
        add(mathField);

        
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(50, 300, 250, 30);
        add(calculateButton);

        
        totalLabel = new JLabel("Total Marks: ");
        totalLabel.setBounds(50, 350, 300, 30);
        add(totalLabel);

        avgLabel = new JLabel("Average Percentage: ");
        avgLabel.setBounds(50, 400, 300, 30);
        add(avgLabel);

        gradeLabel = new JLabel("Grade: ");
        gradeLabel.setBounds(50, 450, 300, 30);
        add(gradeLabel);

        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });

        
        setVisible(true);
    }

    private void calculateResults() {
        try {
            int eng = Integer.parseInt(engField.getText());
            int phys = Integer.parseInt(physField.getText());
            int chem = Integer.parseInt(chemField.getText());
            int bio = Integer.parseInt(bioField.getText());
            int math = Integer.parseInt(mathField.getText());

            int total = eng + phys + chem + bio + math;
            double average = total / 5.0;
            String grade;

            if (average >= 90) {
                grade = "A";
            } else if (average >= 80) {
                grade = "B";
            } else if (average >= 70) {
                grade = "C";
            } else if (average >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            totalLabel.setText("Total Marks: " + total);
            avgLabel.setText("Average Percentage: " + average);
            gradeLabel.setText("Grade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for marks", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MarksCalculator();
    }
}
