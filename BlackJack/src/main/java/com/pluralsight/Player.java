package com.pluralsight;


public class Player {
    private String name;
    private Hand hand;
    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }
    public String getName() {
        return name;
    }
    public Hand getHand() {
        return hand;
    }
    public void deal(Card card) {
        hand.deal(card);
    }
    public void showHand() {
        System.out.println(name + "'s hand:");
        hand.showHand();
        System.out.println("Total: " + hand.getValue());
    }
}
