package ru.vsu.kudinov_i_m.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.model.CardSuit;
import ru.vsu.kudinov_i_m.service.ICombinationService;
import ru.vsu.kudinov_i_m.service.TwoPairsCombinationService;

import java.util.ArrayList;
import java.util.List;

public class TestCombination
{

    @Test
    public void twoPairsTest1()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.TWO);
        Card card3 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.THREE);
        Card card5 = new Card(CardSuit.HEARTS, CardRank.FOUR);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.FOUR);
        Card card7 = new Card(CardSuit.CLUBS, CardRank.SEVEN);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card3);
        result.add(card4);
        result.add(card5);
        result.add(card6);

        ICombinationService sad = new TwoPairsCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }

    }
}
