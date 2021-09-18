package ru.vsu.kudinov_i_m.service;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.model.CardSuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FlushCombinationService implements ICombinationService
{

    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        sort(playerHandCards);
        Map<CardRank, Integer> ranksMap = fillRanksMap(playerHandCards);
        List<Card> combination = new ArrayList<>();

        CardSuit suitHighestCard = null;

        Map<CardSuit, Integer> suitsMap = new TreeMap<>();

        for (Card card : playerHandCards)
        {
            boolean isKeyInMap = false;
            for (Map.Entry<CardSuit, Integer> entry : suitsMap.entrySet())
            {
                if (entry.getKey().equals(card.getSuit()))
                {
                    int value = entry.getValue();
                    entry.setValue(value + 1);
                    isKeyInMap = true;
                }
            }
            if (!isKeyInMap)
            {
                suitsMap.put(card.getSuit(), 1);
            }
        }

        for (Map.Entry<CardSuit, Integer> entry : suitsMap.entrySet())
        {
            if(entry.getValue() > 4)
            {
                suitHighestCard = entry.getKey();
            }
        }

        if(suitHighestCard != null)
        {
            for (int i = playerHandCards.size() - 1, cardCounter = 0; cardCounter < 6 && i > -1; i--)
            {
                if (playerHandCards.get(i).getSuit() == suitHighestCard)
                {
                    combination.add(playerHandCards.get(i));
                    cardCounter++;
                }
            }
            sort(combination);
        }
        return combination;
    }
}
