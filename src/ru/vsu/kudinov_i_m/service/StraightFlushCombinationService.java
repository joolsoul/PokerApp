package ru.vsu.kudinov_i_m.service;

import ru.vsu.kudinov_i_m.model.Card;

import java.util.ArrayList;
import java.util.List;

public class StraightFlushCombinationService implements ICombinationService
{
    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        ICombinationService checkStraight = new StraightCombinationService();
        List<Card> straightCombination = checkStraight.checkCombination(playerHandCards);
        if(!straightCombination.isEmpty())
        {
            boolean isFlush = true;

                for(int i = 0; i < straightCombination.size(); i++)
                {
                    if(i != straightCombination.size() - 1 && straightCombination.get(i).getSuit() != straightCombination.get(i + 1).getSuit())
                    {
                        isFlush = false;
                        break;
                    }
                }

                if(isFlush)
                {
                    return new ArrayList<>(straightCombination);
                }
        }
        return new ArrayList<>();
    }
}
