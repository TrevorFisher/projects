import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class HigherOrLower {
    public static void main() {
        //Variables
        Random rand = new Random();
        int randValue = rand.nextInt(1001);
        final int[] counter = {0};
        final boolean[] boolWin = {false};

        //Creating the JFrame
        JFrame holFrame = new JFrame("Higher Or Lower");
        holFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        holFrame.setLayout(new GridLayout(2,2));
        Container holPane = holFrame.getContentPane();
        //Text field
        JTextField inputField = new JTextField("Input your guess here");
        inputField.setHorizontalAlignment(JTextField.CENTER);
        holPane.add(inputField);
        //enter button
        JButton chooseButton = new JButton("Enter Guess");
        holPane.add(chooseButton);
        //Display
        final JLabel[] displayLabel = {new JLabel("A number between 1 and 1000 has been generated", SwingConstants.CENTER)};
        holPane.add(displayLabel[0]);
        //exit button
        JButton closeButton = new JButton("Exit");
        holPane.add(closeButton);
        //Size of the frame
        holFrame.setBounds(500,200,600,400);
        holFrame.setVisible(true);
        //Button pressed events
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strGuess = "";
                int guess = 1;
                //Game logic
                    strGuess = inputField.getText();
                    guess = Integer.parseInt(strGuess);
                    if (boolWin[0] == true){
                        //Game reset
                        displayLabel[0].setText("Higher or Lower");
                        inputField.setText("Input your guess here");
                        holFrame.setVisible(false);
                        HigherOrLower.main();
                    }
                    else if (guess < randValue){
                        displayLabel[0].setText("Higher");
                        counter[0]++;
                    }
                    else if (guess > randValue){
                        displayLabel[0].setText("Lower");
                        counter[0]++;
                    }
                    else if (guess == randValue){
                        displayLabel[0].setText("You guessed the number! It took you " + counter[0] + " tries!");
                        counter[0] = 0;
                        chooseButton.setText("Play Again?");
                        boolWin[0] = true;
                    }
                    else {
                        inputField.setText("Fam, the input has to be a number between 1 and 1000");
                    }

            }
        });
    }

}