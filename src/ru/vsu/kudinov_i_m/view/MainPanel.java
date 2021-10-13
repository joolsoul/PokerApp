package ru.vsu.kudinov_i_m.view;

import ru.vsu.kudinov_i_m.model.Game;
import ru.vsu.kudinov_i_m.model.Player;
import ru.vsu.kudinov_i_m.service.GameService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class MainPanel extends JPanel
{
    public MainPanel()
    {

    }

    @Override
    public void paint(Graphics g)
    {
        paintBackground(g);

        Player p1 = new Player("Ivan");
        Player p2 = new Player("Yaroslav");

        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.add(p1);
        playerQueue.add(p2);

        GameService gameService = new GameService();
        Game game = gameService.createGame(playerQueue);
        gameService.playGame(game);

        paintHandCards(g, game);

        paintPlayersCards(g, game);

        paintComponent(g);
    }

    private void paintBackground(Graphics g)
    {
        Image background = null;
        try
        {
            background = ImageIO.read(new File("src/ru/vsu/kudinov_i_m/resources/table.jpg"));
        }
        catch (IOException ignored) {}

        g.drawImage(background, -5, 0, 1495, 1100, null);
    }

    private void paintInformation(Graphics g, Game game)
    {

    }


    public void paintComponent(Graphics g)
    {




        Image playerImage = null;
        try
        {
            playerImage = ImageIO.read(new File("src/ru/vsu/kudinov_i_m/resources/player.png"));
        }
        catch (IOException ignored) {}

        //g.drawImage(playerImage, 255, 850, 145, 200, null);
        //g.drawImage(playerImage, 855, 850, 145, 200, null);
        g.drawRect( 855, 850, 145, 200);
        g.drawRect( 255, 850, 145, 200);


    }

    private void paintPlayersCards(Graphics g, Game game)
    {
        for (int i = 0; i < 2; i++)
        {

            Image firstPlayerCard;
            Image secondPlayerCard;

            Player p1 = game.getPlayersQueue().poll();
            Player p2 = game.getPlayersQueue().poll();

            game.getPlayersQueue().add(p1);
            game.getPlayersQueue().add(p2);


            firstPlayerCard = game.getPlayerHandCards().get(p1).get(i).getImage();
            secondPlayerCard = game.getPlayerHandCards().get(p2).get(i).getImage();

            g.drawImage(firstPlayerCard, 400 + 100 * i, 565, 85, 115, null);
            g.drawImage(secondPlayerCard, 900 + 100 * i, 565, 85, 115, null);
        }
    }

    private void paintHandCards(Graphics g, Game game)
    {
        Image currentHandCard;

        for (int i = 0; i < 5; i++)
        {
            currentHandCard = game.getGameDeck().get(i).getImage();
            g.drawImage(currentHandCard, 500 + 100 * i, 290, 85, 115, null);
        }
    }


}
