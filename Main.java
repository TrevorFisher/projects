import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        //Creating the JFrame
        JFrame homeFrame = new JFrame("Game Selection");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setLayout(new GridLayout(4,1));
        Container contentPane = homeFrame.getContentPane();
        //Home screen buttons
        JButton closeButton = new JButton("Close");
        JButton higherOrLower = new JButton("Higher or Lower");
        JButton blackJack = new JButton("Blackjack");
        JButton ticTacToe = new JButton("Tic Tac Toe");
        contentPane.add(higherOrLower);
        contentPane.add(blackJack);
        contentPane.add(ticTacToe);
        contentPane.add(closeButton);
        //Size of the frame
        homeFrame.setBounds(500,200,600,400);
        homeFrame.setVisible(true);
        //Button pressed events
        blackJack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                BlackJack.main();
            }
        });
        ticTacToe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                TicTacToe.main();
            }
        });
        higherOrLower.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                HigherOrLower.main();
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeFrame.setVisible(false);
                System.exit(0);
            }
        });

    }
}
