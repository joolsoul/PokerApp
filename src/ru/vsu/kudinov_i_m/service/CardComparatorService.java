package ru.vsu.kudinov_i_m.service;

import ru.vsu.kudinov_i_m.model.Card;

import java.util.Comparator;

public class CardComparatorService implements Comparator<Card>
{
    @Override
    public int compare(Card o1, Card o2)
    {
        if(o1.getRank().equals(o2.getRank()))
        {
            return 0;
        }

        return Integer.compare(o1.getRank().getValue(), o2.getRank().getValue());
    }
}
