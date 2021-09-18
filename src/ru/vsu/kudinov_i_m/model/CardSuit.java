package ru.vsu.kudinov_i_m.model;

public enum CardSuit
{
    HEARTS('♥'),
    CLUBS('♣'),
    SPADES('♠'),
    DIAMONDS('♦');

    private char suit;

    CardSuit(char suit)
    {
        this.suit = suit;
    }

    public char getSuit()
    {
        return suit;
    }
}
