package ru.vsu.kudinov_i_m.service;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.model.CardSuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoyalFlushCombinationService implements ICombinationService
{
    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        sort(playerHandCards);
        Map<CardRank, Integer> ranksMap = fillRanksMap(playerHandCards);
        List<Card> combination = new ArrayList<>();

        CardRank rankOfSuitCombinationCard = null;
        CardSuit suitCombination = null;

        if(ranksMap.containsKey(CardRank.ACE) && ranksMap.containsKey(CardRank.KING) && ranksMap.containsKey(CardRank.QUEEN) && ranksMap.containsKey(CardRank.JACK) && ranksMap.containsKey(CardRank.TEN))
        {
            for(Map.Entry<CardRank, Integer> entry : ranksMap.entrySet())
            {
                if(entry.getKey().getValue() > 9 && entry.getValue() == 1)
                {
                    rankOfSuitCombinationCard = entry.getKey();
                }
            }
        }
        if(rankOfSuitCombinationCard != null)
        {
            for (Card card : playerHandCards)
            {
                if(card.getRank().equals(rankOfSuitCombinationCard))
                {
                    suitCombination = card.getSuit();
                }
            }
        }

        for (Card card : playerHandCards)
        {
            if(card.getRank().getValue() > 9 && card.getSuit().equals(suitCombination))
            {
                combination.add(card);
            }
        }
        if(combination.size() > 4)
        {
            return combination;
        }
        return new ArrayList<>();
    }
}
