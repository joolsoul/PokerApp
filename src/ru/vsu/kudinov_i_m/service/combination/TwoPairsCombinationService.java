package ru.vsu.kudinov_i_m.service.combination;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.service.combination.ICombinationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoPairsCombinationService implements ICombinationService
{
    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        sort(playerHandCards);
        Map<CardRank, Integer> ranksMap = fillRanksMap(playerHandCards);
        List<Card> combination = new ArrayList<>();
        List<CardRank> combinationRank = new ArrayList<>();

        for (Map.Entry<CardRank, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue().equals(2))
            {
                combinationRank.add(entry.getKey());
            }
        }
        if(combinationRank.size() > 1)
        {
            for(Card card : playerHandCards)
            {
                if(card.getRank().equals(combinationRank.get(combinationRank.size() - 1)) || card.getRank().equals(combinationRank.get(combinationRank.size() - 2)))
                {
                    combination.add(card);
                }
            }
        }
        return combination;
    }
}
