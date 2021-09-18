package ru.vsu.kudinov_i_m.service;

import ru.vsu.kudinov_i_m.model.*;

import java.util.*;

public class GameService
{
    private Map<CombinationType, ICombinationService> combinationServiceMap;


    public GameService()
    {
        combinationServiceMap = new LinkedHashMap<>();
        combinationServiceMap.put(CombinationType.ROYAL_FLUSH, new RoyalFlushCombinationService());
        combinationServiceMap.put(CombinationType.STRAIGHT_FLUSH, new StraightFlushCombinationService());
        combinationServiceMap.put(CombinationType.FOUR_OF_A_KIND, new FourOfAKindCombinationService());
        combinationServiceMap.put(CombinationType.FULL_HOUSE, new FullHouseCombinationService());
        combinationServiceMap.put(CombinationType.FLUSH, new FlushCombinationService());
        combinationServiceMap.put(CombinationType.STRAIGHT, new StraightCombinationService());
        combinationServiceMap.put(CombinationType.THREE_OF_A_KIND, new ThreeOfAKindCombinationService());
        combinationServiceMap.put(CombinationType.TWO_PAIRS, new TwoPairsCombinationService());
        combinationServiceMap.put(CombinationType.PAIR, new PairCombinationService());
        combinationServiceMap.put(CombinationType.HIGH_CARD, new HighCardCombinationService());
    }

    public Game createGame(Queue<Player> playersQueue)
    {
        Game game = new Game(playersQueue);
        GameDeckService gameDeckService = new GameDeckService();
        gameDeckService.initDeck(game.getGameDeck());
        return game;
    }

    public void playGame(Game game)
    {
        CardsDistributorService cardsDistributorService = new CardsDistributorService();
        game.setPlayerHandCards(cardsDistributorService.distributePlayersStartCards(game.getStepPlayersQueue(), game.getGameDeck()));
        cardsDistributorService.distributeFlopCards(game.getStepMap(), game.getGameDeck());
        cardsDistributorService.addTurnCard(game.getStepMap(), game.getGameDeck());
        cardsDistributorService.addRiverCard(game.getStepMap(), game.getGameDeck());

        System.out.println(game.getStepMap().get(StepType.RIVER).toString());
        for(Map.Entry<Player, List<Card>> entry : game.getPlayerHandCards().entrySet())
        {
            System.out.println(entry.getKey().getName() + entry.getValue().toString());
        }

        game.setPlayerCards(getPlayerCards(game.getPlayerHandCards(), game.getStepMap(), StepType.RIVER));
        game.setPlayerCombination(getPlayerCombination(game.getPlayerCards()));

        List<Map.Entry<Player, Combination>> winner = getWinner(game);
        System.out.println(winner.toString());

    }

    public List<Map.Entry<Player, Combination>> getWinner(Game game)
    {
        List<Map.Entry<Player, Combination>> winnerList = new ArrayList<>(game.getPlayerCombination().entrySet());

        HandComparatorService comparatorService = new HandComparatorService();

        boolean isWin = false;

        if(comparatorService.compare(winnerList.get(0), winnerList.get(1)) > 0)
        {
            winnerList.remove(1);
            isWin = true;
        }

        if( !isWin && comparatorService.compare(winnerList.get(0), winnerList.get(1)) < 0)
        {
            winnerList.remove(0);
        }

        return winnerList;
    }

    private Map<Player, List<Card>> getPlayerCards(Map<Player, List<Card>> playerHandCards, Map<StepType, List<Card>> stepMap, StepType stepType)
    {
        Map<Player, List<Card>> playerCards = new LinkedHashMap<>(playerHandCards);

        List<Card> handCard = new ArrayList<>(stepMap.get(stepType));

        for(Map.Entry<Player, List<Card>> entry : playerCards.entrySet())
        {
            entry.getValue().addAll(handCard);
        }
        return playerCards;
    }

    private Map<Player, Combination> getPlayerCombination(Map<Player, List<Card>> playerCards)
    {
        Map<Player, Combination> playerCombination = new LinkedHashMap<>();

        for (Map.Entry<Player, List<Card>> entry : playerCards.entrySet())
        {
            playerCombination.put(entry.getKey(), calcCombination(entry.getValue()));
        }
        return playerCombination;
    }

    private Combination calcCombination(List<Card> cards)
    {
        for(Map.Entry<CombinationType, ICombinationService> entry : combinationServiceMap.entrySet())
        {
            List<Card> combinationList = entry.getValue().checkCombination(cards);
            if(combinationList != null && !combinationList.isEmpty())
            {
                return new Combination(entry.getKey(), combinationList);
            }
        }
        return null;
    }




}
