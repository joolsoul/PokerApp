package ru.vsu.kudinov_i_m.service;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.model.CardSuit;

import java.util.Collections;
import java.util.List;

public class GameDeckService
{

    public void initDeck(List<Card> gameDeck)
    {
        createDeck(gameDeck);
        shuffleOfDeck(gameDeck);
    }

    private void createDeck(List<Card> gameDeck)
    {
        for (CardSuit suit : CardSuit.values())
        {
            for (CardRank rank : CardRank.values())
            {
                gameDeck.add(new Card(suit, rank));
            }
        }
    }

    private void shuffleOfDeck(List<Card> gameDeck)
    {
        Collections.shuffle(gameDeck);
    }
}
