import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BlackJack {
    static int DrawFromDeckDealer(int randNum){
        int[] intDeck = {1, 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9};
        String[] strDeck = {"Ace", "Ace", "Ace", "Ace", "Jack", "Queen", "King", "Jack", "Queen", "King", "Jack", "Queen", "King", "Jack", "Queen", "King"};
        Random rand = new Random();
        randNum = rand.nextInt(intDeck.length - 1);
        if (randNum < 4) {
            System.out.println("The dealer drew an ace, it can equal either 1 or 11");
        } else if (randNum > 3 && randNum < 16) {
            System.out.println("The dealer drew a " + strDeck[randNum] + " which has a value of " + intDeck[randNum]);
        } else if (randNum > 16) {
            System.out.println("The dealer drew a " + intDeck[randNum]);
        }
        return intDeck[randNum];
    }
    static int DrawFromDeckPlayer(int randNum){
        int[] intDeck = {1, 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9};
        String[] strDeck = {"Ace", "Ace", "Ace", "Ace", "Jack", "Queen", "King", "Jack", "Queen", "King", "Jack", "Queen", "King", "Jack", "Queen", "King"};
        Random rand = new Random();
        randNum = rand.nextInt(intDeck.length - 1);
        if (randNum < 4) {
            System.out.println("You drew an ace, it can equal either 1 or 11");
        } else if (randNum > 3 && randNum < 16) {
            System.out.println("You drew a " + strDeck[randNum] + ", which has a value of " + intDeck[randNum]);
        } else if (randNum > 16) {
            System.out.println("You drew a " + intDeck[randNum]);
        }
        return intDeck[randNum];

    }
        public static void main() {
            final int[] dealerTotal = {0};
            final int[] playerTotal = { 0 };
            final int[] dealerDraw = {0};
            final int[] playerDraw = { 0 };
            final Boolean[] playerAce = {false};
            final Boolean[] dealerAce = {false};

            //Creating the JFrame
            JFrame BJFrame = new JFrame("Blackjack");
            BJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            BJFrame.setLayout(new GridLayout(3,2));
            Container BJPane = BJFrame.getContentPane();
            //Player total label
            JLabel playerLabel = new JLabel("Player total: " + playerTotal[0], SwingConstants.CENTER);
            BJPane.add(playerLabel);
            //Dealer total label
            JLabel dealerLabel = new JLabel("Dealer total: " + dealerTotal[0], SwingConstants.CENTER);
            BJPane.add(dealerLabel);
            //Hit button
            JButton hitButton = new JButton("Hit");
            BJPane.add(hitButton);
            //Stand button
            JButton standButton = new JButton("Stand");
            BJPane.add(standButton);
            //Wins label
            JLabel winLabel = new JLabel("The dealer wins ties", SwingConstants.CENTER);
            BJPane.add(winLabel);
            //Exit button
            JButton closeButton = new JButton("Exit");
            BJPane.add(closeButton);
            //Size of the frame
            BJFrame.setBounds(500,200,600,400);
            BJFrame.setVisible(true);
            //Start of the game logic, player draws 2 cards from deck
            playerDraw[0] = DrawFromDeckPlayer(0);
            if (playerDraw[0] == 1) {
                playerAce[0] = true;
                playerDraw[0] = 11;
            }
            playerTotal[0] = playerTotal[0] + playerDraw[0];
            playerDraw[0] = DrawFromDeckPlayer(0);
            if (playerDraw[0] == 1) {
                playerAce[0] = true;
                playerDraw[0] = 11;
            }
            playerTotal[0] = playerTotal[0] + playerDraw[0];
            playerLabel.setText("Player Total: " + playerTotal[0]);
            //In case player draws 2 aces in their first draw
            if (playerTotal[0] > 21 && playerAce[0] == true){
                playerAce[0] = false;
                playerTotal[0] = playerTotal[0] - 10;
                playerLabel.setText("Player Total: " + playerTotal[0]);
            }
            //In case player starts with blackjack
            if (playerTotal[0] == 21){
                System.out.println("You got Blackjack! It is the dealer's turn");
                //Dealer's turn, first 2 draws
                dealerDraw[0] = DrawFromDeckDealer(0);
                if (dealerDraw[0] == 1) {
                    dealerAce[0] = true;
                    dealerDraw[0] = 11;
                }
                dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                dealerDraw[0] = DrawFromDeckDealer(0);
                if (dealerDraw[0] == 1) {
                    dealerAce[0] = true;
                    dealerDraw[0] = 11;
                }
                dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                //Just in case the dealer draws 2 aces
                if (dealerTotal[0] > 21 && dealerAce[0] == true){
                    dealerAce[0] = false;
                    dealerTotal[0] = dealerTotal[0] - 10;
                    dealerLabel.setText("Dealer Total: " + dealerTotal[0]);
                }
                dealerLabel.setText("Dealer Total: " + dealerTotal[0]);
                //Dealer logic
                if (dealerTotal[0] >= playerTotal[0]){
                    System.out.println("The dealer wins with a " + dealerTotal[0]);
                    winLabel.setText("The dealer wins!");
                    //Reset
                    BJFrame.setVisible(false);
                    BlackJack.main();
                }
                //Dealer draws again
                do {
                    dealerDraw[0] = DrawFromDeckDealer(0);
                    if (dealerDraw[0] == 1) {
                        dealerAce[0] = true;
                        dealerDraw[0] = 11;
                    }
                    dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                    if (dealerTotal[0] > 21 && dealerAce[0] == true){
                        dealerAce[0] = false;
                        dealerTotal[0] = dealerTotal[0] - 10;
                    }
                    if(dealerTotal[0] > 21){
                        System.out.println("The dealer went bust! The player wins!");
                        winLabel.setText("The player wins!");
                        //Reset
                        BJFrame.setVisible(false);
                        BlackJack.main();
                    }
                    else if(dealerTotal[0] >= playerTotal[0]){
                        System.out.println("The dealer wins with a " + dealerTotal[0]);
                        winLabel.setText("The dealer wins!");
                        //Reset
                        BJFrame.setVisible(false);
                        BlackJack.main();
                    }
                }
                while (dealerTotal[0] < playerTotal[0]);
            }
            //Hit button logic
            hitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playerDraw[0] = DrawFromDeckPlayer(0);
                    if (playerDraw[0] == 1) {
                        playerAce[0] = true;
                        playerDraw[0] = 11;
                    }
                    playerTotal[0] = playerTotal[0] + playerDraw[0];
                    if (playerTotal[0] == 21){
                        System.out.println("You got Blackjack! It is the dealer's turn");
                        //Dealer's turn, first 2 draws
                        dealerDraw[0] = DrawFromDeckDealer(0);
                        if (dealerDraw[0] == 1) {
                            dealerAce[0] = true;
                            dealerDraw[0] = 11;
                        }
                        dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                        dealerDraw[0] = DrawFromDeckDealer(0);
                        if (dealerDraw[0] == 1) {
                            dealerAce[0] = true;
                            dealerDraw[0] = 11;
                        }
                        dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                        //Just in case the dealer draws 2 aces
                        if (dealerTotal[0] > 21 && dealerAce[0] == true){
                            dealerAce[0] = false;
                            dealerTotal[0] = dealerTotal[0] - 10;
                            dealerLabel.setText("Dealer Total: " + dealerTotal[0]);
                        }
                        dealerLabel.setText("Dealer Total: " + dealerTotal[0]);
                        //Dealer logic
                        if (dealerTotal[0] >= playerTotal[0]){
                            System.out.println("The dealer wins with a " + dealerTotal[0]);
                            winLabel.setText("The dealer wins!");
                            //Reset
                            BJFrame.setVisible(false);
                            BlackJack.main();
                        }
                        //Dealer draws again
                        do {
                            dealerDraw[0] = DrawFromDeckDealer(0);
                            if (dealerDraw[0] == 1) {
                                dealerAce[0] = true;
                                dealerDraw[0] = 11;
                            }
                            dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                            if (dealerTotal[0] > 21 && dealerAce[0] == true){
                                dealerAce[0] = false;
                                dealerTotal[0] = dealerTotal[0] - 10;
                            }
                            if(dealerTotal[0] > 21){
                                System.out.println("The dealer went bust! The player wins!");
                                winLabel.setText("The player wins!");
                                //Reset
                                BJFrame.setVisible(false);
                                BlackJack.main();
                            }
                            else if(dealerTotal[0] >= playerTotal[0]){
                                System.out.println("The dealer wins with a " + dealerTotal[0]);
                                winLabel.setText("The dealer wins!");
                                //Reset
                                BJFrame.setVisible(false);
                                BlackJack.main();
                            }
                        }
                        while (dealerTotal[0] < playerTotal[0]);
                    }
                    else if (playerTotal[0] > 21 && playerAce[0] == true){
                        playerAce[0] = false;
                        playerTotal[0] = playerTotal[0] - 10;
                    }
                    else if (playerTotal[0] > 21){
                        System.out.println("You went bust! The dealer wins!");
                        winLabel.setText("The dealer wins!");
                        //Reset
                        BJFrame.setVisible(false);
                        BlackJack.main();
                    }
                    playerLabel.setText("Player Total: " + playerTotal[0]);
                }
            });
            //Stand button logic
            standButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Player's Total
                    System.out.println("You decided to stand with a total of: " + playerTotal[0]);
                    //Dealer's turn, first 2 draws
                    dealerDraw[0] = DrawFromDeckDealer(0);
                    if (dealerDraw[0] == 1) {
                        dealerAce[0] = true;
                        dealerDraw[0] = 11;
                    }
                    dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                    dealerDraw[0] = DrawFromDeckDealer(0);
                    if (dealerDraw[0] == 1) {
                        dealerAce[0] = true;
                        dealerDraw[0] = 11;
                    }
                    dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                    //Just in case the dealer draws 2 aces
                    if (dealerTotal[0] > 21 && dealerAce[0] == true){
                        dealerAce[0] = false;
                        dealerTotal[0] = dealerTotal[0] - 10;
                        dealerLabel.setText("Dealer Total: " + dealerTotal[0]);
                    }
                    dealerLabel.setText("Dealer Total: " + dealerTotal[0]);
                    //Dealer logic
                    if (dealerTotal[0] >= playerTotal[0]){
                        System.out.println("The dealer wins with a " + dealerTotal[0]);
                        winLabel.setText("The dealer wins!");
                        //Reset
                        BJFrame.setVisible(false);
                        BlackJack.main();
                    }
                    //Dealer draws again
                    do {
                        dealerDraw[0] = DrawFromDeckDealer(0);
                        if (dealerDraw[0] == 1) {
                            dealerAce[0] = true;
                            dealerDraw[0] = 11;
                        }
                        dealerTotal[0] = dealerTotal[0] + dealerDraw[0];
                        if (dealerTotal[0] > 21 && dealerAce[0] == true){
                            dealerAce[0] = false;
                            dealerTotal[0] = dealerTotal[0] - 10;
                        }
                        if(dealerTotal[0] > 21){
                            System.out.println("The dealer went bust! The player wins!");
                            winLabel.setText("The player wins!");
                            //Reset
                            BJFrame.setVisible(false);
                            BlackJack.main();
                        }
                        else if(dealerTotal[0] >= playerTotal[0]){
                            System.out.println("The dealer wins with a " + dealerTotal[0]);
                            winLabel.setText("The dealer wins!");
                            //Reset
                            BJFrame.setVisible(false);
                            BlackJack.main();
                        }
                    }
                    while (dealerTotal[0] < playerTotal[0]);
                }
            });
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BJFrame.setVisible(false);
                    System.exit(0);
                }
            });
        }

}
