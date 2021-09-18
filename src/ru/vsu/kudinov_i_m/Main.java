package ru.vsu.kudinov_i_m;

import ru.vsu.kudinov_i_m.model.Game;
import ru.vsu.kudinov_i_m.model.Player;
import ru.vsu.kudinov_i_m.service.GameService;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args)
    {
        Player p1 = new Player("Ivan");
        Player p2 = new Player("Nadya");

        Queue<Player> playerQueue = new LinkedList<>();
        playerQueue.add(p1);
        playerQueue.add(p2);

        GameService gameService = new GameService();
        Game game = gameService.createGame(playerQueue);
        gameService.playGame(game);
    }
}
