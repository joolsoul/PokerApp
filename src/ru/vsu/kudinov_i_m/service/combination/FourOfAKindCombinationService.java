package ru.vsu.kudinov_i_m.service.combination;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FourOfAKindCombinationService implements ICombinationService
{
    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        sort(playerHandCards);
        Map<CardRank, Integer> ranksMap = fillRanksMap(playerHandCards);
        List<Card> combination = new ArrayList<>();
        CardRank combinationRank = null;

        for (Map.Entry<CardRank, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue().equals(4))
            {
                combinationRank = entry.getKey();
            }
        }

        for(Card card : playerHandCards)
        {
            if(card.getRank().equals(combinationRank))
            {
                combination.add(card);
            }
        }
        return combination;
    }
}
