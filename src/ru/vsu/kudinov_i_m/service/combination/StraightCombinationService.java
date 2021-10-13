package ru.vsu.kudinov_i_m.service.combination;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.service.combination.ICombinationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StraightCombinationService implements ICombinationService
{

    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        sort(playerHandCards);
        Map<CardRank, Integer> ranksMap = fillRanksMap(playerHandCards);
        List<Card> combination = new ArrayList<>();

        List<Card> playerHandCardsCopy = new ArrayList<>(playerHandCards);
        for (int i = 0; i < playerHandCardsCopy.size(); i++)
        {
            if(i != playerHandCardsCopy.size() - 1 && playerHandCardsCopy.get(i + 1).getRank().equals(playerHandCardsCopy.get(i).getRank()))
            {
                playerHandCardsCopy.remove(i + 1);
            }
        }

        if(ranksMap.containsKey(CardRank.TWO) && ranksMap.containsKey(CardRank.THREE) && ranksMap.containsKey(CardRank.FOUR) && ranksMap.containsKey(CardRank.FIVE) && ranksMap.containsKey(CardRank.ACE) && !ranksMap.containsKey(CardRank.SIX))
        {
            for(Card card : playerHandCards)
            {
                if(card.getRank().equals(CardRank.TWO) || card.getRank().equals(CardRank.THREE) || card.getRank().equals(CardRank.FOUR) || card.getRank().equals(CardRank.FIVE) || card.getRank().equals(CardRank.ACE))
                {
                    combination.add(card);
                }
            }
        }

        for(int i = 0; i < playerHandCards.size() - 4; i++)
        {
            if (playerHandCards.get(i).getRank().getValue() == playerHandCards.get(i + 1).getRank().getValue() - 1 &&
                    playerHandCards.get(i + 1).getRank().getValue() == playerHandCards.get(i + 2).getRank().getValue() - 1 &&
                    playerHandCards.get(i + 2).getRank().getValue() == playerHandCards.get(i + 3).getRank().getValue() - 1 &&
                    playerHandCards.get(i + 3).getRank().getValue() == playerHandCards.get(i + 4).getRank().getValue() - 1)
            {
                combination.clear();
                for(int j = i; j < i + 5; j++)
                {
                    combination.add(playerHandCards.get(j));
                }
            }
        }
        return combination;
    }
}