package ru.vsu.kudinov_i_m.model;

import java.awt.*;

public class Card
{
    private CardSuit suit;
    private CardRank rank;
    private Image image;

    public Card(CardSuit suit, CardRank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(CardSuit suit, CardRank rank, Image image)
    {
        this.suit = suit;
        this.rank = rank;
        this.image = image;
    }

    public CardSuit getSuit()
    {
        return suit;
    }

    public CardRank getRank()
    {
        return rank;
    }

    public void setSuit(CardSuit suit)
    {
        this.suit = suit;
    }

    public void setRank(CardRank rank)
    {
        this.rank = rank;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "(" + suit.getSuit() + rank.getValue() + ")";
    }
}
