package ru.vsu.kudinov_i_m.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.model.CardSuit;
import ru.vsu.kudinov_i_m.service.combination.*;

import java.util.ArrayList;
import java.util.List;

public class TestCombination
{
    @Test
    public void pairTest()
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

        result.add(card5);
        result.add(card6);

        ICombinationService sad = new PairCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void twoPairsTest()
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

    @Test
    public void threeOfAKindTest()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.FOUR);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.TWO);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.FOUR);
        Card card5 = new Card(CardSuit.DIAMONDS, CardRank.TWO);
        Card card6 = new Card(CardSuit.DIAMONDS, CardRank.FOUR);
        Card card7 = new Card(CardSuit.CLUBS, CardRank.SEVEN);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card2);
        result.add(card4);
        result.add(card6);

        ICombinationService sad = new ThreeOfAKindCombinationService();


        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void straightTest1()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.FIVE);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.SIX);
        Card card5 = new Card(CardSuit.DIAMONDS, CardRank.EIGHT);
        Card card6 = new Card(CardSuit.DIAMONDS, CardRank.NINE);
        Card card7 = new Card(CardSuit.CLUBS, CardRank.TEN);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card7);

        ICombinationService sad = new HighCardCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void straightTest2()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.FOUR);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.FIVE);
        Card card5 = new Card(CardSuit.DIAMONDS, CardRank.SIX);
        Card card6 = new Card(CardSuit.DIAMONDS, CardRank.SEVEN);
        Card card7 = new Card(CardSuit.CLUBS, CardRank.EIGHT);
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
        result.add(card7);

        ICombinationService sad = new StraightCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void straightTest3()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.FOUR);
        Card card4 = new Card(CardSuit.CLUBS, CardRank.FIVE);
        Card card5 = new Card(CardSuit.DIAMONDS, CardRank.TEN);
        Card card6 = new Card(CardSuit.DIAMONDS, CardRank.SEVEN);
        Card card7 = new Card(CardSuit.CLUBS, CardRank.ACE);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card1);
        result.add(card2);
        result.add(card3);
        result.add(card4);
        result.add(card7);

        ICombinationService sad = new StraightCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void flushTest1()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card3 = new Card(CardSuit.HEARTS, CardRank.FOUR);
        Card card4 = new Card(CardSuit.HEARTS, CardRank.FIVE);
        Card card5 = new Card(CardSuit.HEARTS, CardRank.SIX);
        Card card6 = new Card(CardSuit.HEARTS, CardRank.SEVEN);
        Card card7 = new Card(CardSuit.HEARTS, CardRank.EIGHT);
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
        result.add(card7);

        ICombinationService sad = new FlushCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void fullHouseTest1()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card2 = new Card(CardSuit.DIAMONDS, CardRank.THREE);
        Card card3 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card4 = new Card(CardSuit.DIAMONDS, CardRank.TWO);
        Card card5 = new Card(CardSuit.HEARTS, CardRank.FOUR);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.FOUR);
        Card card7 = new Card(CardSuit.DIAMONDS, CardRank.FOUR);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card1);
        result.add(card2);
        result.add(card5);
        result.add(card6);
        result.add(card7);

        ICombinationService sad = new FullHouseCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void fullHouseTest2()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card2 = new Card(CardSuit.DIAMONDS, CardRank.THREE);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.THREE);
        Card card4 = new Card(CardSuit.DIAMONDS, CardRank.TWO);
        Card card5 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.TWO);
        Card card7 = new Card(CardSuit.DIAMONDS, CardRank.FOUR);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card4);
        result.add(card5);
        result.add(card6);
        result.add(card1);
        result.add(card2);

        ICombinationService sad = new FullHouseCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void fourOfAKindTest()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card2 = new Card(CardSuit.DIAMONDS, CardRank.THREE);
        Card card3 = new Card(CardSuit.CLUBS, CardRank.THREE);
        Card card4 = new Card(CardSuit.SPADES, CardRank.THREE);
        Card card5 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card6 = new Card(CardSuit.CLUBS, CardRank.TWO);
        Card card7 = new Card(CardSuit.DIAMONDS, CardRank.FOUR);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card1);
        result.add(card2);
        result.add(card3);
        result.add(card4);

        ICombinationService sad = new FourOfAKindCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void straightFlushTest()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TWO);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.THREE);
        Card card3 = new Card(CardSuit.HEARTS, CardRank.FOUR);
        Card card4 = new Card(CardSuit.HEARTS, CardRank.FIVE);
        Card card5 = new Card(CardSuit.HEARTS, CardRank.SIX);
        Card card6 = new Card(CardSuit.HEARTS, CardRank.SEVEN);
        Card card7 = new Card(CardSuit.HEARTS, CardRank.EIGHT);
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
        result.add(card7);

        ICombinationService sad = new StraightFlushCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }

    @Test
    public void royalFlushTest()
    {
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(CardSuit.HEARTS, CardRank.TEN);
        Card card2 = new Card(CardSuit.HEARTS, CardRank.JACK);
        Card card3 = new Card(CardSuit.HEARTS, CardRank.QUEEN);
        Card card4 = new Card(CardSuit.HEARTS, CardRank.KING);
        Card card5 = new Card(CardSuit.HEARTS, CardRank.ACE);
        Card card6 = new Card(CardSuit.HEARTS, CardRank.NINE);
        Card card7 = new Card(CardSuit.HEARTS, CardRank.EIGHT);
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);


        List<Card> result = new ArrayList<>();

        result.add(card1);
        result.add(card2);
        result.add(card3);
        result.add(card4);
        result.add(card5);

        ICombinationService sad = new RoyalFlushCombinationService();

        List<Card> abs = sad.checkCombination(hand);

        for(int i = 0; i < result.size(); i++)
        {
            Assert.assertEquals(result.get(i), abs.get(i));
        }
    }
}
