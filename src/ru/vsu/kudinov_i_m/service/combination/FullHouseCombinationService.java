package ru.vsu.kudinov_i_m.service.combination;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FullHouseCombinationService implements ICombinationService
{
    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        sort(playerHandCards);
        Map<CardRank, Integer> ranksMap = fillRanksMap(playerHandCards);
        List<Card> combination = new ArrayList<>();

        int rank2cards = 0;
        int rank3cards = 0;
        int rank4cards = 0;
        for (Map.Entry<CardRank, Integer> entry : ranksMap.entrySet())
        {
            if(entry.getValue() == 2)
            {
                if(rank2cards < entry.getKey().getValue())
                {
                    rank2cards = entry.getKey().getValue();
                }

            }
            else if(entry.getValue() == 3)
            {
                if(rank3cards < entry.getKey().getValue())
                {
                    rank3cards = entry.getKey().getValue();
                }
            }
            else if(entry.getValue() == 4)
            {
                rank4cards = entry.getKey().getValue();
            }
        }

        if(ranksMap.containsValue(2) && ranksMap.containsValue(3))
        {
            for(Card card : playerHandCards)
            {
                if(card.getRank().getValue() == rank2cards)
                {
                    combination.add(card);
                }
                else if(card.getRank().getValue() == rank3cards)
                {
                    combination.add(card);
                }
            }
        }

        if(ranksMap.containsValue(2) && ranksMap.containsValue(4))
        {
            int counterCards = 0;
            for(Card card : playerHandCards)
            {
                if(card.getRank().getValue() == rank2cards)
                {
                    combination.add(card);
                }
                else if(card.getRank().getValue() == rank4cards && counterCards < 4)
                {
                    combination.add(card);
                    counterCards++;
                }
            }
        }

        if(ranksMap.containsValue(4) && ranksMap.containsValue(3))
        {
            int counterCards = 0;
            for(Card card : playerHandCards)
            {
                if(card.getRank().getValue() == rank3cards)
                {
                    combination.add(card);
                }
                else if(card.getRank().getValue() == rank4cards && counterCards < 3)
                {
                    combination.add(card);
                    counterCards++;
                }
            }
        }

        if(ranksMap.containsValue(3))
        {
            List<CardRank> card3Ranks = new ArrayList<>();
            for(Map.Entry<CardRank, Integer> entry : ranksMap.entrySet())
            {
                if(entry.getValue() == 3)
                {
                    card3Ranks.add(entry.getKey());
                }
            }
            if(card3Ranks.size() == 2)
            {
                for(Card card : playerHandCards)
                {
                    if(card.getRank().equals(card3Ranks.get(0)) || card.getRank().equals(card3Ranks.get(1)))
                    {
                        combination.add(card);
                    }
                }
                combination.remove(combination.size() - 1);
            }

        }
        return combination;
    }
}
