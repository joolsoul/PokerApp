package ru.vsu.kudinov_i_m.service.card;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.CardRank;
import ru.vsu.kudinov_i_m.model.CardSuit;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GameDeckService
{

    public void initDeck(List<Card> gameDeck)
    {
        try
        {
            createDeck(gameDeck);
        }
        catch (Exception ignored)
        {

        }

        shuffleOfDeck(gameDeck);
    }

    private void createDeck(List<Card> gameDeck) throws IOException
    {
        int suitCount = 0;
        int x = 0;
        for (CardSuit suit : CardSuit.values())
        {
            suitCount++;
            x = 1;
            for (CardRank rank : CardRank.values())
            {

                BufferedImage bigImg = ImageIO.read(new File("src/ru/vsu/kudinov_i_m/resources/cards_" + suitCount +".bmp"));

                BufferedImage image = bigImg.getSubimage(x, 1, 69, 95);

                gameDeck.add(new Card(suit, rank, image));

                x += 71;
            }
        }
    }

    private void shuffleOfDeck(List<Card> gameDeck)
    {
        Collections.shuffle(gameDeck);
    }
}
