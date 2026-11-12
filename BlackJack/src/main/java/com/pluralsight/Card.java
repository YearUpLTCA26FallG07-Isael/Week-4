package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean faceUp;
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.faceUp = false;
    }
    public String getSuit() {
        if (faceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        if (faceUp) {
            return value;
        } else {
            return "#";
        }
    }

    public int getPointValue() {
        if (faceUp) {
            switch (value) {
                case "A":
                    return 11;
                case "K":
                case "Q":
                case "J":
                    return 10;
                default:
                    return Integer.parseInt(value);
            }
        } else {
            return 0;
        }
    }
    public boolean isFaceUp() {
        return faceUp;
    }
    public void flip() {
        faceUp = !faceUp;
    }
}


