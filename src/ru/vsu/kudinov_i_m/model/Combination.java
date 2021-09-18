package ru.vsu.kudinov_i_m.model;

import java.util.List;

public class Combination
{
    private CombinationType type;

    private List<Card> cardList;

    public Combination(CombinationType type, List<Card> cardList)
    {
        this.type = type;
        this.cardList = cardList;
    }

    public CombinationType getType()
    {
        return type;
    }

    public void setType(CombinationType type)
    {
        this.type = type;
    }

    public List<Card> getCardList()
    {
        return cardList;
    }

    public void setCardList(List<Card> cardList)
    {
        this.cardList = cardList;
    }

    @Override
    public String toString()
    {
        return type + cardList.toString();
    }
}
