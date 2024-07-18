import java.util.*;
import javax.swing.JOptionPane;

class GTN {

    public static void main(String[] args) {
        int attempts = 0;
        Random rc = new Random();
        int response = JOptionPane.YES_OPTION;

        
        while (response == JOptionPane.YES_OPTION) {
            playGame(rc);
            attempts++;
            response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }

        JOptionPane.showMessageDialog(null, "Thanks for playing! You made " + attempts + " attempts.");
    }

    
    public static void playGame(Random rc) {
        int a = rc.nextInt(100) + 1; 
        JOptionPane.showMessageDialog(null, "Welcome to our Number Guessing Game :)");

        int choice = Integer.parseInt(JOptionPane.showInputDialog("Guess the number between 1 to 100 :)"));

        if (a == choice) {
            JOptionPane.showMessageDialog(null, "Hurrayyy!! Your Guess is Correct");
        } else if (a > choice) {
            JOptionPane.showMessageDialog(null, "Your Guess is too low :(");
        } else {
            JOptionPane.showMessageDialog(null, "Your Guess is too high :(");
        }
    }
}




