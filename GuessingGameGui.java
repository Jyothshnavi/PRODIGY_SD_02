import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessingGameGui extends JFrame {
    private int randomNumber;
    private int attempts;
    private JTextField guessField;
    private JLabel feedbackLabel;

    public GuessingGameGui() {
        setTitle("Guessing Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Random random = new Random();
        randomNumber = random.nextInt(100)+1;
        attempts = 0;

        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        guessField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        feedbackLabel = new JLabel(" ");
        feedbackLabel.setFont(new Font("Arial", Font.BOLD,14));

        setLayout(new FlowLayout());
        add(instructionLabel);
        add(guessField);
        add(guessButton);
        add(feedbackLabel);

        guessButton.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = guessField.getText();
                try {
                    int guess = Integer.parseInt(userInput);
                    attempts++;
                    if (guess < randomNumber) {
                        feedbackLabel.setText("Too Low!Try Again.");
                    } else if (guess > randomNumber) {
                        feedbackLabel.setText("Too High!Try Again.");
                    } else {
                        feedbackLabel.setText("Congrats! Attempts:" + attempts);
                        guessField.setEditable(false);
                    }
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please  enter a valid number!");
                }
                guessField.setText("");
            }
        });
        } 
        public static void main(String[] args) {
            SwingUtilities.invokeLater(()-> {
                GuessingGameGui game = new GuessingGameGui();
                game.setVisible(true);
            });
        }
    }

