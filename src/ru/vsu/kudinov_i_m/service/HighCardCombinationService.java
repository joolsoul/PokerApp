package ru.vsu.kudinov_i_m.service;

import ru.vsu.kudinov_i_m.model.Card;

import java.util.ArrayList;
import java.util.List;

public class HighCardCombinationService implements ICombinationService
{
    @Override
    public List<Card> checkCombination(List<Card> playerHandCards)
    {
        sort(playerHandCards);
        List<Card> combination = new ArrayList<>();
        combination.add(playerHandCards.get(playerHandCards.size() - 1));

        return combination;
    }
}
