import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    //Method to check if there is a winner every button press (X Variant)
    public static boolean checkWinX(String but0, String but1, String but2, String but3, String but4, String but5,
                                    String but6, String but7, String but8){
        boolean win = false;
        if ((but0.equals("X") && but1.equals("X") && but2.equals("X"))){
            win = true;
        }
        else if ((but3.equals("X") && but4.equals("X") && but5.equals("X"))){
            win = true;
        }
        else if ((but6.equals("X") && but7.equals("X") && but8.equals("X"))){
            win = true;
        }
        else if ((but0.equals("X") && but3.equals("X") && but6.equals("X"))){
            win = true;
        }
        else if ((but1.equals("X") && but4.equals("X") && but7.equals("X"))){
            win = true;
        }
        else if ((but2.equals("X") && but5.equals("X") && but8.equals("X"))){
            win = true;
        }
        else if ((but0.equals("X") && but4.equals("X") && but8.equals("X"))){
            win = true;
        }
        else if ((but2.equals("X") && but4.equals("X") && but6.equals("X"))){
            win = true;
        }
        return win;
    }
    //Method to check if there is a winner every button press (O Variant)
    public static boolean checkWinO(String but0, String but1, String but2, String but3, String but4, String but5,
                                    String but6, String but7, String but8){
        boolean win = false;
        if ((but0.equals("O") && but1.equals("O") && but2.equals("O"))){
            win = true;
        }
        else if ((but3.equals("O") && but4.equals("O") && but5.equals("O"))){
            win = true;
        }
        else if ((but6.equals("O") && but7.equals("O") && but8.equals("O"))){
            win = true;
        }
        else if ((but0.equals("O") && but3.equals("O") && but6.equals("O"))){
            win = true;
        }
        else if ((but1.equals("O") && but4.equals("O") && but7.equals("O"))){
            win = true;
        }
        else if ((but2.equals("O") && but5.equals("O") && but8.equals("O"))){
            win = true;
        }
        else if ((but0.equals("O") && but4.equals("O") && but8.equals("O"))){
            win = true;
        }
        else if ((but2.equals("O") && but4.equals("O") && but6.equals("O"))){
            win = true;
        }
        return win;
    }
    public static void main(){
        //Variables
        final boolean[] playerTurn = {false};
        final boolean[] winX = {false};
        final boolean[] winO = {false};
        final int[] gameCounter = {0};
        //Creating the JFrame
        JFrame TTTFrame = new JFrame("Tic Tac Toe");
        TTTFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TTTFrame.setLayout(new GridLayout(3,3));
        Container TTTPane = TTTFrame.getContentPane();
        //Buttons 0 through 8
        JButton zeroButton = new JButton("");
        TTTPane.add(zeroButton);
        JButton oneButton = new JButton("");
        TTTPane.add(oneButton);
        JButton twoButton = new JButton("");
        TTTPane.add(twoButton);
        JButton threeButton = new JButton("");
        TTTPane.add(threeButton);
        JButton fourButton = new JButton("");
        TTTPane.add(fourButton);
        JButton fiveButton = new JButton("");
        TTTPane.add(fiveButton);
        JButton sixButton = new JButton("");
        TTTPane.add(sixButton);
        JButton sevenButton = new JButton("");
        TTTPane.add(sevenButton);
        JButton eightButton = new JButton("");
        TTTPane.add(eightButton);
        //Size of the frame
        TTTFrame.setBounds(500,200,400,400);
        TTTFrame.setVisible(true);
        //Button pressed
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (zeroButton.getText().equals("")){
                    gameCounter[0]++;
                    if (playerTurn[0] == false){
                        zeroButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        zeroButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (oneButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        oneButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        oneButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (twoButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        twoButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        twoButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (threeButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        threeButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        threeButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (fourButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        fourButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        fourButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (fiveButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        fiveButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        fiveButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        sixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (sixButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        sixButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        sixButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        sevenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (sevenButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        sevenButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        sevenButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
        eightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameCounter[0]++;
                if (eightButton.getText().equals("")){
                    if (playerTurn[0] == false){
                        eightButton.setText("X");
                        playerTurn[0] = true;
                    }
                    else if (playerTurn[0] == true){
                        eightButton.setText("O");
                        playerTurn[0] = false;
                    }
                }
                //Check to see if X wins
                winX[0] = checkWinX(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //Check to see if O wins
                winO[0] = checkWinO(zeroButton.getText(), oneButton.getText(), twoButton.getText(), threeButton.getText(),fourButton.getText(),
                        fiveButton.getText(), sixButton.getText(), sevenButton.getText(), eightButton.getText());
                //If there is a winner
                if (winX[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player X Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (winO[0] == true){
                    JOptionPane.showMessageDialog(TTTFrame, "Player O Wins!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
                else if (gameCounter[0] == 9){
                    JOptionPane.showMessageDialog(TTTFrame, "Issa tie!");
                    TTTFrame.setVisible(false);
                    TicTacToe.main();
                }
            }
        });
    }
}
