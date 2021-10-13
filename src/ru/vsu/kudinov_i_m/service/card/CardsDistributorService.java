package ru.vsu.kudinov_i_m.service.card;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.Player;
import ru.vsu.kudinov_i_m.model.StepType;

import java.util.*;

public class CardsDistributorService
{

    public Map<Player, List<Card>> distributePlayersStartCards(Map<StepType, List<Card>> stepMap, Queue<Player> stepPlayersQueue, List<Card> gameDeck)
    {
        Map<Player, List<Card>> playerCards = new LinkedHashMap<>();

        for(int i = 0; i < stepPlayersQueue.size(); i++)
        {
            Player currentPlayer = stepPlayersQueue.poll();
            List<Card> startPlayerCards = new ArrayList<>(gameDeck.subList(0, 2));
            gameDeck.remove(0);
            gameDeck.remove(0);

            playerCards.put(currentPlayer, startPlayerCards);

            stepPlayersQueue.add(currentPlayer);
        }
        stepMap.put(StepType.PRE_FLOP, new ArrayList<>());
        return playerCards;
    }

    public void distributeFlopCards(Map<StepType, List<Card>> stepMap, List<Card> gameDeck)
    {
        List<Card> flopHandCards = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            gameDeck.remove(0);
            flopHandCards.add(gameDeck.get(0));
            gameDeck.remove(0);
        }

        stepMap.put(StepType.FLOP, flopHandCards);
    }

    public void addTurnCard(Map<StepType, List<Card>> stepMap, List<Card> gameDeck)
    {
        List<Card> turnHandCards = new ArrayList<>(stepMap.get(StepType.FLOP));

        gameDeck.remove(0);
        turnHandCards.add(gameDeck.get(0));
        gameDeck.remove(0);

        stepMap.put(StepType.TURN, turnHandCards);
    }

    public void addRiverCard(Map<StepType, List<Card>> stepMap, List<Card> gameDeck)
    {
        List<Card> riverHandCards = new ArrayList<>(stepMap.get(StepType.TURN));

        gameDeck.remove(0);
        riverHandCards.add(gameDeck.get(0));
        gameDeck.remove(0);

        stepMap.put(StepType.RIVER, riverHandCards);
    }


}
