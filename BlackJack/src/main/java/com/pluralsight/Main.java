package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<>();

        System.out.println("Welcome to the Card Game!");
        System.out.print("How many players? ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        if (numPlayers < 1 || numPlayers > 26) {
            System.out.println("Enter 1 to 26 players.");
            return;
        }

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        Deck deck = new Deck();
        deck.shuffle();

        // Deal two cards to each player
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.deal(deck.dealCard());
            }
        }

        int highestScore = -1;
        ArrayList<Player> winners = new ArrayList<>();

        // Display hands and compare scores
        for (Player player : players) {
            System.out.println();
            player.showHand();

            int score = player.getHand().getValue();

            if (score <= 21) {
                if (score > highestScore) {
                    highestScore = score;
                    winners.clear();
                    winners.add(player);
                } else if (score == highestScore) {
                    winners.add(player);
                }
            }
        }

        System.out.println();

        if (winners.isEmpty()) {
            System.out.println("No winner! Everyone went over 21.");
        } else if (winners.size() > 1) {
            System.out.println("It's a tie!");
            for (Player player : winners) {
                System.out.println(player.getName());
            }
        } else {
            System.out.println("The winner is "
                    + winners.get(0).getName()
                    + " with " + highestScore + " points!");
        }

        scanner.close();
    }
}