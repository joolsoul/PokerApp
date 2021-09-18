package ru.vsu.kudinov_i_m.model;

import java.util.*;

public class Game
{
    private Map<Player, List<Card>> playerHandCards = new LinkedHashMap<>();

    private Map<Player, List<Card>> playerCards = new LinkedHashMap<>();

    private Map<Player, Combination> playerCombination = new LinkedHashMap<>();

    private Map<StepType, List<Card>> stepMap = new LinkedHashMap<>();

    private Queue<Player> playersQueue;

    private List<Card> gameDeck = new ArrayList<>();

    private Map<Player, Action> playerAction = new LinkedHashMap<>();



    public Game(Queue<Player> playersQueue)
    {
        this.playersQueue = playersQueue;
    }

    public Map<Player, List<Card>> getPlayerCards()
    {
        return playerCards;
    }

    public void setPlayerCards(Map<Player, List<Card>> playerCards)
    {
        this.playerCards = playerCards;
    }

    public Map<StepType, List<Card>> getStepMap()
    {
        return stepMap;
    }

    public void setStepMap(Map<StepType, List<Card>> stepMap)
    {
        this.stepMap = stepMap;
    }

    public Queue<Player> getStepPlayersQueue()
    {
        return playersQueue;
    }

    public Map<Player, List<Card>> getPlayerHandCards()
    {
        return playerHandCards;
    }

    public void setPlayerHandCards(Map<Player, List<Card>> playerHandCards)
    {
        this.playerHandCards = playerHandCards;
    }

    public void setStepPlayersQueue(Queue<Player> stepPlayersQueue)
    {
        this.playersQueue = stepPlayersQueue;
    }

    public List<Card> getGameDeck()
    {
        return gameDeck;
    }

    public void setGameDeck(List<Card> gameDeck)
    {
        this.gameDeck = gameDeck;
    }

    public Map<Player, Combination> getPlayerCombination()
    {
        return playerCombination;
    }

    public void setPlayerCombination(Map<Player, Combination> playerCombination)
    {
        this.playerCombination = playerCombination;
    }

    public Queue<Player> getPlayersQueue()
    {
        return playersQueue;
    }

    public void setPlayersQueue(Queue<Player> playersQueue)
    {
        this.playersQueue = playersQueue;
    }

    public Map<Player, Action> getPlayerAction()
    {
        return playerAction;
    }

    public void setPlayerAction(Map<Player, Action> playerAction)
    {
        this.playerAction = playerAction;
    }
}
