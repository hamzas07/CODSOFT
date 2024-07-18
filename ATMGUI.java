import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGUI {
    private static int balance = 100000;
    private static final int PIN = 9372;
    
    private JFrame frame;
    private JPanel panel;
    private JLabel messageLabel;
    private JTextField pinField;
    private JTextField amountField;
    private JLabel balanceLabel;

    public ATMGUI() {
        frame = new JFrame("ATM");
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        messageLabel = new JLabel("Enter Your 4-digit PIN:");
        panel.add(messageLabel);

        pinField = new JTextField();
        panel.add(pinField);

        JButton enterPinButton = new JButton("Enter PIN");
        enterPinButton.addActionListener(new EnterPinAction());
        panel.add(enterPinButton);

        balanceLabel = new JLabel();
        panel.add(balanceLabel);

        amountField = new JTextField();
        amountField.setVisible(false);
        panel.add(amountField);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(new CheckBalanceAction());
        checkBalanceButton.setVisible(false);
        panel.add(checkBalanceButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new WithdrawAction());
        withdrawButton.setVisible(false);
        panel.add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new DepositAction());
        depositButton.setVisible(false);
        panel.add(depositButton);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class EnterPinAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int enteredPin = Integer.parseInt(pinField.getText());
            if (enteredPin == PIN) {
                messageLabel.setText("PIN accepted. Choose an action:");
                pinField.setVisible(false);

                Component[] components = panel.getComponents();
                for (Component component : components) {
                    if (component instanceof JButton) {
                        component.setVisible(true);
                    }
                }
            } else {
                messageLabel.setText("Incorrect PIN. Try again:");
            }
        }
    }

    private class CheckBalanceAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            balanceLabel.setText("Current Balance: " + balance);
        }
    }

    private class WithdrawAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageLabel.setText("Enter amount to withdraw:");
            amountField.setVisible(true);
            amountField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int amount = Integer.parseInt(amountField.getText());
                    if (balance < amount) {
                        messageLabel.setText("Insufficient Balance.");
                    } else {
                        balance -= amount;
                        messageLabel.setText("Amount withdrawn: " + amount);
                        balanceLabel.setText("Current Balance: " + balance);
                    }
                    amountField.setText("");
                    amountField.setVisible(false);
                }
            });
        }
    }

    private class DepositAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageLabel.setText("Enter amount to deposit:");
            amountField.setVisible(true);
            amountField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int amount = Integer.parseInt(amountField.getText());
                    balance += amount;
                    messageLabel.setText("Amount deposited: " + amount);
                    balanceLabel.setText("Current Balance: " + balance);
                    amountField.setText("");
                    amountField.setVisible(false);
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ATMGUI::new);
    }
}

