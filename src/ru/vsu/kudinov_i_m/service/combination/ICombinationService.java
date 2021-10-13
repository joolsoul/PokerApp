package ru.vsu.kudinov_i_m.service.combination;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;

import java.util.*;

public interface ICombinationService
{
    List<Card> checkCombination(List<Card> playerHandCards);

    default Map<CardRank, Integer> fillRanksMap(List<Card> playerHandCards)
    {
        Map<CardRank, Integer> ranksMap = new TreeMap<>();
        for(Card card : playerHandCards)
        {
            boolean isKeyInMap = false;
            for (Map.Entry<CardRank, Integer> entry : ranksMap.entrySet())
            {
                if (entry.getKey().equals(card.getRank()))
                {
                    int value = entry.getValue();
                    entry.setValue(value + 1);
                    isKeyInMap = true;
                }
            }
            if (!isKeyInMap)
            {
                ranksMap.put(card.getRank(), 1);
            }
        }
        return ranksMap;
    }

    default void sort(List<Card> playerHandCards)
    {
        playerHandCards.sort(Comparator.comparing(Card::getRank));
    }
}
